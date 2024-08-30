package com.nan.middle;

import com.nan.Exception.NotNullException;
import com.nan.dao.AddUserDao;
import com.nan.dao.AdminiDao;
import com.nan.dao.UserDao;
import com.nan.hint.AccountRepetition;
import com.nan.hint.AddReaderUserSucceed;
import com.nan.hint.NotNullText;
import com.nan.user.Admini;
import com.nan.user.User;

import java.util.List;

/**
 * 用户 注册用户账号密码的中间代码
 */
public class UserAddMid {
    /**
     * 将注册的用户账号和密码，以及管理员账号密码传入以下方法，用来判断是否注册成功
     *
     */
    public void userAddMid(String username, String password, String adminiName, String adminiPassword) throws ClassNotFoundException {

        System.out.println("您输入新注册的用户账号为" + username);//输出注册用户输入的账号

        System.out.println("您输入新注册的用户密码为：" + password);//输出注册用户输入的密码

        if (username.equals("") || password.equals("") || adminiName.equals("") || adminiPassword.equals("")) {
            //只要任何一个为空

            try {
                throw new NotNullException("注册信息不能有空的文本框");
                //此处运行提示窗口，窗口信息为 注册信息不能有空的文本框
            } catch (NotNullException e) {
                new NotNullText().nul();//新建一个文本框不能为空的窗口提示
                e.printStackTrace();
                System.out.println("注册信息不能有空的文本框");
            }

        }

        AdminiDao adminiDao = new AdminiDao();//实例化UserDao
        List<Admini> adminis = null;//创建list集合//----======》很重要的地方，很难搞
        adminis = adminiDao.getAllAdmini();//该users集合获取所有user信息，数据库一条信息一个对象

        boolean res4 = adminis.stream().anyMatch(user1 -> user1.getAdmini().equals(adminiName));//如果用户名存在//此处放的是管理员账号
        boolean res5 = adminis.stream().anyMatch(user1 -> user1.getAdmpass().equals(adminiPassword));//如果密码一样//此处放的书管理员的密码

        UserDao userDao = new UserDao();//实例化UserDao
        List<User> users = null;//创建list集合//----======》很重要的地方，很难搞
        users = userDao.getAllUsers();//该users集合获取所有user信息，数据库一条信息一个对象
        AddUserDao addUserDao = new AddUserDao();




        if(res4&&res5){
            System.out.println("超级管理员账户密码比对成功");

            boolean res = users.stream().anyMatch(user1 -> user1.getUsername().equals(username));//如果用户名存在
            //如果用户名存在，提示,否则创建

            if (!res) {
                addUserDao.addUser(username, password);    //如果添加用户账号信息成功，则进入此if
                new AddReaderUserSucceed().win();
                System.out.println("新读者账号注册成功");
            } else {
                System.out.println("用户已存在");
                new AccountRepetition().repetition();
            }

        }


    }//构造方法 end
}
