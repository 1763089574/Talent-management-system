package net.suncaper.demo.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import net.suncaper.demo.common.domain.Company;
import net.suncaper.demo.common.domain.CompanyExample;
import net.suncaper.demo.common.util.HashCode;
import net.suncaper.demo.mapper.CompanyMapper;
import net.suncaper.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static net.suncaper.demo.common.util.AliyunSms.sendSms;

@RestController
@CrossOrigin
@RequestMapping("company")

public class CompanyEnterController {
    @Autowired
    public CompanyService companyService;
    //private CompanyService companyService;

    @GetMapping("register")
    public String register (HttpServletRequest request)//公司注册，其中密码用哈希值存储
    {
        String name = request.getParameter("name");
        String phone=request.getParameter("phone");
        String tmpPassword = request.getParameter("password");
        String password= null;

        password = Integer.toString(HashCode.GetHashCode(tmpPassword));

        System.out.println("name"+name);

        //Company company=new Company(ID,name,phone,password,0,100);
        Company company=new Company();
        company.setPhonenumber(phone);
        company.setName(name);
        company.setPassword(password);
        company.setFlag(0);
        company.setCredit(100);
        companyService.Register(company);

        return "注册成功";

    }

    @GetMapping("checkName")
    public boolean checkName(HttpServletRequest request)//检查公司名称是否已被注册，已被注册返回true，未被注册返回false
    {
        String name=request.getParameter("name");
        long count=companyService.checkName(name);
        System.out.println("count"+count);
        if(count==0) {
            return false;
        }
        else
        {
            return true;
        }


    }
    @GetMapping("checkPhone")
    public boolean checkPhone(HttpServletRequest request)//检查公司名称是否已被注册
    {
        String phone=request.getParameter("phone");
        long count=companyService.checkPhone(phone);
        System.out.println("count"+count);
        if(count==0) {
            return false;
        }
        else
        {
            return true;
        }


    }
    @GetMapping("checkCompany")

    //public List<Company> checkCompany(HttpServletRequest request){//查询公司信息是否存在，并返回公司信息
    public int checkCompany(HttpServletRequest request){//查询公司信息是否存在，并返回公司信息
        String phone=request.getParameter("loginPhone");
        String tmpPassword=request.getParameter("loginPassword");
        System.out.println("tmpPassword"+tmpPassword);
        String password= null;
        password = Integer.toString(HashCode.GetHashCode(tmpPassword));
        System.out.println("真正的password:"+password);
        Integer id=companyService.companyLogin(phone,password);
        //List<Company> company=companyService.companyLogin(phone,password);
        System.out.println("company"+id);
        System.out.println(id);

        return id;
    }

    @GetMapping("check_code")
    @ResponseBody
    public int number_exist(HttpServletRequest request) throws ClientException {//返回 1 代表 该号码已经注册，//返回 2 代表短信成功发送，//返回 3 代表短信短信发送失败
        String phone = request.getParameter("phone");
        String code = request.getParameter("code");
        System.out.println(code);
        long count=companyService.checkPhone(phone);
        if(count!=0)
        {
            return 1;//返回 1 代表 该号码已经注册
        }
        else {
            SendSmsResponse sendSmsResponse = sendSms(phone, code);
            if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
                return 2;//返回 2 代表短信成功发送
            }else{
                return 3;//返回 3 代表短信短信发送失败
            }

        }


    }





}
