package com.zc.web.servlet;

import com.zc.domain.User;
import com.zc.service.UserService;
import com.zc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//1.掉用UserListService
        UserService service = new UserServiceImpl();
        List<User> users = service.findAll();

//        2.将list存入request域
        request.setAttribute("users", users);
//        3.转发到List.jsp
        request.getRequestDispatcher("/list.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
