package net.suncaper.demo.controller;

//import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import net.suncaper.demo.common.domain.*;
import net.suncaper.demo.common.util.HashCode;
import net.suncaper.demo.service.CompanyService;
import net.suncaper.demo.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import static net.suncaper.demo.common.util.AliyunSms.sendSms;

@Controller
public class WorkerController {
    @Autowired
    public WorkerService workerService;

    @Autowired
    public CompanyService companyService;


    @GetMapping("/check_number")

    @ResponseBody
    public int number_exist(HttpServletRequest request) throws ClientException {
        String number = request.getParameter("phonenumber");
        String code = request.getParameter("codenumber");
        System.out.println(code);
        if(workerService.phonenumber_exist(number)){
            return 1;//返回 1 代表 该号码已经注册
        }else{

            SendSmsResponse sendSmsResponse = sendSms(number, code);
            if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
                return 2;//返回 2 代表短信成功发送
            }else{
                return 3;//返回 3 代表短信短信发送失败
            }
        }
    }

    @GetMapping("/register")

    @ResponseBody
    public void register(HttpServletRequest request) throws ClientException, NoSuchAlgorithmException {
        String phonenumber = request.getParameter("phonenumber");
        String name = request.getParameter("name");
        //String password = GetHashCode(request.getParameter("password"));
        String password = Integer.toString(HashCode.GetHashCode(request.getParameter("password")));
        Worker man = new Worker();
        man.setName(name);
        man.setPhonenumber(phonenumber);
        man.setPassword(password);
        workerService.register_(man);
    }

    @GetMapping("/login")

    @ResponseBody
    public int login_(HttpServletRequest request, HttpServletResponse response) throws ClientException, NoSuchAlgorithmException {
        String phonenumber = request.getParameter("phonenumber");

        //String password = GetHashCode(request.getParameter("password"));//邓拳写的
        String password = Integer.toString(HashCode.GetHashCode(request.getParameter("password")));
        Worker man = new Worker();

        man.setPhonenumber(phonenumber);
        man.setPassword(password);
        if(workerService.login(man)){
            //登陆成功的用户，其员工ID被存入cookie中去
            int id = workerService.getWorkerID(man);
            //cookie似乎只能存放String，所以吧workerid转一下类型
            String Sid = String.valueOf(id);
            Cookie cookie = new Cookie("workerid",Sid);
            cookie.setPath("/");
            response.addCookie(cookie);

            return 1;//登陆成功
        }else{
            return 0;//登陆失败
        }
    }

    @GetMapping("/getWorkerNameByID")

    @ResponseBody
    public String getWorkerNameByID(HttpServletRequest request, HttpServletResponse response) throws ClientException, NoSuchAlgorithmException {
        String Str_id = request.getParameter("workerid");
        int workerid = Integer.valueOf(Str_id);
        Worker worker = workerService.getWorkerByID(workerid);
        return worker.getName();
    }

    @GetMapping("/getWorkerAllInformationByID")

    @ResponseBody
    public Worker getWorkerAllInformationByID(HttpServletRequest request, HttpServletResponse response) throws ClientException, NoSuchAlgorithmException {
        String Str_id = request.getParameter("workerid");
        int workerid = Integer.valueOf(Str_id);
        Worker worker = workerService.getWorkerByID(workerid);
        if(worker.getIdcard()!=null){
            worker.setIdcard(worker.getIdcard().substring(0,4)+"**********"+worker.getIdcard().substring(14,18));
        }
        return worker;
    }

    @GetMapping("/getPassCompanyEmployList")

    @ResponseBody
    public List<Employ> getPassCompanyEmployList(HttpServletRequest request, HttpServletResponse response) throws ClientException, NoSuchAlgorithmException {
        String Str_id = request.getParameter("workerid");
        int workerid = Integer.valueOf(Str_id);
        List<Employ> passCompanyEmployList = workerService.getPassCompanyEmployList(workerid);

        return passCompanyEmployList;
    }

    @GetMapping("/getResignList")

    @ResponseBody
    public List<Resign> getResignList(HttpServletRequest request, HttpServletResponse response) throws ClientException, NoSuchAlgorithmException {
        String Str_id = request.getParameter("workerId");
        int workerId = Integer.valueOf(Str_id);
        List<Resign> resignList = workerService.getResignList(workerId);
        return resignList;
    }

    @GetMapping("/confirmResignApply")

    @ResponseBody
    public void confirmResignApply(HttpServletRequest request, HttpServletResponse response) throws ClientException, NoSuchAlgorithmException {
        String str_resignId = request.getParameter("resignId") ;
        int resignId = Integer.valueOf(str_resignId);
        workerService.confirmResignApply(resignId);
    }

    @GetMapping("/getNowCompanyInformation")

    @ResponseBody
    public HashMap getNowCompanyInformation(HttpServletRequest request, HttpServletResponse response) throws ClientException, NoSuchAlgorithmException {
        String Str_id = request.getParameter("workerid");
        int workerid = Integer.valueOf(Str_id);
        Employ employ = workerService.getNowEmploy(workerid);
        Company company = companyService.selectByPrimaryKey(employ.getCompanyId());
        List<Achievement> nowCompanyAchievementByEmployID = workerService.getNowCompanyAchievementByEmployID(employ.getId());
        List<Mistake> nowCompanyMistakeByEmployID = workerService.getNowCompanyMistakeByEmployID(employ.getId());

        //算绩效平均
        List<Grade> nowCompanyGradeByEmployID = workerService.getNowCompanyGradeByEmployID(employ.getId());
        double sum=0;
        int counter=0;
        for(Grade item:nowCompanyGradeByEmployID){
            sum+=item.getContent();
            counter++;
        }


        String[] strNow1 = new SimpleDateFormat("yyyy-MM-dd").format(employ.getStartDate()).toString().split("-");
        HashMap Info=new HashMap();
        Info.put("companyName",company.getName());
        Info.put("startDate", Integer.parseInt(strNow1[0])+"-"+
                              Integer.parseInt(strNow1[1])+"-"+
                              Integer.parseInt(strNow1[2]));
        Info.put("nowCompanyAchievements",nowCompanyAchievementByEmployID);
        Info.put("nowCompanyMistakes",nowCompanyMistakeByEmployID);
        Info.put("averageGrade",sum/counter);

        return Info;

    }

    @RequestMapping(value = "/login1")
    public String login1(HttpServletRequest request) throws ClientException, NoSuchAlgorithmException {
        String phonenumber = request.getParameter("phonenumber");

        return "WorkerPages/WorkerHome";
    }

}
