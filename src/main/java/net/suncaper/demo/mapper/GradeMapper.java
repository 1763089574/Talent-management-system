package net.suncaper.demo.mapper;

import java.util.List;
import net.suncaper.demo.common.domain.Grade;
import net.suncaper.demo.common.domain.GradeExample;
import net.suncaper.demo.mapper.extend.GradeMapperExtend;
import org.apache.ibatis.annotations.Param;

public interface GradeMapper extends GradeMapperExtend {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbg.generated Thu Mar 04 19:34:50 GMT+08:00 2021
     */
    long countByExample(GradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbg.generated Thu Mar 04 19:34:50 GMT+08:00 2021
     */
    int deleteByExample(GradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbg.generated Thu Mar 04 19:34:50 GMT+08:00 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbg.generated Thu Mar 04 19:34:50 GMT+08:00 2021
     */
    int insert(Grade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbg.generated Thu Mar 04 19:34:50 GMT+08:00 2021
     */
    int insertSelective(Grade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbg.generated Thu Mar 04 19:34:50 GMT+08:00 2021
     */
    List<Grade> selectByExample(GradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbg.generated Thu Mar 04 19:34:50 GMT+08:00 2021
     */
    Grade selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbg.generated Thu Mar 04 19:34:50 GMT+08:00 2021
     */
    int updateByExampleSelective(@Param("record") Grade record, @Param("example") GradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbg.generated Thu Mar 04 19:34:50 GMT+08:00 2021
     */
    int updateByExample(@Param("record") Grade record, @Param("example") GradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbg.generated Thu Mar 04 19:34:50 GMT+08:00 2021
     */
    int updateByPrimaryKeySelective(Grade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbg.generated Thu Mar 04 19:34:50 GMT+08:00 2021
     */
    int updateByPrimaryKey(Grade record);
}