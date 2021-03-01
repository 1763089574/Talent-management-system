package net.suncaper.demo.common.domain.extend;

public class WorkerDetail {//这个类是为了展示用户详细信息

    private Integer Id;//员工id

    private String workerName;

    private String companyName;

    private String evaluate;

    private Integer lateCount;

    public WorkerDetail(Integer Id,String workerName,String companyName,String evaluate,Integer lateCount ) {
        this.Id=Id;
        this.workerName=workerName;
        this.companyName=companyName;
        this.evaluate=evaluate;
        this.lateCount=lateCount;

    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public void setLateCount(Integer lateCount) {
        this.lateCount = lateCount;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public Integer getId() {
        return Id;
    }

    public Integer getLateCount() {
        return lateCount;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public String getWorkerName() {
        return workerName;
    }

}
