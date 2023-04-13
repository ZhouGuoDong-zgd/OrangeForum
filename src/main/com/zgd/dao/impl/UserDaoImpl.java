package main.com.zgd.dao.impl;

import main.com.zgd.dao.UserDao;
import main.com.zgd.pojo.User;
import main.com.zgd.util.GetConteroolers;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    static DataSource dataSource = GetConteroolers.getDataSource();
    static QueryRunner queryRunner = new QueryRunner();
    //登录
    @Override
    public User login(User user) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println("login连接获取异常");
            throw new RuntimeException(e);
        }
        try {
            User login = queryRunner.query(connection,"select * from user where username = ? and password = ?", new BeanHandler<User>(User.class), user.getUsername(), user.getPassword());
            return login;
        } catch (SQLException e) {
            System.out.println("登录sql出错");
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("sql关闭异常");
                throw new RuntimeException(e);
            }
        }
    }

    //注册
    @Override
    public String Register(User user) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println("login连接获取异常");
            throw new RuntimeException(e);
        }
        try {
            int i = queryRunner.update(connection,"insert into user(username,password) values (?,?)", user.getUsername(), user.getPassword());
            if (i>0){
                return "注册成功";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("sql关闭异常");
                throw new RuntimeException(e);
            }
        }
        return "登录失败";
    }

    @Override
    public User SearchUser(User user) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println("login连接获取异常");
            throw new RuntimeException(e);
        }
        try {
            User query = queryRunner.query(connection,"select * from user where username = ?", new BeanHandler<>(User.class), user.getUsername());
            return query;
        } catch (SQLException e) {
            System.out.println("查询单个用户sql错误");
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("sql关闭异常");
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public User SearchUserById(User user) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println("login连接获取异常");
            throw new RuntimeException(e);
        }
        try {
            User query = queryRunner.query(connection,"select * from user where userId = ?", new BeanHandler<>(User.class), user.getUserid());
            return query;
        } catch (SQLException e) {
            System.out.println("查询单个用户sql错误");
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("sql关闭异常");
                throw new RuntimeException(e);
            }
        }
    }
}
