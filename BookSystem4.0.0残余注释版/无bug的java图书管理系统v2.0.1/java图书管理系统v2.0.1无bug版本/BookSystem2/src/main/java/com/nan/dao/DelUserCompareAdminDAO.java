package com.nan.dao;

import java.sql.*;

/**
 * compare是比较的意思
 * 该类用于比较数据库中的超级管理员与输入的超级管理员账户密码是否一致
 */
public class DelUserCompareAdminDAO {



    //作用为让传入的账号密码和数据库中的账号密码进行比较
    public boolean compare(String account, String password){//定义jdbc连接数据库方法
        // JDBC驱动程序名称及URL
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/booksystem2";
        // 数据库登录信息
        String username = "root";
        String Password = "123456";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //2.注册驱动

            Class.forName(driver);
            //3.获取数据库连接对象
            conn = DriverManager.getConnection(url,username,Password);


            //5.获取执行sql的对象 Statement,创建Statement对象
            stmt = conn.createStatement();

            //执行sql
            String sql = "SELECT admini,admpass FROM t_admini";//sql语句
            rs = stmt.executeQuery(sql);//获取查询语句执行结果


            while (rs.next()) {//查询结果rs遍历，循环输出
                String name = rs.getString("admini");//获取从数据库查询到的用户信息至name属性
                String password2 =rs.getString("admpass");//获取从数据库查询到的密码信息至password2属性


                //此处为判断传进来的账号密码信息是否与查询数据库中信息是否一致
                //password2接受了数据库中的密码信息，与传参进来的password进行比较
                //account为传参进来的账号信息，与数据库查询到的账号信息name进行比较
                if(password2.equals(password)&&account.equals(name)) {//如果用户输入的管理员密码与数据库中的管理员密码相同进入此if中
                    System.out.println("管理员账号登录成功");//提示用户登录成功
                    System.out.println("管理员密码password:" + password2);//输出用户输入的正确密码
                    return true;//返回ture
                }




            }
            System.out.println("登录失败，请重新输入");//账号密码为空或输如的账号密码不在数据库中，输出此警告信息

            return false;//信息不正确，返回false，以便其它循环条件的使用

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();//打印异常信息
        }finally {

            try {
                if (stmt!=null){//如果stmt不为空，释放此资源
                    //8.释放资源
                    stmt.close(); //关闭Statement对象
                }
            } catch (SQLException throwables) {//出现异常后执行的代码
                throwables.printStackTrace();//打印异常信息
            }

            try {
                if (conn!=null){//如果conn不为空，释放此资源
                    conn.close();//关闭数据库连接对象
                }
            } catch (SQLException throwables) {//出现异常后执行的代码
                throwables.printStackTrace();//抛出异常信息
            }
        }
        return false;
    }//JDBC  end

}
