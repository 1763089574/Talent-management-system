package net.suncaper.demo.controller;

import net.suncaper.demo.common.domain.Worker;
import net.suncaper.demo.service.CompanyService;
import net.suncaper.demo.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("Querystaff")
public class QueryStaffController {
    @Autowired
    public CompanyService companyService;

    @RequestMapping("GetAllWorkers")
    public List<Worker> GetAllWorkerByCompanyId(HttpServletRequest request){
        String CompanyId=request.getParameter("CompanyId");
        System.out.println("querystaff.html"+CompanyId);
        List<Worker> workers=companyService.GetAllWorkersByCompanyId(CompanyId);
        //List<Worker> workers=companyService.findAll();
        System.out.println(workers);
        return workers;
    }

}
