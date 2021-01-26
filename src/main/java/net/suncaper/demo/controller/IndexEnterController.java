package net.suncaper.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexEnterController {
    @RequestMapping("/EnterToCompany")
    public String EnterToCompany(){
        return "CompanyIndex";
    }
    @RequestMapping("/EnterToWorker")
    public String EnterToWorker(){
        return "WorkerIndex";
    }

}
