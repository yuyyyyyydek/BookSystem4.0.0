package com.nan.dao;

import com.nan.view.MainApp;

import java.sql.*;

/**
 * 此窗口为根据ID删除用户
 */
public class DelUserByIdDAO {

    //复制的代码，
    public void  findDelUser(String search) {//传入要查询的ID，进行数据库查询，并显示


        //String sql2 = "SELECT * FROM t_book WHERE bookname LIKE '%" + search + "%'";

        //String sql2 = "SELECT * FROM t_book WHERE bookname LIKE '" + search + "'";
        //String sql2 = "select id form t_book where id = ?";
        //SELECT 字段1,字段2,...  from 表名 where name like '%豪'
        String sql2 = "select id,username from t_user where id LIKE'" + search + "'";


        // 数据库连接配置
        String url = "jdbc:mysql://localhost:3306/booksystem2";
        String user = "root";
        String password = "123456";


        {
            try {
                // 加载数据库驱动
                Class.forName("com.mysql.cj.jdbc.Driver");
                // 建立连接
                Connection con = DriverManager.getConnection(url, user, password);
                // 创建Statement
                Statement stmt = con.createStatement();

                ResultSet rs = stmt.executeQuery(sql2);


                // 遍历结果集
                while (rs.next()) {

                    // 根据列名获取数据
                    int id = rs.getInt("id");//前面声明的id用于后续代码，括号中的ID为数据库表中的列名
                    String username = rs.getString("username");//前面声明的username用于后续代码，括号中的username为数据库表中的列名



                    System.out.println(id);
                    MainApp.staticdata.deid3 = id;//查询到的id 写入到静态类的属性中这里是deid3
                    System.out.println(user);
                    MainApp.staticdata.user = username;//这里是username。查询到的书名写入到静态类的属性user中




                }

                // 关闭资源
                rs.close();
                stmt.close();
                con.close();

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();

            }
        }


    }//updata() end

}
