package com.nan.middle;

import com.nan.dao.Book;
import com.nan.dao.SeeDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

/**
 * 查询图书中间层类，查询图书
 */
public class SeeMid2 {

    /**
     * 首先声明组件
     */
    private JPanel jPanel2 = new JPanel();//创建面板2，并实例化该面板
    private JTable jtable;//声明表格



    public JPanel seeAll(){
        jPanel2.setSize(500,480);//设置该面板的大小
        jPanel2.setLocation(300,0);//设置该面板的位置
        jPanel2.setBackground(Color.gray);//设置该面板的背景颜色
        jPanel2.setVisible(true);//设置该面板可见



        //表格列名
        String[] columnNames = {"ID", "BookName", "BookAuthor","Price","Amount","BookType"};//定义表格列名

        //创建表格的数据模型
        DefaultTableModel model = new DefaultTableModel(columnNames,0);

        SeeDao seeAlldao = new SeeDao();//实例化SeeAllDAO类
        List<Book> books = null;
        try{
            books = seeAlldao.getAllBooks();//查询全部图书
        } catch (SQLException e) {//捕获异常
            throw new RuntimeException(e);//处理异常
        } catch (ClassNotFoundException e) {//捕获异常
            throw new RuntimeException(e);//处理异常
        }

        for(Book book : books){//循环遍历图书信息
            int id = book.getId();//获取图书id
            String name = book.getBookname();//获取图书名称
            String author = book.getBookauthor();//获取图书作者
            BigDecimal price = book.getBookprice();//获取图书价格
            int amount = book.getBookamount();//获取图书数量
            String BookType = book.getBooktype();//获取图书类型
            //将数据添加到表格模型
            model.addRow(new Object[]{id, name, author,price,amount,BookType});//将数据添加到表格模型

        }

        jtable = new JTable(model);//表格模型添加到表

        jPanel2.add(new JScrollPane(jtable)); // 使用滚动面板以防表格太大****


        return jPanel2;
    }


    /**
     * 查询含有指定文字的图书
     *
     */
    public JPanel see(String booktext){//传入一个字符串参数
        jPanel2.setSize(500,480);//设置该面板的大小
        jPanel2.setLocation(300,0);//设置该面板的位置
        jPanel2.setBackground(Color.gray);//设置该面板的背景颜色
        jPanel2.setVisible(true);//设置该面板可见
        //表格列名
        String[] columnNames = {"ID", "BookName", "BookAuthor","Price","Amount","BookType"};//定义表格列名

        //创建表格的数据模型
        DefaultTableModel model = new DefaultTableModel(columnNames,0);

        SeeDao seeDao = new SeeDao();//实例化一个SeeAllDAO
        java.util.List<Book> books2 = null;
        try{
            books2 = seeDao.getBooks(booktext);//方法中传入booktext的指定文字内容进行查询
        } catch (ClassNotFoundException e) {//捕获异常
            throw new RuntimeException(e);//异常处理
        }

        for(Book book : books2){//循环遍历图书内容
            int id = book.getId();//获取图书的id
            String name = book.getBookname();//获取图书的名字
            String author = book.getBookauthor();//获取图书的作者
            BigDecimal price = book.getBookprice();//获取图书的价格
            int amount = book.getBookamount();//获取图书的数量
            String BookType = book.getBooktype();//获取图书的类型
            //将数据添加到表格模型
            model.addRow(new Object[]{id, name, author,price,amount,BookType});//将数据添加到表格模型
//            if(String.valueOf(id).equals("")){
//                return false;
//            }


        }

        jtable = new JTable(model);//表格模型添加到表


        jPanel2.add(new JScrollPane(jtable)); // 使用滚动面板以防表格太大****

        return jPanel2;//返回该面板

    }


}
