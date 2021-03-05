package net.suncaper.demo.common.domain.extend;

public class WorkerDetail {//这个类是为了展示用户详细信息

    private Integer Id;//员工id

    private Integer companyId;//公司id

    private String workerName;

    private String companyName;



    public WorkerDetail(Integer Id,String workerName,Integer companyId,String companyName ) {
        this.Id=Id;

        this.workerName=workerName;
        this.companyId=companyId;
        this.companyName=companyName;


    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public void setCompanyId(Integer id){
        this.companyId=companyId;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }



    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public Integer getId() {
        return Id;
    }

    public Integer getCompanyId(){
        return companyId;
    }



    public String getCompanyName() {
        return companyName;
    }



    public String getWorkerName() {
        return workerName;
    }

}
