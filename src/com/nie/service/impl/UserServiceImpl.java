package com.nie.service.impl;
/*
 *
 *@auth  wenzhao
 *@date 2021/1/28  19:32
 */

import com.nie.dao.UserDao;
import com.nie.dao.imp.UserDaoImpl;
import com.nie.pojo.User;
import com.nie.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {

        if (userDao.queryUserByUsername(username) == null) {
            return false;
        } else {
            return true;
        }
    }
}
