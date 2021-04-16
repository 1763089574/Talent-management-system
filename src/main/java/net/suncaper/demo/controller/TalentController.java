package net.suncaper.demo.controller;

import net.suncaper.demo.common.domain.Dossier;
import net.suncaper.demo.common.domain.Worker;
import net.suncaper.demo.common.domain.extend.WorkerCompare;
import net.suncaper.demo.service.CompanyService;
import net.suncaper.demo.service.DossierService;
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
    @Autowired
    private DossierService dossierService;

    @GetMapping("/findAll")
    public List<Worker> findAll(){
        return companyService.findAll();
    }

    @GetMapping("/findLike")
    public List<Worker> findLike(String name,String major,int minAge,int maxAge,String education,String sex){
        System.out.println(name+major+minAge+maxAge+education+sex);
        return companyService.findLike(name, major, minAge, maxAge, education, sex);
    }
    @GetMapping("/details")
    public List<Dossier> findDetails(int id){
        return dossierService.findDetail(id);
    }

    @GetMapping("/GetCompareDate")
    public List<WorkerCompare> GetCompareDate(int workerId1, int workerId2){
        return companyService.GetCompareDate(workerId1, workerId2);
    }

}
