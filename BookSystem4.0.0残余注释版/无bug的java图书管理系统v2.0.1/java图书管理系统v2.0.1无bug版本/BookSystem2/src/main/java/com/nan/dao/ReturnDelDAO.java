package com.nan.dao;

import com.nan.hint.ReturnDelSucceed;
import com.nan.view.MainApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 删除借阅流水数据表中的数据，删除借阅图书信息的单个数据
 */
public class ReturnDelDAO {
    public void del(){

        String sql="delete from t_lender where id='"+ MainApp.staticdata.returndel+"' ";//生成一条mysql语句


        // 数据库连接配置
        String url = "jdbc:mysql://localhost:3306/booksystem2";
        String user = "root";
        String password = "123456";


        try{
            // 加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 建立连接
            Connection con = DriverManager.getConnection(url, user, password);
            // 创建Statement
            Statement stmt = con.createStatement();




            int rs = stmt.executeUpdate(sql);


            if(rs == 1){//如果所有删除成功了就执行以下代码，弹出成功窗口
                System.out.println("归还成功");//在控制台输出"修改成功"
                if(MainApp.staticdata.countrewin == 0){//检查成功窗口是否为一个
                    new ReturnDelSucceed().win();
                }
            }



            // 关闭资源
//                rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}

