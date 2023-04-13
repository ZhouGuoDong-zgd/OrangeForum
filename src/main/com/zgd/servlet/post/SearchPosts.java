package main.com.zgd.servlet.post;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
import java.util.Collections;
import java.util.List;

@WebServlet("/SearchPosts")
public class SearchPosts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("content-type","text/html;charset=utf-8");
        Integer start = Integer.valueOf(req.getParameter("start"));
        System.out.println("start = " + start);
        PostService postService = new PostServiceImpl();
        List<Post> posts = postService.SearchPosts();
        int size = posts.size();
        List<Post> postsCopy = new ArrayList<>();
        if (size>3){
            for (int i = (start - 1) * 3; i < size; i++) {
                postsCopy.add(posts.get(i));
                if (postsCopy.size()==3){
                    break;
                }
            }
            String s = JSON.toJSONString(postsCopy);
            resp.getWriter().write(s);
        }else {
            String s = JSON.toJSONString(posts);
            resp.getWriter().write(s);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
