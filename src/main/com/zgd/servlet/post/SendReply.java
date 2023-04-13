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
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/SendReply")
public class SendReply extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("content-type","text/html;charset=utf-8");
        ReplyPostService replyPostService = new ReplyPostServiceImpl();

        String content = req.getParameter("content");
        Integer uid = (Integer) req.getSession().getAttribute("uid");
        Integer postId = Integer.valueOf(req.getParameter("postId"));
        Integer replyPostId = Integer.valueOf(req.getParameter("replyPostId"));
        String s = replyPostService.SendReply(new ReplyPost(content, uid, postId, replyPostId));
        ArrayList<String> strings = new ArrayList<>();
        strings.add(s);
        String result = JSON.toJSONString(strings);
        resp.getWriter().write(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
