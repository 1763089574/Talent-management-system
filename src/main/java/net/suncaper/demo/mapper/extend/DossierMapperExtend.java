package net.suncaper.demo.mapper.extend;

import net.suncaper.demo.common.domain.Dossier;

import java.util.List;

public interface DossierMapperExtend {
    List<Dossier> findDetail(int id);
}
