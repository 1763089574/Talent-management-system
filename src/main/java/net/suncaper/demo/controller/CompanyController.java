package net.suncaper.demo.controller;

import net.suncaper.demo.common.domain.Company;
import net.suncaper.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("companyservice")
public class CompanyController {
    @Autowired
    public CompanyService companyService;

    @RequestMapping("/login")
    public String CompanyLogin(Model model,HttpServletRequest request)//登陆之后传入公司id到首页
    {
        String tmpid=request.getParameter("id");

        System.out.println("公司登陆传入的参数tmpid："+tmpid);
        Integer id=Integer.valueOf(tmpid);
        System.out.println("公司登陆传入的参数id:"+id);
        Company company=companyService.selectByPrimaryKey(id);
        String name=company.getName();
        System.out.println("根据id查询到的公司name:"+name);
        GlobalVariableController.id=id;//将公司的id传入到全局变量，由一个类GlobalVariableController控制
        GlobalVariableController.name=name;
        //model.addAttribute("Company_id",id);//将公司的id传入到Model的全局变量，由一个类GlobalVariableController控制
        return "Welcome";
    }

}
