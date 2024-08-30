package com.nan.hint;

import com.nan.view.MainApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 删除图书信息成功窗口
 */
public class DelWin {
    Font font2 = new Font("Serif", Font.BOLD, 28);//设置文字大小
    public void win(){
        MainApp.staticdata.countdewin = 1;//本窗体是否已经存在以及只能存在一个该窗体的判断代码
        JButton win;//声明一个按钮
        JLabel jLabel ;//登录成功的提示
        JFrame jwin = new JFrame();//创建一个窗体对象
        jwin.setTitle("删除图书信息成功");
        jwin.setLayout(null);//设置窗体布局管理器为绝对布局
        jwin.setSize(400,280);//设置窗体大小
        jwin.setLocationRelativeTo(null);//窗口居中显示
        jwin.setResizable(false);//设置窗口是否可以改变大小
        jLabel = new JLabel("删除图书信息成功");//实例化文本域
        win = new JButton("确定");//实例化一个按钮
        win.setFont(font2);//设置按钮字体大小样式
        jLabel.setFont(font2);//设置文本域字体大小样式
        jLabel.setBounds(76,-28,250,200);//设置成功信息文字的大小和位置
        win.setBounds(96,134,180,55);//设置确定按钮的大小和位置
        jwin.add(win);//添加确认按钮到窗体
        jwin.add(jLabel);//将文本域加入到成功窗体中
        jwin.setVisible(true);//设置弹出的窗体可见
        win.addMouseListener(new MouseListener() {//定义修改成功窗口中按钮的监听事件
            @Override
            public void mouseClicked(MouseEvent e) {//鼠标单击事件
                jwin.dispose();//jwin窗体关闭
                MainApp.staticdata.countdewin = 0;//将验证是否存在此窗口的判断重置为0，方便下次再次弹出成功信息窗口
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

        //设置窗体关闭执行的代码
        jwin.addWindowListener(new WindowAdapter() {//添加窗体监听器

            public void windowClosing(WindowEvent e) {//窗口关闭时执行的代码
                super.windowClosing(e);
                MainApp.staticdata.countdewin = 0;  //countup重置为0
            }

        });

    }   //win  end

}
