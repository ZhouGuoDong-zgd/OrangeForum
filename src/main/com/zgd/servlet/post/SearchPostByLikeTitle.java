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
import java.util.List;

@WebServlet("/SearchPostByLikeTitle")
public class SearchPostByLikeTitle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("content-type","text/html;charset=utf-8");
        PostService postService = new PostServiceImpl();
        String searchValue = req.getParameter("SearchValue");
        Integer uid = (Integer) req.getSession().getAttribute("uid");
        List<Post> posts = postService.SearchPostByLikeTitle(new Post(searchValue), uid);
        String s = JSON.toJSONString(posts);
        resp.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
