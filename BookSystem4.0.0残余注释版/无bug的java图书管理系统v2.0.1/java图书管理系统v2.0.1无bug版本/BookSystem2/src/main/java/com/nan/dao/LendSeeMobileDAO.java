package com.nan.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 根据借阅者手机号查询借阅信息，查询带有指定数字的借阅信息，含有指定数字
 */
public class LendSeeMobileDAO {


    /**
     * 数据库连接配置
     */
    static String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/booksystem2";
    String username = "root";
    String password = "123456";

    /**
     * 返回一个集合，该方法传入指定文本参数
     */
    public List<Lender> seeMobile(String search) throws ClassNotFoundException {//返回一个集合，方法传入指定文字参数
        String sql2 = "SELECT * FROM t_lender WHERE mobile LIKE '%" + search + "%'";//sql语句

        List<Lender> lenders = new ArrayList<>();//创建集合
        Class.forName(driver);//加载驱动

        try (Connection conn = DriverManager.getConnection(url, username, password);//获取数据库连接对象
             Statement stmt = conn.createStatement();//获取执行sql的对象，Statement，创建Statement对象
             ResultSet rs = stmt.executeQuery(sql2)) {//执行SQL语句

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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lenders;//返回该集合

    }

}
