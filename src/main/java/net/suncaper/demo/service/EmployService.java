package net.suncaper.demo.service;

import net.suncaper.demo.common.domain.Employ;
import net.suncaper.demo.common.domain.extend.WorkerDetail;

import java.util.List;

public interface EmployService {
    public List<Employ> getEmployByWorker(String workerId,String belong);//找出员工曾经任职过的employ信息，注意，不包含当前任职的公司

    public List<WorkerDetail> getWorkerDetailById(String workerId,String belong);//根据员工id和当前所属公司，找出员工曾经任职经历
}
