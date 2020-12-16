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
import java.util.List;

@WebServlet(urlPatterns = {"/EmpByPageServlet","/empbypage"})
public class EmpFindByPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //-------------接受参数-----------
        int page = 1;
        int size = 10;
        String pageParam = request.getParameter("page");
        String sizeParam = request.getParameter("size");
        if (pageParam != null && !"".equals(pageParam.trim())){
            page = Integer.parseInt(pageParam);
        }
        if (sizeParam != null && !"".equals(sizeParam.trim())){
            size = Integer.parseInt(sizeParam);
        }
        //-------------处理----------
        IEmpService empService = (IEmpService) SpringIOC.getSpringIoc().getBean("empService");
        List<Emp> emps = empService.searchByPage(page,size);
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
