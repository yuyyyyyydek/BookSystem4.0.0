package com.nan.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 借阅系统中查询所有借阅信息的数据库访问
 */
public class LendSeeAllDAO {

    //数据库连接配置
    static String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/booksystem2";
    String username = "root";
    String password = "123456";

    //sql语句
    String sql = "select * from t_lender";

    /**
     * 一个方法，返回一个集合,，DAO中访问数据库得到的数据,新奇的方法，需要借鉴，重点
     */
    public List<Lender> seeAllLender() throws ClassNotFoundException {//一个方法  返回一个集合
        List<Lender> lenders = new ArrayList<>();//创建一个LIST集合
        Class.forName(driver);//加载驱动

        try (Connection conn = DriverManager.getConnection(url, username, password);//获取数据库连接对象
             Statement stmt = conn.createStatement();//获取执行sql的对象，Statement，创建Statement对象
             ResultSet rs = stmt.executeQuery(sql)) {//SQL语句


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


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return lenders;
    }
}





