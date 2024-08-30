package com.nan.dao;

import com.nan.hint.LendMoneyMinus;
import com.nan.view.MainApp;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * 此类需要创建俩个窗口  需要注意
 */


/**
 * 用于将借阅图书以及借阅者信息收录至借阅表
 */
public class LendTableDAO {
    private BigDecimal bokamount = BigDecimal.valueOf(0);
    public void lendTable(String bookname, String bookauthor, BigDecimal bookprice, int bookamount, String booktype, String lender, String mobile, BigDecimal money, String time, int bookid){

        // 数据库连接配置
        String url = "jdbc:mysql://localhost:3306/booksystem2";
        String user = "root";
        String password = "123456";


        {
                try{
                    // 加载数据库驱动
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    // 建立连接
                    Connection con = DriverManager.getConnection(url, user, password);


                    /**
                     * 此处注意，有执行顺序的差别，先判断是否为空不可添加数据库信息，后判断是否低于押金价格
                     */
                    //2
                    if(bookname.equals("")||bookauthor.equals("")||bookprice.equals("")||booktype.equals("")||String.valueOf(bookamount).equals("")||lender.equals("")||mobile.equals("")||money.equals("")||time.equals("")||String.valueOf(bookid).equals("")){

                        System.out.println("借阅信息内容不为空");
                        throw new Exception();//如果信息为空抛出异常停止以后的代码执行
                    }

                    //1
                    if(money.compareTo(bookprice) < 0||bookamount < 0){
                        System.out.println("押金价格不能低于本书的价格，或者图书数量为0不可借阅");
                        throw new RuntimeException();//如果押金低于本书价格，或者数量为0则抛出异常停止以后的代码执行
                    }


                    //准备SQL语句
                    String sqladd = "INSERT INTO t_lender (bookname, bookauthor, bookprice,bookamount,booktype,lender,mobile,money,time,bookid) VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?)";
                    PreparedStatement preparedStatement = con.prepareStatement(sqladd);

                    // 4. 设置参数值
                    preparedStatement.setString(1, bookname);//为第1个问号赋值
                    preparedStatement.setString(2, bookauthor);//为第2个问号赋值
                    preparedStatement.setBigDecimal(3, bookprice);//为第3个问号赋值
                    preparedStatement.setInt(4, bookamount);//为第4个问号赋值
                    preparedStatement.setString(5, booktype);//为第5个问号赋值
                    preparedStatement.setString(6,lender);//为第6个问号赋值
                    preparedStatement.setString(7,mobile);//为第7个问号赋值
                    preparedStatement.setBigDecimal(8,money);//为第8个问号赋值
                    preparedStatement.setString(9,time);//为第9个问号赋值
                    preparedStatement.setInt(10,bookid);//为第10个问号赋值

                    int rowsAffected = preparedStatement.executeUpdate();

                    if(rowsAffected == 1){//如果所有新增都成功了就执行以下代码，弹出成功窗口
                        System.out.println("借阅图书成功");//在控制台输出"新增图书成功"
                        /**
                         * 此处创建一个借阅成功窗口
                         * 此处的成功窗口被修改成功窗口顶替，并且已经将窗体信息改为“操作成功”
                         */
//                        if(MainApp.staticdata.countwinadd == 0){//检查成功窗口是否为一个
//                            win();
//                        }
                    }





                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (RuntimeException e) {
                    /**
                     * 此处要显示弹窗，信息为：押金价格低于图书价格以及图书为零不可借阅
                     */
                    if(MainApp.staticdata.countjymoneyminus == 0){//检查成功窗口是否为一个
                            new LendMoneyMinus().lendMoneyMinus();
                        }



                    throw new RuntimeException(e);
                } catch (Exception e) {

                    throw new RuntimeException(e);
                }

        }


    }

}
