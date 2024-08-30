package com.nan.middle;

import com.nan.dao.Book;
import com.nan.dao.SeeDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * 查询图书的中间层类
 */
public class SeeMid {
    /**
     * 声明要使用的组件
     */
    private JTable jtable;//声明表格
    private JPanel jPanel2;//声明面板2

    SeeDao seeAlldao = new SeeDao();//实例化SeeAllDao类


    //表格列名
    String[] columnNames = {"ID", "BookName", "BookAuthor", "Price", "Amount", "BookType"};//定义表格列名



    /**
     * 查询所有图书信息
     */

    public DefaultTableModel seeAll() throws SQLException ,ClassNotFoundException{
        //创建表格的数据模型
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
//        jPanel2 = new JPanel();//创建面板2
//        jPanel2.setSize(500, 480);
//        jPanel2.setBackground(Color.GRAY); // 设置面板2颜色为灰色背景

//    SeeAllDao seeAlldao = new SeeAllDao();//实例化SeeAllDao类
        java.util.List<Book> books = seeAlldao.getAllBooks();//查询全部图书
        common(books,model);
        return model;

//        for (Book book : books) {//循环遍历图书信息
//            int id = book.getId();//获取图书id
//            String name = book.getBookname();//获取图书名称
//            String author = book.getBookauthor();//获取图书作者
//            BigDecimal price = book.getBookprice();//获取图书价格
//            int amount = book.getBookamount();//获取图书数量
//            String BookType = book.getBooktype();//获取图书类型
//
//            model.addRow(new Object[]{id, name, author, price, amount, BookType});//将数据添加到表格模型//原始行
//        }

//        return model;
//        jtable = new JTable(model);//表格模型添加到表
//        jPanel2.add(new JScrollPane(jtable)); // 使用滚动面板以防表格太大****


//        return jPanel2;//返回面板2

    }

    public void common(java.util.List<Book> books,DefaultTableModel model) {
        //将数据添加到模型
        for (Book book : books) {//循环遍历图书内容
            int id = book.getId();//获取图书的id
            String name = book.getBookname();//获取图书的名字
            String author = book.getBookauthor();//获取图书的作者
            BigDecimal price = book.getBookprice();//获取图书的价格
            int amount = book.getBookamount();//获取图书的数量
            String BookType = book.getBooktype();//获取图书的类型
            //将数据添加到表格模型
            model.addRow(new Object[]{id, name, author, price, amount, BookType});//将数据添加到表格模型
        }
    }


    /**
     * 查询含有指定文字的图书
     */
    public DefaultTableModel see(String booktext) throws ClassNotFoundException {//传入一个字符串参数
        //创建表格的数据模型
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        //SeeAllDAO seeDAO = new SeeAllDAO();//实例化一个SeeDAO

        java.util.List<Book> books2 = seeAlldao.getBooks(booktext);
        common(books2,model);
        return model;
//
//        for (Book book : books2) {//循环遍历图书内容
//            int id = book.getId();//获取图书的id
//            String name = book.getBookname();//获取图书的名字
//            String author = book.getBookauthor();//获取图书的作者
//            BigDecimal price = book.getBookprice();//获取图书的价格
//            int amount = book.getBookamount();//获取图书的数量
//            String BookType = book.getBooktype();//获取图书的类型
//            //将数据添加到表格模型
//            model.addRow(new Object[]{id, name, author, price, amount, BookType});//将数据添加到表格模型
//
//        }

//        jtable = new JTable(model);//表格模型添加到表
//        jPanel2.add(new JScrollPane(jtable)); // 使用滚动面板以防表格太大****
//
//        return jPanel2;//返回面板2

    }

}
