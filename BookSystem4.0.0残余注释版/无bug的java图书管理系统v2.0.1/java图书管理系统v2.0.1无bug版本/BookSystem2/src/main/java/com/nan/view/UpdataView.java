package com.nan.view;

import com.nan.dao.UpdataTableDAO;
import com.nan.tool.Gain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;

/**
 * 此窗口需要从Upd窗口打开才可运行，此类方法用于修改图书信息
 */
    public class UpdataView {
    /**
     * 声明要使用的组件
     */


    Font font2 = new Font("Serif", Font.BOLD, 28);//设置文字大小

    private JButton bupdata2;//updata界面 修改图书信息按钮声明，完成数据修改的按钮
    private JLabel jLabel3;//updata面板 文本域，信息为需要修改的图书名字

    private JLabel jLabel4;//updata面板  文本域，信息为需要修改的图书作者

    private JLabel jLabel5;//updata面板  文本域，信息为需要修改的图书价格

    private JLabel jLabel6;//updata面板  文本域，信息为需要修改的图书数量

    private JLabel jLabel7;//updata面板  文本域，信息为需要修改的图书类型


    private JTextField textField3;//updata面板 文本框，信息为需要修改的图书名字

    private JTextField textField4;//updata面板  文本框，信息为需要修改的图书作者

    private JTextField textField5;//updata面板   文本框，信息为需要修改的图书价格

    private JTextField textField6;//updata面板  文本框，信息为需要修改的图书数量

    private JTextField textField7;//updata面板   文本框，信息为需要修改的图书类型

    /**
     * 该窗口为修改图书信息的窗口
     */
    //该窗口为修改图书信息的窗口
    void updata() {
        JFrame jframe = new JFrame();//创建窗口jframe




        JPanel jPanel5 = new JPanel();//创建面板5
        //jframe.getContentPane().setSize();
        jframe.setTitle("修改图书信息");//窗口标题
        jframe.setSize(700, 700);//设置窗体大小
        //jframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//设置窗体关闭方式
        //jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗体关闭方式//不可释放会连锁反应
        jframe.setLocationRelativeTo(null);//窗口居中显示
        jframe.setResizable(false);//设置窗口是否可以改变大小
        jframe.setVisible(true);//设置窗体可见
        //jPanel5.setBackground(Color.RED); // 设置面板颜色为红色背景
        jframe.setLayout(null);//设置窗体布局为绝对布局

        bupdata2 = new JButton("确认修改");//创建"确认修改"按钮
        bupdata2.setFont(font2);//设置按钮字体大小格式
        bupdata2.setBounds(244, 525, 180, 65);//设置"确认修改"按钮位置大小
        jframe.add(bupdata2);//添加"确认修改"按钮到窗体


        jLabel3 = new JLabel("图书名称修改为");//图书名称文本域
        jLabel3.setFont(font2);//设置文本域字体大小格式
        jLabel3.setBounds(83, 10, 220, 55);//设置文本域的出现位置以及大小
        jframe.add(jLabel3);//将文本域3添加到jframe窗体中

        textField3 = new JTextField();//updata面板 文本框，信息为需要修改的图书名字
        textField3.setFont(font2);//设置文本域字体大小格式
        textField3.setBounds(320, 10, 280, 55);//图书名字文本框位置大小设定
        textField3.setText(MainApp.staticdata.bokname);//设置文本框默认文字信息，此处为书的名称
        jframe.add(textField3);//将文本框3添加到jframe窗体中


        jLabel4 = new JLabel("图书作者修改为");//图书作者文本域
        jLabel4.setFont(font2);//设置文本域字体大小格式
        jLabel4.setBounds(83, 110, 220, 55);//设置文本域的出现位置以及大小
        jframe.add(jLabel4);//将文本域4添加到jframe窗体中

        textField4 = new JTextField();//updata面板 文本框，信息为需要修改的图书作者
        textField4.setFont(font2);//设置文本域字体大小格式
        textField4.setBounds(320, 110, 280, 55);//图书名字文本框位置大小设定
        textField4.setText(MainApp.staticdata.bokauthor);//设置文本框默认文字信息，此处为书的作者
        jframe.add(textField4);//将文本框4添加到jframe窗体中


        jLabel5 = new JLabel("图书价格修改为");//图书价格文本域
        jLabel5.setFont(font2);//设置文本域字体大小格式
        jLabel5.setBounds(83, 210, 220, 55);//设置文本域的出现位置以及大小
        jframe.add(jLabel5);//将文本域5添加到jframe窗体中

        textField5 = new JTextField();//updata面板 文本框，信息为需要修改的图书价格
        textField5.setFont(font2);//设置文本域字体大小格式
        textField5.setBounds(320, 210, 280, 55);//图书名字文本框位置大小设定
        textField5.setText(MainApp.staticdata.bokprice.toString());//设置文本框默认文字信息，此处为书的价格
        jframe.add(textField5);//将文本框5添加到jframe窗体中


        jLabel6 = new JLabel("图书数量修改为");//图书数量文本域
        jLabel6.setFont(font2);//设置文本域字体大小格式
        jLabel6.setBounds(83, 310, 220, 55);//设置文本域的出现位置以及大小
        jframe.add(jLabel6);//将文本域6添加到jframe窗体中

        textField6 = new JTextField();//updata面板 文本框，信息为需要修改的图书数量
        textField6.setFont(font2);//设置文本域字体大小格式
        textField6.setBounds(320, 310, 280, 55);//图书数量文本框位置大小设定
        textField6.setText((String.valueOf(MainApp.staticdata.bokamount)));//设置文本框默认文字信息，此处为书的作者
        jframe.add(textField6);//将文本框6添加到jframe窗体中


        jLabel7 = new JLabel("图书类型修改为");//图书类型文本域
        jLabel7.setFont(font2);//设置文本域字体大小格式
        jLabel7.setBounds(83, 410, 220, 55);//设置文本域的出现位置以及大小
        jframe.add(jLabel7);//将文本域7添加到jframe窗体中

        textField7 = new JTextField();//updata面板 文本框，信息为需要修改的图书类型
        textField7.setFont(font2);//设置文本域字体大小格式
        textField7.setBounds(320, 410, 280, 55);//图书名字文本框位置大小设定
        textField7.setText(MainApp.staticdata.boktype);//设置文本框默认文字信息，此处为书的类型
        jframe.add(textField7);//将文本框7添加到jframe窗体中
        jframe.repaint();//重绘界面



        bupdata2.addMouseListener(new MouseListener() {//为修改按钮添加鼠标监听事件
            @Override
            public void mouseClicked(MouseEvent e) {//鼠标单击事件

                String BOKname = Gain.gain(textField3);//获取图书名称文本框中的内容

                String BOKauthor = Gain.gain(textField4);//获取图书作者文本框中的内容

                BigDecimal BOKprice =   BigDecimal.valueOf(Double.parseDouble(Gain.gain(textField5)));//获取图书价格文本框中的内容


                int BOKamount =Integer.parseInt(Gain.gain(textField6));//获取图书数量文本框中的内容

                String BOKtype = Gain.gain(textField7);//获取图书类型文本框中的内容

                new UpdataTableDAO().updata2(BOKname,BOKauthor,BOKprice,BOKamount,BOKtype);//传入参数以进行修改数据库信息

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
        //---



        jframe.repaint();//重绘界面

        jframe.addWindowListener(new WindowAdapter() {//添加窗体监听器

            public void windowClosing(WindowEvent e) {//窗口关闭时执行的代码
                super.windowClosing(e);
                MainApp.staticdata.countupdata = 0;  //countup重置为0
            }

        });




    }


    }
