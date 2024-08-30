package com.nan.middle;

import com.nan.dao.ReaderDao;
import com.nan.hint.Succeed;
import com.nan.tool.Only;
import com.nan.user.ReaderUser;

/**
 * reader读者登陆账号的中间代码
 */
public class ReadLoginMid {

    public void readLoginMid(String readerAccount,String readerPassword ){

                System.out.println("您输入的读者账号为:" + readerAccount);//显示用户输入的账号
                System.out.println("您输入的读者密码为:" + readerPassword);//显示用户输入的密码

                ReaderDao readerLoginDao = new ReaderDao();//实例化ReaderLoginDao类
                java.util.List<ReaderUser> readerUsers = null;//创建list集合//----======》很重要的地方，很难搞，无数次失败才出现这个的成功
                readerUsers = readerLoginDao.getAllReaderUsers();//readerUsers中存有所有的数据库表中的用户账号密码

        for(ReaderUser readerUser : readerUsers){ //遍历循环readerUsers集合
                    if(readerUser.getReaderUser().equals(readerAccount)){//如果用户输入的账号与数据库中的账号一样，进入此if
                        if(readerUser.getReaderPassword().equals(readerPassword)){//如果用户输入的密码与数据库中的密码一样，进入此if
                            System.out.println("终于登录成功");
                            Only.readerLoginSucceed = 1;//读者登陆成功
                            new Succeed().succeed();
                        }
                    }else{
                        System.out.println("登陆失败，请重新登陆");
                    }


                }

    }

}
