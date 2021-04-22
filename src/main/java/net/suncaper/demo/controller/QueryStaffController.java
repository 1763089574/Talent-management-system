package net.suncaper.demo.controller;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import net.suncaper.demo.common.domain.*;
import net.suncaper.demo.common.domain.extend.WorkerDetail;
import net.suncaper.demo.common.util.DateTime;
import net.suncaper.demo.common.util.RedisUtils;
import net.suncaper.demo.common.util.RedisUtilsObject;
import net.suncaper.demo.service.CompanyService;
import net.suncaper.demo.service.DossierService;
import net.suncaper.demo.service.EmployService;
import net.suncaper.demo.service.WorkerService;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class QueryStaffController {
    @Autowired
    public CompanyService companyService;
    @Autowired
    public WorkerService workerService;
    @Autowired
    public EmployService employService;
    @Autowired
    public DossierService dossierService;
    @Autowired
    public RedisUtils redisUtils;
    @Autowired
    public RedisUtilsObject redisUtilsObject;

    @RequestMapping("GetAllWorkers")
    public List<Worker> GetAllWorkerByCompanyId(HttpServletRequest request){
        String CompanyId=request.getParameter("CompanyId");
        System.out.println("querystaff.html"+CompanyId);
        List<Worker> workers=companyService.GetAllWorkersByCompanyId(CompanyId);
        //List<Worker> workers=companyService.findAll();
        System.out.println(workers);
        return workers;

    }
    @RequestMapping("GetWorkerById")
    public Worker GetWorkerById(HttpServletRequest request){
        /*String tmpid=request.getParameter("worker_id");
        Integer id=Integer.valueOf(tmpid);
        Worker worker=workerService.getWorkerByID(id);

        return worker;*/

        //以上是没使用redis，以下用了redis

        String tmpid=request.getParameter("worker_id");
        Integer id=Integer.valueOf(tmpid);
        Worker worker=(Worker)redisUtilsObject.get("worker:Id:Id"+tmpid);//先查缓存，如果缓存没有，再查数据库
        if(worker==null){//如果缓存中没有
            System.out.println("null");
            worker=workerService.getWorkerByID(id);//从数据库查
            redisUtilsObject.expire("worker:Id:Id"+tmpid,worker,100);//查出来后，设置到缓存中，设置一个过期时间100秒
        }
        return worker;
    }


    @RequestMapping("getDossierById")
    public List<Dossier> getDossierById(HttpServletRequest request){
        String workerId=request.getParameter("workerId");
        String belong=request.getParameter("belong");


        return null;
    }

    @RequestMapping("getEmployById")
    public List<Employ> getEmployById(HttpServletRequest request){//找出员工曾经任职过的employ信息，注意，不包含当前任职的公司
        String workerId=request.getParameter("workerId");
        String belong=request.getParameter("belong");

        List<Employ> employs=employService.getEmployByWorker(workerId,belong);

        return employs;
    }

    @RequestMapping("getWorkerDetailById")
    public List<WorkerDetail> getWorkerDetailById(HttpServletRequest request){//根据员工id返回员工的详细信息
        String workerId=request.getParameter("workerId");
        String belong=request.getParameter("belong");
        List<WorkerDetail> workerDetails=employService.getWorkerDetailById(workerId,belong);
        return workerDetails;
    }

    @RequestMapping("getApplyList")
    public List<Worker> getApplyList(HttpServletRequest request)//返回待入职列表，其中返回每个对象都是worker
    {
        String companyId=request.getParameter("companyId");
        List<Worker> workers=companyService.getApplyList(companyId);
        return workers;
    }
    @RequestMapping("getResignList")
    public List<Worker> getResignList(HttpServletRequest request){
        String companyId=request.getParameter("companyId");
        List<Worker> workers=companyService.getResignList(companyId);
        return workers;
    }

    @RequestMapping("applyAgree")
    public boolean applyAgree(HttpServletRequest request) throws ParseException {//同意员工申请入职，根据公司id和员工id去apply表中将isconsent置为1，
        // 并将worker表中的belong置为当前公司的id,还要为员工创建employ信息，dossier信息是在离职的时候创建
        String workerId=request.getParameter("workerId");
        String companyId=request.getParameter("companyId");

        Boolean flag=companyService.applyAgree(workerId,companyId);//将worker的belong由0改为当前需要加入的公司

        //接下来为员工添加employ信息
        System.out.println("插入employ");

        Date startDate= DateTime.getDateTime();
        System.out.println("startDate"+startDate);
        int count=employService.insertEmploy(companyId,workerId,startDate);


        return flag;
    }

    @RequestMapping("applyRefuse")
    public boolean applyRefuse(HttpServletRequest request){//拒绝员工申请入职,根据公司id和员工id去apply表中将此条记录的isconsent置为2
        String workerId=request.getParameter("workerId");
        String companyId=request.getParameter("companyId");

        Boolean flag=companyService.applyRefuse(workerId,companyId);

        return flag;
    }

    @RequestMapping("resignAgree")
    public boolean resignAgree(HttpServletRequest request) throws ParseException {//同意员工申请离职，根据公司id和员工id去resign表中将isconsent置为1，并将worker表中的belong置为0
        Integer workerId=Integer.valueOf(request.getParameter("workerId"));
        Integer companyId=Integer.valueOf(request.getParameter("companyId"));

        String evaluate=request.getParameter("evaluate");
        System.out.println("appliAgree");
        System.out.println(workerId);
        System.out.println(companyId);
        System.out.println(evaluate);
        Boolean flag=companyService.resignAgree(workerId,companyId);

        //以下是为完善employ的离职时间和为用户创建dossier
        Date endDate= DateTime.getDateTime();


        List<Employ> employs=employService.getEmploy(request.getParameter("companyId"),request.getParameter("workerId"));
        System.out.println("aemploys");
        System.out.println(employs);
        String employId=String.valueOf(employs.get(0).getId());
        int count2=employService.employEndDate(employId,endDate);//员工离职时完善其employ的离职字段

        int count=dossierService.dossierCreate(employId,evaluate);//员工离职时为其创建dossier并添加评价

        //员工离职时为其往Evaluate表中添加信息
        employService.insertEvaluate(Integer.valueOf(employId));

        int count3=employService.updateIsEvaluate(request.getParameter("workerId"));//员工离职时更改他的isevaluate字段

        return flag;
    }

    @RequestMapping("resignRefuse")
    public boolean resignRefuse(HttpServletRequest request){//拒绝员工申请离职，根据公司id和员工id去resign表中将isconsent置为2
        Integer workerId=Integer.valueOf(request.getParameter("workerId"));
        Integer companyId=Integer.valueOf(request.getParameter("companyId"));
        Boolean flag=companyService.resignRefuse(workerId,companyId);
        return flag;
    }

    @RequestMapping("getGrade")
    public List<Grade> getGrade(HttpServletRequest request){
        /*Integer companyId=Integer.valueOf(request.getParameter("companyId"));
        Integer workerId=Integer.valueOf(request.getParameter("workerId"));*/
        String companyId=request.getParameter("companyId");
        String workerId=request.getParameter("workerId");
        List<Grade> grades=employService.getGrade(companyId,workerId);
        return grades;
    }
    @RequestMapping("getEmploy")
    public List<Employ> getEmploy(String workerId,String companyId){

        List<Employ> employs=employService.getEmploy(companyId,workerId);
        return  employs;
    }

    @RequestMapping("getAchievement")
    public List<Achievement> getAchievement(String workerId,String companyId)
    {
        List<Achievement> achievements=employService.getAchievement(companyId,workerId);
        return  achievements;
    }

    @RequestMapping("getMistake")
    public List<Mistake> getMistake(String workerId,String companyId){
        List<Mistake> mistakes=employService.getMistake(companyId,workerId);
        return mistakes;
    }

    @RequestMapping("addGrade")
    public boolean addGrade(String workerId,String companyId,String content) throws ParseException {
        //每个月，每个员工都要添加一次绩效评价，添加完成之后，Grade表会增加一条记录(workerId和companyId决定employId)，worker表会将该员工的isevaluate置为1
        List<Employ> employs = employService.getEmploy(companyId, workerId);
        String employId = String.valueOf(employs.get(0).getId());
        Date createDate= DateTime.getDateTime();
        int count = employService.insertGrade(employId, content, createDate);
        Boolean flag=companyService.updateIsEvaluate(workerId);
        if (count == 1&& flag==true)
            return true;
        else
            return false;

    }

    @RequestMapping("addAchievement")
    public boolean addAchievement(String workerId,String companyId,String achievementContent) throws ParseException {
        System.out.println("post测试");
        System.out.println("workerId:"+workerId);
        System.out.println("achievementContent:"+achievementContent);
        List<Employ> employs = employService.getEmploy(companyId, workerId);
        String employId = String.valueOf(employs.get(0).getId());
        Date createDate= DateTime.getDateTime();
        int count=employService.insertAchievement(employId,achievementContent,createDate);
        if(count==1)
        return true;
        else
            return false;
    }

    @RequestMapping("addMistake")
    public boolean addMistake(String workerId,String companyId,String mistakeContent) throws ParseException {

        List<Employ> employs = employService.getEmploy(companyId, workerId);
        String employId = String.valueOf(employs.get(0).getId());
        Date createDate= DateTime.getDateTime();
        int count=employService.insertMistake(employId,mistakeContent,createDate);
        if(count==1)
            return true;
        else
            return false;
    }

    @RequestMapping("getResignContent")
    public String getResignContent(String workerId,String companyId){
       String resignContent=employService.getResignContent(companyId,workerId);

        return resignContent;
    }

}
