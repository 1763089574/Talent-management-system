package net.suncaper.demo.mapper;

import java.util.List;
import net.suncaper.demo.common.domain.Worker;
import net.suncaper.demo.common.domain.WorkerExample;
import net.suncaper.demo.mapper.extend.WorkerMapperExtend;
import org.apache.ibatis.annotations.Param;

public interface WorkerMapper extends WorkerMapperExtend {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table worker
     *
     * @mbg.generated Sun Mar 07 20:35:25 GMT+08:00 2021
     */
    long countByExample(WorkerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table worker
     *
     * @mbg.generated Sun Mar 07 20:35:25 GMT+08:00 2021
     */
    int deleteByExample(WorkerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table worker
     *
     * @mbg.generated Sun Mar 07 20:35:25 GMT+08:00 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table worker
     *
     * @mbg.generated Sun Mar 07 20:35:25 GMT+08:00 2021
     */
    int insert(Worker record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table worker
     *
     * @mbg.generated Sun Mar 07 20:35:25 GMT+08:00 2021
     */
    int insertSelective(Worker record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table worker
     *
     * @mbg.generated Sun Mar 07 20:35:25 GMT+08:00 2021
     */
    List<Worker> selectByExample(WorkerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table worker
     *
     * @mbg.generated Sun Mar 07 20:35:25 GMT+08:00 2021
     */
    Worker selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table worker
     *
     * @mbg.generated Sun Mar 07 20:35:25 GMT+08:00 2021
     */
    int updateByExampleSelective(@Param("record") Worker record, @Param("example") WorkerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table worker
     *
     * @mbg.generated Sun Mar 07 20:35:25 GMT+08:00 2021
     */
    int updateByExample(@Param("record") Worker record, @Param("example") WorkerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table worker
     *
     * @mbg.generated Sun Mar 07 20:35:25 GMT+08:00 2021
     */
    int updateByPrimaryKeySelective(Worker record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table worker
     *
     * @mbg.generated Sun Mar 07 20:35:25 GMT+08:00 2021
     */
    int updateByPrimaryKey(Worker record);
}