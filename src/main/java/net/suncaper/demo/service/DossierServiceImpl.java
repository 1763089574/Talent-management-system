package net.suncaper.demo.service;

import net.suncaper.demo.common.domain.Dossier;
import net.suncaper.demo.common.domain.DossierExample;
import net.suncaper.demo.mapper.DossierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class DossierServiceImpl implements DossierService {
    @Autowired
    private DossierMapper dossierMapper;

    @Override
    public List<Dossier> findDetail(int id) {
        return dossierMapper.findDetail(id);
    }

    @Override
    public int DossierEvaluate(String employId,String evaluate) {//将employId匹配的数据的Evaluate进行更改
        DossierExample dossierExample=new DossierExample();
        DossierExample.Criteria criteria=dossierExample.createCriteria();
        criteria.andEmployIdEqualTo(Integer.valueOf(employId));
        Dossier record=new Dossier();
        record.setEvaluate(evaluate);
        //dossierMapper.updateByExampleSelective():
        int count=dossierMapper.updateByExampleSelective(record,dossierExample);
        return count;
    }


}


