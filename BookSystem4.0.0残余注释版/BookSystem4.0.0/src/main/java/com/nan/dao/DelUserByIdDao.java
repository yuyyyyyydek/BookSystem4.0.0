package com.nan.dao;

import com.nan.hint.DelUserSucceed;
import com.nan.tool.StaticData;
import database.DBConnectionManager;

import java.sql.*;

/**
 * 此窗口为根据ID删除用户
 */
public class DelUserByIdDao {

    //复制的代码，

    /**
     * 根据用户ID查询数据库，并显示
     * @param search
     */
    public void  findDelUser(String search) {//传入要查询的ID，进行数据库查询，并显示


        String sql2 = "select id,username from t_user where id LIKE'" + search + "'";


        // 数据库连接配置
//        String url = "jdbc:mysql://localhost:3306/booksystem2";
//        String user = "root";
//        String password = "123456";


        {
            try {
                // 加载数据库驱动
//                Class.forName("com.mysql.cj.jdbc.Driver");
                // 建立连接
                //Connection con = DriverManager.getConnection(url, user, password);
                Connection conn = DBConnectionManager.getConnection();//获取数据库连接对象
                // 创建Statement
                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(sql2);


                // 遍历结果集
                while (rs.next()) {

                    // 根据列名获取数据
                    int id = rs.getInt("id");//前面声明的id用于后续代码，括号中的ID为数据库表中的列名
                    String delUserName = rs.getString("username");//前面声明的username用于后续代码，括号中的username为数据库表中的列名



                    System.out.println(id);
                    //MainApp.staticdata.deid3 = id;//查询到的id 写入到静态类的属性中这里是deid3
                    StaticData.delId3 = id;//查询到的需要删除用户的id 写入到静态类的属性中这里是delId3
                    System.out.println(delUserName);
                    StaticData.delUsername =delUserName;//这里是delUserName。查询到的用户名写入到静态类的属性delUsername中




                }


                try {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }

                // 关闭资源
//                rs.close();
//                stmt.close();
//                con.close();

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();

            }
        }


    }// end


    /**
     * compare是比较的意思
     * 该类用于比较数据库中的超级管理员与输入的超级管理员账户密码是否一致
     */

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
                //conn = DriverManager.getConnection(url,username,Password);
                conn = DBConnectionManager.getConnection();//获取数据库连接对象


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



    /**
     * 根据用户ID删除用户
     */

        public void  delUser() {//删除数据库信息的方法，传入要删除的数据信息，根据静态变量ID查找



            String sql="delete from t_user where id='"+ StaticData.delId3+"' ";//生成一条mysql语句






            try {
                // 加载数据库驱动
                //Class.forName("com.mysql.cj.jdbc.Driver");
                // 建立连接
                //Connection con = DriverManager.getConnection(url, user, password);
                Connection conn = DBConnectionManager.getConnection();//获取数据库连接对象
                // 创建Statement
                Statement stmt = conn.createStatement();

                int rs = stmt.executeUpdate(sql);


                if(rs == 1){//如果所有删除成功了就执行以下代码，弹出成功窗口
                    System.out.println("删除成功");//在控制台输出"修改成功"
//                    if(MainApp.staticdata.countuserdelwin == 0){//检查成功窗口是否为一个
                        new DelUserSucceed().win();
//                    }
                }



                try {
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }


                // 关闭资源
//                rs.close();
//                stmt.close();
//                con.close();

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();


            }


        }


}
