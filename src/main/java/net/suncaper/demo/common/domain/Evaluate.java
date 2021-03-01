package net.suncaper.demo.common.domain;

public class Evaluate {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.Id
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.employ_id
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    private Integer employId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.isEvaluate
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    private Integer isevaluate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.evaluateContent
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    private String evaluatecontent;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public Evaluate(Integer id, Integer employId, Integer isevaluate, String evaluatecontent) {
        this.id = id;
        this.employId = employId;
        this.isevaluate = isevaluate;
        this.evaluatecontent = evaluatecontent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public Evaluate() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.Id
     *
     * @return the value of evaluate.Id
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.Id
     *
     * @param id the value for evaluate.Id
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.employ_id
     *
     * @return the value of evaluate.employ_id
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public Integer getEmployId() {
        return employId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.employ_id
     *
     * @param employId the value for evaluate.employ_id
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public void setEmployId(Integer employId) {
        this.employId = employId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.isEvaluate
     *
     * @return the value of evaluate.isEvaluate
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public Integer getIsevaluate() {
        return isevaluate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.isEvaluate
     *
     * @param isevaluate the value for evaluate.isEvaluate
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public void setIsevaluate(Integer isevaluate) {
        this.isevaluate = isevaluate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.evaluateContent
     *
     * @return the value of evaluate.evaluateContent
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public String getEvaluatecontent() {
        return evaluatecontent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.evaluateContent
     *
     * @param evaluatecontent the value for evaluate.evaluateContent
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public void setEvaluatecontent(String evaluatecontent) {
        this.evaluatecontent = evaluatecontent == null ? null : evaluatecontent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
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
        Evaluate other = (Evaluate) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEmployId() == null ? other.getEmployId() == null : this.getEmployId().equals(other.getEmployId()))
            && (this.getIsevaluate() == null ? other.getIsevaluate() == null : this.getIsevaluate().equals(other.getIsevaluate()))
            && (this.getEvaluatecontent() == null ? other.getEvaluatecontent() == null : this.getEvaluatecontent().equals(other.getEvaluatecontent()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEmployId() == null) ? 0 : getEmployId().hashCode());
        result = prime * result + ((getIsevaluate() == null) ? 0 : getIsevaluate().hashCode());
        result = prime * result + ((getEvaluatecontent() == null) ? 0 : getEvaluatecontent().hashCode());
        return result;
    }
}