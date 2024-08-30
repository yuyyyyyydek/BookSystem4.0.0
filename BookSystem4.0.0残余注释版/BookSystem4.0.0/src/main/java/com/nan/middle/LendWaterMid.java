package com.nan.middle;

import com.nan.dao.LendSeeAllDao;
import com.nan.dao.Lender;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;

/**
 * 借阅流水中间层类
 */
public class LendWaterMid {

    private JTable jTable;//声明表格
    private JPanel jPanel2 = new JPanel();

    LendSeeAllDao lendSeeAllDao = new LendSeeAllDao();//实例化LendSeeAllDAO类



    public JPanel seeAllLender() {
        //jPanel2.setBounds(280, 0, 520, 480);//设置面板2的大小与位置
        jPanel2.setSize(520,480);
        jPanel2.setLocation(280,0);
        jPanel2.setBackground(Color.gray);//设置该面板的背景颜色
        jPanel2.setVisible(true);//设置该面板可见

        //表格列名
        String[] columnNames = {"ID", "BookName", "Lender", "Mobile", "Money", "Time"};//定义表格列名
        //创建表格的数据模型
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

//        LendSeeAllDao lendSeeAllDao = new LendSeeAllDao();//实例化LendSeeAllDAO类
        java.util.List<Lender> lenders = null;
        try {
            lenders = lendSeeAllDao.seeAllLender();//查询全部借阅信息
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (Lender lender : lenders) {//遍历循环借阅信息
            int id = lender.getId();//获得借阅图书序列id
            String bookname = lender.getBookname();//获得借阅图书的名称
            String author = lender.getBookauthor();//获得借阅图书的作者
            BigDecimal price = lender.getBookprice();//获得借阅图书的价格
            int amount = lender.getBookamount();//获得借阅图书的数量
            String BookType = lender.getBooktype();//获得借阅图书的类型

            String lendername = lender.getLender();//获得借阅者的姓名
            String mobile = lender.getMobile();//获得借阅者的手机号码
            BigDecimal money = lender.getMoney();//获得借阅者的押金
            String time = lender.getTime();//获得借阅者借书的时间
            int bookid = lender.getBookid();//获得借阅者借书时，借阅图书的图书ID序列

            //将数据添加到表格模型
            model.addRow(new Object[]{id, bookname, lendername, mobile, money, time});//将数据添加到表格模型

        }

        jTable = new JTable(model);//表格模型添加到表

        jPanel2.add(new JScrollPane(jTable)); // 使用滚动面板以防表格太大****

        return jPanel2;

    }// seeAllLender()  end

    public JPanel seeLender(String lenderName) {//传入一个字符串参数
        jPanel2.setBounds(280, 0, 520, 480);//设置面板2的大小与位置
        jPanel2.setBackground(Color.gray);//设置该面板的背景颜色
        jPanel2.setVisible(true);//设置该面板可见

        //表格列名
        String[] columnNames = {"ID", "BookName", "Lender", "Mobile", "Money", "Time"};//定义表格列名
        //创建表格的数据模型
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        //LendSeeNameDAO lendSeeNameDAO = new LendSeeNameDAO();//实例化LendSeeAllDAO类
        java.util.List<Lender> lenders = null;

        try {
            lenders = lendSeeAllDao.seeName(lenderName);//方法中传入lender的指定文字内容进行查询
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (Lender lender : lenders) {//遍历循环借阅信息
            int id = lender.getId();//获得借阅图书序列id
            String bookname = lender.getBookname();//获得借阅图书的名称
            String author = lender.getBookauthor();//获得借阅图书的作者
            BigDecimal price = lender.getBookprice();//获得借阅图书的价格
            int amount = lender.getBookamount();//获得借阅图书的数量
            String BookType = lender.getBooktype();//获得借阅图书的类型

            String lendername = lender.getLender();//获得借阅者的姓名
            String mobile = lender.getMobile();//获得借阅者的手机号码
            BigDecimal money = lender.getMoney();//获得借阅者的押金
            String time = lender.getTime();//获得借阅者借书的时间
            int bookid = lender.getBookid();//获得借阅者借书时，借阅图书的图书ID序列

            //将数据添加到表格模型
            model.addRow(new Object[]{id, bookname, lendername, mobile, money, time});//将数据添加到表格模型


        }


        jTable = new JTable(model);//表格模型添加到表

        jPanel2.add(new JScrollPane(jTable)); // 使用滚动面板以防表格太大****

        return jPanel2;

    }


    public JPanel seeMobile(String lenderMobile) {//传入一个字符串参数
        jPanel2.setBounds(280, 0, 520, 480);//设置面板2的大小与位置
        jPanel2.setBackground(Color.gray);//设置该面板的背景颜色
        jPanel2.setVisible(true);//设置该面板可见

        //表格列名
        String[] columnNames = {"ID", "BookName", "Lender", "Mobile", "Money", "Time"};//定义表格列名
        //创建表格的数据模型
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        //LendSeeMobileDAO lendSeeMobileDAO = new LendSeeMobileDAO();//实例化LendSeeMobileDAO类
        java.util.List<Lender> lenders = null;

        try {
            lenders = lendSeeAllDao.seeMobile(lenderMobile);//方法中传入lender的指定文字内容进行查询
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (Lender lender : lenders) {//遍历循环借阅信息
            int id = lender.getId();//获得借阅图书序列id
            String bookname = lender.getBookname();//获得借阅图书的名称
            String author = lender.getBookauthor();//获得借阅图书的作者
            BigDecimal price = lender.getBookprice();//获得借阅图书的价格
            int amount = lender.getBookamount();//获得借阅图书的数量
            String BookType = lender.getBooktype();//获得借阅图书的类型

            String lendername = lender.getLender();//获得借阅者的姓名
            String mobile = lender.getMobile();//获得借阅者的手机号码
            BigDecimal money = lender.getMoney();//获得借阅者的押金
            String time = lender.getTime();//获得借阅者借书的时间
            int bookid = lender.getBookid();//获得借阅者借书时，借阅图书的图书ID序列

            //将数据添加到表格模型
            model.addRow(new Object[]{id, bookname, lendername, mobile, money, time});//将数据添加到表格模型


        }


        jTable = new JTable(model);//表格模型添加到表

        jPanel2.add(new JScrollPane(jTable)); // 使用滚动面板以防表格太大****

        return jPanel2;

    }


}
