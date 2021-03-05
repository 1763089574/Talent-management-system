package net.suncaper.demo.mapper.extend;

import net.suncaper.demo.common.domain.Evaluate;

import java.util.List;

public interface EvaluateMapperExtend {
    List<Evaluate> getAllWaitToEvaluateList(int workerid);
}
