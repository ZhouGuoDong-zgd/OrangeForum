package main.com.zgd.servlet.post;

import com.alibaba.fastjson.JSON;
import main.com.zgd.pojo.ReplyPost;
import main.com.zgd.service.ReplyPostService;
import main.com.zgd.service.impl.ReplyPostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/SendReplyPost")
public class SendReplyPost extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("content-type","text/html;charset=utf-8");

        String value = req.getParameter("value");
        HttpSession session = req.getSession();
        Integer uid = (Integer) session.getAttribute("uid");
        Integer postid = Integer.valueOf(req.getParameter("postid"));
        ReplyPostService replyPostService = new ReplyPostServiceImpl();
        replyPostService.SendReplyPost(new ReplyPost(uid,postid,value));

        List<ReplyPost> replyPostList = replyPostService.SearchReplyPostByPostId(new ReplyPost(postid));
        String s = JSON.toJSONString(replyPostList);
        resp.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
