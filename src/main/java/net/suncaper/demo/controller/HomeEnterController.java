package net.suncaper.demo.controller;

import com.aliyuncs.exceptions.ClientException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

@Controller
public class HomeEnterController {
    @RequestMapping("/EnterToCompany")
    public String EnterToCompany(){
        return "company_login";
    }
    @RequestMapping("/EnterToWorker")
    public String EnterToWorker(){
        return "worker_login";
    }

}
