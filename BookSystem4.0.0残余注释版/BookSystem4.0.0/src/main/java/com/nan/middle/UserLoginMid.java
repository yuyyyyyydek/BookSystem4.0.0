package com.nan.middle;

import com.nan.dao.UserDao;
import com.nan.hint.UserLoginSucceed;
import com.nan.tool.Only;
import com.nan.user.User;

import java.util.List;


/**
 * 用户登陆账号的中间层
 */
public class UserLoginMid {
    public void userLoginMid(String userAccount,String userPassword){

        System.out.println("您输入的用户账号为:" + userAccount);//显示用户输入的账号
        System.out.println("您输入的用户密码为:" + userPassword);//显示用户输入的密码

        UserDao userDao = new UserDao();//实例化UserDao对象
        List<User> users = null;//创建list集合

        try {
            users = userDao.getAllUsers();//users中接收了所有用户的账号密码信息
        } catch (ClassNotFoundException e) {//捕获异常
            throw new RuntimeException(e);//异常处理
        }

        boolean res2 = users.stream().anyMatch(user1 -> user1.getUsername().equals(userAccount));//如果用户名存在
        boolean res3 = users.stream().anyMatch(user1 -> user1.getPassword().equals(userPassword));//如果密码一样

        if(res2&&res3){
            System.out.println("终于登录成功");
            new UserLoginSucceed().succeed();//如果登陆成功，显示登陆成功的跳转提示窗口
            Only.UserLoginSucceed = 1;//用户登陆成功，重置该静态量为1，表示登陆成功

        } else {
            System.out.println("登陆失败，请重新登陆");
        }


    }
}
