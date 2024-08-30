package com.nan.middle;

import com.nan.Exception.NotNullException;
import com.nan.dao.AddReaderUserDao;
import com.nan.dao.ReaderDao;
import com.nan.dao.UserDao;
import com.nan.hint.AccountRepetition;
import com.nan.hint.AddReaderUserSucceed;
import com.nan.hint.NotNullText;
import com.nan.user.ReaderUser;
import com.nan.user.User;

import java.util.List;

/**
 * 读者 注册读者账号密码的中间代码
 */
public class ReaderUserAddMid {


    /**
     * 将注册的读者账号和密码，以及用户账号密码传入以下方法，用来判断是否注册成功
     *
     * @param
     * @param
     * @param userName
     * @param password
     * @throws ClassNotFoundException
     */


//    public void  readerUserAddMid(String readerUser,String readerUserPass,String userName, String password) throws ClassNotFoundException {
    public void readerUserAddMid(String readerUser, String readerUserPass, String userName, String password) throws ClassNotFoundException {



        System.out.println("您输入的读者账号为" + readerUser);//输出读者输入的账号

        System.out.println("您输入的读者密码为：" + readerUserPass);//输出读者输入的密码
        if (readerUser.equals("") || readerUserPass.equals("") || userName.equals("") || password.equals("")) {
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


        UserDao userDao = new UserDao();//实例化UserDao
        List<User> users = null;//创建list集合//----======》很重要的地方，很难搞
        users = userDao.getAllUsers();//该users集合获取所有user信息，数据库一条信息一个对象


        for (User user : users) { //遍历循环Users集合
            if (user.getUsername().equals(userName)) {//如果读者输入的用户账号与数据库中的账号一样，进入此if
                if (user.getPassword().equals(password)) {
                    //如果读者输入的用户密码与数据库中的密码一样，进入此if
                    System.out.println("读者账号密码数据比对成功");


                    //循环遍历读者表，不能有重复
                    //UserDao userDao = new UserDao();//实例化UserDao
                    //List<User> users = null;//创建list集合//----======》很重要的地方，很难搞
                    //users = userDao.getAllUsers();//该users集合获取所有user信息，数据库一条信息一个对象

                    ReaderDao readerLoginDao = new ReaderDao();//实例化readerLoginDao
                    List<ReaderUser> readerUsers = null;//创建list集合
                    readerUsers = readerLoginDao.getAllReaderUsers();//readerUsers该集合获取所有readerUser对象内容，一个对象对应一条数据库信息
                    //System.out.println("READERS:"+readerUsers);
                    AddReaderUserDao addReaderUserDao = new AddReaderUserDao();

                    boolean res = readerUsers.stream().anyMatch(user1 -> user1.getReaderUser().equals(readerUser));//如果用户名存在
                    //如果用户名存在，提示,否则创建
                    if (!res) {
                        addReaderUserDao.addReaderUser(readerUser, readerUserPass);    //如果添加读者账号信息成功，则进入此if
                        new AddReaderUserSucceed().win();
                        System.out.println("新读者账号注册成功");
                    } else {
                        System.out.println("用户已存在");
                        new AccountRepetition().repetition();
                    }


                }

            } else {
                System.out.println("用户账号密码信息比对失败，请检查你的用户账号密码是否正确");

            }
        }

    }
}











//        if(new AddUserAdminiDAO().jdbc(account,password))  {  //管理员账号密码和数据库横纵的密码进行比对
//
//            new AddUserDAO().addUser(addAccount,addPass);
//            MainApp.staticdata.countreg = 0;//设置此注册窗口不存在，重置为0方便下次创建
//            dispose();
//
//
//                }










