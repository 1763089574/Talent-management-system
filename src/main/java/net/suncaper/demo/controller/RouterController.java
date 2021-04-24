package net.suncaper.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
public class RouterController {
    @RequestMapping("/EnterToWelcome")
    public String EnterToWelcome(){
        return "Welcome";
    }
    @RequestMapping("/EnterToTalentQuery")
    public String EnterToTalentQuery(HttpServletRequest request){
        /*Cookie[] cookies = request.getCookies();
        if(cookies!=null) {

            for (Cookie cookie : cookies) {//遍历Cookie
                System.out.println("value:" + cookie.getValue());
                System.out.println("name:" + cookie.getName());
                if (cookie.getName().equals("company_name")) {
                    return "TalentQuery";
                }
                else {
                    return "company_login";
                }

            }
        }*/

        return "TalentQuery";



    }
    @RequestMapping("/EnterToTalentCompare")
    public String EnterToTalentCompare(){
        return "TalentCompare";
    }
    @RequestMapping("/EnterToQueryStaff")
    public String EnterToQueryStaff(HttpServletRequest request){
        /*Cookie[] cookies = request.getCookies();
        if(cookies!=null){

            for (Cookie cookie : cookies) {//遍历Cookie
                if(cookie.getName()=="company_id")
                System.out.println("value:"+cookie.getValue());
                System.out.println("name:"+cookie.getName());
            }

        }*/
        return "QueryStaff";
    }
    @RequestMapping("/EnterToAuditStaff")
    public String EnterToAuditStaff(){
        return  "AuditStaff";
    }

    @RequestMapping("/EnterToAddEvaluation")
    public String EnterToAddEvaluation(){
        return "AddEvaluation";
    }

    @RequestMapping("/EnterToCompanyInformation")
    public String EnterToCompanyInformation(){
        return "CompanyInformationOperation";
    }
    @RequestMapping("/EnterToCompanyCertification")
    public String EnterToCompanyCertification(){
        return "CompanyCertification";
    }
    @RequestMapping("/EnterToMission")
    public String EnterToMission(){
        return "Mission";
    }

}
