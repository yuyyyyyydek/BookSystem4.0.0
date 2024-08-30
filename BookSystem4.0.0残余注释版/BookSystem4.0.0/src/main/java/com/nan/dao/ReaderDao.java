package com.nan.dao;

import com.nan.hint.DelUserSucceed;
import com.nan.tool.StaticData;
import com.nan.user.ReaderUser;
import database.DBConnectionManager;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 该类创建方法用于访问数据库中的读者表，并提取出表中的账号和密码
 */
public  class ReaderDao {


    /**
     * 查询含有指定字符的读者的方法，指定字母的读者
     */
    public List<ReaderUser> getReaderUsers(String search) {//创建一个ReaderUser的集合，并抛出ClassNotFoundException异常
        List<ReaderUser> readerUsers = new ArrayList<>();//集合初始化
        String sql = "SELECT * FROM t_reader WHERE reader LIKE '%" + search + "%'";

        readerUsers = getReaderUser(sql, readerUsers);
        return readerUsers;//返回readerUsers集合
    }


    /**
     * 查询所有的读者方法
     * @return
     * @throws ClassNotFoundException
     */
    public List<ReaderUser> getAllReaderUsers() {//创建一个ReaderUser的集合，并抛出ClassNotFoundException异常
        List<ReaderUser> readerUsers = new ArrayList<>();//集合初始化
        String sql = "select * from t_reader";//SQL语句

        readerUsers = getReaderUser(sql,readerUsers);
        return readerUsers;//返回readerUsers集合

//        try (
//
//                Connection conn = DBConnectionManager.getConnection();//获取数据库连接对象
//                Statement stmt = conn.createStatement();//获取执行sql的对象，Statement，创建Statement对象
//                ResultSet rs = stmt.executeQuery(sql)) { //执行sql
//
//            while (rs.next()) {//遍历rs集合中的内容
//                ReaderUser readerUser = new ReaderUser();//创建一个ReaderUser对象
//                System.out.println("LoginDao:+reader:"+rs.getString("reader")+" password:"+rs.getString("reader_password"));
//                readerUser.setReaderUser(rs.getString("reader"));//readerUser对象设置该对象的用户id，括号中为从数据库中得到账号数据信息
//                readerUser.setReaderPassword(rs.getString("reader_password"));//readerUser对象设置该对象的密码，括号中为数据库中得到的密码数据信息
//
//                readerUsers.add(readerUser);//将该readerUser对象添加到readerUsers集合中
//            }
//            try {
//                if (rs != null) rs.close();
//                if (stmt != null) stmt.close();
//                if (conn != null) conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }
//        } catch (Exception e) {//捕获异常
//            throw new RuntimeException(e);
//        }


    }


    /**
     * 根据读者ID查询，并显示读者账号
     * @param search
     */
    public void  findDelReaderUser(String search) {//传入要查询的ID，进行数据库查询，并显示


        String sql2 = "select id,reader from t_reader where id LIKE'" + search + "'";


        {
            try {

                Connection conn = DBConnectionManager.getConnection();//获取数据库连接对象
                // 创建Statement
                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(sql2);


                // 遍历结果集
                while (rs.next()) {

                    // 根据列名获取数据
                    int id = rs.getInt("id");//前面声明的id用于后续代码，括号中的ID为数据库表中的列名
                    String delUserName = rs.getString("reader");//前面声明的reader用于后续代码，括号中的reader为数据库表中的列名



                    System.out.println(id);
                    //MainApp.staticdata.deid3 = id;//查询到的id 写入到静态类的属性中这里是deid3
                    StaticData.delReaderId4 = id;//查询到的需要删除用户的id 写入到静态类的属性中这里是delId3
                    System.out.println(delUserName);
                    StaticData.delReaderUsername =delUserName;//这里是delUserName。查询到的用户名写入到静态类的属性delUsername中




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
     * 根据读者ID删除读者
     */

    public void  delReaderUser() {//删除数据库信息的方法，传入要删除的数据信息，根据静态变量ID查找



        String sql="delete from t_reader where id='"+ StaticData.delReaderId4+"' ";//生成一条mysql语句


        try {
            Connection conn = DBConnectionManager.getConnection();//获取数据库连接对象
            // 创建Statement
            Statement stmt = conn.createStatement();

            int rs = stmt.executeUpdate(sql);


            if(rs == 1){//如果所有删除成功了就执行以下代码，弹出成功窗口
                System.out.println("删除成功");//在控制台输出"修改成功"
                new DelUserSucceed().win();
            }



            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }



        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();


        }


    }





    /**
     * 此方法将重复代码写成了一个方法，方便使用时调用
     * @param sql
     * @param
     * @return
     */
    public List<ReaderUser> getReaderUser(String sql,List<ReaderUser> readerUsers) {
        //专门数据库数据转成list
        try(
                //Connection conn = DriverManager.getConnection(url,username,password);//获取数据库连接对象
                Connection conn = DBConnectionManager.getConnection();////获取数据库连接对象
                Statement stmt = conn.createStatement();//获取执行sql的对象，Statement，创建Statement对象
                ResultSet rs = stmt.executeQuery(sql)){//SQL语句

            while(rs.next()){//遍历rs集合中的内容
                ReaderUser readerUser = new ReaderUser();//创建一个ReaderUser对象
                readerUser.setId(rs.getInt("id"));//设置新ReaderUser对象的id为数据库中的ReaderUser的id
                readerUser.setReaderUser(rs.getString("reader"));//设置新ReaderUser对象的reader为数据库中的reader名称
                readerUser.setReaderPassword(rs.getString("reader_password"));//readerUser对象设置该对象的密码，括号中为数据库中得到的密码数据信息

                readerUsers.add(readerUser);//将该ReaderUser对象添加到readerUsers集合中

            }

            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }



        } catch (SQLException e) {//捕获异常
            e.printStackTrace();//异常处理
        } catch (Exception e) {//捕获异常
            throw new RuntimeException(e);//异常处理
        }
        return readerUsers;
    }



}


