package com.nan.dao;

import com.nan.hint.DelUserSucceed;
import com.nan.view.MainApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 根据用户ID删除用户
 */
public class DelUserDAO {


    public void  delUser() {//删除数据库信息的方法，传入要删除的数据信息，根据静态变量ID查找



        String sql="delete from t_user where id='"+ MainApp.staticdata.deid3+"' ";//生成一条mysql语句


        // 数据库连接配置
        String url = "jdbc:mysql://localhost:3306/booksystem2";
        String user = "root";
        String password = "123456";



        try {
            // 加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 建立连接
            Connection con = DriverManager.getConnection(url, user, password);
            // 创建Statement
            Statement stmt = con.createStatement();

            int rs = stmt.executeUpdate(sql);


            if(rs == 1){//如果所有删除成功了就执行以下代码，弹出成功窗口
                System.out.println("删除成功");//在控制台输出"修改成功"
                if(MainApp.staticdata.countuserdelwin == 0){//检查成功窗口是否为一个
                    new DelUserSucceed().win();
                }
            }



            // 关闭资源
//                rs.close();
            stmt.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();


        }




    }

}
