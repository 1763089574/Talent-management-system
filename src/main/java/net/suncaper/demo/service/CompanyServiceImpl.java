package net.suncaper.demo.service;

import net.suncaper.demo.common.domain.*;
import net.suncaper.demo.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private WorkerMapper workerMapper;
    @Autowired
    private ApplyMapper applyMapper;
    @Autowired
    private ResignMapper resignMapper;
    @Autowired
    private LicenseMapper licenseMapper;

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
    //public List<Company> companyLogin(String phone, String password) {
    public int companyLogin(String phone, String password) {//公司登陆校验，只是校验，-1代表账号密码错误,0代表没有查询到这个公司，大于等于1代表查询到了这个公司
        Integer id=null;
        String realPassword=null;
        CompanyExample example = new CompanyExample();
        CompanyExample.Criteria criteria = example.createCriteria();
        criteria.andPhonenumberEqualTo(phone);
        //criteria.andPasswordEqualTo(password);

        List<Company> company=companyMapper.selectByExample(example);
        if(!company.isEmpty()){
            id=company.get(0).getId();
            realPassword=company.get(0).getPassword();
            System.out.println("真正的密码:"+realPassword);
            System.out.println("公司的id:"+id);
            if(password.equals(realPassword))
            {
                return id;
            }
            else
            return -1;//-1代表账号密码错误
        }
        else
            return 0;//0代表没有查询到这个公司

    }

    @Override
    public Company selectByPrimaryKey(Integer id) {
        Company company=companyMapper.selectByPrimaryKey(id);
        return company;


    }

    @Override
    public List<Worker> GetAllWorkersByCompanyId(String CompanyId) {

        System.out.println("CompanyServiceImpl.GetAllWorkersByCompanyId");
        WorkerExample example=new WorkerExample();
        WorkerExample.Criteria criteria=example.createCriteria();
        criteria.andBelongEqualTo(CompanyId);
        List<Worker> workers=workerMapper.selectByExample(example);

        return workers;
    }

    @Override
    public List<Worker> findAll() {
        WorkerExample example = new WorkerExample();
        WorkerExample.Criteria criteria = example.createCriteria();
        criteria.andIdIsNotNull();
        List<Worker> workers = workerMapper.selectByExample(example);
        return workers;
    }

    @Override
    public List<Company> findAllCompany() {
        CompanyExample companyExample = new CompanyExample();
        companyExample.createCriteria().andFlagEqualTo(1);
        List<Company> companies = companyMapper.selectByExample(companyExample);
        return companies;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Worker> findLike(String name, String major, int minAge, int maxAge, String education, String sex) {
        return workerMapper.findLike(name, major, minAge, maxAge, education, sex);
    }

    @Override
    public List<Worker> getApplyList(String companyId) {
        List<Worker> workers=workerMapper.getApplyList(companyId);

        return workers;
    }

    @Override
    public List<Worker> getResignList(String companyId) {
        List<Worker> workers=workerMapper.getResignList(companyId);
        return workers;
    }

    @Override
    public boolean applyAgree(String workerId,String companyId) {//根据员工id和公司id，同意员工的申请
        Integer companyId2=Integer.valueOf(companyId);
        Integer workerId2=Integer.valueOf(workerId);
        ApplyExample applyExample=new ApplyExample();
        ApplyExample.Criteria criteria=applyExample.createCriteria();
        criteria.andCompanyidEqualTo(companyId2);
        criteria.andWorkeridEqualTo(workerId2);
        Apply record=new Apply();
        record.setIsconsent(1);
        int count=applyMapper.updateByExampleSelective(record,applyExample);//以上是对apply表中的Isconsent字段进行改动

        /*WorkerExample workerExample=new WorkerExample();
        WorkerExample.Criteria criteria1=workerExample.createCriteria();*/

        Worker record2=new Worker();//以下是对worker表中的belong字段进行改动
        record2.setId(workerId2);
        record2.setBelong(companyId);
        int count2=workerMapper.updateByPrimaryKeySelective(record2);
        if(count==0)
        {
            return false;
        }
        else
            return true;
    }

    @Override
    public boolean applyRefuse(String workerId, String companyId) {
        Integer companyId2=Integer.valueOf(companyId);
        Integer workerId2=Integer.valueOf(workerId);
        ApplyExample applyExample=new ApplyExample();
        ApplyExample.Criteria criteria=applyExample.createCriteria();
        criteria.andCompanyidEqualTo(companyId2);
        criteria.andWorkeridEqualTo(workerId2);
        Apply record=new Apply();
        record.setIsconsent(2);
        int count=applyMapper.updateByExampleSelective(record,applyExample);
        if(count==0)
        {
            return false;
        }
        else
            return true;

    }

    @Override
    public boolean resignAgree(int workerId, int companyId) {
        ResignExample resignExample=new ResignExample();
        ResignExample.Criteria criteria=resignExample.createCriteria();
        criteria.andCompanyIdEqualTo(companyId);
        criteria.andWorkerIdEqualTo(workerId);
        Resign resign=new Resign();
        resign.setIsconsent("1");
        int count=resignMapper.updateByExampleSelective(resign,resignExample);//以上是对resign表中的isConsent字段进行改动


        Worker worker=new Worker();//以下是对worker表中的belong字段进行改动
        worker.setBelong("0");
        worker.setId(workerId);
        int count2=workerMapper.updateByPrimaryKeySelective(worker);
        if(count==0)
        {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public boolean resignRefuse(int workerId, int companyId) {
        ResignExample example=new ResignExample();
        ResignExample.Criteria criteria=example.createCriteria();
        criteria.andCompanyIdEqualTo(companyId);
        criteria.andIdEqualTo(workerId);
        Resign record=new Resign();
        record.setIsconsent("2");
        int count=resignMapper.updateByExampleSelective(record,example);
        if(count==0)
           return false;
        else
            return true;
    }

    @Override
    public boolean updateIsEvaluate(String workerId) {
        Worker record=new Worker();
        record.setId(Integer.valueOf(workerId));
        record.setIsevaluate(1);
        int count=workerMapper.updateByPrimaryKeySelective(record);
        if(count==1)
            return true;
        else
        return false;
    }
    @Override
    public Company findCompanyInfo(String id) {
        int intid = Integer.parseInt(id);
//        System.out.println("cookie中的id为");
//        System.out.println(intid);
        CompanyExample companyExample = new CompanyExample();
        companyExample.createCriteria().andIdEqualTo(intid);
        Company company = companyMapper.selectByExample(companyExample).get(0);
        return company;
    }

    @Override
    public void updateCompanyInfo(String id, String name, String phonenumber) {
        int initid = Integer.valueOf(id);
        Company record=new Company();
        record.setId(initid);
        record.setName(name);
        record.setPhonenumber(phonenumber);

        int tmp=companyMapper.updateByPrimaryKeySelective(record);

    }

    @Override
    public int save(License license) {
        License license1 = licenseMapper.selectByPrimaryKey(license.getCompanyid());
        if (license1==null){
            return licenseMapper.insertSelective(license);
        }else {
            return licenseMapper.updateByPrimaryKeySelective(license);
        }

    }

    @Override
    public License ifCertification(String CompanyId) {
        int CompanyId1 = Integer.valueOf(CompanyId);
        return licenseMapper.selectByPrimaryKey(CompanyId1);
    }

    @Override
    public List<Worker> getCommission(String CompanyId) {
        WorkerExample workerExample = new WorkerExample();
        workerExample.createCriteria().andBelongEqualTo(CompanyId).andIsevaluateEqualTo(0);
        return workerMapper.selectByExample(workerExample);
    }

    @Override
    public List<Worker> getCheck(String CompanyId) {
        return companyMapper.getCheck(Integer.valueOf(CompanyId));
    }

    @Override
    public List<Worker> getResign(String CompanyId) {
        return companyMapper.getResign(Integer.valueOf(CompanyId));
    }
}
