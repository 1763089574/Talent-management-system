package net.suncaper.demo.mapper.extend;

import net.suncaper.demo.common.domain.Mistake;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MistakeMapperExtend {
    public List<Mistake> getMistake(@Param("companyId") String companyId,@Param("workerId") String workerId);
}
