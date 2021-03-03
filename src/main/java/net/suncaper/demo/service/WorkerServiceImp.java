package net.suncaper.demo.service;

import net.suncaper.demo.common.domain.*;
import net.suncaper.demo.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.stereotype.Service;

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
    AchievementMapper achievementMapper;
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
        workerMapper.insert(worker);
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
        System.out.println(employs.get(0).getId());
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
