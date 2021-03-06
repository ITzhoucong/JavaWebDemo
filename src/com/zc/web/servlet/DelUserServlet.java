package com.zc.web.servlet;

import com.zc.service.UserService;
import com.zc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delUserServlet")
public class DelUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        1.获取id
        Integer id = Integer.valueOf(request.getParameter("id"));
//        2.调用service删除
        UserService service = new UserServiceImpl();
        service.deleteUser(id);
//        3.跳转到查询所有userListServlet
        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
