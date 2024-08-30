package com.nan.dao;

import com.nan.user.Admini;
import com.nan.user.User;
import database.DBConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 该类创建方法用于访问数据库中的超级管理员表，并提取出超级管理员表中的账号和密码,一个对象一条数据库信息
 * 超级管理员表
 */
public class AdminiDao {

    String sql = "select * from t_admini";//SQL语句

    public List<Admini> getAllAdmini(){//创建一个User的集合
        List<Admini> adminis = new ArrayList<>();//集合初始化

        try (


                Connection conn = DBConnectionManager.getConnection();//获取数据库连接对象
                Statement stmt = conn.createStatement();//获取执行sql的对象，Statement，创建Statement对象
                ResultSet rs = stmt.executeQuery(sql)) { //执行sql

            while(rs.next()){//遍历rs集合中的内容
                Admini admini = new Admini();//创建一个Admini对象
                admini.setAdmini(rs.getString("admini"));//admini对象设置该对象的管理员账户，括号中为从数据库中得到账号数据信息
                admini.setAdmpass(rs.getString("admpass"));//admini对象设置该对象的管理员密码，括号中为数据库中得到的密码数据信息

                adminis.add(admini);//将该admini对象添加到adminis集合中
            }

            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }

        }catch (Exception e) {//捕获异常
            throw new RuntimeException(e);
        }

        return adminis;//返回adminis集合

    }

}
