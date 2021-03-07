package net.suncaper.demo.controller;

import net.suncaper.demo.common.domain.Company;
import net.suncaper.demo.service.CompanyService;
import net.suncaper.demo.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

@Component
public class ScheduleController {
    @Autowired
    public CompanyService companyService;




    @Scheduled(cron = "0 0 2 1 * ?")//表示每月的一日凌晨两点调整任务
    public void scheduleMethod(){
           System.out.println("定时任务触发");
           int count=companyService.updateAllIsEvaluate();
           System.out.println("一共更新的数据个数："+count);

    }
    @Scheduled(cron = "0 0 3 1 * ?")//表示每月的一日凌晨两点调整任务
    public void changeCredit(){
        List<Company> companyList=companyService.getAllCompany();
        int size=companyList.size();
        System.out.println("所有公司的个数为:"+size);
        for(int i=0;i<size;i++){
            int companyId=companyList.get(i).getId();
            System.out.println("公司id："+companyId);
            int countYes=companyService.workerEvaluateYes(companyId);
            int countNo=companyService.workerEvaluateNo(companyId);
            if(countNo>=countYes){//如果本月有一半的员工还未评价绩效，则扣分
               companyService.updateCredit(companyId);
            }
        }
    }
}
