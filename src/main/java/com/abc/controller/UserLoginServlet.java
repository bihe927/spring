package com.abc.controller;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.common.SpringIOC;
import com.abc.dao.entity.User;
import com.abc.service.iservice.IUserService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/UserLoginServlet","/login"})
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 接受
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2 处理

        IUserService userService = (IUserService) SpringIOC.getSpringIoc().getBean("userService");

        User user = new User(username,password);
        Res<User> res = userService.userLogin(username,password);

        HttpSession session = request.getSession();
        session.setAttribute(Comm.CURRENT_USER,res.getData());
        System.out.println(res);
        //3 反馈
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        Object resJson = JSON.toJSONString(res);
        out.println(resJson);
        out.close();
    }

}
