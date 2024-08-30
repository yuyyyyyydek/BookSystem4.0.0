package com.nan.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询指定文字的图书信息
 */
public class SeeDAO {


    /**
     * 数据库连接配置
     */
    static String driver = "com.mysql.cj.jdbc.Driver";
    String url ="jdbc:mysql://localhost:3306/booksystem2";
    String username = "root";
    String password = "123456";

    /**
     * 返回一个集合，该方法传入指定文本参数
     */
    public List<Book> getBooks(String search) throws ClassNotFoundException {//返回一个集合，方法传入指定文字参数
        String sql2 = "SELECT * FROM t_book WHERE bookname LIKE '%" + search + "%'";//sql语句

        List<Book> books2 = new ArrayList<>();//创建集合
        Class.forName(driver);//加载驱动

        try(Connection conn = DriverManager.getConnection(url,username,password);//获取数据库连接对象
                Statement stmt = conn.createStatement();//获取执行sql的对象，Statement，创建Statement对象
                ResultSet rs = stmt.executeQuery(sql2)) {//执行sql语句

                while(rs.next()){//遍历rs集合中的内容
                    Book book = new Book();//创建一个User对象
                    book.setId(rs.getInt("id"));//设置新book对象的id为数据库中的图书id
                    book.setBookname(rs.getString("bookname"));//设置新book对象的bookname为数据库中的图书名称
                    book.setBookauthor(rs.getString("bookauthor"));//设置新book对象的bookauthor为数据库中的图书作者
                    book.setBookprice(rs.getBigDecimal("bookprice"));//设置新book对象的bookprice为数据库中的图书价格
                    book.setBookamount(rs.getInt("bookamount"));//设置新book对象的bookamount为数据库中的图书数量
                    book.setBooktype(rs.getString("booktype"));//设置新book对象的booktype为数据库中的图书类型

                    books2.add(book);//将该book对象添加到books集合中
                }

        } catch (SQLException e) {//捕获异常
            throw new RuntimeException(e);//处理异常
        }

        return books2;//返回该集合

    }




}
