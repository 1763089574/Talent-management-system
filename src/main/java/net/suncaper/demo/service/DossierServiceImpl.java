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
    public int dossierCreate(String employId,String evaluate) {//为员工创建dossier
        DossierExample dossierExample=new DossierExample();
        DossierExample.Criteria criteria=dossierExample.createCriteria();
        criteria.andEmployIdEqualTo(Integer.valueOf(employId));
        Dossier record=new Dossier();
        record.setEvaluate(evaluate);
        record.setEmployId(Integer.valueOf(employId));
        //dossierMapper.updateByExampleSelective():

        int count=dossierMapper.insertSelective(record);
        return count;
    }


}


