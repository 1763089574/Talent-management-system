package net.suncaper.demo.controller;

import net.suncaper.demo.common.domain.Company;
import net.suncaper.demo.service.CompanyService;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

@Controller
@RequestMapping("companyservice")
public class CompanyController {
    @Autowired
    public CompanyService companyService;

    @RequestMapping("/login")//登录操作，已经通过校验
    public String CompanyLogin(Model model, HttpServletRequest request, HttpServletResponse response)//登陆之后
    {
        String tmpid=request.getParameter("id");
        System.out.println("公司登陆传入的参数tmpid："+tmpid);
        Integer id=Integer.valueOf(tmpid);
        System.out.println("公司登陆传入的参数id:"+id);
        Company company=companyService.selectByPrimaryKey(id);
        String name=company.getName();
        System.out.println("根据id查询到的公司name:"+name);
        Cookie cookie1=new Cookie("company_name",name);//把公司id和公司名称存到cookie中返回给浏览器，以便切换其他页面成功
        Cookie cookie2=new Cookie("company_id",tmpid);
        cookie1.setPath("/");//任意路径都可以访问
        cookie2.setPath("/");
        response.addCookie(cookie1);
        response.addCookie(cookie2);

        return "Welcome";
    }

}
