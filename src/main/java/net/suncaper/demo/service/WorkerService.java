package net.suncaper.demo.service;

import net.suncaper.demo.common.domain.Apply;
import net.suncaper.demo.common.domain.Worker;

import java.util.List;

public interface WorkerService {
    boolean phonenumber_exist(String numbers);//验证号码是否已经存在
    void register_(Worker worker);//员工注册
    boolean login(Worker worker);//判断账号密码是否正确
    int getWorkerID(Worker worker);
    Worker getWorkerByID(int workid);
    public List<Worker> GetAllWorkersByCompanyId(String CompanyId);//根据CompanyId查询隶属于这个公司的所有员工
    void sendWorkerApply(int companyid,int workerid);//员工发送加入公司的申请
    boolean ifApplying(int workerid);
}
