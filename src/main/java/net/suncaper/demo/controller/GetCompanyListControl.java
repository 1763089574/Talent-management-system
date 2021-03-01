package net.suncaper.demo.controller;

//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import net.suncaper.demo.common.domain.Company;
import net.suncaper.demo.service.CompanyService;
import net.suncaper.demo.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static net.suncaper.demo.common.util.AliyunSms.sendSms;

@Controller
public class GetCompanyListControl {
    @Autowired
    public CompanyService companyService;

    @GetMapping("/getAllHasIdentifyCompanies")

    @ResponseBody
    public List<Company> getAllHasIdentifyCompanies(HttpServletRequest request){
        List<Company> allCompany = companyService.findAllCompany();
//        JSONArray jsonArray = new JSONArray();
//        for(Company mp:allCompany){
//            JSONObject jsonObj = new JSONObject();
//            jsonObj.put("id", mp.getId());
//            jsonObj.put("name", mp.getName());
//            jsonObj.put("flag", mp.getFlag());
//
//            jsonArray.add(jsonObj);
//        }
//        System.out.println("我执行了");
//        return jsonArray;
        return allCompany;

    }
}
