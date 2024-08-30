package com.nan.view.userandreader;

import com.nan.middle.SeeUserMid;
import com.nan.tool.Gain;
import com.nan.tool.Only;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 查看所有用户
 */
public class SeeUser extends JFrame{


    SeeUserMid seeUserMid = new SeeUserMid();


    /**
     * 声明要使用到的组件
     */
    private String userText;//查询文本框中的内容
    private JTextField textField;//声明查询文本框
    private JPanel jPanel = new JPanel();//面板，或许用不到
    private JButton bse;//查询按钮
    private JLabel jLabel;//查询文字提醒
    Font font2 = new Font("Serif", Font.BOLD, 28);//设置文字大小

    public void see(){
        Only.seeUserCount = 1;//设置该查询窗口已经存在,1表示存在，0表示不存在

        setSize(890,610);//查询窗口的大小
        setTitle("用户查询");//设置窗口标题
        setLayout(null);//设置窗体布局为绝对布局
        setLocationRelativeTo(null);//c窗口居中显示
        setResizable(false);//设置窗体是否可以改变大小

        jLabel = new JLabel("输入用户账号可查询");//查询提示文字
        bse = new JButton("用户查询");//查询按钮
        textField = new JTextField();//文本框创建,用于输入查询信息内容

        bse.setFont(font2);//查询按钮文字采用28号
        textField.setFont(font2);//查询文本框文字大小使用28号字体
        jLabel.setFont(font2);//查询文本信息字体大小设置

        textField.setBounds(60,250,190,55);//查询文本框位置大小设定
        bse.setBounds(70,100,180,65);//查询按钮位置大小设定
        jLabel.setBounds(22,190,280,55);////查询文本域信息位置大小设定

        add(textField);//添加文本框到面板
        add(bse);//按钮添加到窗体,查询按钮
        add(jLabel);//文本提示信息添加到窗体

        setVisible(true);//设置窗体可见


        jPanel = seeUserMid.seeAllUser();//显示所有信息，调用类方法获得面板内容
        add(jPanel);//添加面板到本窗体
        jPanel.setVisible(true);//面板设置可见
        repaint();//重绘刷新


        bse.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {


                System.out.println(Gain.gain(textField));//输出显示查询文本框中的信息
                userText = Gain.gain(textField);//使用gain方法获得文本框中的内容信息并赋值给booktext

                    jPanel.removeAll();//面板去除所有内容

                    if(userText == null ||userText.equals("")){//如果文本框中为空
                    jPanel.removeAll();//移除面板所有内容
                    jPanel = seeUserMid.seeAllUser();//显示所有信息
                    add(jPanel);//添加面板到窗体
                    jPanel.setVisible(true);//面板设置可见
                    setVisible(true);//窗体设置可见
                    repaint();//重绘刷新

                    }

                    if(userText!=null){//当文本框中的内容不为空的时候，执行此if中的内容
                    jPanel.removeAll();//移除面板所有内容
                    jPanel = seeUserMid.seeUserByName(userText);//根据userText内容查询内容
                    add(jPanel);//面板添加到窗体
                    jPanel.setVisible(true);//设置面板可见
                    setVisible(true);//设置窗体可见
                    repaint();//刷新重绘
                }

                jPanel.setVisible(true);//设置面板可见
                repaint();//刷新重绘


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

        setVisible(true);//设置窗体可见
        repaint();//刷新重绘

        //设置窗体关闭执行的代码
        addWindowListener(new WindowAdapter() {//添加窗体监听器

            public void windowClosing(WindowEvent e) {//窗口关闭时执行的代码
                super.windowClosing(e);
                Only.seeUserCount = 0;  //countup重置为0
            }

        });


    }


}
