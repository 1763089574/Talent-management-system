package net.suncaper.demo.service;

import net.suncaper.demo.common.domain.Company;
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
    List<Worker> findLike(String name,String major,int minAge,int maxAge,String education,String sex);
}
