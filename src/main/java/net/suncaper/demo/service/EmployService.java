package net.suncaper.demo.service;

import net.suncaper.demo.common.domain.Achievement;
import net.suncaper.demo.common.domain.Employ;
import net.suncaper.demo.common.domain.Grade;
import net.suncaper.demo.common.domain.Mistake;
import net.suncaper.demo.common.domain.extend.WorkerDetail;

import java.util.List;

public interface EmployService {
    public List<Employ> getEmployByWorker(String workerId,String belong);//找出员工曾经任职过的employ信息，注意，不包含当前任职的公司


    public List<WorkerDetail> getWorkerDetailById(String workerId,String belong);//根据员工id和当前所属公司，找出员工曾经任职任职过的所有公司

    public List<Grade> getGrade(String companyId,String workerId);

    public List<Employ> getEmploy(String companyId,String workerId);

    public List<Achievement> getAchievement(String companyId,String workerId);

    public List<Mistake> getMistake(String companyId,String workerId);

    public int insertEmploy(String companyId,String workerId);
}
