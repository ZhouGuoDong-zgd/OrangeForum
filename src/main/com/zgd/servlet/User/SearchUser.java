package main.com.zgd.servlet.User;

import com.alibaba.fastjson.JSON;
import main.com.zgd.pojo.User;
import main.com.zgd.util.GetConteroolers;
import main.com.zgd.util.GetUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/SearchUser")
public class SearchUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("content-type","text/html;charset=utf-8");
        String username = req.getParameter("name");
        System.out.println(username);
        User user = GetUserService.userService.SearchUser(new User(username));
        if (user!=null){
            ArrayList<String> result = new ArrayList<>();
            result.add("用户已注册");
            String s = JSON.toJSONString(result);
            resp.getWriter().write(s);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
