package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Role;
import org.apache.ibatis.annotations.Param;

/**
 * @author HKK
 * @create 2021-12-25
 */
public interface IRoleService {

    public int create(Role instance);

    public Role getRoleById(@Param("id") Long id);
}
