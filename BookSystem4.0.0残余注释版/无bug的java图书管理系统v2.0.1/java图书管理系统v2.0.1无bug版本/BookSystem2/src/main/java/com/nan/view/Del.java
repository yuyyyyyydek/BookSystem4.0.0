package com.nan.view;

import com.nan.dao.DelDAO;
import com.nan.dao.DelSeeDAO;
import com.nan.tool.Gain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 删除数据库图书信息
 */
public class Del extends JFrame{


    /**
     * 首先声明使用的组件
     */
    private String booktext;//接收文本框中的内容

    Font font2 = new Font("Serif", Font.BOLD, 28);//设置文字大小

    private JButton bdelse;//查询删除图书信息按钮，点击后查询到图书的名称

    private JButton bdel;//确认删除图书信息按钮，点击后删除显示出的图书

    private JLabel jLabel;//删除书籍的id 的文本域信息

    private JLabel jLabel2;//删除书籍的图书名称 的文本域信息

    private JTextField textField;//声明删除图书ID的文本框，用来填写图书ID

    private JTextField textField2;//声明删除图书名称的文本框，用来显示图书名称信息

    /**
     * 删除数据库图书信息的图形化界面
     */
    void del(){
        setSize(400, 500);//设置窗体大小
        setTitle("图书删除");
        setLocationRelativeTo(null);//窗口居中显示
        setResizable(false);//设置窗口是否可以改变大小
        setLayout(null);//设置窗体布局为绝对布局
        setVisible(true);//设置窗体可见
        //setAlwaysOnTop(true);//设置窗口前置,不必前置
        jLabel = new JLabel("请填入图书ID以确认");//文本域 提示信息,请填入图书ID以确认
        jLabel2 = new JLabel("请查看图书名称以确认");//文本域 提示信息,请填入图书ID以确认
        jLabel.setFont(font2);//设置文本域字体大小,信息内容为：填写删除图书的ID提示信息
        jLabel2.setFont(font2);//设置文本域字体大小，信息内容为：显示删除图书的图书名称
        jLabel.setBounds(58,10,400,55);//设置文本域提示信息位置大小
        jLabel2.setBounds(48,130,400,55);
        add(jLabel2);
        add(jLabel);//添加文本域至本窗口
        textField = new JTextField();//实例化文本框，此文本框用于填写图书ID
        textField.setFont(font2);//设置文本框的文字大小格式
        textField.setBounds(58,65,280,55);
        textField2 = new JTextField("此处显示图书名称");
        textField2.setFont(font2);//设置文本框的文字大小格式
        textField2.setBounds(58,195,280,55);
        //setLocation(58,65);
        add(textField);//添加文本域到窗口，信息为：要输入的图书ID
        add(textField2);//添加文本域到窗口  信息为：显示要删除图书的图书名称
        bdelse = new JButton("显示图书名称");//实例化按钮对象,按钮信息为:显示图书名称
        bdelse.setFont(font2);//设置按钮文字大小格式
        bdelse.setBounds(83,270,210,65);//设置按钮位置大小，默认的按钮大小为180 65
        bdel = new JButton("确认删除");//实例化按钮对象，按钮信息为：确认删除
        bdel.setFont(font2);//设置按钮文字大小格式
        bdel.setBounds(99,360,180,65);
        //bdel.setEnabled(false);//设置"确认修改"按钮不可用,除非查出来了书籍信息
        bdel.setVisible(false);//设置按钮不可见
        add(bdel);//添加按钮到窗体
        add(bdelse);//将显示图书名称按钮添加到窗体
        repaint();//刷新重绘

        //显示图书名称按下后  需要激活"确认删除"按钮,并且要查询到图书的图书名称
        bdelse.addMouseListener(new MouseListener() {//为鼠标添加监听器
            @Override
            public void mouseClicked(MouseEvent e) {//鼠标单击事件，鼠标单击后执行的代码

                booktext = Gain.gain(textField);//使用gain方法获得文本框中的内容信息并赋值给booktext，删除图书ID的文本框

                new DelSeeDAO().find(booktext);//获得需要查询的文本框内容并进行数据库查找,查找书籍的ID
                textField2.setText(MainApp.staticdata.bokname2);//修改文本框内容，内容为要修改的书籍名称


                if(MainApp.staticdata.bokname2 != ""){  //当静态字符串bokname2不为空，bokname2有内容时进行此判断

                    //bdel.setEnabled(true);//修改"删除图书信息"按钮进入激活可按状态
                    bdel.setVisible(true);//设置删除按钮可见


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

        //按下删除图书按钮，删除图书
        bdel.addMouseListener(new MouseListener() {//为删除图书按钮添加鼠标监听器
            @Override
            public void mouseClicked(MouseEvent e) {//鼠标单击事件

                new DelDAO().del();//传入参数以进行删除数据库信息

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


        //删除界面关闭后，是否存在一个删除窗口的静态变量要恢复为0，方便下次判断
        this.addWindowListener(new WindowAdapter() {//添加窗体监听器

            public void windowClosing(WindowEvent e) {//窗口关闭时执行的代码
                super.windowClosing(e);
                MainApp.staticdata.countdel = 0;  //countup重置为0
            }

        });


    }

}
