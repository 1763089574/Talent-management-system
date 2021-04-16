package net.suncaper.demo.service;

import net.suncaper.demo.common.domain.*;
import net.suncaper.demo.common.domain.extend.WorkerCompare;
import net.suncaper.demo.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        criteria.andBelongEqualTo("0");
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
        ResignExample resignExample=new ResignExample();
        ResignExample.Criteria criteria=resignExample.createCriteria();
        criteria.andCompanyIdEqualTo(companyId);
        criteria.andWorkerIdEqualTo(workerId);
        Resign record=new Resign();
        record.setIsconsent("2");
        int count=resignMapper.updateByExampleSelective(record,resignExample);
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

    @Override
    public int updateAllIsEvaluate() {//定时任务，每月一日凌晨两点将所有worker的isEvaluate调整为0
        Worker worker=new Worker();
        worker.setIsevaluate(0);
        WorkerExample workerExample=new WorkerExample();
        WorkerExample.Criteria criteria=workerExample.createCriteria();
        criteria.andIdIsNotNull();
        int count=workerMapper.updateByExampleSelective(worker,workerExample);
        return count;
    }

    @Override
    public List<Company> getAllCompany() {
        CompanyExample companyExample=new CompanyExample();
        CompanyExample.Criteria criteria=companyExample.createCriteria();
        criteria.andIdIsNotNull();
        List<Company> companys=companyMapper.selectByExample(companyExample);
        return companys;
    }

    @Override
    public int workerEvaluateYes(int companyId) {
        WorkerExample workerExample=new WorkerExample();
        WorkerExample.Criteria criteria=workerExample.createCriteria();
        criteria.andBelongEqualTo(String.valueOf(companyId));
        criteria.andIsevaluateEqualTo(1);
        List<Worker> workers=workerMapper.selectByExample(workerExample);
        int size=workers.size();
        return size;
    }

    @Override
    public int workerEvaluateNo(int companyId) {
        WorkerExample example=new WorkerExample();
        WorkerExample.Criteria criteria=example.createCriteria();
        criteria.andBelongEqualTo(String.valueOf(companyId));
        criteria.andIsevaluateEqualTo(0);
        List<Worker> workers=workerMapper.selectByExample(example);
        int size=workers.size();
        return size;
    }

    @Override
    public void updateCredit(int companyId) {//对公司信誉分减5

        Company company=companyMapper.selectByPrimaryKey(companyId);
        Integer Credit=company.getCredit();
        Credit-=5;
        Company record=new Company();
        record.setId(companyId);
        record.setCredit(Credit);
        int count=companyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<WorkerCompare> GetCompareDate(int workerId1, int workerId2) {
        List<WorkerCompare> workerCompares = new ArrayList<>();
        WorkerCompare workerCompare1 = new WorkerCompare();
        String lateCount = companyMapper.GetLateCount1(workerId1);
        if (lateCount != null){
            String evaluate = companyMapper.GetEvaluate1(workerId1);
            List<WorkerCompare> names = new ArrayList<>();
            names = companyMapper.GetNameAndCountMisAndCountAch1(workerId1);
            workerCompare1.setCountAch(names.get(0).getCountAch());
            workerCompare1.setCountMis(names.get(0).getCountMis());
            workerCompare1.setEvaluate(evaluate);
            workerCompare1.setCountLate(lateCount);
            workerCompare1.setName(names.get(0).getName());
            String score = String.valueOf(100-(0.5*Integer.parseInt(workerCompare1.getCountLate())+0.5*Integer.parseInt(workerCompare1.getCountMis())-0.5*Integer.parseInt(workerCompare1.getCountAch())));
            workerCompare1.setScore(score);
        }
        else {
            workerCompare1.setScore("暂无");
            workerCompare1.setCountAch("暂无");
            workerCompare1.setCountMis("暂无");
            workerCompare1.setEvaluate("暂无");
            workerCompare1.setCountLate("暂无");
            List<WorkerCompare> names = new ArrayList<>();
            names = companyMapper.GetNameAndCountMisAndCountAch1(workerId1);
            workerCompare1.setName(names.get(0).getName());
        }
        workerCompares.add(workerCompare1);

        WorkerCompare workerCompare2 = new WorkerCompare();
        String lateCount1 = companyMapper.GetLateCount2(workerId2);
        if(lateCount1!=null){
            String evaluate1 = companyMapper.GetEvaluate2(workerId2);
            List<WorkerCompare> names1 = new ArrayList<>();
            names1 = companyMapper.GetNameAndCountMisAndCountAch1(workerId2);
            workerCompare2.setCountAch(names1.get(0).getCountAch());
            workerCompare2.setCountMis(names1.get(0).getCountMis());
            workerCompare2.setEvaluate(evaluate1);
            workerCompare2.setCountLate(lateCount1);
            workerCompare2.setName(names1.get(0).getName());
            String score1 = String.valueOf(100-(0.5*Integer.parseInt(workerCompare2.getCountLate())+0.5*Integer.parseInt(workerCompare2.getCountMis())-0.5*Integer.parseInt(workerCompare2.getCountAch()))) ;
            workerCompare2.setScore(score1);
        }
        else {
            workerCompare2.setScore("暂无");
            workerCompare2.setCountAch("暂无");
            workerCompare2.setCountMis("暂无");
            workerCompare2.setEvaluate("暂无");
            workerCompare2.setCountLate("暂无");
            List<WorkerCompare> names1 = new ArrayList<>();
            names1 = companyMapper.GetNameAndCountMisAndCountAch1(workerId2);
            workerCompare2.setName(names1.get(0).getName());
        }

        workerCompares.add(workerCompare2);

        return workerCompares;
    }


}
