package main.com.zgd.service.impl;

import main.com.zgd.dao.UserDao;
import main.com.zgd.dao.impl.UserDaoImpl;
import main.com.zgd.pojo.User;
import main.com.zgd.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public String Register(User user) {
        return userDao.Register(user);
    }

    @Override
    public User SearchUser(User user) {
        return userDao.SearchUser(user);
    }

    @Override
    public User SearchUserById(User user) {
        return userDao.SearchUserById(user);
    }
}
