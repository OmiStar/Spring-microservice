package com.coolcoder.department.controller;

import com.coolcoder.department.entity.Department;
import com.coolcoder.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        log.info("inSide saveDepartment method of Department");
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("inSide findDepartmentById method of Department");
        return  departmentService.findDepartmentById(departmentId);
    }


}
