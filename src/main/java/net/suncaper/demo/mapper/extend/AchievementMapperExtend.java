package net.suncaper.demo.mapper.extend;

import net.suncaper.demo.common.domain.Achievement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AchievementMapperExtend {
    List<Achievement> getAchievement(@Param("workerId") String workerId, @Param("companyId") String companyId);
}
