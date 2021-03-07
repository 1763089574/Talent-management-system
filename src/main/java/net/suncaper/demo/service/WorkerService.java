package net.suncaper.demo.service;

import net.suncaper.demo.common.domain.*;

import java.util.List;

public interface WorkerService {
    boolean phonenumber_exist(String numbers);//验证号码是否已经存在
    void register_(Worker worker);//员工注册
    boolean login(Worker worker);//判断账号密码是否正确
    int getWorkerID(Worker worker);
    Worker getWorkerByID(int workid);
    int getWorkerIdByEmployId(int employId);//通过employId，得到对应的workerId--DQ
    public List<Worker> GetAllWorkersByCompanyId(String CompanyId);//根据CompanyId查询隶属于这个公司的所有员工
    void sendWorkerApply(int companyid,int workerid);//员工发送加入公司的申请
    boolean ifApplying(int workerid);
    Employ getEmployIncludeCompanyNameByEmployId(int employId);//通过employId，得到包括公司名称的employ实例对象---DQ
    Employ getNowEmploy(int workerid);//通过员工Id 得到现在效忠的公司的emlpoy关系类的实例，没有就返回null ——DQ
    List<Grade> getNowCompanyGradeByEmployID(int employid);//通过employ_id 得到对应的grade类实例 ，没有就返回null ——DQ
    List<Achievement> getNowCompanyAchievementByEmployID(int employid);//通过employ_id 得到对应的Achievement类实例 ，没有就返回null ——DQ
    List<Mistake> getNowCompanyMistakeByEmployID(int employid);//通过employ_id 得到对应的Mistake类实例 ，没有就返回null ——DQ
    List<Employ> getPassCompanyEmployList(int workerid);
    List<Resign> getResignList(int workerId);//通过workerId 得到对应的resign表列表 ，没有就返回null ——DQ
    void confirmResignApply(int resignId);//通过resignId，将resign字符有0改为1（表示员工已经确认离职通知）成功返回true ，失败就返回false ——DQ
    int getEmployIdByCompanyIdAndWorkerId(int companyId,int workerId);//通过companyId和workerId,获得对应的employId---DQ
    Resign getResignByResignId(int resignId);//通过resignId,得到实体类--DQ
    Resign getResignByWorkerIdAndCompanyId(int companyId,int workerId);//通过compantID和worekrID得到resign对象实例--DQ
    void addResignEvaluate(int employId);//在员工确认离职后，添加为员工在evaluate表中添加评价待评价记录--DQ
    void addEmpolyEndDate(int employId);//在员工确认离职后，在对应empoly表中的对应雇员关系记录中添加商endDate--DQ
    List<Evaluate> getAllWaitToEvaluateList(int workerId);//获得员工所有评价列表（未评价和已评价均包括）———DQ
    void addEvaluate(String text,int evaluateId);//员工添加评价到数据库————DQ
    Dossier getDossierObjectByEmployId(int employId);//通过EmployId得到对应的dossier档案对象实例--DQ
    Evaluate getEvaluateObjectByEmployId(int employId);//通过employId,得到Evaluate表的实例对象--DQ
    void addResignApply(int companyId,int workerId,String content);
    boolean addCertifyWorkerInformation(Worker worker);//将识别的身份证信息加入数据库
    boolean ifConfirm(int workerId);//判断是否身份认证
}
