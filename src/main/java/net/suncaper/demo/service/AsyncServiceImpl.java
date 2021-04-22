package net.suncaper.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AsyncServiceImpl implements AsyncService {
    @Override
    public void executeAsync() {
        //logger.info("start executeAsync");
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        //logger.info("end executeAsync");

    }
}
