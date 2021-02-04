package net.suncaper.demo.service;

import net.suncaper.demo.common.domain.Company;
import net.suncaper.demo.common.domain.CompanyExample;
import net.suncaper.demo.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public void Register(Company company) {
        companyMapper.insertSelective(company);
    }//公司注册，一开始没有营业执照

    @Override
    public long checkName(String name)//检查公司名称是否已注册
    {
        CompanyExample example = new CompanyExample();
        CompanyExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        Long count= companyMapper.countByExample(example);

        return count;
    }

    @Override
    public long checkPhone(String phone)//检查公司名称是否已注册
    {
        CompanyExample example = new CompanyExample();
        CompanyExample.Criteria criteria = example.createCriteria();
        criteria.andPhonenumberEqualTo(phone);
        Long count= companyMapper.countByExample(example);

        return count;
    }

    @Override
    public List<Company> companyLogin(String phone, String password) {
        CompanyExample example = new CompanyExample();
        CompanyExample.Criteria criteria = example.createCriteria();
        criteria.andPhonenumberEqualTo(phone);
        criteria.andPasswordEqualTo(password);

        List<Company> company=companyMapper.selectByExample(example);
        return company;
    }
}
