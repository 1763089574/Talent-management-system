package net.suncaper.demo.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import net.suncaper.demo.common.domain.Worker;
import net.suncaper.demo.mapper.WorkerMapper;
import net.suncaper.demo.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import java.security.NoSuchAlgorithmException;

import static net.suncaper.demo.common.util.AliyunSms.sendSms;
import static net.suncaper.demo.common.util.HashCode.GetHashCode;

@Controller
public class WorkerController {
    @Autowired
    public WorkerService workerService;

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
        String password = GetHashCode(request.getParameter("password"));
        Worker man = new Worker();
        man.setName(name);
        man.setPhonenumber(phonenumber);
        man.setPassword(password);
        workerService.register_(man);
    }


}
