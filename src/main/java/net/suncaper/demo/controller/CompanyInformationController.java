package net.suncaper.demo.controller;

import net.suncaper.demo.common.domain.Company;
import net.suncaper.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("information")
public class CompanyInformationController {
    @Autowired
    private CompanyService companyService;
    @GetMapping("/getCompanyInfo")
    public Company getCompanyInfo(HttpServletRequest request){
        String id=request.getParameter("CompanyId");
//        System.out.println(id);
        Company company = companyService.findCompanyInfo(id);
        if (company.getFlag()==0){
            company.setStringFlag("未认证");
        }
        else {
            company.setStringFlag("已认证");
        }
        return company;
    }

    @GetMapping("/updateCompanyInfo")
    public String updateCompanyInfo(HttpServletRequest request){
        String id = request.getParameter("CompanyId");
        String name = request.getParameter("CompanyName");
        String phonenumber = request.getParameter("phoneNumber");
//        System.out.println(name);
        companyService.updateCompanyInfo(id,name,phonenumber);
        return "修改成功";
    }
}
