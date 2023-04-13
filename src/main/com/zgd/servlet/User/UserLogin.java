package main.com.zgd.servlet.User;

import com.alibaba.fastjson.JSON;
import main.com.zgd.pojo.User;
import main.com.zgd.service.UserService;
import main.com.zgd.service.impl.UserServiceImpl;
import main.com.zgd.util.GetConteroolers;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/login")
public class UserLogin extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("content-type","text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String memory = req.getParameter("memory");
        if (username !=null && password!=null && !username.equals("") && !password.equals("")){
            System.out.println(username);
            System.out.println(password);
            User user = userService.login(new User(username, password));
            if (user!=null){
                if ("on".equals(memory)){
                    HttpSession session = req.getSession();
                    session.setAttribute("user",user);
                    Cookie cookieUsername = new Cookie("username",user.getUsername());
                    Cookie cookiePassword = new Cookie("password",user.getPassword());
                    cookieUsername.setMaxAge(60*60*24*10);
                    cookiePassword.setMaxAge(60*60*24*10);
                    resp.addCookie(cookieUsername);
                    resp.addCookie(cookiePassword);
                }
                HttpSession session = req.getSession();
                session.setAttribute("uid",user.getUserid());
                session.setAttribute("username",user.getUsername());
                session.setAttribute("createTime",user.getCreateTime());
                /*req.getRequestDispatcher("/Html/UserHome.jsp").forward(req,resp);*/
                ArrayList<String> result = new ArrayList<>();
                result.add("登入成功");
                String s = JSON.toJSONString(result);
                resp.getWriter().write(s);
            }else {
                ArrayList<String> result = new ArrayList<>();
                result.add("登入失败");
                String s = JSON.toJSONString(result);
                resp.getWriter().write(s);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
