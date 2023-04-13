package main.com.zgd.pojo;

public class ReplyPost {
    private Integer replyPostId; //回复id
    private Integer userId; //用户id
    private Integer postId; //被回复的帖子id
    private Integer replyPostIdCo; //回复帖子的内容的id
    private String replyPostContent; //回复内容
    private Integer replyPostLike; //点赞数量
    private Integer replyPostBelittle; //贬低数量
    private Integer replyPostReplyNumber; //回复量
    //"content":content,"userId":userId,"postId":postId,"replyPostId":replyPostId}
    public ReplyPost(String replyPostContent,Integer userId,Integer postId,Integer replyPostIdCo) {
        this.replyPostContent = replyPostContent;
        this.userId = userId;
        this.postId = postId;
        this.replyPostIdCo = replyPostIdCo;
    }

    public ReplyPost(Integer postId) {
        this.postId = postId;
    }
    public ReplyPost(Integer userId,Integer postId,String replyPostContent) {
        this.userId = userId;
        this.postId = postId;
        this.replyPostContent = replyPostContent;
    }
    public ReplyPost(){

    }
    public ReplyPost(Integer replyPostId, Integer userId, Integer postId, Integer replyPostIdCo, String replyPostContent, Integer replyPostLike, Integer replyPostBelittle, Integer replyPostReplyNumber) {
        this.replyPostId = replyPostId;
        this.userId = userId;
        this.postId = postId;
        this.replyPostIdCo = replyPostIdCo;
        this.replyPostContent = replyPostContent;
        this.replyPostLike = replyPostLike;
        this.replyPostBelittle = replyPostBelittle;
        this.replyPostReplyNumber = replyPostReplyNumber;
    }

    public Integer getReplyPostId() {
        return replyPostId;
    }

    public void setReplyPostId(Integer replyPostId) {
        this.replyPostId = replyPostId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getReplyPostIdCo() {
        return replyPostIdCo;
    }

    public void setReplyPostIdCo(Integer replyPostIdCo) {
        this.replyPostIdCo = replyPostIdCo;
    }

    public String getReplyPostContent() {
        return replyPostContent;
    }

    public void setReplyPostContent(String replyPostContent) {
        this.replyPostContent = replyPostContent;
    }

    public Integer getReplyPostLike() {
        return replyPostLike;
    }

    public void setReplyPostLike(Integer replyPostLike) {
        this.replyPostLike = replyPostLike;
    }

    public Integer getReplyPostBelittle() {
        return replyPostBelittle;
    }

    public void setReplyPostBelittle(Integer replyPostBelittle) {
        this.replyPostBelittle = replyPostBelittle;
    }

    public Integer getReplyPostReplyNumber() {
        return replyPostReplyNumber;
    }

    public void setReplyPostReplyNumber(Integer replyPostReplyNumber) {
        this.replyPostReplyNumber = replyPostReplyNumber;
    }

    @Override
    public String toString() {
        return "ReplyPost{" +
                "replyPostId=" + replyPostId +
                ", userId=" + userId +
                ", postId=" + postId +
                ", replyPostIdCo=" + replyPostIdCo +
                ", replyPostContent='" + replyPostContent + '\'' +
                ", replyPostLike=" + replyPostLike +
                ", replyPostBelittle=" + replyPostBelittle +
                ", replyPostReplyNumber=" + replyPostReplyNumber +
                '}';
    }
}
