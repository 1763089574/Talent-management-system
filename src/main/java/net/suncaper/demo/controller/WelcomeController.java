package net.suncaper.demo.controller;

import net.suncaper.demo.common.domain.Worker;
import net.suncaper.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/welcome")
public class WelcomeController {
    @Autowired
    private CompanyService companyService;
    @GetMapping("/getCommission")
    public List<Worker> getCommission(String CompanyId){
        return companyService.getCommission(CompanyId);
    }

    @GetMapping("/getCheck")
    public List<Worker> getCheck(String CompanyId){
        return companyService.getCheck(CompanyId);
    }
    @GetMapping("/getResign")
    public List<Worker> getResign(String CompanyId){
        return companyService.getResign(CompanyId);
    }
}
