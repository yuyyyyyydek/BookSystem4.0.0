package com.nan.dao;

import com.nan.hint.ReturnDelSucceed;
import com.nan.tool.StaticData;
import database.DBConnectionManager;

import java.math.BigDecimal;
import java.sql.*;

/**
 * 归还图书的数据访问层
 */
public class ReturnDao {

    public void findReturn(String search) {
        ResultSet rs;

        //sql语句
        String sql2 = "select id,bookname,bookauthor,bookprice,bookamount,booktype,lender,mobile,money,time,bookid from t_lender where id LIKE'" + search + "'";



        {
            try {
                // 加载数据库驱动
                //Class.forName("com.mysql.cj.jdbc.Driver");
                // 建立连接
                //Connection con = DriverManager.getConnection(url, user, password);
                Connection conn = DBConnectionManager.getConnection();//获取数据库连接对象
                // 创建Statement
                Statement stmt = conn.createStatement();
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
                    StaticData.returndel = id;//查询到的图书ID写入到静态类的属性中
                    System.out.println(name);
                    StaticData.bokName = name;//查询到的图书名称写入到静态类的属性中
                    System.out.println(author);
                    StaticData.bokAuthor = author;//查询到的图书作者写入到静态类的属性中
                    System.out.println(price);
                    StaticData.bokPrice = price;//查询到的图书价格写入到静态类的属性中
                    System.out.println(amount);
                    StaticData.bokAmount = amount;//查询到的图书数量写入到静态类的属性中
                    System.out.println(BookType);
                    StaticData.bokType = BookType;//查询到的图书类型写入到静态类的属性中

                    StaticData.staticlengder = lender;//查询到的借阅者姓名写入到静态类的属性中
                    StaticData.staticmobile = mobile;//查询到的借阅者手机号写入到静态类的属性中
                    StaticData.staticmoney = money;//查询到的借阅者押金写入到静态类的属性中
                    StaticData.statictime = time;//查询到的借阅者借书时间写入到静态类的属性中
                    StaticData.staticbookid = bookid;//查询到的借阅者借阅图书的原ID写入到静态类的属性中


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


        }

    }


    /**
     * 删除借阅流水数据表中的数据，删除借阅图书信息的单个数据
     */
        public void del(){

            String sql="delete from t_lender where id='"+ StaticData.returndel+"' ";//生成一条mysql语句



            try{
                // 加载数据库驱动
                //Class.forName("com.mysql.cj.jdbc.Driver");
                // 建立连接
                //Connection con = DriverManager.getConnection(url, user, password);
                Connection conn = DBConnectionManager.getConnection();//获取数据库连接对象
                // 创建Statement
                Statement stmt = conn.createStatement();




                int rs = stmt.executeUpdate(sql);


                if(rs == 1){//如果所有删除成功了就执行以下代码，弹出成功窗口
                    System.out.println("归还成功");//在控制台输出"修改成功"
//                    if(MainApp.staticdata.countrewin == 0){//检查成功窗口是否为一个
                        new ReturnDelSucceed().win();
//                    }
                }




                // 关闭资源
                try {
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }


//                rs.close();
//                stmt.close();
//                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }





}
