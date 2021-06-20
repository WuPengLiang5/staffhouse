package com.example.staffhouse.dao;

import com.example.staffhouse.entity.JobInf;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value="JobInfDao")
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

    Integer deleteJobs(@Param("ids") String[] ids);
}