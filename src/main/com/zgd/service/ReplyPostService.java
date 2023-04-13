package main.com.zgd.service;

import main.com.zgd.dao.ReplyPostDao;
import main.com.zgd.pojo.ReplyPost;

import java.util.List;

public interface ReplyPostService {
    List<ReplyPost> SearchReplyPostByPostId(ReplyPost replyPost);

    String SendReplyPost(ReplyPost replyPost);

    //对评论进行回复
    String SendReply(ReplyPost replyPost);

    //查看对评论回复
    List<ReplyPost> SearchReplyByReplyPostId(ReplyPost replyPost);
}
