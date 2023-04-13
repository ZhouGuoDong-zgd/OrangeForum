package main.com.zgd.servlet.post;

import com.alibaba.fastjson.JSON;
import main.com.zgd.pojo.Post;
import main.com.zgd.service.PostService;
import main.com.zgd.service.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/SendPost")
public class SendPost extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("content-type","text/html;charset=utf-8");
        String PostTitle = req.getParameter("PostTitle");
        String PostContent = req.getParameter("PostContent");
        Integer uid = (Integer) req.getSession().getAttribute("uid");
        PostService postService = new PostServiceImpl();
        String s = postService.SendPost(new Post(uid, PostTitle, PostContent));
        ArrayList<String> results = new ArrayList<>();
        results.add(s);
        String result = JSON.toJSONString(results);
        resp.getWriter().write(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
