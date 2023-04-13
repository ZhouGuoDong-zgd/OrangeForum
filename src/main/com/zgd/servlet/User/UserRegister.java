package main.com.zgd.servlet.User;

import main.com.zgd.pojo.User;
import main.com.zgd.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Register")
public class UserRegister extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username != null && password != null && !username.equals("") && !password.equals("")){
            String register = new UserServiceImpl().Register(new User(username, password));
            if (register.equals("注册成功")){
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
            }
        }else {
            req.getRequestDispatcher("/Html/Register.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
