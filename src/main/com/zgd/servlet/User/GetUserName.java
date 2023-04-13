package main.com.zgd.servlet.User;

import com.alibaba.fastjson.JSON;
import main.com.zgd.pojo.User;
import main.com.zgd.service.UserService;
import main.com.zgd.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/GetUserName")
public class GetUserName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("content-type","text/html;charset=utf-8");

        Integer uid = Integer.valueOf(req.getParameter("uid"));
        if (uid!=null){
            UserService userService = new UserServiceImpl();
            User user = userService.SearchUserById(new User(uid));
            if (user!=null){
                ArrayList<String> strings = new ArrayList<>();
                strings.add(user.getUsername());
                String s = JSON.toJSONString(strings);
                resp.getWriter().write(s);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
