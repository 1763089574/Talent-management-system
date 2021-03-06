package net.suncaper.demo.mapper.extend;

import net.suncaper.demo.common.domain.Worker;
import net.suncaper.demo.mapper.WorkerMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkerMapperExtend {

    //模糊搜索
    List<Worker> findLike(@Param("name") String name, @Param("major")String major, @Param("minAge")int minAge,
                          @Param("maxAge")int maxAge, @Param("education")String education, @Param("sex")String sex);

    List<Worker> getApplyList(String companyId);//根据公司Id，返回当前公司的待入职列表

    List<Worker> getResignList(String companyId);//根据公司Id，返回当前公司的待离职列表
}
