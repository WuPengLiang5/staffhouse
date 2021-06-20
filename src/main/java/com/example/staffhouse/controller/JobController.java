package com.example.staffhouse.controller;

import com.example.staffhouse.Vo.SysResult;
import com.example.staffhouse.entity.JobInf;
import com.example.staffhouse.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;

    /**
     * 职位分页
     * @param jobName
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/getAllJobsByLike")
    public SysResult getAllJobsByLike(String jobName, @RequestParam("page") Integer page,@RequestParam("limit") Integer limit){

        return SysResult.success("职位查询成功",jobService.getAllJobsByLike(jobName,page,limit));
    }

    @PutMapping("/editJob")
    public SysResult editJob(@RequestBody JobInf job){
        Integer key = jobService.editJob(job);
        if(key==0){
            return SysResult.fail("修改失败");
        }
        return SysResult.success("职位修改成功",key);
    }

    @PostMapping("/addJob")
    public SysResult addJob(@RequestBody JobInf job){
        Integer key = jobService.addJob(job);
        if(key==0){
            return SysResult.fail("新增失败");
        }
        return SysResult.success("职位新增成功",key);
    }

    /**
     * 不分页
     * @return
     */
    @GetMapping("/getAllJobs")
    public SysResult getAllJobs(){
        return SysResult.success("职位查询成功",jobService.getAllJobs());
    }

    @DeleteMapping("/deleteJobs")
    public SysResult deleteJobs(String ids){
        Integer key = jobService.deleteJobs(ids);
        return SysResult.success("删除了"+key+"条数据",null);
    }
}
