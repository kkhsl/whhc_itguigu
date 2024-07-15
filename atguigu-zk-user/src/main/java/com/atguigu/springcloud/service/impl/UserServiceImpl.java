package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.UserDao;
import com.atguigu.springcloud.entities.User;
import com.atguigu.springcloud.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Resource
    private UserDao userDao;

    @Override
    public int create(User instance) {
        return this.userDao.create(instance);
    }

    @Override
    public User getUserById(Long id) {
        return this.userDao.getUserById(id);
    }
}
