package com.nan.middle;

import com.nan.dao.ReaderDao;
import com.nan.dao.UserDao;
import com.nan.user.ReaderUser;
import com.nan.user.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;
/**
 * 查询读者信息中间层类
 */
public class SeeReaderMid {

        /**
         * 首先声明组件
         */
        private JPanel jPanel2 = new JPanel();//创建面板2，并实例化该面板
        private JTable jtable;//声明表格


        public JPanel seeAllReaderUser(){
            jPanel2.setSize(500,480);//设置该面板的大小
            jPanel2.setLocation(300,0);//设置该面板的位置
            jPanel2.setBackground(Color.gray);//设置该面板的背景颜色
            jPanel2.setVisible(true);//设置该面板可见



            //表格列名
            String[] columnNames = {"ID", "ReaderName"};//定义表格列名

            //创建表格的数据模型
            DefaultTableModel model = new DefaultTableModel(columnNames,0);

            ReaderDao readerDao = new ReaderDao();//实例化ReaderDao
            java.util.List<ReaderUser> readerUsers = null;
            readerUsers = readerDao.getAllReaderUsers();//查询全部用户

            for(ReaderUser readerUser : readerUsers){//循环遍历所有信息
                int id = readerUser.getId();//获取id
                String name = readerUser.getReaderUser();//获取账号
                //将数据添加到表格模型
                model.addRow(new Object[]{id, name});//将数据添加到表格模型


            }

            jtable = new JTable(model);//表格模型添加到表

            jPanel2.add(new JScrollPane(jtable)); // 使用滚动面板以防表格太大****


            return jPanel2;
        }

        public JPanel seeReaderUserByName(String Name) {
            jPanel2.setSize(500,480);//设置该面板的大小
            jPanel2.setLocation(300,0);//设置该面板的位置
            jPanel2.setBackground(Color.gray);//设置该面板的背景颜色
            jPanel2.setVisible(true);//设置该面板可见



            //表格列名
            String[] columnNames = {"ID", "ReaderName"};//定义表格列名

            //创建表格的数据模型
            DefaultTableModel model = new DefaultTableModel(columnNames,0);

            ReaderDao readerDao = new ReaderDao();//实例化ReaderDao
            java.util.List<ReaderUser> readerUsers = null;
            readerUsers = readerDao.getReaderUsers(Name);//查询全部用户

            for(ReaderUser readerUser : readerUsers){//循环遍历所有信息
                int id = readerUser.getId();//获取id
                String name = readerUser.getReaderUser();//获取账号
                //将数据添加到表格模型
                model.addRow(new Object[]{id, name});//将数据添加到表格模型


            }



            jtable = new JTable(model);//表格模型添加到表

            jPanel2.add(new JScrollPane(jtable)); // 使用滚动面板以防表格太大****


            return jPanel2;
        }





}
