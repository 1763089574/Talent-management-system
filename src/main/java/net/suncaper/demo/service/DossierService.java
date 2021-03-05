package net.suncaper.demo.service;

import net.suncaper.demo.common.domain.Dossier;

import java.util.List;

public interface DossierService {
    List<Dossier> findDetail(int id);

    int DossierEvaluate(String employId,String evaluate);//公司对员工的评价
}
