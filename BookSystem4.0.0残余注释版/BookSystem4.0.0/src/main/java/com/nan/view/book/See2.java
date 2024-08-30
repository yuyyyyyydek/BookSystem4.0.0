package com.nan.view.book;

import com.nan.dao.SeeDao;
import com.nan.middle.SeeMid2;
import com.nan.tool.Gain;
import com.nan.tool.Only;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 查询图书界面设计
 */
public class See2 extends JFrame {
    SeeMid2 seeMid2 = new SeeMid2();//创建一个查询图书的中间层类，并且实例化

    private JPanel jPanel3 = new JPanel();//创建面板3，用于接收中间层类传过来的面板
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

    public void see2() {

        jPanel2 = new JPanel();//创建面板2
        //MainApp.staticdata.count = 1;//设置该窗口是否存在，这里赋值为0，表示该窗口已经存在
        Only.SeeCount = 1;//设置该窗口是否存在，这里赋值为1，表示窗口已经存在
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



        //jPanel2.setBounds(300,0,500,480);//设置面板2的大小以及位置
        //jPanel2.setBackground(Color.GRAY); // 设置面板2颜色为黄色背景
        //jPanel2.add(jtable);//添加表格到面板2
        //下面和上面一样


        //seeall();//默认显示所有图书信息

        //以下代码极其重要，是将表格面板添加至窗口的重要代码
        //getContentPane().add(jPanel2);//得到当前哦那个其，把jpanel2添加到容器中***极其重要的代码
        setVisible(true);//设置窗体可见
        repaint();//刷新重绘


        jPanel3 = seeMid2.seeAll();//显示所有图书信息
        add(jPanel3);
        jPanel3.setVisible(true);
        repaint();
        //-=--------------------------------------------------------------
//        jPanel3 = seeMid2.seeAll();//显示所有图书信息
//        getContentPane().add(jPanel3);
//        jPanel3.setVisible(true);
//        repaint();
        seeAll();//默认显示所有图书
        repaint();

        bse.addMouseListener(new MouseListener() {//为查询按钮添加鼠标监听器
            @Override
            public void mouseClicked(MouseEvent e) {//鼠标点击事件

/**
 * 以下代码为测试功能使用过的，暂存
 */
                //以下代码为测试功能使用过的，暂存
//                try {
//                    new SeeDao().getLendBookId(58,49);
//                } catch (ClassNotFoundException ex) {
//                    throw new RuntimeException(ex);
//                }


                //jPanel2.removeAll();//移除面板2中所有的内容
                jPanel3.removeAll();
                System.out.println(Gain.gain(textField));//输出显示查询文本框中的信息
                booktext = Gain.gain(textField);//使用gain方法获得文本框中的内容信息并赋值给booktext
                if(booktext==null||booktext.equals("")){//当文本框中内容为空的时候，运行此if中的内容
//                    jPanel3 = seeMid2.seeAll();//显示所有图书信息
//                    getContentPane().add(jPanel3);
//                    jPanel3.setVisible(true);
//                    repaint();
                    seeAll();//如果查询文本框中没有内容，则点击查询图书按钮时，显示所有图书

                }
                if(booktext!=null){//当图书文本框中的内容不为空的时候，单击查询图书按钮执行此if中的内容
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

        /**
         * 该方法为窗体关闭时执行的代码
         */
        this.addWindowListener(new WindowAdapter() {//窗口关闭执行的代码


            public void windowClosing(WindowEvent e) {//关闭窗口时执行的事件
                super.windowClosing(e);
                //MainApp.staticdata.count = 0;//设置该窗口是否存在，这里重置为0，方便下次创建
                Only.SeeCount = 0;//设置该窗口是否存在，这里赋值为0，表示不存在，可以创建该窗口
            }

        });


    }

    /**
     * 该方法为显示所有图书的方法
     */
    public void seeAll(){
        jPanel3.removeAll();//移除面板3所有内容
        jPanel3 = seeMid2.seeAll();//显示所有图书信息
        getContentPane().add(jPanel3);//将面板3添加到窗体面板中
        jPanel3.setVisible(true);//设置面板3可见
        repaint();//刷新重绘
    }

    /**
     * 该方法为查询含有指定文字图书的方法
     * @param booktext
     */
    public void see(String booktext){//传一个参数，该参数为需要查询包含的文字，根据该文字模糊查询图书
        jPanel3.removeAll();//移除面板3所有内容
        jPanel3 = seeMid2.see(booktext);//显示所有图书信息
        getContentPane().add(jPanel3);//将面板3添加到窗体面板中
        jPanel3.setVisible(true);//设置面板3可见
        repaint();//刷新重绘
    }







}