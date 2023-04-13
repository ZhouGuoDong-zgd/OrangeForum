package main.com.zgd.dao;

import main.com.zgd.pojo.User;

public interface UserDao {
    //登录
    User login(User user);

    //注册
    String Register(User user);

    //查询单个用户
    User SearchUser(User user);

    //根据用户id查询用户
    User SearchUserById(User user);
}
