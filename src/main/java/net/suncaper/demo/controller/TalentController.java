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
@RequestMapping("worker")
public class TalentController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/findAll")
    public List<Worker> findAll(){
        return companyService.findAll();
    }

    /*@GetMapping("/findLike")
    public List<Worker> findLike(String name,String major,int minAge,int maxAge,String education,String sex){
        System.out.println(name+major+minAge+maxAge+education+sex);
        return companyService.findLike(name, major, minAge, maxAge, education, sex);
    }*/
}
