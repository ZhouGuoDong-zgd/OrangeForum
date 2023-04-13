package main.com.zgd.servlet.ReplyPost;

import com.alibaba.fastjson.JSON;
import main.com.zgd.pojo.ReplyPost;
import main.com.zgd.service.ReplyPostService;
import main.com.zgd.service.impl.ReplyPostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ReplyPostByPostId")
public class ReplyPostByPostId extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("content-type","text/html;charset=utf-8");
        Integer postid = Integer.valueOf(req.getParameter("postid"));
        ReplyPostService replyPostService = new ReplyPostServiceImpl();
        List<ReplyPost> replyPostList = replyPostService.SearchReplyPostByPostId(new ReplyPost(postid));
        resp.getWriter().write(JSON.toJSONString(replyPostList));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
