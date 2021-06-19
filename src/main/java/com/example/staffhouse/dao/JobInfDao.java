package com.example.staffhouse.dao;

import com.example.staffhouse.entity.JobInf;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JobInfDao {
    int deleteByPrimaryKey(Integer id);

    int insert(JobInf record);

    int insertSelective(JobInf record);

    JobInf selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobInf record);

    int updateByPrimaryKey(JobInf record);

    List<JobInf> getAllJobsByLike(@Param("jobName") String jobName, @Param("page") Integer page, @Param("limit") Integer limit);

    Number countAllJobsByLike(@Param("jobName") String jobName);

    List<JobInf> selectAll();
}