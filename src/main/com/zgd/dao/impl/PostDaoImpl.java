package main.com.zgd.dao.impl;

import main.com.zgd.dao.PostDao;
import main.com.zgd.pojo.Post;
import main.com.zgd.util.GetConteroolers;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PostDaoImpl implements PostDao {
    DataSource dataSource = GetConteroolers.getDataSource();
    QueryRunner queryRunner = new QueryRunner();
    //查询所有帖子
    @Override
    public List<Post> SearchPosts() {
        String sql = "select * from post";
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println("获取sql异常");
            throw new RuntimeException(e);
        }
        try {
            List<Post> query = queryRunner.query(connection, sql, new BeanListHandler<Post>(Post.class));
            return query;
        } catch (SQLException e) {
            System.out.println("SearchPosts出错");
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("连接关闭异常");
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public Post SearchPostById(Post post) {
        Connection connection=null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println("SearchPostById获取连接异常");
            throw new RuntimeException(e);
        }
        try {
            Post Serpost = queryRunner.query(connection, "select * from post where postId = ?", new BeanHandler<>(Post.class), post.getPostId());
            return Serpost;
        } catch (SQLException e) {
            System.out.println("sql查询失败");
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String SendPost(Post post) {
        Connection connection=null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println("SearchPostById获取连接异常");
            throw new RuntimeException(e);
        }
        try {
            int result = queryRunner.update(connection, "insert into post(userId,postContent,title) values (?,?,?)",post.getUserId(),post.getPostContent(),post.getTitle());
            if (result>0){
                return "发布成功";
            }else {
                return "发布失败";
            }
        } catch (SQLException e) {
            System.out.println("SendPost查询失败");
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}














