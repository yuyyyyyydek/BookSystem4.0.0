package com.nan.dao;

import com.nan.Exception.Minus;
import com.nan.Exception.NotNullException;
import com.nan.hint.AddSucceed;
import com.nan.hint.AmountAndPriceMinus;
import com.nan.hint.NotNullText;
import database.DBConnectionManager;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 图书增添功能
 */
public class AddDao {
    // 数据库连接配置
//    String url = "jdbc:mysql://localhost:3306/booksystem2";
//    String user = "root";
//    String password = "123456";
    private BigDecimal bokamount = BigDecimal.valueOf(0);
    public void addBook(String bookname, String bookauthor, BigDecimal bookprice, int bookamount, String booktype){

        {
            try {

                // 加载数据库驱动
//                Class.forName("com.mysql.cj.jdbc.Driver");
                // 建立连接
//                Connection con = DriverManager.getConnection(url, user, password);
                Connection conn = DBConnectionManager.getConnection();//获取数据库连接对象

                //图书信息不能为空，测试异常

                if (bookname.equals("") || bookauthor.equals("") || bookprice.equals("") || booktype.equals("")) {

                    System.out.println("新增图书信息不能有空文本框");
                    //throw new Exception();//如果信息为空抛出异常停止以后的代码执行
                    throw new NotNullException("新增图书信息不能有空文本框");//如果有空文本框，抛出异常
                }

                //图书数量与不为0：
                if (bookamount < 0 || bookprice.compareTo(bokamount) < 0) {//与声明的数量为0进行比较
                    System.out.println("图书数量与价格不能为负数");
                    throw new Minus("图书数量与价格不能为负数");//如果信息为空抛出异常停止以后的代码执行
                }


                //使用PreparedStatement
                //  准备SQL语句
                String sqladd = "INSERT INTO t_book (bookname, bookauthor, bookprice,bookamount,booktype) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sqladd);

                // 4. 设置参数值
                preparedStatement.setString(1, bookname);//为第1个问号赋值
                preparedStatement.setString(2, bookauthor);//为第2个问号赋值
                preparedStatement.setBigDecimal(3, bookprice);//为第3个问号赋值
                preparedStatement.setInt(4, bookamount);//为第4个问号赋值
                preparedStatement.setString(5, booktype);//为第5个问号赋值

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected == 1) {//如果所有新增都成功了就执行以下代码，弹出成功窗口
                    System.out.println("新增图书成功");//在控制台输出"新增图书成功"
//                    if (MainApp.staticdata.countwinadd == 0) {//检查成功窗口是否为一个

                        new AddSucceed().addWin();
                    }
//                }

                // 关闭资源
//                rs.close();
//                preparedStatement.close();
//                conn.close();

                try {
                    if (preparedStatement != null) preparedStatement.close();
                    if (conn != null) conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }



            }catch(Minus e){
                new AmountAndPriceMinus().amount();
            }catch(NotNullException e){
                new NotNullText().nul();
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

    }

}
