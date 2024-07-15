package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.RoleDao;
import com.atguigu.springcloud.entities.Role;
import com.atguigu.springcloud.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Resource
    private RoleDao roleDao;

    @Override
    public int create(Role instance) {
        return this.roleDao.create(instance);
    }

    @Override
    public Role getRoleById(Long id) {
        return this.roleDao.getRoleById(id);
    }
}
