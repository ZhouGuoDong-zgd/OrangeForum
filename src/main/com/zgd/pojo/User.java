package main.com.zgd.pojo;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class User {
    private Integer userid; //用户id
    private String username; //用户姓名
    private String password; //用户密码
    private LocalDateTime createTime; //用户创建时间

    public User(String username,String password){
        this.username = username;
        this.password = password;
    }
    public User(String username){
        this.username = username;
    }
    public User(Integer uid){
        userid = uid;
    }
    public User(Integer userId, String username, String password, LocalDateTime createTime) {
        this.userid = userId;
        this.username = username;
        this.password = password;
        this.createTime = createTime;
    }
    public User(){

    }

    public int getUserid() {
        return userid;
    }

    public void setUserId(Integer userId) {
        this.userid = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreateTime() {

        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
