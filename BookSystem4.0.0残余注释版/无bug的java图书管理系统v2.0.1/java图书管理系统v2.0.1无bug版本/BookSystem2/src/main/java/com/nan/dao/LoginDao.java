package com.nan.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 该类创建方法用于访问数据库中的用户表，并提取出表中的账号和密码
 */
public  class LoginDao {


    //JDBC驱动名称以及URL
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/booksystem2";
    //数据库登录信息
    static String username = "root";
    static String password = "123456";
    static Connection conn = null;//未使用
    static Statement stmt = null;//未使用
    static ResultSet rs;//未使用
    String name;//未使用
    String password2;//未使用
    String sql = "select * from t_user";//SQL语句

    public List<User> getAllUsers() throws ClassNotFoundException {//创建一个User的集合，并抛出ClassNotFoundException异常
        List<User> users = new ArrayList<>();//集合初始化

        Class.forName(driver);//注册驱动

        try (Connection conn = DriverManager.getConnection(url,username,password);//获取数据库连接对象
             Statement stmt = conn.createStatement();//获取执行sql的对象，Statement，创建Statement对象
             ResultSet rs = stmt.executeQuery(sql)) { //执行sql

            while(rs.next()){//遍历rs集合中的内容
                User user = new User();//创建一个User对象
                user.setUsername(rs.getString("username"));//user对象设置该对象的用户id，括号中为从数据库中得到账号数据信息
                user.setPassword(rs.getString("password"));//user对象设置该对象的密码，括号中为数据库中得到的密码数据信息

                users.add(user);//将该user对象添加到users集合中
            }


        } catch (SQLException e) {//捕获异常
            e.printStackTrace();
        } catch (Exception e) {//捕获异常
            throw new RuntimeException(e);
        }finally {
            // 关闭资源
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return users;//返回users集合
    }


}
