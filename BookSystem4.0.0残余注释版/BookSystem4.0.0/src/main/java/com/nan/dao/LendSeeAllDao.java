package com.nan.dao;

import database.DBConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 借阅系统中查询所有借阅信息的数据库访问
 */
public class LendSeeAllDao {

    //sql语句


    /**
     * 一个方法，返回一个集合,，DAO中访问数据库得到的数据,新奇的方法，需要借鉴，重点
     */
    public List<Lender> seeAllLender() throws ClassNotFoundException {//一个方法  返回一个集合
        String sql = "select * from t_lender";
        List<Lender> lenders = new ArrayList<>();//创建一个LIST集合
        lenders = getLenders(sql,lenders);
        return lenders;

//        Class.forName(driver);//加载驱动
//        try (
//                //Connection conn = DriverManager.getConnection(url, username, password);//获取数据库连接对象
//                Connection conn = DBConnectionManager.getConnection();//获取数据库连接对象
//                Statement stmt = conn.createStatement();//获取执行sql的对象，Statement，创建Statement对象
//                ResultSet rs = stmt.executeQuery(sql)) {//SQL语句
//
//
//            while (rs.next()) {//遍历rs集合中的内容
//                Lender lender = new Lender();//创建一个Lender对象
//                lender.setId(rs.getInt("id"));//设置lenders的book对象的id为数据库中的借阅信息的id
//                lender.setBookname(rs.getString("bookname"));//设置lenders的book对象的bookname为数据库中的图书名称
//                lender.setBookauthor(rs.getString("bookauthor"));//设置lenders的book对象的bookauthor为数据库中的图书作者
//                lender.setBookprice(rs.getBigDecimal("bookprice"));//设置lenders的book对象的bookprice为数据库中的图书价格
//                lender.setBookamount(rs.getInt("bookamount"));//设置lenders的book对象的bookamount为数据库中的图书数量
//                lender.setBooktype(rs.getString("booktype"));//设置lengders的book对象的booktype为数据库中的图书类型
//
//                lender.setLender(rs.getString("lender"));//设置lender对象的lender为数据库中的借阅者姓名名称
//                lender.setMobile(rs.getString("mobile"));//设置lender对象的mobile为数据库中的手机号
//                lender.setMoney(rs.getBigDecimal("money"));//设置lender对象的money为数据库中的金钱数额
//                lender.setTime(rs.getString("time"));//设置lender对象的time为数据库表中的日期
//                lender.setBookid(rs.getInt("bookid"));//设置lender对象的bookid为数据库表中的图书id
//
//                lenders.add(lender);//将该lender对象添加到lenders集合中
//            }
//
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }
//
//        return lenders;
    }


    /**
     * 根据借阅者姓名查询借阅信息，查询带有指定文字的借阅信息，含有指定姓名
     */

        /**
         * 返回一个集合，该方法传入指定文本参数
         */
        public List<Lender> seeName(String search) throws ClassNotFoundException {//返回一个集合，方法传入指定文字参数
            String sql2 = "SELECT * FROM t_lender WHERE lender LIKE '%" + search + "%'";//sql语句

            List<Lender> lenders = new ArrayList<>();//创建集合
            lenders = getLenders(sql2,lenders);
            return lenders;
            //Class.forName(driver);//加载驱动

//            try (
//                 //Connection conn = DriverManager.getConnection(url, username, password);//获取数据库连接对象
//                 Connection conn = DBConnectionManager.getConnection();//获取数据库连接对象
//                 Statement stmt = conn.createStatement();//获取执行sql的对象，Statement，创建Statement对象
//                 ResultSet rs = stmt.executeQuery(sql2)) {//执行SQL语句
//
//                while (rs.next()) {//遍历rs集合中的内容
//                    Lender lender = new Lender();//创建一个Lender对象
//                    lender.setId(rs.getInt("id"));//设置lenders的book对象的id为数据库中的借阅信息的id
//                    lender.setBookname(rs.getString("bookname"));//设置lenders的book对象的bookname为数据库中的图书名称
//                    lender.setBookauthor(rs.getString("bookauthor"));//设置lenders的book对象的bookauthor为数据库中的图书作者
//                    lender.setBookprice(rs.getBigDecimal("bookprice"));//设置lenders的book对象的bookprice为数据库中的图书价格
//                    lender.setBookamount(rs.getInt("bookamount"));//设置lenders的book对象的bookamount为数据库中的图书数量
//                    lender.setBooktype(rs.getString("booktype"));//设置lengders的book对象的booktype为数据库中的图书类型
//
//                    lender.setLender(rs.getString("lender"));//设置lender对象的lender为数据库中的借阅者姓名名称
//                    lender.setMobile(rs.getString("mobile"));//设置lender对象的mobile为数据库中的手机号
//                    lender.setMoney(rs.getBigDecimal("money"));//设置lender对象的money为数据库中的金钱数额
//                    lender.setTime(rs.getString("time"));//设置lender对象的time为数据库表中的日期
//                    lender.setBookid(rs.getInt("bookid"));//设置lender对象的bookid为数据库表中的图书id
//
//
//                    lenders.add(lender);//将该lender对象添加到lenders集合中
//
//                }


            }




    /**
     * 根据借阅者手机号查询借阅信息，查询带有指定数字的借阅信息，含有指定数字
     */



        /**
         * 数据库连接配置
         */
