package net.suncaper.demo.common.domain.extend;

import java.util.Date;

public class EvalauteExtend {
    private  String companyName;//公司名称
    private Date endDate;//离职日期

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
