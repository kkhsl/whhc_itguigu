package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author HKK
 * @create 2021-12-25
 */
public interface IUserService {

    public int create(User instance);

    public User getUserById(@Param("id") Long id);
}