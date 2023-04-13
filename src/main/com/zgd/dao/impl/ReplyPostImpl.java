package main.com.zgd.dao.impl;

import main.com.zgd.dao.ReplyPostDao;
import main.com.zgd.pojo.ReplyPost;
import main.com.zgd.util.GetConteroolers;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ReplyPostImpl implements ReplyPostDao {
    DataSource dataSource = GetConteroolers.getDataSource();
    QueryRunner queryRunner = new QueryRunner();
    @Override
    public List<ReplyPost> SearchReplyPostByPostId(ReplyPost replyPost) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println("获取连接异常");
            throw new RuntimeException(e);
        }
        String sql = "select * from reply_post where postId = ? and replyPostIdCo is null order by replyPostCreateTime desc ";
        try {
            List<ReplyPost> query = queryRunner.query(connection,sql, new BeanListHandler<ReplyPost>(ReplyPost.class),replyPost.getPostId());
            return query;
        } catch (SQLException e) {
            System.out.println("SearchReplyPostByPostId查询异常");
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
    public String SendReplyPost(ReplyPost replyPost) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println("获取连接异常");
            throw new RuntimeException(e);
        }
        String sql = "insert into reply_post(userId,postId,replyPostContent) values(?,?,?);";
        try {
            int update = queryRunner.update(connection, sql,replyPost.getUserId(),replyPost.getPostId(),replyPost.getReplyPostContent());
            if (update>0){
                return "添加成功";
            }
        } catch (SQLException e) {
            System.out.println("SendReplyPost添加异常");
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return "添加失败";
    }

    @Override
    public String SendReply(ReplyPost replyPost) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println("获取连接异常");
            throw new RuntimeException(e);
        }
        String sql = "insert into reply_post(userId,postId,replyPostContent,replyPostIdCo) values(?,?,?,?);";
        try {
            int update = queryRunner.update(connection, sql,replyPost.getUserId(),replyPost.getPostId(),replyPost.getReplyPostContent(),replyPost.getReplyPostIdCo());
            if (update>0){
                return "添加成功";
            }
        } catch (SQLException e) {
            System.out.println("SendReply添加异常");
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return "添加失败";
    }

    @Override
    public List<ReplyPost> SearchReplyByReplyPostId(ReplyPost replyPost) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println("获取连接异常");
            throw new RuntimeException(e);
        }
        String sql = "select * from reply_post where replyPostIdCo = ? order by replyPostCreateTime desc ";
        try {
            List<ReplyPost> query = queryRunner.query(connection,sql, new BeanListHandler<ReplyPost>(ReplyPost.class),replyPost.getPostId());
            return query;
        } catch (SQLException e) {
            System.out.println("SearchReplyPostByPostId查询异常");
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














