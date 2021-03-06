package net.suncaper.demo.service;

import net.suncaper.demo.common.domain.Company;
import net.suncaper.demo.common.domain.License;
import net.suncaper.demo.common.domain.Worker;

import java.util.List;


public interface CompanyService {

    void Register(Company company);//员工注册

    public long checkName(String name);//检查公司名称是否已注册

    public long checkPhone(String phone);//检查公司号码是否已注册

    //public List<Company> companyLogin(String phone,String password);//公司登陆并返回公司信息
    public int companyLogin(String phone,String password);//公司登陆校验，只是校验

    public Company selectByPrimaryKey(Integer id);//根据id查询公司信息

    public List<Worker> GetAllWorkersByCompanyId(String CompanyId);//根据CompanyId查询隶属于这个公司的所有员工

    List<Worker> findAll();
    List<Company> findAllCompany();//返回所有认证成功的公司列表
    List<Worker> findLike(String name,String major,int minAge,int maxAge,String education,String sex);

    public List<Worker> getApplyList(String companyId);//根据公司id,返回当前公司的待入职列表

    public List<Worker> getResignList(String companyId);//根据公司id，返回当前公司的待离职列表

    public boolean applyAgree(String workerId,String companyId);//根据workerId，来同意员工的入职申请

    public boolean applyRefuse(String workerId,String companyId);//根据workerId和companyId，来拒绝员工的入职申请

    public boolean resignAgree(int workerId,int companyId);//根据workerId，来同意员工的离职申请

    public boolean resignRefuse(int workerId,int companyId);//根据workerId和companyId，来拒绝员工的离职申请

    public boolean updateIsEvaluate(String workerId);//根据workerId将worker的isevaluate字段置为1

    public Company findCompanyInfo(String id);
    public void updateCompanyInfo(String id,String name,String phonenumber);
    int save(License license);
    License ifCertification(String CompanyId);
    List<Worker> getCommission(String CompanyId);
}
