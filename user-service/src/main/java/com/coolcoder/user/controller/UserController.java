package com.coolcoder.user.controller;

import com.coolcoder.user.VO.ResponseTemplateVO;
import com.coolcoder.user.entity.User;
import com.coolcoder.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService  userService;

    @PostMapping("/")
    public User saveMyUser(@RequestBody User user){
        log.info("inSide of saveUSer of UserController");
        return userService.saveMyUser(user);
    }
    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("inSide of getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(userId);
    }

}
