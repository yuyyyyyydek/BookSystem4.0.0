package com.nan.middle;

import com.nan.dao.Book;
import com.nan.dao.SeeDao;
import com.nan.dao.UserDao;
import com.nan.user.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

/**
 * 查询用户信息中间层类
 */
public class SeeUserMid {

    /**
     * 首先声明组件
     */
    private JPanel jPanel2 = new JPanel();//创建面板2，并实例化该面板
    private JTable jtable;//声明表格


    public JPanel seeAllUser(){
        jPanel2.setSize(500,480);//设置该面板的大小
        jPanel2.setLocation(300,0);//设置该面板的位置
        jPanel2.setBackground(Color.gray);//设置该面板的背景颜色
        jPanel2.setVisible(true);//设置该面板可见



        //表格列名
        String[] columnNames = {"ID", "UserName"};//定义表格列名

        //创建表格的数据模型
        DefaultTableModel model = new DefaultTableModel(columnNames,0);

        UserDao userDao = new UserDao();//实例化SeeAllDAO类
        List<User> users = null;
        try{
            users = userDao.getAllUsers();//查询全部用户
        } catch (ClassNotFoundException e) {//捕获异常
            throw new RuntimeException(e);//处理异常
        }

        for(User user : users){//循环遍历所有信息
            int id = user.getId();//获取id
            String name = user.getUsername();//获取账号
            //将数据添加到表格模型
            model.addRow(new Object[]{id, name});//将数据添加到表格模型


        }

        jtable = new JTable(model);//表格模型添加到表

        jPanel2.add(new JScrollPane(jtable)); // 使用滚动面板以防表格太大****


        return jPanel2;
    }

    public JPanel seeUserByName(String Name){
        jPanel2.setSize(500,480);//设置该面板的大小
        jPanel2.setLocation(300,0);//设置该面板的位置
        jPanel2.setBackground(Color.gray);//设置该面板的背景颜色
        jPanel2.setVisible(true);//设置该面板可见



        //表格列名
        String[] columnNames = {"ID", "UserName"};//定义表格列名

        //创建表格的数据模型
        DefaultTableModel model = new DefaultTableModel(columnNames,0);

        UserDao userDao = new UserDao();//实例化SeeAllDAO类
        List<User> users = null;
        try{
            users = userDao.getUsersByName(Name);//查询全部用户
        } catch (ClassNotFoundException | SQLException e) {//捕获异常
            throw new RuntimeException(e);//处理异常
        }

        for(User user : users){//循环遍历所有信息
            int id = user.getId();//获取id
            String name = user.getUsername();//获取账号
            //将数据添加到表格模型
            model.addRow(new Object[]{id, name});//将数据添加到表格模型
        }

//        int rows = model.getRowCount();
//        int cols = model.getColumnCount();
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0;j< cols;j++) {
//                Object data = model.getValueAt(i,j);
//                System.out.println(String.format("(%d,%d):%s",i,j,data));
//            }
//        }


        jtable = new JTable(model);//表格模型添加到表

        jPanel2.add(new JScrollPane(jtable)); // 使用滚动面板以防表格太大****


        return jPanel2;
    }


}
