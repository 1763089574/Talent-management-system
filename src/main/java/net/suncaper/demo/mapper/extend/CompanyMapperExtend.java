package net.suncaper.demo.mapper.extend;

import net.suncaper.demo.common.domain.Worker;
import net.suncaper.demo.common.domain.extend.WorkerDetail;
import org.apache.ibatis.annotations.Param;
import org.w3c.dom.ls.LSException;

import java.util.List;

public interface CompanyMapperExtend {
    List<WorkerDetail> getWorkerDetailById(@Param("workerId") String workerId, @Param("belong") String belong);//通过员工id进行联表查询，

    List<Worker> getApplyList(String companyId);//根据公司Id，返回当前公司的待入职列表
    void modification(int id,String name,String phonenumber);
    List<Worker> getCheck(int CompanyId);
    List<Worker> getResign(int CompanyId);
}
