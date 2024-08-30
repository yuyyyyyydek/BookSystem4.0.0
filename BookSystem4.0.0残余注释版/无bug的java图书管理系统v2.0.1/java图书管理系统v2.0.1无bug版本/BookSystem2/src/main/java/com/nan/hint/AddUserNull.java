package com.nan.hint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *新增用户栏中不能有空框
 */
public class AddUserNull {

    //amount方法中的声明项
    private JLabel jLblank;//"账号注册信息中不能有空框"文本域声明
    private JButton bdef;//"账号注册信息中不能有空框"弹出窗的确定按钮
    Font font2 = new Font("Serif", Font.BOLD, 28);//设置文字大小

    //注册信息中不能有空缺文本框
    public void nul(){

        JFrame jframeamount = new JFrame(); //注册账号信息框中不能有空，提示框
        jframeamount.setSize(410, 200);//设置窗体大小
        jframeamount.setTitle("注册内容不能为空");
        jframeamount.setLocationRelativeTo(null);//窗口居中显示
        jframeamount.setResizable(false);//设置窗口是否可以改变大小
        jframeamount.setLayout(null);//设置窗体布局为绝对布局
        jframeamount.setVisible(true);//设置窗体可见
        jframeamount.setAlwaysOnTop(true);//设置窗口前置
        jLblank = new JLabel("账号注册信息中不能有空框");//实例化文本域信息，并初始化信息内容
        jLblank.setFont(font2);//修改提示信息文本域的字体大小格式
        jLblank.setBounds(10,15,400,55);//设置信息文本域出现的位置以及大小
        jframeamount.add(jLblank);//添加文本域到此窗口
        bdef = new JButton("确认信息");//实例化按钮对象并初始化按钮信息
        bdef.setFont(font2);//设置按钮文字大小格式
        bdef.setBounds(100,75,180,55);
        jframeamount.add(bdef);

        //按下按钮关闭窗口
        bdef.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //按钮单击事件
                jframeamount.dispose(); //退出此窗口
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


    }

}
