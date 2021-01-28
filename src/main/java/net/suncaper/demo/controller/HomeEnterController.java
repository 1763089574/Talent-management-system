package net.suncaper.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeEnterController {
    @RequestMapping("/EnterToCompany")
    public String EnterToCompany(){
        return "company_login";
    }
    @RequestMapping("/EnterToWorker")
    public String EnterToWorker(){
        return "employee_login";
    }

}