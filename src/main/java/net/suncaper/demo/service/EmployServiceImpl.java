package net.suncaper.demo.service;

import net.suncaper.demo.common.domain.Employ;
import net.suncaper.demo.common.domain.EmployExample;
import net.suncaper.demo.common.domain.extend.WorkerDetail;
import net.suncaper.demo.mapper.CompanyMapper;
import net.suncaper.demo.mapper.EmployMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployServiceImpl implements EmployService {
    @Autowired
    EmployMapper employMapper;
    @Autowired
    CompanyMapper companyMapper;
    @Override
    public List<Employ> getEmployByWorker(String workerId,String belong) {//找出员工曾经任职过的employ，注意，不包含当前任职的公司
        EmployExample employExample=new EmployExample();
        EmployExample.Criteria criteria=employExample.createCriteria();
        Integer workerId2=Integer.valueOf(workerId);
        Integer belong2=Integer.valueOf(belong);
        criteria.andWorkerIdEqualTo(workerId2);
        criteria.andCompanyIdNotEqualTo(belong2);
        List<Employ> employs=employMapper.selectByExample(employExample);
        return employs;
    }

    @Override
    public List<WorkerDetail> getWorkerDetailById(String workerId,String belong) {
        List<WorkerDetail> workerDetails=companyMapper.getWorkerDetailById(workerId,belong);

        return workerDetails;
    }
}
