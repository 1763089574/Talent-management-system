package net.suncaper.demo.common.domain;

public class Company {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.Id
     *
     * @mbg.generated Thu Feb 25 11:39:29 GMT+08:00 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.PhoneNumber
     *
     * @mbg.generated Thu Feb 25 11:39:29 GMT+08:00 2021
     */
    private String phonenumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.Name
     *
     * @mbg.generated Thu Feb 25 11:39:29 GMT+08:00 2021
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.Password
     *
     * @mbg.generated Thu Feb 25 11:39:29 GMT+08:00 2021
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.Flag
     *
     * @mbg.generated Thu Feb 25 11:39:29 GMT+08:00 2021
     */
    private Integer flag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.Credit
     *
     * @mbg.generated Thu Feb 25 11:39:29 GMT+08:00 2021
     */
    private Integer credit;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.LicenseNumber
     *
     * @mbg.generated Thu Feb 25 11:39:29 GMT+08:00 2021
     */
    private String licensenumber;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbg.generated Thu Feb 25 11:39:29 GMT+08:00 2021
     */
    public Company(Integer id, String phonenumber, String name, String password, Integer flag, Integer credit, String licensenumber) {
        this.id = id;
        this.phonenumber = phonenumber;
        this.name = name;
        this.password = password;
        this.flag = flag;
        this.credit = credit;
        this.licensenumber = licensenumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbg.generated Thu Feb 25 11:39:29 GMT+08:00 2021
     */
    public Company() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.Id
     *
     * @return the value of company.Id
     *
     * @mbg.generated Thu Feb 25 11:39:29 GMT+08:00 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.Id
     *
     * @param id the value for company.Id
     *
     * @mbg.generated Thu Feb 25 11:39:29 GMT+08:00 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.PhoneNumber
     *
     * @return the value of company.PhoneNumber
     *
     * @mbg.generated Thu Feb 25 11:39:29 GMT+08:00 2021
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.PhoneNumber
     *
     * @param phonenumber the value for company.PhoneNumber
     *
     * @mbg.generated Thu Feb 25 11:39:29 GMT+08:00 2021
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.Name
     *
     * @return the value of company.Name
     *
     * @mbg.generated Thu Feb 25 11:39:29 GMT+08:00 2021
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.Name
     *
     * @param name the value for company.Name
     *
     * @mbg.generated Thu Feb 25 11:39:29 GMT+08:00 2021
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.Password
     *
     * @return the value of company.Password
     *
     * @mbg.generated Thu Feb 25 11:39:29 GMT+08:00 2021
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.Password
     *
     * @param password the value for company.Password
     *
     * @mbg.generated Thu Feb 25 11:39:29 GMT+08:00 2021
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.Flag
     *
     * @return the value of company.Flag
     *
     * @mbg.generated Thu Feb 25 11:39:29 GMT+08:00 2021
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.Flag
     *
     * @param flag the value for company.Flag
     *
     * @mbg.generated Thu Feb 25 11:39:29 GMT+08:00 2021
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.Credit
     *
     * @return the value of company.Credit
     *
     * @mbg.generated Thu Feb 25 11:39:29 GMT+08:00 2021
     */
    public Integer getCredit() {
        return credit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.Credit
     *
     * @param credit the value for company.Credit
     *
     * @mbg.generated Thu Feb 25 11:39:29 GMT+08:00 2021
     */
    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.LicenseNumber
     *
     * @return the value of company.LicenseNumber
     *
     * @mbg.generated Thu Feb 25 11:39:29 GMT+08:00 2021
     */
    public String getLicensenumber() {
        return licensenumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.LicenseNumber
     *
     * @param licensenumber the value for company.LicenseNumber
     *
     * @mbg.generated Thu Feb 25 11:39:29 GMT+08:00 2021
     */
    public void setLicensenumber(String licensenumber) {
        this.licensenumber = licensenumber == null ? null : licensenumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbg.generated Thu Feb 25 11:39:29 GMT+08:00 2021
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
        Company other = (Company) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPhonenumber() == null ? other.getPhonenumber() == null : this.getPhonenumber().equals(other.getPhonenumber()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getFlag() == null ? other.getFlag() == null : this.getFlag().equals(other.getFlag()))
            && (this.getCredit() == null ? other.getCredit() == null : this.getCredit().equals(other.getCredit()))
            && (this.getLicensenumber() == null ? other.getLicensenumber() == null : this.getLicensenumber().equals(other.getLicensenumber()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbg.generated Thu Feb 25 11:39:29 GMT+08:00 2021
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPhonenumber() == null) ? 0 : getPhonenumber().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getFlag() == null) ? 0 : getFlag().hashCode());
        result = prime * result + ((getCredit() == null) ? 0 : getCredit().hashCode());
        result = prime * result + ((getLicensenumber() == null) ? 0 : getLicensenumber().hashCode());
        return result;
    }
}