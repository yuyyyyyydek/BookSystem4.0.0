package com.nan.dao;


import com.nan.user.ReaderUser;
import com.nan.user.User;
import database.DBConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 该类创建方法用于访问数据库中的用户表，并提取出读者表中的账号和密码,一个对象一条数据库信息
 * 读者表
 */
public  class UserDao {



    public List<User> getUsers(String sql,List<User> users) {
        try (
                Connection conn = DBConnectionManager.getConnection();//获取数据库连接对象
                Statement stmt = conn.createStatement();//获取执行sql的对象，Statement，创建Statement对象
                ResultSet rs = stmt.executeQuery(sql)) { //执行sql

            while (rs.next()) {//遍历rs集合中的内容
                User user = new User();//创建一个User对象
                user.setId(rs.getInt("id"));//user对象设置该对象的用户id，括号中为从数据库中得到账号数据信息
                user.setUsername(rs.getString("username"));//user对象设置该对象的用户账号，括号中为从数据库中得到账号数据信息
                user.setPassword(rs.getString("password"));//user对象设置该对象的密码，括号中为数据库中得到的密码数据信息

                users.add(user);//将该readerUser对象添加到readerUsers集合中
            }


            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return users;//返回users集合
    }


        public List<User> getAllUsers() throws ClassNotFoundException {//创建一个User的集合，并抛出ClassNotFoundException异常
        String sql = "select * from t_user";//SQL语句
        List<User> users = new ArrayList<>();//集合初始化
        users = getUsers(sql,users);
        return users;

    }


    public List<User> getUsersByName(String Name) throws ClassNotFoundException, SQLException {//一个方法，返回一个集合
        String sql = "select * from t_user where username LIKE '%" + Name + "%' ";
        List<User> users = new ArrayList<>();//创建一个LIST集和
        users = getUsers(sql,users);//将数据数据添加到集合中
        return users;//返回集合


    }



}