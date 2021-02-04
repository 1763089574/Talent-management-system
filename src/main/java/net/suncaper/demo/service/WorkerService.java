package net.suncaper.demo.service;

import net.suncaper.demo.common.domain.Worker;

public interface WorkerService {
    boolean phonenumber_exist(String numbers);//验证号码是否已经存在
    void register_(Worker worker);//员工注册
    boolean login(Worker worker);
}
