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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.设置编码
        request.setCharacterEncoding("utf-8");
//        2.获取数据
//        2.1获取用户填写验证码
        String verifycode = request.getParameter("verifycode");

//        3.验证码校验
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");// 确保验证码一次性
//        equalsIgnoreCase忽略大小写比较
        if (!checkcode_server.equalsIgnoreCase(verifycode)) {
            //验证码不正确
//            提示信息
            request.setAttribute("login_msg", "验证码错误！");
//            跳转登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        /*
         * request.getParameterMap()返回的是一个Map类型的值，
         * 该返回值记录着前端（如jsp页面）所提交请求中的请求参数和请求参数值的映射关系。
         * 这个返回值有个特别之处——只能读。
         */
        Map<String, String[]> map = request.getParameterMap();
//        4.封装对象
        User user = new User();
        try {
            /*
             * 功能描述:
             * BeanUtils位于org.apache.commons.beanutils.BeanUtils下面，其方法populate的作用解释如下：
             * 完整方法：BeanUtils.populate( Object bean, Map properties )，
             * 这个方法会遍历map<key, value>中的key，如果bean中有这个属性，就把这个key对应的value值赋给bean的属性。
             *
             */
            BeanUtils.populate(user, map);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

//        5.调用service查询
        UserService service = new UserServiceImpl();
        User loginUser = service.login(user);
//        6.判断是否登录成功
        if (loginUser != null) {
//            登录成功
//            将用户存入session
            session.setAttribute("user", loginUser);
//            跳转页面
            response.sendRedirect(request.getContextPath() + "/index.jsp");


        } else {
//            登录失败
            //            提示信息
            request.setAttribute("login_msg", "用户名或密码错误！");
//            跳转登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
