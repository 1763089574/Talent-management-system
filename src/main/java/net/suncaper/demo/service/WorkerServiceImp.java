package net.suncaper.demo.service;

import net.suncaper.demo.common.domain.Apply;
import net.suncaper.demo.common.domain.ApplyExample;
import net.suncaper.demo.common.domain.Worker;
import net.suncaper.demo.common.domain.WorkerExample;
import net.suncaper.demo.mapper.ApplyMapper;
import net.suncaper.demo.mapper.WorkerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WorkerServiceImp implements WorkerService{

    @Autowired
    WorkerMapper workerMapper;

    @Autowired
    ApplyMapper applyMapper;
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
