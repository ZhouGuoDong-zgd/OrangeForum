package main.com.zgd.servlet.post;

import com.alibaba.fastjson.JSON;
import main.com.zgd.pojo.Post;
import main.com.zgd.pojo.ReplyPost;
import main.com.zgd.service.PostService;
import main.com.zgd.service.ReplyPostService;
import main.com.zgd.service.impl.PostServiceImpl;
import main.com.zgd.service.impl.ReplyPostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/GetPostSize")
public class GetPostSize extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("content-type","text/html;charset=utf-8");
        int end = 3;
        PostService postService = new PostServiceImpl();
        List<Post> posts = postService.SearchPosts();
        int size = posts.size();
        if (size<end){
            String s = JSON.toJSONString(size);
            resp.getWriter().write(s);
        }else {
            if (size % end == 0){
                int i = size / end;
                String s = JSON.toJSONString(i);
                resp.getWriter().write(s);
            }else {
                int i = size / end + 1;
                String s = JSON.toJSONString(i);
                resp.getWriter().write(s);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
