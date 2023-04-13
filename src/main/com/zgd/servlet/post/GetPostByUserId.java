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
import java.util.List;

@WebServlet("/GetPostByUserId")
public class GetPostByUserId extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("content-type","text/html;charset=utf-8");
        Integer uid = (Integer) req.getSession().getAttribute("uid");
        PostService postService = new PostServiceImpl();
        List<Post> posts = postService.SearchPosts();
        ArrayList<Post> postsById = new ArrayList<>();
        for (Post p : posts) {
            if (p.getUserId() == uid){
                postsById.add(p);
            }
        }
        String s = JSON.toJSONString(postsById);
        resp.getWriter().write(s);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
