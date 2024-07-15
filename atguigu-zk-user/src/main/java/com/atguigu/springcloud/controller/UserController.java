package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Role;
import com.atguigu.springcloud.entities.User;
import com.atguigu.springcloud.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Autowired
    private IUserService userService;
    private static  final String ROLE_SERVICE = "http://metoo-role-service";

    @PostMapping("/user/create")
    public CommonResult create(User user){
        int result = userService.create(user);
        log.info("插入结果", result);
        return new CommonResult(200, "Success");
    }

    @GetMapping("/user/get/{id}")
    public CommonResult query(@PathVariable("id") Long id){
        User user = userService.getUserById(id);
        if(user != null){
            return new CommonResult(200, "Success", user);
        }else{
            return new CommonResult(200,"查无此人");
        }
    }

    @GetMapping("/user/role/get")
    public CommonResult query_role(Long id){
        User user = userService.getUserById(id);
        if(user != null){
            // 根据用户Id查询User
            return this.restTemplate.getForObject(ROLE_SERVICE + "/role/get/" + id, CommonResult.class);
        }else{
            return new CommonResult(200,"查无此人");
        }
    }

    @GetMapping("/user/discovery")
    public Object discovery(){
         List<String> serviceList = discoveryClient.getServices();
         for(String element : serviceList){
            log.info("element：" + element);
         }

         List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("metoo-user-service");
         for (ServiceInstance instance : serviceInstanceList){
             log.info("instance：" + instance.getHost() + "\t" + instance.getInstanceId() + "\t"
                     + instance.getScheme() + "\t" + instance.getServiceId() + "\t" + instance.getMetadata() + "\t"
                     + instance.getPort() + "\t" + instance.getUri() + "\t" + instance.getClass());
         }
         int order = discoveryClient.getOrder();
         log.info("order：" + order);
         return this.discoveryClient;
    }
}

