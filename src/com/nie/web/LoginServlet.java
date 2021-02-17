package com.nie.web;/*
 *
 *@auth  wenzhao
 *@date 2021/1/28  23:30
 */

import com.nie.pojo.User;
import com.nie.service.UserService;
import com.nie.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //调用userService.login()处理登录业务
        User loginUser = userService.login(new User(null, username, password, null));
        if (loginUser == null) {
            //把错误信息,会显到表单项信息,保存到Request
            req.setAttribute("msg","用户或密码错误！");
            req.setAttribute("username", username);
            //跳回到登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);

        } else {
            //登陆成功
            //跳回到成功页面 login_success.jsp
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);

        }

    }
}


