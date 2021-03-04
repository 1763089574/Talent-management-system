package net.suncaper.demo.service;

import net.suncaper.demo.common.domain.*;

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
    Employ getNowEmploy(int workerid);//通过员工Id 得到现在效忠的公司的emlpoy关系类的实例，没有就返回null ——DQ
    List<Grade> getNowCompanyGradeByEmployID(int employid);//通过employ_id 得到对应的grade类实例 ，没有就返回null ——DQ
    List<Achievement> getNowCompanyAchievementByEmployID(int employid);//通过employ_id 得到对应的Achievement类实例 ，没有就返回null ——DQ
    List<Mistake> getNowCompanyMistakeByEmployID(int employid);//通过employ_id 得到对应的Mistake类实例 ，没有就返回null ——DQ
    List<Employ> getPassCompanyEmployList(int workerid);
}
