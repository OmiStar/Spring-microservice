package com.coolcoder.user.service;

import com.coolcoder.user.VO.Department;
import com.coolcoder.user.VO.ResponseTemplateVO;
import com.coolcoder.user.entity.User;
import com.coolcoder.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveMyUser(User user) {
        log.info("inSide of saveUSer of UserService");
        return repository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("inSide of getUserWithDepartment of UserService");
        ResponseTemplateVO vo=new ResponseTemplateVO();
        User user= repository.findByUserId(userId);


        Department department=
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId()
                        ,Department.class);

            vo.setUser(user);
            vo.setDepartment(department);

            return vo;

    }
}
