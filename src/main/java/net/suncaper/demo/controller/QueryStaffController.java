package net.suncaper.demo.controller;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import net.suncaper.demo.common.domain.Dossier;
import net.suncaper.demo.common.domain.Employ;
import net.suncaper.demo.common.domain.Worker;
import net.suncaper.demo.common.domain.extend.WorkerDetail;
import net.suncaper.demo.service.CompanyService;
import net.suncaper.demo.service.DossierService;
import net.suncaper.demo.service.EmployService;
import net.suncaper.demo.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
        String tmpid=request.getParameter("worker_id");
        Integer id=Integer.valueOf(tmpid);
        Worker worker=workerService.getWorkerByID(id);

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
    public boolean applyAgree(HttpServletRequest request){//同意员工申请入职，根据公司id和员工id去resign表中将isconsent置为1，并将worker表中的belong置为当前公司的id
        String workerId=request.getParameter("workerId");
        String companyId=request.getParameter("companyId");
        Boolean flag=companyService.applyAgree(workerId,companyId);
        //将worker的belong由0改为当前需要加入的公司

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
    public boolean resignAgree(HttpServletRequest request){//同意员工申请离职，根据公司id和员工id去resign表中将isconsent置为1，并将worker表中的belong置为0
        Integer workerId=Integer.valueOf(request.getParameter("workerId"));
        Integer companyId=Integer.valueOf(request.getParameter("companyId"));
        Boolean flag=companyService.resignAgree(workerId,companyId);
        return flag;
    }

    @RequestMapping("resignRefuse")
    public boolean resignRefuse(HttpServletRequest request){//拒绝员工申请离职，根据公司id和员工id去resign表中将isconsent置为2
        Integer workerId=Integer.valueOf(request.getParameter("workerId"));
        Integer companyId=Integer.valueOf(request.getParameter("companyId"));
        Boolean flag=companyService.resignRefuse(workerId,companyId);
        return flag;
    }

}
