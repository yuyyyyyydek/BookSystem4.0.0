package com.nan.dao;

import database.DBConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 增加用户，数据库访问用户表,新增用户
 */
public class AddUserDao {

    public int addUser(String addUsername,String addPassword){

        int rowsAffected;

        {
            try{
                Connection conn = DBConnectionManager.getConnection();////获取数据库连接对象

                //  准备SQL语句
                String sqladd = "INSERT INTO t_user (username, password) VALUES (?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sqladd);//预编译SQL语句
                // 4. 设置参数值
                preparedStatement.setString(1, addUsername);//为第1个问号赋值
                preparedStatement.setString(2, addPassword);//为第2个问号赋值

                rowsAffected = preparedStatement.executeUpdate();//添加成功返回数值1


                // 关闭资源
                preparedStatement.close();
                conn.close();

                try {
                    if (preparedStatement != null) preparedStatement.close();
                    if (conn != null) conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
//                new AddUserNull().nul();//设置文本框有空时报异常，并显示注册信息不能有空值
                throw new RuntimeException(e);
            }

        }

        return rowsAffected;

    }

}
