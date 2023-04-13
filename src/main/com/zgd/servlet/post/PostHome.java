package main.com.zgd.servlet.post;

import com.alibaba.fastjson.JSON;
import main.com.zgd.dao.ReplyPostDao;
import main.com.zgd.dao.impl.ReplyPostImpl;
import main.com.zgd.pojo.Post;
import main.com.zgd.pojo.ReplyPost;
import main.com.zgd.pojo.User;
import main.com.zgd.service.PostService;
import main.com.zgd.service.ReplyPostService;
import main.com.zgd.service.UserService;
import main.com.zgd.service.impl.PostServiceImpl;
import main.com.zgd.service.impl.ReplyPostServiceImpl;
import main.com.zgd.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/PostHome")
public class PostHome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("content-type","text/html;charset=utf-8");
        Integer postId = Integer.valueOf(req.getParameter("postId"));
        PostService postService = new PostServiceImpl();
        Post post = postService.SearchPostById(new Post(postId));
        req.setAttribute("post",post);

        Integer userId = post.getUserId();
        UserService userService = new UserServiceImpl();
        User user = userService.SearchUserById(new User(userId));
        String username = user.getUsername();
        req.setAttribute("username",username);
        req.getRequestDispatcher("/Html/PostHome.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
