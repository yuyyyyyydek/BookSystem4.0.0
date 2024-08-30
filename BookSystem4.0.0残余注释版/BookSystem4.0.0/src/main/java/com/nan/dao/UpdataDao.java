package com.nan.dao;

import com.nan.Exception.Minus;
import com.nan.Exception.NotNullException;
import com.nan.hint.AmountAndPriceMinus;
import com.nan.hint.NotNullText;
import com.nan.hint.UpdataWin;
import com.nan.tool.Only;
import com.nan.tool.StaticData;
import database.DBConnectionManager;

import java.math.BigDecimal;
import java.sql.*;

/**
 * 根据ID查询图书，以便修改图书信息
 */
public class UpdataDao {

    /**
     *传入要查询的ID，进行数据库查询，并显示
     * 原始的查询方法，另外创建一个用于比对ID用的相同方法
     * 在代码的最下面
     */
    public void updata(String search){

//        // 数据库连接配置
//        String url = "jdbc:mysql://localhost:3306/booksystem2";
//        String user = "root";
//        String password = "123456";

        String sql2 = "select id,bookname,bookauthor,bookprice,bookamount,booktype from t_book where id LIKE'" + search + "'";

        {
            try {
                // 加载数据库驱动
                //Class.forName("com.mysql.cj.jdbc.Driver");
                // 建立连接
                //Connection con = DriverManager.getConnection(url, user, password);
                Connection conn = DBConnectionManager.getConnection();//获取数据库连接对象
                // 创建Statement
                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(sql2);


                // 遍历结果集
                while (rs.next()) {

                    // 根据列名获取数据
                    int id = rs.getInt("ID");
                    String name = rs.getString("BookName");
                    String author = rs.getString("BookAuthor");
                    BigDecimal price = rs.getBigDecimal("bookprice");
                    int amount = rs.getInt("bookamount");
                    String bookType = rs.getString("booktype");

                    //*****System.out.println(name);


                    System.out.println(id);
                    //MainApp.staticdata.upid = id;//查询到的图书ID写入到静态类的属性中
                    StaticData.upId = id;//查询到的图书ID写入到静态类的属性中
                    System.out.println(name);
                    //MainApp.staticdata.bokname = name;//查询到的图书名称写入到静态类的属性中
                    StaticData.bokName = name;//查询到的图书名称写入到静态类的属性中
                    System.out.println(author);
                    //MainApp.staticdata.bokauthor = author;//查询到的图书作者写入到静态类的属性中
                    StaticData.bokAuthor = author;//查询到的图书作者写入到静态类的属性中
                    System.out.println(price);
                    //MainApp.staticdata.bokprice = price;//查询到的图书价格写入到静态类的属性中
                    StaticData.bokPrice = price;//查询到的图书价格写入到静态类的属性中
                    System.out.println(amount);
                    //MainApp.staticdata.bokamount = amount;//查询到的图书数量写入到静态类的属性中
                    StaticData.bokAmount = amount;//查询到的图书数量写入到静态类的属性中
                    System.out.println(bookType);
                    //MainApp.staticdata.boktype = BookType;//查询到的图书类型写入到静态类的属性中
                    StaticData.bokType = bookType;//查询到的图书类型写入到静态类的属性中

                }

                // 关闭资源
//                rs.close();
//                stmt.close();
//                conn.close();

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
     *修改数据库信息的方法,传入要修改成功的数据
     * 实现获得的信更新进数据库的方法
     */
    private BigDecimal bokamount = BigDecimal.valueOf(0);
    public void  updata2(String bookname, String bookauthor, BigDecimal bookprice, int bookamount, String booktype){

        String sql="update t_book set bookname='" + bookname + "' where id='"+ StaticData.upId+"' ";//生成一条mysql语句
        String sql2="update t_book set bookauthor='" + bookauthor + "' where id='"+ StaticData.upId+"' ";//生成一条mysql语句
        String sql3="update t_book set bookprice='" + bookprice + "' where id='"+ StaticData.upId+"' ";//生成一条mysql语句
        String sql4="update t_book set bookamount='" + bookamount + "' where id='"+ StaticData.upId+"' ";//生成一条mysql语句
        String sql5="update t_book set booktype='" + booktype + "' where id='"+ StaticData.upId+"' ";//生成一条mysql语句

        // 数据库连接配置
//        String url = "jdbc:mysql://localhost:3306/booksystem2";
//        String user = "root";
//        String password = "123456";

        {
            try {
                // 加载数据库驱动
                //Class.forName("com.mysql.cj.jdbc.Driver");
                // 建立连接
                //Connection con = DriverManager.getConnection(url, user, password);
                Connection conn = DBConnectionManager.getConnection();//获取数据库连接对象
                // 创建Statement
                Statement stmt = conn.createStatement();

                //图书信息不能为空，测试异常
                if (bookname.equals("") || bookauthor.equals("") || bookprice.equals("") || booktype.equals("")) {

                    System.out.println("图书信息不能为空");
                    throw new NotNullException("图书信息不能为空");
                    //throw new Exception();
                }

                //图书数量不为负数
                if (bookamount < 0 || bookprice.compareTo(bokamount) < 0) {
                    throw new Minus("图书数量与价格不能为负数");
                }

                int rs = stmt.executeUpdate(sql);
                int rs2 = stmt.executeUpdate(sql2);
                int rs3 = stmt.executeUpdate(sql3);
                int rs4 = stmt.executeUpdate(sql4);
                int rs5 = stmt.executeUpdate(sql5);


                if (rs == 1 && rs2 == 1 && rs3 == 1 && rs4 == 1 && rs5 == 1) {//如果所有修改都成功了就执行以下代码，弹出成功窗口
                    System.out.println("操作成功");//在控制台输出"修改成功"//修改为操作成功，因为在其它地方也调用了本方法，弹出信息需要符合逻辑
//                    if(MainApp.staticdata.countwin == 0){//检查成功窗口是否为一个
                    new UpdataWin().win();
//                    }
                }

                try {
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }

//                stmt.close();
//                con.close();
            }catch(NotNullException e){
                new NotNullText().nul();
            } catch (ClassNotFoundException |SQLException e) {
                throw new RuntimeException(e);
            } catch ( Minus e) {
                new AmountAndPriceMinus().amount();//程序出现运行时错误的时候，创建数据数量价格不能为负数的提示窗口
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


    }



    /**
     *传入要查询的ID，进行数据库查询，并显示
     * 此处的参数要设置成INT型
     * 一个用于比对ID用的相同方法
     * INT型比对，用来比对书籍ID,ID不存在的话创建一个新的Book图书信息，数量为1
     *
     */

    public boolean updataBookBiaoId(int search){



        String sql2 = "select id from t_book where id ='" + search + "'";

        {
            try {
                // 加载数据库驱动
                //Class.forName("com.mysql.cj.jdbc.Driver");
                // 建立连接
                //Connection con = DriverManager.getConnection(url, user, password);
                Connection conn = DBConnectionManager.getConnection();//获取数据库连接对象
                // 创建Statement
                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(sql2);

                if(rs.next()){
                    System.out.println("查询到了书籍，此时不创建新书了");
                    return false;//不创建，假值
                }else{
                    System.out.println("没有查询到书籍，此时需要创建该书籍");


                    return true;//创建信息，真值
                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        //return jieshouBookBiaodeId;
    }

    /**
     * 如果还书的图书是同一本书籍，如何实现书籍数量叠加，看下面代码，
     * 上面代码是没有图书的时候创建图书，有图书不创建
     * repetition
     * 重复，重说
     */
    int id;
    public int  updataBookRepetition(String bookname, String bookauthor, BigDecimal bookprice, String booktype){


        String sql2 = "SELECT ' " + id + " ', bookname, bookauthor, bookprice, booktype FROM t_book WHERE bookname = '" + bookname + "' AND bookauthor = '" + bookauthor + "' AND bookprice = " + bookprice + " AND booktype = '" + booktype + "'";


        {
            try {
                // 加载数据库驱动
                //Class.forName("com.mysql.cj.jdbc.Driver");
                // 建立连接
                //Connection con = DriverManager.getConnection(url, user, password);
                Connection conn = DBConnectionManager.getConnection();//获取数据库连接对象
                // 创建Statement
                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(sql2);
                System.out.println(rs);
                if(rs.next()){
                    System.out.println("=======>查询到了相同信息的书籍，此时不创建新书了，直接叠加数量");



                    return StaticData.upId2;//为真，添加数量+1
                }else{
                    System.out.println("=========>没有查询到书籍，此时需要创建该书籍");
                    return -1;//为假，没有找到，创建书籍数据
                }




            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        //return jieshouBookBiaodeId;
    }






}
