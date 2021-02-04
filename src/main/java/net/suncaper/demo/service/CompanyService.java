package net.suncaper.demo.service;

import net.suncaper.demo.common.domain.Company;

import java.util.List;


public interface CompanyService {

    void Register(Company company);//员工注册

    public long checkName(String name);//检查公司名称是否已注册

    public long checkPhone(String phone);//检查公司名称是否已注册

    public List<Company> companyLogin(String phone,String password);//公司登陆并返回公司信息
}
