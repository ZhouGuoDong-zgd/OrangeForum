package main.com.zgd.Test;

import main.com.zgd.pojo.Post;
import main.com.zgd.pojo.PostType;
import main.com.zgd.pojo.ReplyPost;
import main.com.zgd.pojo.User;
import main.com.zgd.service.PostService;
import main.com.zgd.service.UserService;
import main.com.zgd.service.impl.PostServiceImpl;
import main.com.zgd.service.impl.UserServiceImpl;
import main.com.zgd.util.GetConteroolers;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.awt.*;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class T1 {
    @Test
    public void t1(){
        PostService postService = new PostServiceImpl();
        List<Post> posts = postService.SearchPosts();
        System.out.println(posts);
    }
    @Test
    public void t2(){
        Hashtable<Object, String> hashtable = new Hashtable<>();
        hashtable.put("key1","value");
        hashtable.put("key2","value");
        hashtable.put("key3","value");
        Enumeration<String> elements = hashtable.elements();
        System.out.println("elements = " + elements);
    }
}
