package com.nan.dao;

import com.nan.view.MainApp;

import java.math.BigDecimal;
import java.sql.*;

public class DelSeeDAO {

    /**
     * 传入要查询的ID，进行数据库查询，并显示，以便删除
     */
    public void find(String search) {//传入要查询的ID，进行数据库查询，并显示

        /**
         * 数据库连接配置
         */
        // 数据库连接配置
        String url = "jdbc:mysql://localhost:3306/booksystem2";
        String user = "root";
        String password = "123456";

        String sql2 = "select id,bookname,bookauthor,bookprice,bookamount,booktype from t_book where id LIKE'" + search + "'";//sql语句

        {
            try {
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
                        int id = rs.getInt("ID");
                        String name = rs.getString("BookName");
                        String author = rs.getString("BookAuthor");
                        BigDecimal price = rs.getBigDecimal("bookprice");
                        int amount = rs.getInt("bookamount");
                        String BookType = rs.getString("BookType");

                        //*****System.out.println(name);


                        System.out.println(id);
                        MainApp.staticdata.deid2 = id;//查询到的id 写入到静态类的属性中这里是deid2
                        System.out.println(name);
                        MainApp.staticdata.bokname2 = name;//这里是bokname2。查询到的书名写入到静态类的属性中
                        System.out.println(author);
                        MainApp.staticdata.bokauthor = author;//查询到的图书名称写入到静态类的属性中
                        System.out.println(price);
                        MainApp.staticdata.bokprice = price;//查询到的图书价格写入到静态类的属性中
                        System.out.println(amount);
                        MainApp.staticdata.bokamount = amount;//查询到的图书数量写入到静态类的属性中
                        System.out.println(BookType);
                        MainApp.staticdata.boktype = BookType;//查询到的图书类型写入到静态类的属性中
                        // 将数据添加到表格模型
                        //model.addRow(new Object[]{id, name, author, price, amount, BookType});


                        ;

                    }

                    // 关闭资源
                    rs.close();
                    stmt.close();
                    con.close();

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
