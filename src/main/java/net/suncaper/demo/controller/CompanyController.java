package net.suncaper.demo.controller;

import net.suncaper.demo.common.domain.Company;
import net.suncaper.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@CrossOrigin
@RequestMapping("company")

public class CompanyController {
    @Autowired
    public CompanyService companyService;
    //private CompanyService companyService;

    @GetMapping("register")
    public String register (HttpServletRequest request)
    {
        Integer ID = Integer.valueOf(request.getParameter("phone"));
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        System.out.println("name"+name);

        Company company=new Company(ID,name,phone,password,0,100);
        companyService.Register(company);




        return "注册成功";

    }



}
