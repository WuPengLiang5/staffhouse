package com.example.staffhouse.service.impl;

import com.example.staffhouse.Vo.PageObject;
import com.example.staffhouse.dao.JobInfDao;
import com.example.staffhouse.entity.JobInf;
import com.example.staffhouse.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobInfDao jobInfDao;
    @Override
    public PageObject<JobInf> getAllJobsByLike(String jobName, Integer page, Integer limit) {
        if(page==0||limit==0||page<0||limit<0){
            return null;
        }
        page = (page - 1) * limit;
        List<JobInf> jobs = jobInfDao.getAllJobsByLike(jobName, page, limit);
        Number total = jobInfDao.countAllJobsByLike(jobName);
        return new PageObject<>(total.longValue(),jobs);
    }

    @Override
    public Integer editJob(JobInf job) {
        return jobInfDao.updateByPrimaryKeySelective(job);
    }

    @Override
    public Integer addJob(JobInf job) {
        return jobInfDao.insertSelective(job);
    }

    @Override
    public List<JobInf> getAllJobs() {
        return jobInfDao.selectAll();
    }

    @Override
    public Integer deleteJob(Integer id) {
        return jobInfDao.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteJobs(String ids) {
        String[] eidList= ids.split(",");
        return jobInfDao.deleteJobs(eidList);
    }
}
