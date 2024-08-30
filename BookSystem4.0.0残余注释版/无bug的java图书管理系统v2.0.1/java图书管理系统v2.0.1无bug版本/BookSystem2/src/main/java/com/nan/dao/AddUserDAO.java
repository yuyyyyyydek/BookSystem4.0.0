package com.nan.dao;

import com.nan.hint.AddUserNull;
import com.nan.hint.AddUserSucceed;
import com.nan.view.MainApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 增加用户，数据库访问用户表
 */
public class AddUserDAO {

    /**
     * 新增数据库信息，为新增用户的账号和密码
     */
    public void addUser(String addname2, String addpass2){

        // 数据库连接配置
        String url = "jdbc:mysql://localhost:3306/booksystem2";
        String user = "root";
        String password = "123456";

        {
            try{
                // 加载数据库驱动
                Class.forName("com.mysql.cj.jdbc.Driver");
                // 建立连接
                Connection con = DriverManager.getConnection(url, user, password);


                //填上管理员密码后的新增账号空框提示
                //注册信息不能为空，测试异常
                if(addname2.equals("")||addpass2.equals("")){//如果任意项为空则抛出异常，停止后续代码的执行，防止空值进入数据库

                    System.out.println("账号密码不为空");
                    throw new Exception();//如果信息为空抛出异常停止以后的代码执行
                }

                //使用PreparedStatement
                //  准备SQL语句
                String sqladd = "INSERT INTO t_user (username, password) VALUES (?, ?)";
                PreparedStatement preparedStatement = con.prepareStatement(sqladd);

                // 4. 设置参数值
                preparedStatement.setString(1, addname2);//为第1个问号赋值
                preparedStatement.setString(2, addpass2);//为第2个问号赋值

                int rowsAffected = preparedStatement.executeUpdate();




                if(rowsAffected == 1){//如果所有新增成功了就执行以下代码，弹出成功窗口
                    System.out.println("注册账号成功");//在控制台输出"注册成功"
                    if(MainApp.staticdata.countregwin == 0){//检查成功窗口是否为一个
                        new AddUserSucceed().win();
                    }
                }

                // 关闭资源
//                rs.close();
                preparedStatement.close();
                con.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                new AddUserNull().nul();//设置文本框有空时报异常，并显示注册信息不能有空值
                throw new RuntimeException(e);
            }

        }

    }

}
