package com.nan.dao;

import com.nan.view.MainApp;

import java.math.BigDecimal;
import java.sql.*;

/**
 * 归还图书的数据访问层
 */
public class ReturnDAO {

    public void findReturn(String search) {
        ResultSet rs;

        //sql语句
        String sql2 = "select id,bookname,bookauthor,bookprice,bookamount,booktype,lender,mobile,money,time,bookid from t_lender where id LIKE'" + search + "'";

        //数据库连接配置
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
                //执行sql语句，并存储内容到集合rs
                rs = stmt.executeQuery(sql2);

                // 遍历结果集
                while (rs.next()) {

                    // 根据列名获取数据
                    int id = rs.getInt("ID");
                    String name = rs.getString("BookName");
                    String author = rs.getString("BookAuthor");
                    BigDecimal price = rs.getBigDecimal("bookprice");
                    int amount = rs.getInt("bookamount");
                    String BookType = rs.getString("BookType");

                    String lender = rs.getString("lender");
                    String mobile = rs.getString("mobile");
                    BigDecimal money = rs.getBigDecimal("money");
                    String time = rs.getString("time");
                    int bookid = rs.getInt("bookid");


                    System.out.println(id);
                    MainApp.staticdata.returndel = id;//查询到的图书ID写入到静态类的属性中
                    System.out.println(name);
                    MainApp.staticdata.bokname = name;//查询到的图书名称写入到静态类的属性中
                    System.out.println(author);
                    MainApp.staticdata.bokauthor = author;//查询到的图书作者写入到静态类的属性中
                    System.out.println(price);
                    MainApp.staticdata.bokprice = price;//查询到的图书价格写入到静态类的属性中
                    System.out.println(amount);
                    MainApp.staticdata.bokamount = amount;//查询到的图书数量写入到静态类的属性中
                    System.out.println(BookType);
                    MainApp.staticdata.boktype = BookType;//查询到的图书类型写入到静态类的属性中

                    MainApp.staticdata.staticlengder = lender;//查询到的借阅者姓名写入到静态类的属性中
                    MainApp.staticdata.staticmobile = mobile;//查询到的借阅者手机号写入到静态类的属性中
                    MainApp.staticdata.staticmoney = money;//查询到的借阅者押金写入到静态类的属性中
                    MainApp.staticdata.statictime = time;//查询到的借阅者借书时间写入到静态类的属性中
                    MainApp.staticdata.staticbookid = bookid;//查询到的借阅者借阅图书的原ID写入到静态类的属性中


                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


        }

    }

}
