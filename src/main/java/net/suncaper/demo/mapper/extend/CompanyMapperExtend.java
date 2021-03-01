package net.suncaper.demo.mapper.extend;

import net.suncaper.demo.common.domain.extend.WorkerDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyMapperExtend {
    List<WorkerDetail> getWorkerDetailById(@Param("workerId") String workerId, @Param("belong") String belong);//通过员工id进行联表查询，查出员工的详细信息
}
