package net.suncaper.demo.mapper;

import java.util.List;
import net.suncaper.demo.common.domain.Evaluate;
import net.suncaper.demo.common.domain.EvaluateExample;
import org.apache.ibatis.annotations.Param;

public interface EvaluateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    long countByExample(EvaluateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    int deleteByExample(EvaluateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    int insert(Evaluate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    int insertSelective(Evaluate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    List<Evaluate> selectByExample(EvaluateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    Evaluate selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    int updateByExampleSelective(@Param("record") Evaluate record, @Param("example") EvaluateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    int updateByExample(@Param("record") Evaluate record, @Param("example") EvaluateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    int updateByPrimaryKeySelective(Evaluate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table evaluate
     *
     * @mbg.generated Mon Mar 01 16:16:43 GMT+08:00 2021
     */
    int updateByPrimaryKey(Evaluate record);
}