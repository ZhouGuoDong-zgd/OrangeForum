package main.com.zgd.service;

import main.com.zgd.pojo.Post;

import java.util.List;

public interface PostService {
    //查询所有帖子
    List<Post> SearchPosts();
    //根据id查询单个帖子
    Post SearchPostById(Post post);

    //添加帖子
    String SendPost(Post post);
}
