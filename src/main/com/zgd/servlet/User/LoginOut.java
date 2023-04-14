package main.com.zgd.servlet.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginOut")
public class LoginOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("content-type","text/html;charset=utf-8");
        Cookie cookieUsername = new Cookie("username","");
        Cookie cookiePassword = new Cookie("password","");
        //退出登入后删除持久化姓名密码相关的cookie
        cookieUsername.setMaxAge(0);
        cookiePassword.setMaxAge(0);
        resp.addCookie(cookieUsername);
        resp.addCookie(cookiePassword);
        HttpSession session = req.getSession();
        //退出登入后将以下内容置空
        session.setAttribute("username",null);
        session.setAttribute("uid",null);
        session.setAttribute("createTime",null);
        resp.sendRedirect("/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
