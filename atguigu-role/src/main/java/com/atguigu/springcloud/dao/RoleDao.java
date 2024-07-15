package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Role;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface RoleDao {

    int create(Role instance);

    Role getRoleById(Long id);
}
