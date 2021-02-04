package net.suncaper.demo.controller;

import net.suncaper.demo.common.domain.Company;
import net.suncaper.demo.common.domain.CompanyExample;
import net.suncaper.demo.common.util.HashCode;
import net.suncaper.demo.mapper.CompanyMapper;
import net.suncaper.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("company")

public class CompanyController {
    @Autowired
    public CompanyService companyService;
    //private CompanyService companyService;

    @GetMapping("register")
    public String register (HttpServletRequest request)//公司注册
    {
        String name = request.getParameter("name");
        String phone=request.getParameter("phone");
        String tmpPassword = request.getParameter("password");
        String password= null;
        try {//使用哈希函数存储密码
            password = HashCode.GetHashCode(tmpPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("name"+name);

        //Company company=new Company(ID,name,phone,password,0,100);
        Company company=new Company();
        company.setPhonenumber(phone);
        company.setName(name);
        company.setPassword(password);
        company.setFlag(0);
        company.setCredit(100);
        companyService.Register(company);

        return "注册成功";

    }

    @GetMapping("checkName")
    public boolean checkName(HttpServletRequest request)//检查公司名称是否已被注册
    {
        String name=request.getParameter("name");
        long count=companyService.checkName(name);
        System.out.println("count"+count);
        if(count==0) {
            return false;
        }
        else
        {
            return true;
        }


    }
    @GetMapping("checkPhone")
    public boolean checkPhone(HttpServletRequest request)//检查公司名称是否已被注册
    {
        String phone=request.getParameter("phone");
        long count=companyService.checkPhone(phone);
        System.out.println("count"+count);
        if(count==0) {
            return false;
        }
        else
        {
            return true;
        }


    }
    @GetMapping("login")

    public List<Company> login(HttpServletRequest request){
        String phone=request.getParameter("loginPhone");
        String tmpPassword=request.getParameter("loginPassword");
        String password= null;
        try {//使用哈希函数存储密码
            password = HashCode.GetHashCode(tmpPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("password"+password);
        List<Company> company=companyService.companyLogin(phone,password);
        System.out.println("company"+company);
        System.out.println(company);


        return company;
    }





}
