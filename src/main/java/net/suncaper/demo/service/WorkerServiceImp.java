package net.suncaper.demo.service;

import net.suncaper.demo.common.domain.*;
import net.suncaper.demo.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class WorkerServiceImp implements WorkerService{

    @Autowired
    WorkerMapper workerMapper;

    @Autowired
    ApplyMapper applyMapper;

    @Autowired
    EmployMapper employMapper;

    @Autowired
    GradeMapper gradeMapper;

    @Autowired
    MistakeMapper mistakeMapper;

    @Autowired
    ResignMapper resignMapper;

    @Autowired
    AchievementMapper achievementMapper;

    @Autowired
    EvaluateMapper evaluateMapper;

    @Autowired
    DossierMapper dossierMapper;
    public boolean phonenumber_exist(String numbers){
        WorkerExample example = new WorkerExample();
        example.createCriteria().andPhonenumberEqualTo(numbers);
        List<Worker> workers = workerMapper.selectByExample(example);
        if(workers.size()!=0){
            return true;
        }else {
            return false;
        }
    }

    public void register_(Worker worker){
        workerMapper.insertSelective(worker);
    }

    public void sendWorkerApply(int companyid,int workerid){
        Apply apply = new Apply();
        apply.setCompanyid(companyid);
        apply.setWorkerid(workerid);
        apply.setIsconsent(0);
        applyMapper.insert(apply);
    }

    public boolean ifApplying(int workerid){
        ApplyExample applyExample = new ApplyExample();
        applyExample.createCriteria().andWorkeridEqualTo(workerid).andIsconsentEqualTo(0);
        List<Apply> applies = applyMapper.selectByExample(applyExample);
        if(applies.size()>0){
            return true;
        }else{
            return false;
        }


    }

    public Employ getEmployIncludeCompanyNameByEmployId(int emloyId){
        return employMapper.getEmployIncludeCompanyNameByEmployId(emloyId);
    }

    public Dossier getDossierObjectByEmployId(int emloyId){
        DossierExample dossierExample = new DossierExample();
        dossierExample.createCriteria().andEmployIdEqualTo(emloyId);
        List<Dossier> dossiers = dossierMapper.selectByExample(dossierExample);
        return dossiers.get(0);


    }

    public boolean login(Worker worker){
        WorkerExample example = new WorkerExample();
        example.createCriteria().andPhonenumberEqualTo(worker.getPhonenumber()).andPasswordEqualTo(worker.getPassword());
        List<Worker> workers = workerMapper.selectByExample(example);
        if(workers.size()!=0){
            return true;
        }else{
            return false;
        }

    }
    public int getWorkerID(Worker worker){
        WorkerExample example = new WorkerExample();
        example.createCriteria().andPhonenumberEqualTo(worker.getPhonenumber()).andPasswordEqualTo(worker.getPassword());
        List<Worker> workers = workerMapper.selectByExample(example);

        return workers.get(0).getId();

    }

    public Worker getWorkerByID(int workerid){
        Worker worker = workerMapper.selectByPrimaryKey(workerid);
        return worker;
    }

    public Evaluate getEvaluateObjectByEmployId(int employId){
        EvaluateExample evaluateExample = new EvaluateExample();
        evaluateExample.createCriteria().andEmployIdEqualTo(employId);
        List<Evaluate> evaluates = evaluateMapper.selectByExample(evaluateExample);
        return evaluates.get(0);


    }

    public Resign getResignByResignId(int resignId){
        return resignMapper.selectByPrimaryKey(resignId);
    }
    public void addResignEvaluate(int employId){
        Evaluate evaluate = new Evaluate();
        evaluate.setEmployId(employId);
        evaluate.setIsevaluate(0);
        evaluateMapper.insert(evaluate);
    }

    public  List<Grade> getNowCompanyGradeByEmployID(int employid){
        GradeExample gradeExample = new GradeExample();
        gradeExample.createCriteria().andEmployIdEqualTo(employid);
        List<Grade> grades = gradeMapper.selectByExample(gradeExample);
        if(grades.size()>0){
            return grades;
        }else{
            return null;
        }

    }

    public List<Achievement> getNowCompanyAchievementByEmployID(int employid){
        AchievementExample achievementExample = new AchievementExample();
        achievementExample.createCriteria().andEmployIdEqualTo(employid);
        List<Achievement> achievements = achievementMapper.selectByExample(achievementExample);
        if(achievements.size()>0){
            return achievements;
        }else{
            return null;
        }

    }
    public int getEmployIdByCompanyIdAndWorkerId(int companyId,int workerId){
        EmployExample employExample = new EmployExample();
        employExample.createCriteria().andCompanyIdEqualTo(companyId).andWorkerIdEqualTo(workerId);
        List<Employ> employs = employMapper.selectByExample(employExample);

        return employs.get(0).getId();


    }
    public List<Resign> getResignList(int workerId){

        List<Resign> resigns = resignMapper.getResignListByWorkerid(workerId);
        if(resigns.size()>0){
            return resigns;
        }else{
            return null;
        }

    }
    public void addEmpolyEndDate(int employId){
        Employ employ = employMapper.selectByPrimaryKey(employId);
        Date date = new Date();
        employ.setEndDate(date);
        employMapper.updateByPrimaryKey(employ);
    }
    public void confirmResignApply(int resignId){
        Resign resign = resignMapper.selectByPrimaryKey(resignId);
        resign.setIsconsent("1");
        resignMapper.updateByPrimaryKey(resign);

    }

    public boolean ifConfirm(int workerId){
        Worker worker = workerMapper.selectByPrimaryKey(workerId);
        if(worker.getIdentifyflag()==1){
            return true;
        }else{
            return false;
        }

    }

    public boolean addCertifyWorkerInformation(Worker worker){
        String Cid = worker.getIdcard();
        //判断是否已经使用改身份证进行注册
        WorkerExample example = new WorkerExample();
        example.createCriteria().andIdcardEqualTo(Cid);
        List<Worker> workers = workerMapper.selectByExample(example);


        if(workers.size()==0){
            int workerId =worker.getId();
            Worker worker1 = workerMapper.selectByPrimaryKey(workerId);
            worker.setPassword(worker1.getPassword());
            worker.setPhonenumber(worker1.getPhonenumber());
            worker.setIdentifyflag(1);

            workerMapper.updateByPrimaryKeySelective(worker);
            return true;

        }else{
            return false;
        }
    }

    public Resign getResignByWorkerIdAndCompanyId(int companyId,int workerId){
        ResignExample resignExample = new ResignExample();
        resignExample.createCriteria().andWorkerIdEqualTo(workerId).andCompanyIdEqualTo(companyId).andIsconsentEqualTo("0");
        List<Resign> resigns = resignMapper.selectByExample(resignExample);
        if (resigns.size()==0){
            return null;
        }else {
            return resigns.get(0);
        }


    }

    public void addResignApply(int companyId,int workerId,String content){
        Resign resign = new Resign();
        resign.setIsconsent("0");
        resign.setCompanyId(companyId);
        resign.setWorkerId(workerId);
        resign.setContent(content);

        resignMapper.insert(resign);

    }

    public void addEvaluate(String text,int evaluateId){
        Evaluate evaluate = evaluateMapper.selectByPrimaryKey(evaluateId);
        evaluate.setEvaluatecontent(text);
        evaluate.setIsevaluate(1);
        evaluateMapper.updateByPrimaryKey(evaluate);
    }
    public List<Evaluate> getAllWaitToEvaluateList(int workerId){
        List<Evaluate> allWaitToEvaluateList = evaluateMapper.getAllWaitToEvaluateList(workerId);
        if (allWaitToEvaluateList.size()>0){
            return allWaitToEvaluateList;
        }else{
            return null;
        }

    }

    public int getWorkerIdByEmployId(int employId){
        Employ employ = employMapper.selectByPrimaryKey(employId);
        int workerId = employ.getWorkerId();
        return workerId;

    }
    public List<Mistake> getNowCompanyMistakeByEmployID(int employid){
        MistakeExample mistakeExample = new MistakeExample();
        mistakeExample.createCriteria().andEmployIdEqualTo(employid);
        List<Mistake> mistakes = mistakeMapper.selectByExample(mistakeExample);
        if(mistakes.size()>0){
            return mistakes;
        }else{
            return null;
        }

    }

    public Employ getNowEmploy(int workerid){
        EmployExample employExample = new EmployExample();
        employExample.createCriteria().andWorkerIdEqualTo(workerid).andEndDateIsNull();
        List<Employ> employs = employMapper.selectByExample(employExample);
        //System.out.println(employs.get(0).getId());
        if(employs.size()>0){
            return employs.get(0);
        }else{
            return null;
        }

    }
    public List<Employ> getPassCompanyEmployList(int workerid){
//        EmployExample employExample = new EmployExample();
//        employExample.createCriteria().andWorkerIdEqualTo(workerid).andEndDateIsNotNull();
//        List<Employ> employs = employMapper.selectByExample(employExample);

        List<Employ> passCompanyList = employMapper.getPassCompanyList(workerid);
        if(passCompanyList.size()>0){
            return passCompanyList;
        }else{
            return null;
        }

    }

    @Override
    public List<Worker> GetAllWorkersByCompanyId(String CompanyId) {

        System.out.println("WorkerServiceImpl");
        WorkerExample example=new WorkerExample();
        WorkerExample.Criteria criteria=example.createCriteria();
        criteria.andBelongEqualTo(CompanyId);
        List<Worker> workers=workerMapper.selectByExample(example);

        if(!workers.isEmpty()){


                String idcard = workers.get(0).getIdcard();
                System.out.println(idcard);



        }
        return workers;
    }
}
