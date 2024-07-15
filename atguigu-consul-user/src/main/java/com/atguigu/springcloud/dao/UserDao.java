package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author HKK
 * @create 2021-12-25
 */
@Mapper
public interface UserDao {

    public int create(User instance);

    public User getUserById(@Param("id") Long id);
}
