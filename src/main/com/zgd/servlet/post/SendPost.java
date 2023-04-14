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
        //获取输入的帖子标题
        String PostTitle = req.getParameter("PostTitle");
        //如果帖子标题为空则向前端发送一条提示消息
        if (PostTitle == null){
            resp.getWriter().write(0);
            return;
        }
        //获取输入的帖子内容
        String PostContent = req.getParameter("PostContent");
        //如果帖子内容为空则向前端发送一条提示消息
        if (PostContent == null){
            resp.getWriter().write(0);
            return;
        }
        //判断用户登入状态
        Integer uid = (Integer) req.getSession().getAttribute("uid");
        //如果处于未登入状态则向前端发送一条提示消息
        if (uid == null){
            resp.getWriter().write(0);
            return;
        }

        //创建执行sql的对象
        PostService postService = new PostServiceImpl();
        //执行sql
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
