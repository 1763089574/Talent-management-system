package net.suncaper.demo.service;

import net.suncaper.demo.common.domain.Dossier;

import java.util.List;

public interface DossierService {
    List<Dossier> findDetail(int id);
}
