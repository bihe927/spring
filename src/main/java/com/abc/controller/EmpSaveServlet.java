package com.abc.controller;

import com.abc.common.Comm;
import com.abc.common.SpringIOC;
import com.abc.dao.entity.Emp;
import com.abc.service.iservice.IEmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "EmpSaveServlet",urlPatterns = "/empsave")
public class EmpSaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//中文乱码
        String ename = request.getParameter("ename");
        System.out.println(ename);
        Date hiredate = null;
        try {
            hiredate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hiredate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Double sal = Double.valueOf(request.getParameter("sal"));

        IEmpService empService = (IEmpService) SpringIOC.getSpringIoc().getBean("empService");
        Emp emp = new Emp(ename,hiredate,sal);
        String msg = empService.save(emp);

        if (Comm.SUCCESS.equals(msg)){
            response.sendRedirect(request.getContextPath()+"/empbypage");
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("errMsg","添加失败");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
}
