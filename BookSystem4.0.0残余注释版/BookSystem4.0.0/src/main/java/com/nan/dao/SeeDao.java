package com.nan.dao;

import com.nan.tool.StaticData;
import com.nan.user.ReaderUser;
import database.DBConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询所有的数据库图书信息
 */
public class SeeDao {



    /**
     *一个方法，返回一个集合，DAO中访问数据库得到的数据
     */
    public List<Book> getAllBooks() throws ClassNotFoundException, SQLException {//一个方法，返回一个集合
        String sql = "select * from t_book";
        List<Book> books = new ArrayList<>();//创建一个LIST集和
        books = getBook(sql,books);//将数据数据添加到集合中
        return books;//返回集合
        //Class.forName(driver);//加载驱动
//        try(
//                //Connection conn = DriverManager.getConnection(url,username,password);//获取数据库连接对象
//                Connection conn = DBConnectionManager.getConnection();////获取数据库连接对象
//                Statement stmt = conn.createStatement();//获取执行sql的对象，Statement，创建Statement对象
//                ResultSet rs = stmt.executeQuery(sql)){//SQL语句
//
//            while(rs.next()){//遍历rs集合中的内容
//                Book book = new Book();//创建一个Book对象
//                book.setId(rs.getInt("id"));//设置新book对象的id为数据库中的图书id
//                book.setBookname(rs.getString("bookname"));//设置新book对象的bookname为数据库中的图书名称
//                book.setBookauthor(rs.getString("bookauthor"));//设置新book对象的bookauthor为数据库中的图书作者
//                book.setBookprice(rs.getBigDecimal("bookprice"));//设置新book对象的bookprice为数据库中的图书价格
//                book.setBookamount(rs.getInt("bookamount"));//设置新book对象的bookamount为数据库中的图书数量
//                book.setBooktype(rs.getString("booktype"));//设置新book对象的booktype为数据库中的图书类型
//
//                books.add(book);//将该book对象添加到books集合中
//            }
//        } catch (SQLException e) {//捕获异常
//            e.printStackTrace();//异常处理
//        } catch (Exception e) {//捕获异常
//            throw new RuntimeException(e);//异常处理
//        }


//        return books;//返回books集合

    }

    /**
     * 此方法将重复代码写成了一个方法，方便使用时调用
     * @param sql
     * @param books
     * @return
     */
    public List<Book> getBook(String sql,List<Book> books) {
        //专门数据库数据转成list
        try(
                //Connection conn = DriverManager.getConnection(url,username,password);//获取数据库连接对象
                Connection conn = DBConnectionManager.getConnection();////获取数据库连接对象
                Statement stmt = conn.createStatement();//获取执行sql的对象，Statement，创建Statement对象
                ResultSet rs = stmt.executeQuery(sql)){//SQL语句

            while(rs.next()){//遍历rs集合中的内容
                Book book = new Book();//创建一个Book对象
                book.setId(rs.getInt("id"));//设置新book对象的id为数据库中的图书id
                book.setBookname(rs.getString("bookname"));//设置新book对象的bookname为数据库中的图书名称
                book.setBookauthor(rs.getString("bookauthor"));//设置新book对象的bookauthor为数据库中的图书作者
                book.setBookprice(rs.getBigDecimal("bookprice"));//设置新book对象的bookprice为数据库中的图书价格
                book.setBookamount(rs.getInt("bookamount"));//设置新book对象的bookamount为数据库中的图书数量
                book.setBooktype(rs.getString("booktype"));//设置新book对象的booktype为数据库中的图书类型

                books.add(book);//将该book对象添加到books集合中

            }

            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }



        } catch (SQLException e) {//捕获异常
            e.printStackTrace();//异常处理
        } catch (Exception e) {//捕获异常
            throw new RuntimeException(e);//异常处理
        }
        return books;
    }

    /**
     * 返回一个集合，该方法传入指定文本参数
     */
    public List<Book> getBooks(String search) throws ClassNotFoundException {//返回一个集合，方法传入指定文字参数
        String sql2 = "SELECT * FROM t_book WHERE bookname LIKE '%" + search + "%'";//sql语句

        List<Book> books2 = new ArrayList<>();//创建集合
        books2 = getBook(sql2,books2);//将模糊查询到的数据添加到集合中

        //Class.forName(driver);//加载驱动

//        try(
//            //Connection conn = DriverManager.getConnection(url,username,password);//获取数据库连接对象
//            Connection conn = DBConnectionManager.getConnection();////获取数据库连接对象
//            Statement stmt = conn.createStatement();//获取执行sql的对象，Statement，创建Statement对象
//            ResultSet rs = stmt.executeQuery(sql2)) {//执行sql语句
//
//            while(rs.next()){//遍历rs集合中的内容
//                Book book = new Book();//创建一个User对象
//                book.setId(rs.getInt("id"));//设置新book对象的id为数据库中的图书id
//                book.setBookname(rs.getString("bookname"));//设置新book对象的bookname为数据库中的图书名称
//                book.setBookauthor(rs.getString("bookauthor"));//设置新book对象的bookauthor为数据库中的图书作者
//                book.setBookprice(rs.getBigDecimal("bookprice"));//设置新book对象的bookprice为数据库中的图书价格
//                book.setBookamount(rs.getInt("bookamount"));//设置新book对象的bookamount为数据库中的图书数量
//                book.setBooktype(rs.getString("booktype"));//设置新book对象的booktype为数据库中的图书类型
//
//                books2.add(book);//将该book对象添加到books集合中
//            }
//
//        } catch (SQLException e) {//捕获异常
//            throw new RuntimeException(e);//处理异常
//        }


        return books2;//返回该集合

    }




}