//        static String driver = "com.mysql.cj.jdbc.Driver";
//        String url = "jdbc:mysql://localhost:3306/booksystem2";
//        String username = "root";
//        String password = "123456";

        /**
         * 返回一个集合，该方法传入指定文本参数
         */
        public List<Lender> seeMobile(String search) throws ClassNotFoundException {//返回一个集合，方法传入指定文字参数
            String sql2 = "SELECT * FROM t_lender WHERE mobile LIKE '%" + search + "%'";//sql语句

            List<Lender> lenders = new ArrayList<>();//创建集合

            lenders = getLenders(sql2,lenders);
            return lenders;

            //Class.forName(driver);//加载驱动
//            try (
//                 //Connection conn = DriverManager.getConnection(url, username, password);//获取数据库连接对象
//                 Connection conn = DBConnectionManager.getConnection();//获取数据库连接对象
//                 Statement stmt = conn.createStatement();//获取执行sql的对象，Statement，创建Statement对象
//                 ResultSet rs = stmt.executeQuery(sql2)) {//执行SQL语句
//
//                while (rs.next()) {//遍历rs集合中的内容
//                    Lender lender = new Lender();//创建一个Lender对象
//                    lender.setId(rs.getInt("id"));//设置lenders的book对象的id为数据库中的借阅信息的id
//                    lender.setBookname(rs.getString("bookname"));//设置lenders的book对象的bookname为数据库中的图书名称
//                    lender.setBookauthor(rs.getString("bookauthor"));//设置lenders的book对象的bookauthor为数据库中的图书作者
//                    lender.setBookprice(rs.getBigDecimal("bookprice"));//设置lenders的book对象的bookprice为数据库中的图书价格
//                    lender.setBookamount(rs.getInt("bookamount"));//设置lenders的book对象的bookamount为数据库中的图书数量
//                    lender.setBooktype(rs.getString("booktype"));//设置lengders的book对象的booktype为数据库中的图书类型
//
//                    lender.setLender(rs.getString("lender"));//设置lender对象的lender为数据库中的借阅者姓名名称
//                    lender.setMobile(rs.getString("mobile"));//设置lender对象的mobile为数据库中的手机号
//                    lender.setMoney(rs.getBigDecimal("money"));//设置lender对象的money为数据库中的金钱数额
//                    lender.setTime(rs.getString("time"));//设置lender对象的time为数据库表中的日期
//                    lender.setBookid(rs.getInt("bookid"));//设置lender对象的bookid为数据库表中的图书id
//
//
//                    lenders.add(lender);//将该lender对象添加到lenders集合中
//
//                }

//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//
//            return lenders;//返回该集合



    }


    public List<Lender> getLenders(String sql,List<Lender> lenders){


        try (
                Connection conn = DBConnectionManager.getConnection();//获取数据库连接对象
                Statement stmt = conn.createStatement();//获取执行sql的对象，Statement，创建Statement对象
                ResultSet rs = stmt.executeQuery(sql)) {//执行SQL语句

            while (rs.next()) {//遍历rs集合中的内容
                Lender lender = new Lender();//创建一个Lender对象
                lender.setId(rs.getInt("id"));//设置lenders的book对象的id为数据库中的借阅信息的id
                lender.setBookname(rs.getString("bookname"));//设置lenders的book对象的bookname为数据库中的图书名称
                lender.setBookauthor(rs.getString("bookauthor"));//设置lenders的book对象的bookauthor为数据库中的图书作者
                lender.setBookprice(rs.getBigDecimal("bookprice"));//设置lenders的book对象的bookprice为数据库中的图书价格
                lender.setBookamount(rs.getInt("bookamount"));//设置lenders的book对象的bookamount为数据库中的图书数量
                lender.setBooktype(rs.getString("booktype"));//设置lengders的book对象的booktype为数据库中的图书类型

                lender.setLender(rs.getString("lender"));//设置lender对象的lender为数据库中的借阅者姓名名称
                lender.setMobile(rs.getString("mobile"));//设置lender对象的mobile为数据库中的手机号
                lender.setMoney(rs.getBigDecimal("money"));//设置lender对象的money为数据库中的金钱数额
                lender.setTime(rs.getString("time"));//设置lender对象的time为数据库表中的日期
                lender.setBookid(rs.getInt("bookid"));//设置lender对象的bookid为数据库表中的图书id


                lenders.add(lender);//将该lender对象添加到lenders集合中


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

        return lenders;//返回该集合
    }



}

