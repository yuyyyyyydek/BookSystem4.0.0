package com.nan;

import com.nan.view.book.*;
import com.nan.view.index.ReaderIndex;
import com.nan.view.index.UserIndex;
import com.nan.view.lend.LendWater;
import com.nan.view.lend.ReturnBook;
import com.nan.view.login.ReaderLogin;
import com.nan.view.userandreader.DelReader;
import com.nan.view.userandreader.DelUser;
import com.nan.view.userandreader.SeeReader;
import com.nan.view.userandreader.SeeUser;

import java.sql.SQLException;

public class Main {

    /**
     * 各功能测试类，同样是程序入口类，程序启动类
     */

        public static void main(String args[]){
            new ReaderLogin().login();   //程序入口，主函数，
            //'' OR '1'='1'
            //new UserIndex().mainap();//测试用户端图书管理系统主界面  测试成功  end
            //new ReaderIndex().readerIndex();

            //new ReturnBook().returnBook();

            //new AdminiLogin().login();//测试用户管理登陆界面  测试成功 end
            //new ReaderUserAdd().register();//测试读者注册窗口  测试成功  end
            //new ReaderIndex().readerIndex();//测试读者端图书管理系统主界面  测试成功  end
            //new UserAdd().userAdd();//测试用户注册窗口  测试成功  end


//                try {
//                    new See().see2();   //查询1测试失败，废弃
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                } catch (ClassNotFoundException e) {
//                    throw new RuntimeException(e);
//                }

            //new See2().see2();//测试查询图书2功能， 测试成功  end
            //new UpdSee().upd();//测试图书修改功能   测试成功  end
            //new Del().del();//测试图书删除功能  测试成功  end
            //new Add().add();//测试图书增添功能  测试成功  end
            //new Lend().lend();//测试图书借阅功能  测试成功  end
            //new Return().returnBook();//测试图书归还功能  测试成功 end
            //new LendWater().lendWater();//测试借阅流水功能   测试成功  end
            //new DelUser().delUser();//测试用户删除功能  测试成功  end
            //new SeeUser().see();//测试用户查询功能   测试成功  end
            //new SeeReader().seeReader();//测试查询读者功能  测试成功  end
            //new DelReader().delReaderUser();//测试读者删除功能  测试成功  end


        }


}
