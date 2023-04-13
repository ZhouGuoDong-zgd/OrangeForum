package main.com.zgd.service.impl;

import main.com.zgd.dao.ReplyPostDao;
import main.com.zgd.dao.impl.ReplyPostImpl;
import main.com.zgd.pojo.ReplyPost;
import main.com.zgd.service.ReplyPostService;

import java.util.List;

public class ReplyPostServiceImpl implements ReplyPostService {
    private ReplyPostDao replyPostDao = new ReplyPostImpl();
    @Override
    public List<ReplyPost> SearchReplyPostByPostId(ReplyPost replyPost) {
        return replyPostDao.SearchReplyPostByPostId(replyPost);
    }

    @Override
    public String SendReplyPost(ReplyPost replyPost) {
        return replyPostDao.SendReplyPost(replyPost);
    }

    @Override
    public String SendReply(ReplyPost replyPost) {
        return replyPostDao.SendReply(replyPost);
    }

    @Override
    public List<ReplyPost> SearchReplyByReplyPostId(ReplyPost replyPost) {
        return replyPostDao.SearchReplyByReplyPostId(replyPost);
    }
}
