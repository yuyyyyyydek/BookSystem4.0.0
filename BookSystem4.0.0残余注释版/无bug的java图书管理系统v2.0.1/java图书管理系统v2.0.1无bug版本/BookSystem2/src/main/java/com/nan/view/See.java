package com.nan.view;

import com.nan.dao.Book;
import com.nan.dao.SeeAllDAO;
import com.nan.dao.SeeDAO;
import com.nan.tool.Gain;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * 查询图书界面设计
 */
public class See extends JFrame {

    /**
     * 声明要使用到的组件
     */
    private String booktext;//查询文本框中的内容
    private JTextField textField;//声明图书查询的文本框
    private JPanel jPanel2;//声明面板2
    private JButton bse;//查询图书按钮
    private JLabel jLabel;//查询书籍 的文本域信息
    private JTable jtable;//声明表格
    Font font2 = new Font("Serif", Font.BOLD, 28);//设置文字大小

    void see2() {

        jPanel2 = new JPanel();//创建面板2
        MainApp.staticdata.count = 1;//设置该窗口是否存在，这里赋值为0，表示该窗口已经存在
        jtable = new JTable();//创建数据表格
        this.setSize(890, 610);//查询窗口的大小
        this.setTitle("图书查询");//设置窗口标题
        this.setLayout(null);//设置窗口布局
        this.setLocationRelativeTo(null);//窗口居中显示
        setResizable(false);//设置窗口是否可以改变大小


        jLabel = new JLabel("输入图书名称可查询");//输入图书名称可查询 文本域的内容
        bse = new JButton("图书查询");//图书查询按钮创建，并赋值"图书查询"
        textField = new JTextField();  //文本框创建，用于输入图书名称信息

        bse.setFont(font2);//查询按钮文字采用28号
        textField.setFont(font2);//图书查询窗口文字大小使用28号字体
        jLabel.setFont(font2);//为文本信息设置字体大小，此处为：输入图书名称可查询

        textField.setBounds(60, 250, 190, 55);//图书查询文本框位置大小设定
        bse.setBounds(70, 100, 180, 65);//图书查询按钮位置大小设定
        jLabel.setBounds(22, 190, 280, 55);//图书名称查询文本域信息位置大小设定
        jtable.setBounds(300,0,800,600);//设置表格的大小以及位置


        add(textField);//添加文本框到面板,文本框为 填写的查询图书信息
        add(bse);//按钮添加到面板1容器,查询按钮
        add(jLabel);//文本内容为：输入图书名称可查询，文本域



        jPanel2.setBounds(300,0,500,480);//设置面板2的大小以及位置
        jPanel2.setBackground(Color.GRAY); // 设置面板2颜色为黄色背景
        jPanel2.add(jtable);//添加表格到面板2
        //下面和上面一样


        seeall();//默认显示所有图书信息

        //以下代码极其重要，是将表格面板添加至窗口的重要代码
        getContentPane().add(jPanel2);//得到当前哦那个其，把jpanel2添加到容器中***极其重要的代码
        setVisible(true);//设置窗体可见
        repaint();//刷新重绘





        bse.addMouseListener(new MouseListener() {//为查询按钮添加鼠标监听器
            @Override
            public void mouseClicked(MouseEvent e) {//鼠标点击事件
                jPanel2.removeAll();//移除面板2中所有的内容
                System.out.println(Gain.gain(textField));//输出显示查询文本框中的信息
                booktext = Gain.gain(textField);//使用gain方法获得文本框中的内容信息并赋值给booktext
                if(booktext==null){//当文本框中内容为空的时候，运行此if中的内容
                    seeall();//显示所有图书信息

                }
                if(booktext!=null){//当图书文本框中的内容不为空的时候，执行此if中的内容
                    see(booktext);//查询带有"booktext"字段的图书信息
                    repaint();//刷新重绘

                }

                repaint();//窗体重绘
                setVisible(true);//设置窗口内容可见


            }


            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        setVisible(true);//设置窗口内容可见

        this.addWindowListener(new WindowAdapter() {//窗口关闭执行的代码


            public void windowClosing(WindowEvent e) {//关闭窗口时执行的事件
                super.windowClosing(e);
                MainApp.staticdata.count = 0;//设置该窗口是否存在，这里重置为0，方便下次创建
            }

        });


    }


    //表格列名
    String[] columnNames = {"ID", "BookName", "BookAuthor","Price","Amount","BookType"};//定义表格列名

    //创建表格的数据模型
    DefaultTableModel model = new DefaultTableModel(columnNames,0);


    /**
     * 查询含有指定文字的图书
     *
     */
    boolean see(String booktext){//传入一个字符串参数
        //表格列名
        String[] columnNames = {"ID", "BookName", "BookAuthor","Price","Amount","BookType"};//定义表格列名

        //创建表格的数据模型
        DefaultTableModel model = new DefaultTableModel(columnNames,0);

        SeeDAO seeDAO = new SeeDAO();//实例化一个SeeDAO
        java.util.List<Book> books2 = null;
        try{
            books2 = seeDAO.getBooks(booktext);//方法中传入booktext的指定文字内容进行查询
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
            if(String.valueOf(id).equals("")){
                return false;
            }


        }

            jtable = new JTable(model);//表格模型添加到表


            jPanel2.add(new JScrollPane(jtable)); // 使用滚动面板以防表格太大****

            return true;

    }


    /**
     * 查询所有图书信息
     */
    void seeall(){

        //表格列名
        String[] columnNames = {"ID", "BookName", "BookAuthor","Price","Amount","BookType"};//定义表格列名

        //创建表格的数据模型
        DefaultTableModel model = new DefaultTableModel(columnNames,0);

        SeeAllDAO seeAlldao = new SeeAllDAO();//实例化SeeAllDAO类
        java.util.List<Book> books = null;
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



    }

    /**
     *下面这个方法是专门为图书归还，查询图书是否存在，不存在的话创建图书   而设计的
     */
    boolean seeRe(String booktext){//传入一个字符串参数
//        //表格列名
//        String[] columnNames = {"ID", "BookName", "BookAuthor","Price","Amount","BookType"};//定义表格列名
//
//        //创建表格的数据模型
//        DefaultTableModel model = new DefaultTableModel(columnNames,0);

        SeeDAO seeDAO = new SeeDAO();//实例化一个SeeDAO
        java.util.List<Book> books2 = null;
        try{
            books2 = seeDAO.getBooks(booktext);//方法中传入booktext的指定文字内容进行查询
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
            if(String.valueOf(id).equals(booktext)){
                return false;
            }else{
                return true;
            }



        }

//        jtable = new JTable(model);//表格模型添加到表
//
//
//        jPanel2.add(new JScrollPane(jtable)); // 使用滚动面板以防表格太大****

        return false;

    }



}
