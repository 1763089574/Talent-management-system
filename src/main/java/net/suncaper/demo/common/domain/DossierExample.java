package net.suncaper.demo.common.domain;

import java.util.ArrayList;
import java.util.List;

public class DossierExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dossier
     *
     * @mbg.generated Mon Mar 01 16:19:22 GMT+08:00 2021
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dossier
     *
     * @mbg.generated Mon Mar 01 16:19:22 GMT+08:00 2021
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dossier
     *
     * @mbg.generated Mon Mar 01 16:19:22 GMT+08:00 2021
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dossier
     *
     * @mbg.generated Mon Mar 01 16:19:22 GMT+08:00 2021
     */
    public DossierExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dossier
     *
     * @mbg.generated Mon Mar 01 16:19:22 GMT+08:00 2021
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dossier
     *
     * @mbg.generated Mon Mar 01 16:19:22 GMT+08:00 2021
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dossier
     *
     * @mbg.generated Mon Mar 01 16:19:22 GMT+08:00 2021
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dossier
     *
     * @mbg.generated Mon Mar 01 16:19:22 GMT+08:00 2021
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dossier
     *
     * @mbg.generated Mon Mar 01 16:19:22 GMT+08:00 2021
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dossier
     *
     * @mbg.generated Mon Mar 01 16:19:22 GMT+08:00 2021
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dossier
     *
     * @mbg.generated Mon Mar 01 16:19:22 GMT+08:00 2021
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dossier
     *
     * @mbg.generated Mon Mar 01 16:19:22 GMT+08:00 2021
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dossier
     *
     * @mbg.generated Mon Mar 01 16:19:22 GMT+08:00 2021
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dossier
     *
     * @mbg.generated Mon Mar 01 16:19:22 GMT+08:00 2021
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dossier
     *
     * @mbg.generated Mon Mar 01 16:19:22 GMT+08:00 2021
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEmployIdIsNull() {
            addCriterion("Employ_id is null");
            return (Criteria) this;
        }

        public Criteria andEmployIdIsNotNull() {
            addCriterion("Employ_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmployIdEqualTo(Integer value) {
            addCriterion("Employ_id =", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdNotEqualTo(Integer value) {
            addCriterion("Employ_id <>", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdGreaterThan(Integer value) {
            addCriterion("Employ_id >", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Employ_id >=", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdLessThan(Integer value) {
            addCriterion("Employ_id <", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdLessThanOrEqualTo(Integer value) {
            addCriterion("Employ_id <=", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdIn(List<Integer> values) {
            addCriterion("Employ_id in", values, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdNotIn(List<Integer> values) {
            addCriterion("Employ_id not in", values, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdBetween(Integer value1, Integer value2) {
            addCriterion("Employ_id between", value1, value2, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Employ_id not between", value1, value2, "employId");
            return (Criteria) this;
        }

        public Criteria andLateCountIsNull() {
            addCriterion("Late_count is null");
            return (Criteria) this;
        }

        public Criteria andLateCountIsNotNull() {
            addCriterion("Late_count is not null");
            return (Criteria) this;
        }

        public Criteria andLateCountEqualTo(Integer value) {
            addCriterion("Late_count =", value, "lateCount");
            return (Criteria) this;
        }

        public Criteria andLateCountNotEqualTo(Integer value) {
            addCriterion("Late_count <>", value, "lateCount");
            return (Criteria) this;
        }

        public Criteria andLateCountGreaterThan(Integer value) {
            addCriterion("Late_count >", value, "lateCount");
            return (Criteria) this;
        }

        public Criteria andLateCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("Late_count >=", value, "lateCount");
            return (Criteria) this;
        }

        public Criteria andLateCountLessThan(Integer value) {
            addCriterion("Late_count <", value, "lateCount");
            return (Criteria) this;
        }

        public Criteria andLateCountLessThanOrEqualTo(Integer value) {
            addCriterion("Late_count <=", value, "lateCount");
            return (Criteria) this;
        }

        public Criteria andLateCountIn(List<Integer> values) {
            addCriterion("Late_count in", values, "lateCount");
            return (Criteria) this;
        }

        public Criteria andLateCountNotIn(List<Integer> values) {
            addCriterion("Late_count not in", values, "lateCount");
            return (Criteria) this;
        }

        public Criteria andLateCountBetween(Integer value1, Integer value2) {
            addCriterion("Late_count between", value1, value2, "lateCount");
            return (Criteria) this;
        }

        public Criteria andLateCountNotBetween(Integer value1, Integer value2) {
            addCriterion("Late_count not between", value1, value2, "lateCount");
            return (Criteria) this;
        }

        public Criteria andGradeIdIsNull() {
            addCriterion("Grade_id is null");
            return (Criteria) this;
        }

        public Criteria andGradeIdIsNotNull() {
            addCriterion("Grade_id is not null");
            return (Criteria) this;
        }

        public Criteria andGradeIdEqualTo(Integer value) {
            addCriterion("Grade_id =", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdNotEqualTo(Integer value) {
            addCriterion("Grade_id <>", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdGreaterThan(Integer value) {
            addCriterion("Grade_id >", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Grade_id >=", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdLessThan(Integer value) {
            addCriterion("Grade_id <", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdLessThanOrEqualTo(Integer value) {
            addCriterion("Grade_id <=", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdIn(List<Integer> values) {
            addCriterion("Grade_id in", values, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdNotIn(List<Integer> values) {
            addCriterion("Grade_id not in", values, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdBetween(Integer value1, Integer value2) {
            addCriterion("Grade_id between", value1, value2, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Grade_id not between", value1, value2, "gradeId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsNull() {
            addCriterion("Evaluate is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsNotNull() {
            addCriterion("Evaluate is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateEqualTo(String value) {
            addCriterion("Evaluate =", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotEqualTo(String value) {
            addCriterion("Evaluate <>", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateGreaterThan(String value) {
            addCriterion("Evaluate >", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateGreaterThanOrEqualTo(String value) {
            addCriterion("Evaluate >=", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateLessThan(String value) {
            addCriterion("Evaluate <", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateLessThanOrEqualTo(String value) {
            addCriterion("Evaluate <=", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateLike(String value) {
            addCriterion("Evaluate like", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotLike(String value) {
            addCriterion("Evaluate not like", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateIn(List<String> values) {
            addCriterion("Evaluate in", values, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotIn(List<String> values) {
            addCriterion("Evaluate not in", values, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateBetween(String value1, String value2) {
            addCriterion("Evaluate between", value1, value2, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotBetween(String value1, String value2) {
            addCriterion("Evaluate not between", value1, value2, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEstimateIsNull() {
            addCriterion("Estimate is null");
            return (Criteria) this;
        }

        public Criteria andEstimateIsNotNull() {
            addCriterion("Estimate is not null");
            return (Criteria) this;
        }

        public Criteria andEstimateEqualTo(String value) {
            addCriterion("Estimate =", value, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateNotEqualTo(String value) {
            addCriterion("Estimate <>", value, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateGreaterThan(String value) {
            addCriterion("Estimate >", value, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateGreaterThanOrEqualTo(String value) {
            addCriterion("Estimate >=", value, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateLessThan(String value) {
            addCriterion("Estimate <", value, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateLessThanOrEqualTo(String value) {
            addCriterion("Estimate <=", value, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateLike(String value) {
            addCriterion("Estimate like", value, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateNotLike(String value) {
            addCriterion("Estimate not like", value, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateIn(List<String> values) {
            addCriterion("Estimate in", values, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateNotIn(List<String> values) {
            addCriterion("Estimate not in", values, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateBetween(String value1, String value2) {
            addCriterion("Estimate between", value1, value2, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateNotBetween(String value1, String value2) {
            addCriterion("Estimate not between", value1, value2, "estimate");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dossier
     *
     * @mbg.generated do_not_delete_during_merge Mon Mar 01 16:19:22 GMT+08:00 2021
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dossier
     *
     * @mbg.generated Mon Mar 01 16:19:22 GMT+08:00 2021
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}