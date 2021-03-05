package net.suncaper.demo.mapper.extend;

import net.suncaper.demo.common.domain.Grade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradeMapperExtend {

    List<Grade> getGrade(@Param("companyId") String companyId, @Param("workerId") String workerId);
}
