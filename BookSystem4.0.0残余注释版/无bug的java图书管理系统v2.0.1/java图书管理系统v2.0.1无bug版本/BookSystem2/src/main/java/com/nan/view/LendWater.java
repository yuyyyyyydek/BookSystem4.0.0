package com.nan.view;

import com.nan.dao.LendSeeAllDAO;
import com.nan.dao.LendSeeMobileDAO;
import com.nan.dao.LendSeeNameDAO;
import com.nan.dao.Lender;
import com.nan.tool.Gain;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;

/**
 * 借阅流水窗体设计
 */
public class LendWater extends JFrame {
    private String lendername;//暂存借阅者的姓名,以便借阅信息查询
    private String lendermobile;//暂存借阅者的手机号，以便借阅信息查询
    Font font = new Font("Serif", Font.BOLD, 20);//设置文字大小
    private JPanel jPanel2;//面板2声明
    private JTable jTable;//声明表格
    private JLabel jLabel;//"根据借阅者姓名查询"的文本域标签
    private JLabel jLabel2;//借阅者姓名的文本域标签声明
    private JLabel jLabel3;//"根据借阅者手机号查询"的文本域标签声明
    private JLabel jLabel4;//“号码”的文本域标签声明
    private JLabel jLabel5;//查询所有借阅信息的标签声明
    private JTextField textField;//借阅者姓名文本框声明
    private JTextField textField2;//借阅者手机号码文本框声明

    private JButton bseename;//根据姓名查询借阅信息的按钮声明
    private JButton bseemobile;//根据手机号查询借阅信息的按钮声明
    private JButton bseeall;//查询所有借阅信息标签的声明，显示全部借阅信息


