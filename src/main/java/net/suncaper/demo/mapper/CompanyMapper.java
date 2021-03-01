package net.suncaper.demo.mapper;

import java.util.List;
import net.suncaper.demo.common.domain.Company;
import net.suncaper.demo.common.domain.CompanyExample;
import net.suncaper.demo.mapper.extend.CompanyMapperExtend;
import org.apache.ibatis.annotations.Param;

public interface CompanyMapper extends CompanyMapperExtend {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    long countByExample(CompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    int deleteByExample(CompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    int insert(Company record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    int insertSelective(Company record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    List<Company> selectByExample(CompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    Company selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    int updateByExampleSelective(@Param("record") Company record, @Param("example") CompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    int updateByExample(@Param("record") Company record, @Param("example") CompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    int updateByPrimaryKeySelective(Company record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbg.generated Sat Feb 27 14:32:24 CST 2021
     */
    int updateByPrimaryKey(Company record);
}