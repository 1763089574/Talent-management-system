package net.suncaper.demo.service;

import net.suncaper.demo.common.domain.*;
import net.suncaper.demo.common.domain.extend.WorkerDetail;
import net.suncaper.demo.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class EmployServiceImpl implements EmployService {
    @Autowired
    EmployMapper employMapper;
    @Autowired
    CompanyMapper companyMapper;
    @Autowired
    GradeMapper gradeMapper;
    @Autowired
    AchievementMapper achievementMapper;
    @Autowired
    MistakeMapper mistakeMapper;
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

    @Override
    public List<Grade> getGrade(String companyId, String workerId) {

        List<Grade> grades=gradeMapper.getGrade(companyId,workerId);
        return grades;
    }

    @Override
    public List<Employ> getEmploy(String companyId, String workerId) {//根据指定的公司id和员工id找出对应的employ
        EmployExample employExample=new EmployExample();
        EmployExample.Criteria criteria =employExample.createCriteria();
        criteria.andCompanyIdEqualTo(Integer.valueOf(companyId));
        criteria.andWorkerIdEqualTo(Integer.valueOf(workerId));
        List<Employ> employs=employMapper.selectByExample(employExample);
        return employs;
    }

    @Override
    public List<Achievement> getAchievement(String companyId, String workerId) {
        List<Achievement> achievements=achievementMapper.getAchievement(workerId,companyId);
        return achievements;
    }

    @Override
    public List<Mistake> getMistake(String companyId, String workerId) {
        List<Mistake> mistakes=mistakeMapper.getMistake(companyId,workerId);
        return mistakes;
    }

    @Override
    public int insertEmploy(String companyId, String workerId, Date date) {
        Employ employ=new Employ();
        employ.setCompanyId(Integer.valueOf(companyId));
        employ.setWorkerId(Integer.valueOf(workerId));
        employ.setStartDate(date);
        int count=employMapper.insertSelective(employ);
        return count;
    }

    @Override
    public int employEndDate(String employID, Date endDate) {
        Employ record=new Employ();
        record.setId(Integer.valueOf(employID));
        record.setEndDate(endDate);
        int count=employMapper.updateByPrimaryKeySelective(record);
        return count;
    }
}
