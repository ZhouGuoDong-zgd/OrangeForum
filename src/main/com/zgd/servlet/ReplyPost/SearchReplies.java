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

@WebServlet("/SearchReplies")
public class SearchReplies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("content-type","text/html;charset=utf-8");
        Integer postId = Integer.valueOf(req.getParameter("postId"));
        ReplyPostService replyPostService = new ReplyPostServiceImpl();
        List<ReplyPost> replyPostList = replyPostService.SearchReplyByReplyPostId(new ReplyPost(postId));
        String s = JSON.toJSONString(replyPostList);
        resp.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
