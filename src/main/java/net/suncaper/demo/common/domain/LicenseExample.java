package net.suncaper.demo.common.domain;

import java.util.ArrayList;
import java.util.List;

public class LicenseExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table license
     *
     * @mbg.generated Sat Mar 06 13:31:28 CST 2021
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table license
     *
     * @mbg.generated Sat Mar 06 13:31:28 CST 2021
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table license
     *
     * @mbg.generated Sat Mar 06 13:31:28 CST 2021
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table license
     *
     * @mbg.generated Sat Mar 06 13:31:28 CST 2021
     */
    public LicenseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table license
     *
     * @mbg.generated Sat Mar 06 13:31:28 CST 2021
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table license
     *
     * @mbg.generated Sat Mar 06 13:31:28 CST 2021
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table license
     *
     * @mbg.generated Sat Mar 06 13:31:28 CST 2021
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table license
     *
     * @mbg.generated Sat Mar 06 13:31:28 CST 2021
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table license
     *
     * @mbg.generated Sat Mar 06 13:31:28 CST 2021
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table license
     *
     * @mbg.generated Sat Mar 06 13:31:28 CST 2021
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table license
     *
     * @mbg.generated Sat Mar 06 13:31:28 CST 2021
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table license
     *
     * @mbg.generated Sat Mar 06 13:31:28 CST 2021
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
     * This method corresponds to the database table license
     *
     * @mbg.generated Sat Mar 06 13:31:28 CST 2021
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table license
     *
     * @mbg.generated Sat Mar 06 13:31:28 CST 2021
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table license
     *
     * @mbg.generated Sat Mar 06 13:31:28 CST 2021
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

        public Criteria andCompanyidIsNull() {
            addCriterion("companyid is null");
            return (Criteria) this;
        }

        public Criteria andCompanyidIsNotNull() {
            addCriterion("companyid is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyidEqualTo(Integer value) {
            addCriterion("companyid =", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotEqualTo(Integer value) {
            addCriterion("companyid <>", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidGreaterThan(Integer value) {
            addCriterion("companyid >", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("companyid >=", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidLessThan(Integer value) {
            addCriterion("companyid <", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidLessThanOrEqualTo(Integer value) {
            addCriterion("companyid <=", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidIn(List<Integer> values) {
            addCriterion("companyid in", values, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotIn(List<Integer> values) {
            addCriterion("companyid not in", values, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidBetween(Integer value1, Integer value2) {
            addCriterion("companyid between", value1, value2, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotBetween(Integer value1, Integer value2) {
            addCriterion("companyid not between", value1, value2, "companyid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCreditIsNull() {
            addCriterion("credit is null");
            return (Criteria) this;
        }

        public Criteria andCreditIsNotNull() {
            addCriterion("credit is not null");
            return (Criteria) this;
        }

        public Criteria andCreditEqualTo(String value) {
            addCriterion("credit =", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotEqualTo(String value) {
            addCriterion("credit <>", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditGreaterThan(String value) {
            addCriterion("credit >", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditGreaterThanOrEqualTo(String value) {
            addCriterion("credit >=", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLessThan(String value) {
            addCriterion("credit <", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLessThanOrEqualTo(String value) {
            addCriterion("credit <=", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLike(String value) {
            addCriterion("credit like", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotLike(String value) {
            addCriterion("credit not like", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditIn(List<String> values) {
            addCriterion("credit in", values, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotIn(List<String> values) {
            addCriterion("credit not in", values, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditBetween(String value1, String value2) {
            addCriterion("credit between", value1, value2, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotBetween(String value1, String value2) {
            addCriterion("credit not between", value1, value2, "credit");
            return (Criteria) this;
        }

        public Criteria andIfcreditvalidIsNull() {
            addCriterion("ifCreditValid is null");
            return (Criteria) this;
        }

        public Criteria andIfcreditvalidIsNotNull() {
            addCriterion("ifCreditValid is not null");
            return (Criteria) this;
        }

        public Criteria andIfcreditvalidEqualTo(String value) {
            addCriterion("ifCreditValid =", value, "ifcreditvalid");
            return (Criteria) this;
        }

        public Criteria andIfcreditvalidNotEqualTo(String value) {
            addCriterion("ifCreditValid <>", value, "ifcreditvalid");
            return (Criteria) this;
        }

        public Criteria andIfcreditvalidGreaterThan(String value) {
            addCriterion("ifCreditValid >", value, "ifcreditvalid");
            return (Criteria) this;
        }

        public Criteria andIfcreditvalidGreaterThanOrEqualTo(String value) {
            addCriterion("ifCreditValid >=", value, "ifcreditvalid");
            return (Criteria) this;
        }

        public Criteria andIfcreditvalidLessThan(String value) {
            addCriterion("ifCreditValid <", value, "ifcreditvalid");
            return (Criteria) this;
        }

        public Criteria andIfcreditvalidLessThanOrEqualTo(String value) {
            addCriterion("ifCreditValid <=", value, "ifcreditvalid");
            return (Criteria) this;
        }

        public Criteria andIfcreditvalidLike(String value) {
            addCriterion("ifCreditValid like", value, "ifcreditvalid");
            return (Criteria) this;
        }

        public Criteria andIfcreditvalidNotLike(String value) {
            addCriterion("ifCreditValid not like", value, "ifcreditvalid");
            return (Criteria) this;
        }

        public Criteria andIfcreditvalidIn(List<String> values) {
            addCriterion("ifCreditValid in", values, "ifcreditvalid");
            return (Criteria) this;
        }

        public Criteria andIfcreditvalidNotIn(List<String> values) {
            addCriterion("ifCreditValid not in", values, "ifcreditvalid");
            return (Criteria) this;
        }

        public Criteria andIfcreditvalidBetween(String value1, String value2) {
            addCriterion("ifCreditValid between", value1, value2, "ifcreditvalid");
            return (Criteria) this;
        }

        public Criteria andIfcreditvalidNotBetween(String value1, String value2) {
            addCriterion("ifCreditValid not between", value1, value2, "ifcreditvalid");
            return (Criteria) this;
        }

        public Criteria andCapitalIsNull() {
            addCriterion("capital is null");
            return (Criteria) this;
        }

        public Criteria andCapitalIsNotNull() {
            addCriterion("capital is not null");
            return (Criteria) this;
        }

        public Criteria andCapitalEqualTo(String value) {
            addCriterion("capital =", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalNotEqualTo(String value) {
            addCriterion("capital <>", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalGreaterThan(String value) {
            addCriterion("capital >", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalGreaterThanOrEqualTo(String value) {
            addCriterion("capital >=", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalLessThan(String value) {
            addCriterion("capital <", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalLessThanOrEqualTo(String value) {
            addCriterion("capital <=", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalLike(String value) {
            addCriterion("capital like", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalNotLike(String value) {
            addCriterion("capital not like", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalIn(List<String> values) {
            addCriterion("capital in", values, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalNotIn(List<String> values) {
            addCriterion("capital not in", values, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalBetween(String value1, String value2) {
            addCriterion("capital between", value1, value2, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalNotBetween(String value1, String value2) {
            addCriterion("capital not between", value1, value2, "capital");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNull() {
            addCriterion("owner is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNotNull() {
            addCriterion("owner is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEqualTo(String value) {
            addCriterion("owner =", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotEqualTo(String value) {
            addCriterion("owner <>", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThan(String value) {
            addCriterion("owner >", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("owner >=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThan(String value) {
            addCriterion("owner <", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThanOrEqualTo(String value) {
            addCriterion("owner <=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLike(String value) {
            addCriterion("owner like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotLike(String value) {
            addCriterion("owner not like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIn(List<String> values) {
            addCriterion("owner in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotIn(List<String> values) {
            addCriterion("owner not in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerBetween(String value1, String value2) {
            addCriterion("owner between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotBetween(String value1, String value2) {
            addCriterion("owner not between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andCompanytypeIsNull() {
            addCriterion("companyType is null");
            return (Criteria) this;
        }

        public Criteria andCompanytypeIsNotNull() {
            addCriterion("companyType is not null");
            return (Criteria) this;
        }

        public Criteria andCompanytypeEqualTo(String value) {
            addCriterion("companyType =", value, "companytype");
            return (Criteria) this;
        }

        public Criteria andCompanytypeNotEqualTo(String value) {
            addCriterion("companyType <>", value, "companytype");
            return (Criteria) this;
        }

        public Criteria andCompanytypeGreaterThan(String value) {
            addCriterion("companyType >", value, "companytype");
            return (Criteria) this;
        }

        public Criteria andCompanytypeGreaterThanOrEqualTo(String value) {
            addCriterion("companyType >=", value, "companytype");
            return (Criteria) this;
        }

        public Criteria andCompanytypeLessThan(String value) {
            addCriterion("companyType <", value, "companytype");
            return (Criteria) this;
        }

        public Criteria andCompanytypeLessThanOrEqualTo(String value) {
            addCriterion("companyType <=", value, "companytype");
            return (Criteria) this;
        }

        public Criteria andCompanytypeLike(String value) {
            addCriterion("companyType like", value, "companytype");
            return (Criteria) this;
        }

        public Criteria andCompanytypeNotLike(String value) {
            addCriterion("companyType not like", value, "companytype");
            return (Criteria) this;
        }

        public Criteria andCompanytypeIn(List<String> values) {
            addCriterion("companyType in", values, "companytype");
            return (Criteria) this;
        }

        public Criteria andCompanytypeNotIn(List<String> values) {
            addCriterion("companyType not in", values, "companytype");
            return (Criteria) this;
        }

        public Criteria andCompanytypeBetween(String value1, String value2) {
            addCriterion("companyType between", value1, value2, "companytype");
            return (Criteria) this;
        }

        public Criteria andCompanytypeNotBetween(String value1, String value2) {
            addCriterion("companyType not between", value1, value2, "companytype");
            return (Criteria) this;
        }

        public Criteria andEstablishdateIsNull() {
            addCriterion("establishDate is null");
            return (Criteria) this;
        }

        public Criteria andEstablishdateIsNotNull() {
            addCriterion("establishDate is not null");
            return (Criteria) this;
        }

        public Criteria andEstablishdateEqualTo(String value) {
            addCriterion("establishDate =", value, "establishdate");
            return (Criteria) this;
        }

        public Criteria andEstablishdateNotEqualTo(String value) {
            addCriterion("establishDate <>", value, "establishdate");
            return (Criteria) this;
        }

        public Criteria andEstablishdateGreaterThan(String value) {
            addCriterion("establishDate >", value, "establishdate");
            return (Criteria) this;
        }

        public Criteria andEstablishdateGreaterThanOrEqualTo(String value) {
            addCriterion("establishDate >=", value, "establishdate");
            return (Criteria) this;
        }

        public Criteria andEstablishdateLessThan(String value) {
            addCriterion("establishDate <", value, "establishdate");
            return (Criteria) this;
        }

        public Criteria andEstablishdateLessThanOrEqualTo(String value) {
            addCriterion("establishDate <=", value, "establishdate");
            return (Criteria) this;
        }

        public Criteria andEstablishdateLike(String value) {
            addCriterion("establishDate like", value, "establishdate");
            return (Criteria) this;
        }

        public Criteria andEstablishdateNotLike(String value) {
            addCriterion("establishDate not like", value, "establishdate");
            return (Criteria) this;
        }

        public Criteria andEstablishdateIn(List<String> values) {
            addCriterion("establishDate in", values, "establishdate");
            return (Criteria) this;
        }

        public Criteria andEstablishdateNotIn(List<String> values) {
            addCriterion("establishDate not in", values, "establishdate");
            return (Criteria) this;
        }

        public Criteria andEstablishdateBetween(String value1, String value2) {
            addCriterion("establishDate between", value1, value2, "establishdate");
            return (Criteria) this;
        }

        public Criteria andEstablishdateNotBetween(String value1, String value2) {
            addCriterion("establishDate not between", value1, value2, "establishdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateIsNull() {
            addCriterion("expirationDate is null");
            return (Criteria) this;
        }

        public Criteria andExpirationdateIsNotNull() {
            addCriterion("expirationDate is not null");
            return (Criteria) this;
        }

        public Criteria andExpirationdateEqualTo(String value) {
            addCriterion("expirationDate =", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateNotEqualTo(String value) {
            addCriterion("expirationDate <>", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateGreaterThan(String value) {
            addCriterion("expirationDate >", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateGreaterThanOrEqualTo(String value) {
            addCriterion("expirationDate >=", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateLessThan(String value) {
            addCriterion("expirationDate <", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateLessThanOrEqualTo(String value) {
            addCriterion("expirationDate <=", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateLike(String value) {
            addCriterion("expirationDate like", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateNotLike(String value) {
            addCriterion("expirationDate not like", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateIn(List<String> values) {
            addCriterion("expirationDate in", values, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateNotIn(List<String> values) {
            addCriterion("expirationDate not in", values, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateBetween(String value1, String value2) {
            addCriterion("expirationDate between", value1, value2, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateNotBetween(String value1, String value2) {
            addCriterion("expirationDate not between", value1, value2, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeIsNull() {
            addCriterion("businessScope is null");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeIsNotNull() {
            addCriterion("businessScope is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeEqualTo(String value) {
            addCriterion("businessScope =", value, "businessscope");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeNotEqualTo(String value) {
            addCriterion("businessScope <>", value, "businessscope");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeGreaterThan(String value) {
            addCriterion("businessScope >", value, "businessscope");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeGreaterThanOrEqualTo(String value) {
            addCriterion("businessScope >=", value, "businessscope");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeLessThan(String value) {
            addCriterion("businessScope <", value, "businessscope");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeLessThanOrEqualTo(String value) {
            addCriterion("businessScope <=", value, "businessscope");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeLike(String value) {
            addCriterion("businessScope like", value, "businessscope");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeNotLike(String value) {
            addCriterion("businessScope not like", value, "businessscope");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeIn(List<String> values) {
            addCriterion("businessScope in", values, "businessscope");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeNotIn(List<String> values) {
            addCriterion("businessScope not in", values, "businessscope");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeBetween(String value1, String value2) {
            addCriterion("businessScope between", value1, value2, "businessscope");
            return (Criteria) this;
        }

        public Criteria andBusinessscopeNotBetween(String value1, String value2) {
            addCriterion("businessScope not between", value1, value2, "businessscope");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table license
     *
     * @mbg.generated do_not_delete_during_merge Sat Mar 06 13:31:28 CST 2021
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table license
     *
     * @mbg.generated Sat Mar 06 13:31:28 CST 2021
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