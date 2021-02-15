package net.suncaper.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("GlobalVariable")
public class GlobalVariableController {//全局变量控制器，需要什么就往Cookie里面加，要取的时候就写方法来取

    public static int id;//公司id
    public static String name;//公司名称
    @GetMapping("GetCompanyId")
    public int GetCompanyID(HttpServletRequest request, HttpServletResponse response) throws IOException {//公司Id被存在全局变量中，需要的时候就从里面取
        Cookie[] cookies=request.getCookies();
        for(Cookie cookie:cookies){
            System.out.println("getCompanyID");
            System.out.println("value:" + cookie.getValue());
            System.out.println("name:" + cookie.getName());
            if (cookie.getName().equals("company_id")) {
                id=Integer.parseInt(cookie.getValue());
            }
            /*else {
                response.sendRedirect("/EnterToCompany");
            }*/
        }

        return id;
    }

    @RequestMapping("GetCompanyName")
    public String GetCompanyName(HttpServletRequest request, HttpServletResponse response) throws IOException {//公司Name被存在全局变量中，需要的时候就从里面取
        Cookie[] cookies=request.getCookies();
        for(Cookie cookie:cookies){
            System.out.println("getCompanyname");
            System.out.println("value:" + cookie.getValue());
            System.out.println("name:" + cookie.getName());
            if (cookie.getName().equals("company_name")) {
                name=cookie.getValue();
            }
            /*else {
                response.sendRedirect("/EnterToCompany");
            }*/
        }

        return name;
    }
}
