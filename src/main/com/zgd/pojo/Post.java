package main.com.zgd.pojo;

import java.time.LocalDateTime;
import java.util.Date;

public class Post {
    private Integer postId; //帖子id
    private Integer userId; //发帖用户id
    private Integer postTypeId; //帖子内容的id
    private String postContent; //发帖内容
    private LocalDateTime postCreateTime; //发帖时间
    private LocalDateTime postUpdateTime; //帖子修改时间
    private Integer postNumber; //帖子访问量
    private Integer postLike; //帖子点赞数量
    private Integer postBelittle; //帖子贬低数量
    private Integer postReplyNumber; //帖子回复数量
    private String title;



    public Post(Integer postId, Integer userId, Integer postTypeId, String postContent, LocalDateTime postCreateTime, LocalDateTime postUpdateTime, Integer postNumber, Integer postLike, Integer postBelittle, Integer postReplyNumber, String title) {
        this.postId = postId;
        this.userId = userId;
        this.postTypeId = postTypeId;
        this.postContent = postContent;
        this.postCreateTime = postCreateTime;
        this.postUpdateTime = postUpdateTime;
        this.postNumber = postNumber;
        this.postLike = postLike;
        this.postBelittle = postBelittle;
        this.postReplyNumber = postReplyNumber;
        this.title = title;
    }

    public Post() {
    }
    public Post(Integer userId,String title,String postContent){
        this.userId = userId;
        this.title = title;
        this.postContent = postContent;
    }
    public Post(String title){
        this.title = title;
    }
    public Post(Integer postId){
        this.postId = postId;
    }
    public Post(Integer postId, Integer userId, Integer postTypeId, String postContent, LocalDateTime postCreateTime, LocalDateTime postUpdateTime, Integer postNumber, Integer postLike, Integer postBelittle, Integer postReplyNumber) {
        this.postId = postId;
        this.userId = userId;
        this.postTypeId = postTypeId;
        this.postContent = postContent;
        this.postCreateTime = postCreateTime;
        this.postUpdateTime = postUpdateTime;
        this.postNumber = postNumber;
        this.postLike = postLike;
        this.postBelittle = postBelittle;
        this.postReplyNumber = postReplyNumber;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPostTypeId() {
        return postTypeId;
    }

    public void setPostTypeId(Integer postTypeId) {
        this.postTypeId = postTypeId;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public LocalDateTime getPostCreateTime() {
        return postCreateTime;
    }

    public void setPostCreateTime(LocalDateTime postCreateTime) {
        this.postCreateTime = postCreateTime;
    }

    public LocalDateTime getPostUpdateTime() {
        return postUpdateTime;
    }

    public void setPostUpdateTime(LocalDateTime postUpdateTime) {
        this.postUpdateTime = postUpdateTime;
    }

    public Integer getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(Integer postNumber) {
        this.postNumber = postNumber;
    }

    public Integer getPostLike() {
        return postLike;
    }

    public void setPostLike(Integer postLike) {
        this.postLike = postLike;
    }

    public Integer getPostBelittle() {
        return postBelittle;
    }

    public void setPostBelittle(Integer postBelittle) {
        this.postBelittle = postBelittle;
    }

    public Integer getPostReplyNumber() {
        return postReplyNumber;
    }

    public void setPostReplyNumber(Integer postReplyNumber) {
        this.postReplyNumber = postReplyNumber;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", postTypeId=" + postTypeId +
                ", postContent='" + postContent + '\'' +
                ", postCreateTime=" + postCreateTime +
                ", postUpdateTime=" + postUpdateTime +
                ", postNumber=" + postNumber +
                ", postLike=" + postLike +
                ", postBelittle=" + postBelittle +
                ", postReplyNumber=" + postReplyNumber +
                ", title='" + title + '\'' +
                '}';
    }
}
