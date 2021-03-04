package net.suncaper.demo.common.domain;

import net.suncaper.demo.common.domain.extend.ResignExtend;

public class Resign extends ResignExtend {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resign.Id
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resign.company_id
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    private Integer companyId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resign.worker_id
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    private Integer workerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resign.content
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resign.isConsent
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    private String isconsent;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resign
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public Resign(Integer id, Integer companyId, Integer workerId, String content, String isconsent) {
        this.id = id;
        this.companyId = companyId;
        this.workerId = workerId;
        this.content = content;
        this.isconsent = isconsent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resign
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public Resign() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resign.Id
     *
     * @return the value of resign.Id
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resign.Id
     *
     * @param id the value for resign.Id
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resign.company_id
     *
     * @return the value of resign.company_id
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resign.company_id
     *
     * @param companyId the value for resign.company_id
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resign.worker_id
     *
     * @return the value of resign.worker_id
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public Integer getWorkerId() {
        return workerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resign.worker_id
     *
     * @param workerId the value for resign.worker_id
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resign.content
     *
     * @return the value of resign.content
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resign.content
     *
     * @param content the value for resign.content
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resign.isConsent
     *
     * @return the value of resign.isConsent
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public String getIsconsent() {
        return isconsent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resign.isConsent
     *
     * @param isconsent the value for resign.isConsent
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public void setIsconsent(String isconsent) {
        this.isconsent = isconsent == null ? null : isconsent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resign
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Resign other = (Resign) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getWorkerId() == null ? other.getWorkerId() == null : this.getWorkerId().equals(other.getWorkerId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getIsconsent() == null ? other.getIsconsent() == null : this.getIsconsent().equals(other.getIsconsent()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resign
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getWorkerId() == null) ? 0 : getWorkerId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getIsconsent() == null) ? 0 : getIsconsent().hashCode());
        return result;
    }
}