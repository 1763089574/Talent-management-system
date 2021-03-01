package net.suncaper.demo.controller;

import net.suncaper.demo.common.domain.Dossier;
import net.suncaper.demo.common.domain.Employ;
import net.suncaper.demo.common.domain.Worker;
import net.suncaper.demo.common.domain.extend.WorkerDetail;
import net.suncaper.demo.service.CompanyService;
import net.suncaper.demo.service.DossierService;
import net.suncaper.demo.service.EmployService;
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
    @Autowired
    public WorkerService workerService;
    @Autowired
    public EmployService employService;
    @Autowired
    public DossierService dossierService;
    @RequestMapping("GetAllWorkers")
    public List<Worker> GetAllWorkerByCompanyId(HttpServletRequest request){
        String CompanyId=request.getParameter("CompanyId");
        System.out.println("querystaff.html"+CompanyId);
        List<Worker> workers=companyService.GetAllWorkersByCompanyId(CompanyId);
        //List<Worker> workers=companyService.findAll();
        System.out.println(workers);
        return workers;
    }
    @RequestMapping("GetWorkerById")
    public Worker GetWorkerById(HttpServletRequest request){
        String tmpid=request.getParameter("worker_id");
        Integer id=Integer.valueOf(tmpid);
        Worker worker=workerService.getWorkerByID(id);

        return worker;
    }


    @RequestMapping("getDossierById")
    public List<Dossier> getDossierById(HttpServletRequest request){
        String workerId=request.getParameter("workerId");
        String belong=request.getParameter("belong");


        return null;
    }

    @RequestMapping("getEmployById")
    public List<Employ> getEmployById(HttpServletRequest request){//找出员工曾经任职过的employ信息，注意，不包含当前任职的公司
        String workerId=request.getParameter("workerId");
        String belong=request.getParameter("belong");

        List<Employ> employs=employService.getEmployByWorker(workerId,belong);

        return employs;
    }

    @RequestMapping("getWorkerDetailById")
    public List<WorkerDetail> getWorkerDetailById(HttpServletRequest request){//根据员工id返回员工的详细信息
        String workerId=request.getParameter("workerId");
        String belong=request.getParameter("belong");
        List<WorkerDetail> workerDetails=employService.getWorkerDetailById(workerId,belong);
        return workerDetails;
    }



}
