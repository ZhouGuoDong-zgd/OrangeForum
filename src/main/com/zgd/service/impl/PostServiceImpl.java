package main.com.zgd.service.impl;

import main.com.zgd.dao.PostDao;
import main.com.zgd.dao.impl.PostDaoImpl;
import main.com.zgd.pojo.Post;
import main.com.zgd.service.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {
    private PostDao postDao = new PostDaoImpl();
    @Override
    public List<Post> SearchPosts() {
        return postDao.SearchPosts();
    }

    @Override
    public Post SearchPostById(Post post) {
        return postDao.SearchPostById(post);
    }

    @Override
    public String SendPost(Post post) {
        return postDao.SendPost(post);
    }
}
