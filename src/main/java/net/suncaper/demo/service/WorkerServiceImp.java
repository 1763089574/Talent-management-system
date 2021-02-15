package net.suncaper.demo.service;

import net.suncaper.demo.common.domain.Worker;
import net.suncaper.demo.common.domain.WorkerExample;
import net.suncaper.demo.mapper.WorkerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WorkerServiceImp implements WorkerService{

    @Autowired
    WorkerMapper workerMapper;
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
