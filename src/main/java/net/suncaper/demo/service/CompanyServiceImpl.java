package net.suncaper.demo.service;

import net.suncaper.demo.domain.Company;
import net.suncaper.demo.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public void Register(Company company) {
        companyMapper.insert(company);
    }
}
