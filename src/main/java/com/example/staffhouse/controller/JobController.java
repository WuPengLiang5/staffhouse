package com.example.staffhouse.controller;

import com.example.staffhouse.Vo.SysResult;
import com.example.staffhouse.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("/getAllJobsByLike")
    public SysResult getAllJobsByLike(String jobName, @RequestParam("page") Integer page,@RequestParam("limit") Integer limit){

        return SysResult.success("职位查询成功",jobService.getAllJobsByLike(jobName,page,limit));
    }
}
