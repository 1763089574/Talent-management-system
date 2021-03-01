package net.suncaper.demo.common.domain;

public class Dossier {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dossier.Id
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dossier.Employ_id
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    private Integer employId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dossier.Late_count
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    private Integer lateCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dossier.Grade_id
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    private Integer gradeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dossier.Evaluate
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    private String evaluate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dossier.Estimate
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    private String estimate;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dossier
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    public Dossier(Integer id, Integer employId, Integer lateCount, Integer gradeId, String evaluate, String estimate) {
        this.id = id;
        this.employId = employId;
        this.lateCount = lateCount;
        this.gradeId = gradeId;
        this.evaluate = evaluate;
        this.estimate = estimate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dossier
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    public Dossier() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dossier.Id
     *
     * @return the value of dossier.Id
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dossier.Id
     *
     * @param id the value for dossier.Id
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dossier.Employ_id
     *
     * @return the value of dossier.Employ_id
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    public Integer getEmployId() {
        return employId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dossier.Employ_id
     *
     * @param employId the value for dossier.Employ_id
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    public void setEmployId(Integer employId) {
        this.employId = employId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dossier.Late_count
     *
     * @return the value of dossier.Late_count
     *
<<<<<<< Updated upstream
     * @mbg.generated Mon Mar 01 16:19:22 GMT+08:00 2021
=======
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
>>>>>>> Stashed changes
     */
    public Integer getLateCount() {
        return lateCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dossier.Late_count
     *
     * @param lateCount the value for dossier.Late_count
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    public void setLateCount(Integer lateCount) {
        this.lateCount = lateCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dossier.Grade_id
     *
     * @return the value of dossier.Grade_id
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    public Integer getGradeId() {
        return gradeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dossier.Grade_id
     *
     * @param gradeId the value for dossier.Grade_id
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dossier.Evaluate
     *
     * @return the value of dossier.Evaluate
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    public String getEvaluate() {
        return evaluate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dossier.Evaluate
     *
     * @param evaluate the value for dossier.Evaluate
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate == null ? null : evaluate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dossier.Estimate
     *
     * @return the value of dossier.Estimate
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    public String getEstimate() {
        return estimate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dossier.Estimate
     *
     * @param estimate the value for dossier.Estimate
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    public void setEstimate(String estimate) {
        this.estimate = estimate == null ? null : estimate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dossier
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
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
        Dossier other = (Dossier) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEmployId() == null ? other.getEmployId() == null : this.getEmployId().equals(other.getEmployId()))
            && (this.getLateCount() == null ? other.getLateCount() == null : this.getLateCount().equals(other.getLateCount()))
            && (this.getGradeId() == null ? other.getGradeId() == null : this.getGradeId().equals(other.getGradeId()))
            && (this.getEvaluate() == null ? other.getEvaluate() == null : this.getEvaluate().equals(other.getEvaluate()))
            && (this.getEstimate() == null ? other.getEstimate() == null : this.getEstimate().equals(other.getEstimate()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dossier
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEmployId() == null) ? 0 : getEmployId().hashCode());
        result = prime * result + ((getLateCount() == null) ? 0 : getLateCount().hashCode());
        result = prime * result + ((getGradeId() == null) ? 0 : getGradeId().hashCode());
        result = prime * result + ((getEvaluate() == null) ? 0 : getEvaluate().hashCode());
        result = prime * result + ((getEstimate() == null) ? 0 : getEstimate().hashCode());
        return result;
    }
}