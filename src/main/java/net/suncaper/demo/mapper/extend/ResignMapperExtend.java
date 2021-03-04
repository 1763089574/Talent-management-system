package net.suncaper.demo.mapper.extend;

import net.suncaper.demo.common.domain.Resign;

import java.util.List;

public interface ResignMapperExtend {
    List<Resign> getResignListByWorkerid(int workerId);
}
