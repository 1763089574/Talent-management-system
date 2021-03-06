package net.suncaper.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import net.suncaper.demo.common.domain.License;
import net.suncaper.demo.common.util.Certification;
import net.suncaper.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/certification")
public class CompanyCertificationController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping("/getUrl")
    //public License getUrl(@RequestBody String imgUrl, @RequestBody String CompanyId){
    public License getUrl(@RequestBody Map<String,String> map){
        String imgUrl = map.get("imgUrl");
        String CompanyId = map.get("CompanyId");
        License license = new License();
        String sourceArray = imgUrl.substring(23,imgUrl.length());
        String imageurl = URLEncoder.encode(sourceArray);
        String appcode = "f9d7ccf5fc9d400092b7e76e713360c0";
        String url = "http://yingye.market.alicloudapi.com/CreditValid";
        String params= "image="+imageurl;
        String sr= Certification.sendPost(url, params,appcode);
        JSONObject jsonObject = JSON.parseObject(sr);
        license.setCompanyid(Integer.valueOf(CompanyId));
        license.setAddress(jsonObject.getString("address"));
        license.setOwner(jsonObject.getString("owner"));
        license.setBusinessscope(jsonObject.getString("businessScope"));
        license.setCapital(jsonObject.getString("capital"));
        license.setCompanytype(jsonObject.getString("companyType"));
        license.setEstablishdate(jsonObject.getString("establishDate"));
        license.setExpirationdate(jsonObject.getString("expirationDate"));
        license.setCredit(jsonObject.getString("credit"));
        if(jsonObject.getString("ifCreditValid")=="true"){
            license.setIfcreditvalid("认证成功！");
        }else {
            license.setIfcreditvalid("认证失败！");
        }
//        license.setIfcreditvalid(jsonObject.getString("ifCreditValid"));
        license.setName(jsonObject.getString("name"));
//        System.out.println(name);
        return license;
    }

    @GetMapping("/save")
    public int save(License license){
        System.out.println(license.getAddress());
        return companyService.save(license);
    }
    @GetMapping("ifcertification")
    public boolean ifcertification(String CompanyId){
        License license = companyService.ifCertification(CompanyId);
        if(license==null) {
            return false;
        }else {
            return true;
        }
    }
    @GetMapping("/getLicense")
    public License getLicense(String CompanyId){
        return companyService.ifCertification(CompanyId);
    }
}
