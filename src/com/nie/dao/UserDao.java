package com.nie.dao;/*
 *
 *@auth  wenzhao
 *@date 2021/1/28  18:16
 */

import com.nie.pojo.User;

public interface UserDao {

    /**
     * 根据用户名查询用户信息
     *
     * @param userName 用户名字
     * @return 如果返回null, 说明没有这个用户
     */
    public User queryUserByUsername(String userName);

    /**
     * 根据 用户名和密码查询用户信息
     *
     * @param username
     * @param password
     * @return 如果返回null, 说明没有这个用户
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存用户信息
     *
     * @param user
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    public int saveUser(User user);
}
