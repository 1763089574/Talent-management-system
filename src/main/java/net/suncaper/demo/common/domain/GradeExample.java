package net.suncaper.demo.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class GradeExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table grade
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table grade
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table grade
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public GradeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
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
     * This method corresponds to the database table grade
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table grade
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterionForJDBCDate("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterionForJDBCDate("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterionForJDBCDate("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterionForJDBCDate("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andEmployIdIsNull() {
            addCriterion("employ_id is null");
            return (Criteria) this;
        }

        public Criteria andEmployIdIsNotNull() {
            addCriterion("employ_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmployIdEqualTo(Integer value) {
            addCriterion("employ_id =", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdNotEqualTo(Integer value) {
            addCriterion("employ_id <>", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdGreaterThan(Integer value) {
            addCriterion("employ_id >", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("employ_id >=", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdLessThan(Integer value) {
            addCriterion("employ_id <", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdLessThanOrEqualTo(Integer value) {
            addCriterion("employ_id <=", value, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdIn(List<Integer> values) {
            addCriterion("employ_id in", values, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdNotIn(List<Integer> values) {
            addCriterion("employ_id not in", values, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdBetween(Integer value1, Integer value2) {
            addCriterion("employ_id between", value1, value2, "employId");
            return (Criteria) this;
        }

        public Criteria andEmployIdNotBetween(Integer value1, Integer value2) {
            addCriterion("employ_id not between", value1, value2, "employId");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(Integer value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(Integer value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(Integer value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(Integer value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(Integer value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(Integer value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<Integer> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<Integer> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(Integer value1, Integer value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(Integer value1, Integer value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table grade
     *
     * @mbg.generated do_not_delete_during_merge Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table grade
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
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