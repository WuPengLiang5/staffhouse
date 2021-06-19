package com.example.staffhouse.service;

import com.example.staffhouse.Vo.PageObject;
import com.example.staffhouse.entity.JobInf;

import java.util.List;

public interface JobService {
    PageObject<JobInf> getAllJobsByLike(String jobName, Integer page, Integer limit);

    Integer editJob(JobInf job);

    Integer addJob(JobInf job);

    List<JobInf> getAllJobs();

}
