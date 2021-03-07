package net.suncaper.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import net.suncaper.demo.common.domain.License;
import net.suncaper.demo.common.domain.Worker;
import net.suncaper.demo.common.util.Certification;
import net.suncaper.demo.common.util.IdentificationCard;
import net.suncaper.demo.common.util.TwoElements;
import net.suncaper.demo.service.CompanyService;
import net.suncaper.demo.service.WorkerService;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.util.Map;

@RestController
@CrossOrigin
public class WorkerInformationCertifyController {
    @Autowired
    private CompanyService companyService;

    @Autowired
    WorkerService workerService;

    @RequestMapping("/confirmInformation")
    //public License getUrl(@RequestBody String imgUrl, @RequestBody String CompanyId){
   //返回 0 为运行时错误  1 为成功  2 为身份证已经注册过了 3 为 上传身份证是假的
    public int getUrl(@RequestBody Map<String,String> map){
        String imgUrl = map.get("imageBase");
        String str_workerId = map.get("workerId");
        System.out.println("ID"+str_workerId);
        int workerId = Integer.valueOf(str_workerId);
        System.out.println("ID"+workerId);
        IdentificationCard identificationCard = new IdentificationCard();
        try {
            JSONObject workerObject = identificationCard.check(imgUrl);
            String name = workerObject.get("name").toString();
            String num = workerObject.get("num").toString();

            TwoElements twoElements = new TwoElements();
            HttpResponse res = twoElements.check(name, num);
            String s = EntityUtils.toString(res.getEntity());
            JSONObject jsonObject = JSONObject.parseObject(s);
            System.out.println(jsonObject.toJSONString());
            if(jsonObject.get("data")!=null){
                Worker worker = new Worker();
                //添加姓名
                worker.setName(workerObject.get("name").toString());
                //规范生日
                String Birth1 =workerObject.get("birth").toString();
                StringBuilder  sb = new StringBuilder (Birth1);
                sb.insert(6,"-");
                sb.insert(4,"-");
                worker.setBirth(sb.toString());
                //添加性别
                worker.setSex(workerObject.get("sex").toString());

                //添加身份证号码
                worker.setIdcard(workerObject.get("num").toString());

                //添加workerId
                worker.setId(workerId);

                if(workerService.addCertifyWorkerInformation(worker)==false){
                    return 3;
                }else{
                    return 1;
                }

            }else{
                return 2;
            }


        }catch (Exception e){
            System.out.println("错误为:"+e);
            return 0;
        }
    }

}
