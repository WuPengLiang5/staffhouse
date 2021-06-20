package com.example.staffhouse.controller;

import com.example.staffhouse.Vo.SysResult;
import com.example.staffhouse.entity.EmployeeInf;
import com.example.staffhouse.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 员工分页查询
     * @param deptId
     * @param jobId
     * @param sex
     * @param name
     * @param phone
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/getEmployeeByLike")
    public SysResult getEmployeeByLike(Integer deptId,Integer jobId,Integer sex,String name,String phone,Integer page,Integer limit){
        return SysResult.success("员工查询成功",employeeService.getEmployeeByLike(deptId,jobId,sex,name,phone,page,limit));
    }

    /**
     * 修改员工
     * @param employee
     * @return
     */
    @PutMapping("/editEmployee")
    public SysResult editEmployee(@RequestBody EmployeeInf employee){
        Integer key = employeeService.editEmployee(employee);
        if(key==0){
            return SysResult.fail("员工修改失败");
        }
        return SysResult.success("员工修改成功",key);
    }

    /**
     *添加员工
     * @param employee
     * @return
     */
    @PostMapping("/addEmployee")
    public SysResult addEmployee(@RequestBody EmployeeInf employee){
        Integer key = employeeService.addEmployee(employee);
        if(key==0){
            return SysResult.fail("员工添加失败");
        }
        return SysResult.success("员工添加成功",key);
    }

    @DeleteMapping("/deleteEmployees")
    public SysResult deleteEmployees(Integer[] ids){
        Integer key = 0;
        for(int i =0;i<ids.length;i++){
            key+=employeeService.deleteEmployee(ids[i]);
        }
        if(key==0){
            return SysResult.fail("员工删除失败");
        }
        return SysResult.success("删除了"+key+"条数据",null);
    }
}
