package main.com.zgd.util;

import main.com.zgd.service.UserService;
import main.com.zgd.service.impl.UserServiceImpl;

public class GetUserService {

    public static UserService userService = new UserServiceImpl();
    public static UserService getUserService(){
        return userService;
    }
}
