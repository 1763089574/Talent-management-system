package net.suncaper.demo.controller;

import com.aliyuncs.exceptions.ClientException;
import net.suncaper.demo.common.domain.Apply;
import net.suncaper.demo.common.domain.Worker;
import net.suncaper.demo.common.util.HashCode;
import net.suncaper.demo.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

@Controller
public class ApplyController {
    @Autowired
    public WorkerService workerService;
    @GetMapping("/sendWorkerApply")

    @ResponseBody
    public void sendWorkerApply(HttpServletRequest request) throws ClientException, NoSuchAlgorithmException {
        int workerid = Integer.valueOf(request.getParameter("workerid"));
        int companyid = Integer.valueOf(request.getParameter("companyid"));

        System.out.println(workerid+" "+companyid);

        workerService.sendWorkerApply(companyid,workerid);

    }

    //判断用户是否可以点击公司查询页面的按钮
    //不能点击的条件：未实名认证、已经申请但公司未确定、现已经在某家企业上班
    @GetMapping("/ifClickApplyButton")

    @ResponseBody
    public boolean ifClickApplyButton(HttpServletRequest request) throws ClientException, NoSuchAlgorithmException {
        int workerid = Integer.valueOf(request.getParameter("workerid"));
        Worker worker = workerService.getWorkerByID(workerid);
        System.out.println(worker.getIdentifyflag());
        System.out.println("workerID为"+workerid);
        if(worker.getBelong()!="0"||worker.getIdentifyflag()!=1||workerService.ifApplying(workerid)){
            return false;
        }else{
            return true;
        }



    }

}
