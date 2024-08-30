package com.nan.view;

import com.nan.dao.LoginDao;
import com.nan.dao.User;
import com.nan.hint.Amount;
import com.nan.hint.LendMoneyMinus;
import com.nan.hint.ReturnDelSucceed;
import com.nan.hint.UpdataWin;

public class Main {
    public static void main(String args[]) throws ClassNotFoundException {

//        LoginDao log = new LoginDao();
//        java.util.List<User> users =  log.getAllUsers();
//
//        for(User user : users){
//            System.out.println("user:" + user.getUsername() + ",pass:" + user.getPassword());
//
//        }


        /**
         * Login().login()
         * 登陆界面的方法
         */
        new Login().login();  //程序入口，此处程序开始

        //new See().see2();//测试图书查询，已经完成 end
        //new Upd().upd();//测试图书修改,已经完成  end
        //new MainApp().mainap();//测试主界面，已经完成  end
        //new Lend().lend();//测试借阅系统界面 ,已经完成   end
        //new UpdataWin().win();
        //new Amount().amount();//图书价格与数量不能为负数
        //new LendMoneyMinus().lendMoneyMinus();//借阅押金不能低于图书价格,或图书数量为0的提示警告窗口，已经完成 end
        //new LendWater().lendWater();//借阅流水功能的测试，已经完成  end
        //new Return().returnBook();





    }
}
