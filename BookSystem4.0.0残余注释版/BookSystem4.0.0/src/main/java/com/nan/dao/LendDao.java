package com.nan.dao;

import com.nan.Exception.NotNullException;
import com.nan.hint.AmountAndPriceMinus;
import com.nan.hint.LendMoneyMinus;
import com.nan.hint.NotNullText;
import com.nan.hint.UpdataWin;
import com.nan.tool.StaticData;
import database.DBConnectionManager;

import java.math.BigDecimal;
import java.sql.*;

/**
 * 借阅系统，借阅图书信息查询显示，
 * 本类方法可以根据修改图书信息的ID查询功能修改
 */
public class LendDao {

    public void findLend(String search){
        ResultSet rs;

        //sql语句
        String sql2 = "select id,bookname,bookauthor,bookprice,bookamount,booktype from t_book where id LIKE'" + search + "'";


        {
            try{
                // 加载数据库驱动
//                Class.forName("com.mysql.cj.jdbc.Driver");
                // 建立连接
//                Connection con = DriverManager.getConnection(url, user, password);
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



                    System.out.println(id);
//                    MainApp.staticdata.upid = id;//查询到的图书ID写入到静态类的属性中
                    StaticData.upId = id;//查询到的图书ID写入到静态类的属性中
                    System.out.println(name);
//                    MainApp.staticdata.bokname = name;//查询到的图书名称写入到静态类的属性中
                    StaticData.bokName = name;//查询到的图书名称写入到静态类的属性中
                    System.out.println(author);
//                    MainApp.staticdata.bokauthor = author;//查询到的图书作者写入到静态类的属性中
                    StaticData.bokAuthor = author;//查询到的图书作者写入到静态类的属性中
                    System.out.println(price);
//                    MainApp.staticdata.bokprice = price;//查询到的图书价格写入到静态类的属性中
                    StaticData.bokPrice = price;//查询到的图书价格写入到静态类的属性中
                    System.out.println(amount);
//                    MainApp.staticdata.bokamount = amount;//查询到的图书数量写入到静态类的属性中
                    StaticData.bokAmount = amount;//查询到的图书数量写入到静态类的属性中
                    System.out.println(BookType);
//                    MainApp.staticdata.boktype = BookType;//查询到的图书类型写入到静态类的属性中
                    StaticData.bokType = BookType;//查询到的图书类型写入到静态类的属性中

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
     * 更新修改数据库图书内容信息
     *修改数据库信息的方法,传入要修改成功的数据
     * 实现获得的信更新进数据库的方法
     */
        private BigDecimal bokamount = BigDecimal.valueOf(0);//上面已经有这一行代码了
        public void  updata2(String bookname, String bookauthor, BigDecimal bookprice, int bookamount, String booktype){

            String sql="update t_book set bookname='" + bookname + "' where id='"+ StaticData.upId+"' ";//生成一条mysql语句
            String sql2="update t_book set bookauthor='" + bookauthor + "' where id='"+ StaticData.upId+"' ";//生成一条mysql语句
            String sql3="update t_book set bookprice='" + bookprice + "' where id='"+ StaticData.upId+"' ";//生成一条mysql语句
            String sql4="update t_book set bookamount='" + bookamount + "' where id='"+ StaticData.upId+"' ";//生成一条mysql语句
            String sql5="update t_book set booktype='" + booktype + "' where id='"+ StaticData.upId+"' ";//生成一条mysql语句



            {
                try{
                    // 加载数据库驱动
//                    Class.forName("com.mysql.cj.jdbc.Driver");
                    // 建立连接
//                    Connection con = DriverManager.getConnection(url, user, password);
                    Connection conn = DBConnectionManager.getConnection();//获取数据库连接对象
                    // 创建Statement
                    Statement stmt = conn.createStatement();

                    //图书信息不能为空，测试异常
                    if(bookname.equals("")||bookauthor.equals("")||bookprice.equals("")||booktype.equals("")){

                        System.out.println("图书信息不能为空");
                        throw new Exception();
                    }

                    //图书数量不为负数
                    if(bookamount < 0 || bookprice.compareTo(bokamount) < 0){
                        throw new RuntimeException();
                    }

                    int rs = stmt.executeUpdate(sql);
                    int rs2 = stmt.executeUpdate(sql2);
                    int rs3 = stmt.executeUpdate(sql3);
                    int rs4 = stmt.executeUpdate(sql4);
                    int rs5 = stmt.executeUpdate(sql5);


                    if(rs == 1&&rs2 == 1&&rs3 == 1&&rs4 == 1&&rs5 == 1){//如果所有修改都成功了就执行以下代码，弹出成功窗口
                        System.out.println("操作成功");//在控制台输出"修改成功"//修改为操作成功，因为在其它地方也调用了本方法，弹出信息需要符合逻辑
//                        if(MainApp.staticdata.countwin == 0){//检查成功窗口是否为一个
                            new UpdataWin().win();
//                        }
                    }


                    try {
                        if (stmt != null) stmt.close();
                        if (conn != null) conn.close();
                    } catch (SQLException se) {
                        se.printStackTrace();
                    }


//                    stmt.close();
//                    con.close();

                } catch (ClassNotFoundException |SQLException e) {
                    throw new RuntimeException(e);
                } catch ( RuntimeException e) {

                    throw new RuntimeException(e);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }


        }








}
