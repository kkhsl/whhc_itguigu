package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient // 该注解用于向使用Consul或者Zookeeper作为注册中心时注册服务
//@EnableEurekaClient(停更)
@SpringBootApplication
public class ZkUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZkUserApplication.class, args);
    }

}
