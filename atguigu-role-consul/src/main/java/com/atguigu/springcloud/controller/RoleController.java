package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Role;
import com.atguigu.springcloud.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @PostMapping("/role/create")
    public CommonResult create(Role role){
        int result = roleService.create(role);
        log.info("插入结果", result);
        return new CommonResult(200, "Success");
    }

    @GetMapping("/role/get/{id}")
    public CommonResult query(@PathVariable("id") Long id){
        Role role = roleService.getRoleById(id);
        if(role != null){
            return new CommonResult(200, "Success", role);
        }else{
            return new CommonResult(200,"role1:查无此角色");
        }
    }
}

