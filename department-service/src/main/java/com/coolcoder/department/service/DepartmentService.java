package com.coolcoder.department.service;

import com.coolcoder.department.entity.Department;
import com.coolcoder.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("inSide saveDepartment method of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("inSide findDepartmentById method of DepartmentService");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
