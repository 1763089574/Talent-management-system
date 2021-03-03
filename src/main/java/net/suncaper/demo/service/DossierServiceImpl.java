package net.suncaper.demo.service;

import net.suncaper.demo.common.domain.Dossier;
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
}


