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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmpFindByIdServlet",urlPatterns = "/empbyid")
public class EmpFindByIdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empno = Integer.parseInt(request.getParameter("empno"));

        IEmpService empService = (IEmpService) SpringIOC.getSpringIoc().getBean("empService");
        Emp emp = empService.searchById(empno);

        if (emp!=null){
            request.setAttribute("emp",emp);
            request.getRequestDispatcher("/updateemp.jsp").forward(request,response);
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("errMsg","无此员工");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //-------------接受参数-----------
        int empno = 0;
        String empnoParam = request.getParameter("empno");
        if (empnoParam != null && !"".equals(empnoParam.trim())){
            empno = Integer.parseInt(empnoParam);
        }
        //-------------处理----------
        IEmpService empService = (IEmpService)SpringIOC.getSpringIoc().getBean("empService");
        Emp emp = empService.searchById(empno);
        List<Emp> emps = new ArrayList<>();
        emps.add(emp);
        //反馈--JAVA模板引擎
        if (emps != null && emps.size()>0){
            request.setAttribute("empsFromServer",emps);
            request.getRequestDispatcher("/emps.jsp").forward(request,response);
        }else {
            System.out.println("Error");
            HttpSession session = request.getSession();
            session.setAttribute("errMsg","分页查询失败");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
}
