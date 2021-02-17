package com.nie.test;

import com.nie.pojo.User;
import com.nie.service.UserService;
import com.nie.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/*
 *
 *@auth  wenzhao
 *@date 2021/1/28  19:35
 */
public class UserServiceTest {

    private UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null, "bb132", "9999", "dada@qq.com"));
        userService.registUser(new User(null, "bb321", "66666", "qqqqq@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "bb1322", "9999", "dada@qq.com")));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("bb132")) {
            System.out.println("用户名已存在！");
        } else {
            System.out.println("用户名可用！");
        }
    }
}