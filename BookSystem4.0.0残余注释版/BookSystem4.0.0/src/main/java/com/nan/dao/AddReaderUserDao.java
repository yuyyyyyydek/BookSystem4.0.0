package com.nan.dao;

import database.DBConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 增加读者，数据库访问读者表,新增读者
 */
public class AddReaderUserDao {

    /**
     * 新增数据库信息，为新增用户的账号和密码
     */
    public int addReaderUser(String addname2, String addpass2){

        int rowsAffected;


        {
            try{
                Connection conn = DBConnectionManager.getConnection();////获取数据库连接对象

                //  准备SQL语句
                String sqladd = "INSERT INTO t_reader (reader, reader_password) VALUES (?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sqladd);
                // 4. 设置参数值
                preparedStatement.setString(1, addname2);//为第1个问号赋值
                preparedStatement.setString(2, addpass2);//为第2个问号赋值

                rowsAffected = preparedStatement.executeUpdate();


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
