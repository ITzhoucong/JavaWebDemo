package com.zc.web.servlet;

import com.zc.domain.User;
import com.zc.service.UserService;
import com.zc.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        1.设置编码
        request.setCharacterEncoding("utf-8");
//        2.获取Map
        Map<String, String[]> map = request.getParameterMap();
//        3.封装对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        4.调用service
        UserService service = new UserServiceImpl();
        service.updateUser(user);
//        5.重定向到userListServlet
        response.sendRedirect(request.getContextPath() + "/findUserByPageServlet");

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