    void lendWater() {
        jPanel2 = new JPanel();//面板2实例化
        MainApp.staticdata.countlendwater = 1;//设置借阅流水窗体只能存在一个，1表示已经创建，0表示未创建，为1 后不可再次创建

        jTable = new JTable();//实例化数据表格

        setSize(890, 610);//设置借阅流水窗体的大小
        setTitle("借阅流水");//设置窗口标题
        setLayout(null);//设置窗体布局为绝对布局
        setLocationRelativeTo(null);//设置窗体居中显示
        setResizable(false);//设置窗体不可改变大小
        setVisible(true);//设置窗体可见

        jLabel = new JLabel("根据借阅者姓名查询");//实例化标签文本域，标签内容为"根据借阅者姓名查询"
        jLabel.setFont(font);//设置标签字体大小
        jLabel.setBounds(22, 20, 280, 55);//标签的位置大小
        add(jLabel);//添加标签到窗体

        jLabel2 = new JLabel("姓名");//实例化标签文本域,标签内容为“姓名”
        jLabel2.setFont(font);//设置标签字体大小
        jLabel2.setBounds(22, 60, 100, 55);//设置“姓名”标签的位置大小
        add(jLabel2);//将标签添加到窗体

        textField = new JTextField();//借阅者姓名文本框实例化
        textField.setFont(font);//设置借阅者姓名文本框的字体大小
        textField.setBounds(80, 70, 150, 35);//借阅者姓名的文本框大小位置设定
        add(textField);//添加借阅者姓名的文本框到窗体

        bseename = new JButton("借阅姓名查询");//实例化姓名查询按钮
        bseename.setFont(font);//按钮字体大小设定
        bseename.setBounds(45, 110, 160, 45);
        add(bseename);

        jLabel3 = new JLabel("根据借阅者手机号查询");//实例化文本域标签,标签内容为："根据借阅者手机号查询"
        jLabel3.setFont(font);//标签字体大小设定
        jLabel3.setBounds(22, 190, 280, 55);
        add(jLabel3);

        jLabel4 = new JLabel("号码");//实例化文本域标签，标签内容为“号码”
        jLabel4.setFont(font);//标签字体大小设定
        jLabel4.setBounds(22, 230, 100, 55);//标签位置大小设定
        add(jLabel4);//添加本标签至窗体中

        textField2 = new JTextField();//实例化手机号码文本框
        textField2.setFont(font);//设置文本框字体大小
        textField2.setBounds(80, 240, 150, 35);//设置手机号码查询文本框的大小位置
        add(textField2);//将手机号码查询文本框添加到窗体

        bseemobile = new JButton("手机号码查询");//实例化号码查询按钮
        bseemobile.setFont(font);//设置按钮的字体大小
        bseemobile.setBounds(45, 280, 160, 45);//差40，按钮与上面的
        add(bseemobile);//将手机号码查询按钮添加到窗体

        jLabel5 = new JLabel("显示所有借阅信息");//查询所有借阅信息的标签实例化
        jLabel5.setFont(font);//设置标签的字体大小
        jLabel5.setBounds(22, 360, 280, 55);//差80,设置标签的大小位置
        add(jLabel5);//将标签添加到窗体

        bseeall = new JButton("显示全部信息");//实例化显示全部信息按钮
        bseeall.setFont(font);//设置按钮字体大小
        bseeall.setBounds(45, 410, 160, 45);
        add(bseeall);

        jPanel2.setBounds(280, 0, 520, 480);//设置面板2的大小与位置
        jPanel2.setBackground(Color.GRAY);//设置面板2颜色为灰色背景
        jPanel2.add(jTable);//添加数据表格到面板2


        //以下代码极其重要，是将表格面板添加至窗口的重要代码
        getContentPane().add(jPanel2);//得到当前哦那个其，把jpanel2添加到容器中***极其重要的代码
        seeAllLender();//默认显示出所有的借阅信息

        /**
         * 按钮事件监听器添加
         */

        bseeall.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jPanel2.removeAll();//移除面板2中所有的内容
                seeAllLender();

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


        bseename.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jPanel2.removeAll();//移除面板2中所有的内容
                System.out.println("姓名查询文本框中的内容是:" + Gain.gain(textField));//输出显示姓名查询文本框中的内容
                lendername = Gain.gain(textField);//使用gain方法获取借阅姓名文本框中的内容信息并赋值给lendername
                if (lendername != null) {//当借阅者姓名文本框中的内容不为空的时候，执行此if中的内容
                    /**
                     * 此处查询类似于   see(booktext)
                     */
                    jPanel2.removeAll();//移除面板2中所有的内容
                    seeLender(lendername);//查询带有lendername中内容的借阅信息
                    repaint();//刷新重绘
                    setVisible(true);//设置窗口内容可见

                }

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

        bseemobile.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                jPanel2.removeAll();//移除面板2中所有的内容
                System.out.println("姓名查询文本框中的内容是:" + Gain.gain(textField2));//输出显示姓名查询文本框中的内容
                lendermobile = Gain.gain(textField2);//使用gain方法获取借阅者手机号文本框中的内容信息并赋值给lendermobile

                seeMobile(lendermobile);//查询带有lendername中内容的借阅信息
                repaint();//刷新重绘
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


        repaint();//重绘刷新


        addWindowListener(new WindowAdapter() {//添加窗体监听器

            public void windowClosing(WindowEvent e) {//窗口关闭时执行的代码
                super.windowClosing(e);
                MainApp.staticdata.countlendwater = 0;  //countlendwater重置为0
            }

        });


    }//lendWater()  end   ,这里急着添加唯一窗口判定


    void seeAllLender() {
        //表格列名
        String[] columnNames = {"ID", "BookName", "Lender", "Mobile", "Money", "Time"};//定义表格列名
        //创建表格的数据模型
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        LendSeeAllDAO lendSeeAllDAO = new LendSeeAllDAO();//实例化LendSeeAllDAO类
        java.util.List<Lender> lenders = null;
        try {
            lenders = lendSeeAllDAO.seeAllLender();//查询全部借阅信息
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


    }// seeAllLender()  end

    void seeLender(String lenderName) {//传入一个字符串参数

        //表格列名
        String[] columnNames = {"ID", "BookName", "Lender", "Mobile", "Money", "Time"};//定义表格列名
        //创建表格的数据模型
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        LendSeeNameDAO lendSeeNameDAO = new LendSeeNameDAO();//实例化LendSeeAllDAO类
        java.util.List<Lender> lenders = null;

        try {
            lenders = lendSeeNameDAO.seeName(lenderName);//方法中传入lender的指定文字内容进行查询
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


    }


    void seeMobile(String lenderMobile) {//传入一个字符串参数

        //表格列名
        String[] columnNames = {"ID", "BookName", "Lender", "Mobile", "Money", "Time"};//定义表格列名
        //创建表格的数据模型
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        LendSeeMobileDAO lendSeeMobileDAO = new LendSeeMobileDAO();//实例化LendSeeMobileDAO类
        java.util.List<Lender> lenders = null;

        try {
            lenders = lendSeeMobileDAO.seeMobile(lenderMobile);//方法中传入lender的指定文字内容进行查询
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


    }



}
