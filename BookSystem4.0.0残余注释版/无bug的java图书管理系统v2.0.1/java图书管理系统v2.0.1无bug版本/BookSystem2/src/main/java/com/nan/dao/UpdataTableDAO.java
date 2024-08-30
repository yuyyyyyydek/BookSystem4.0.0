package com.nan.dao;

import com.nan.hint.Amount;
import com.nan.view.MainApp;
import com.nan.hint.UpdataWin;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 更新修改数据库图书内容信息
 */
public class UpdataTableDAO {

    /**
     *修改数据库信息的方法,传入要修改成功的数据
     * 实现获得的信更新进数据库的方法
     */
    private BigDecimal bokamount = BigDecimal.valueOf(0);
    public void  updata2(String bookname, String bookauthor, BigDecimal bookprice, int bookamount, String booktype){

        String sql="update t_book set bookname='" + bookname + "' where id='"+ MainApp.staticdata.upid+"' ";//生成一条mysql语句
        String sql2="update t_book set bookauthor='" + bookauthor + "' where id='"+ MainApp.staticdata.upid+"' ";//生成一条mysql语句
        String sql3="update t_book set bookprice='" + bookprice + "' where id='"+ MainApp.staticdata.upid+"' ";//生成一条mysql语句
        String sql4="update t_book set bookamount='" + bookamount + "' where id='"+ MainApp.staticdata.upid+"' ";//生成一条mysql语句
        String sql5="update t_book set booktype='" + booktype + "' where id='"+ MainApp.staticdata.upid+"' ";//生成一条mysql语句

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
                // 创建Statement
                Statement stmt = con.createStatement();

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
                    if(MainApp.staticdata.countwin == 0){//检查成功窗口是否为一个
                       new UpdataWin().win();
                    }
                }


                stmt.close();
                con.close();

            } catch (ClassNotFoundException |SQLException e) {
                throw new RuntimeException(e);
            } catch ( RuntimeException e) {
                new Amount().amount();//程序出现运行时错误的时候，创建数据数量价格不能为负数的提示窗口
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


    }


}
