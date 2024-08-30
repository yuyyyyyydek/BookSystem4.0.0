package com.nan.hint;

import com.nan.view.MainApp;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 登陆成功五秒跳转画面窗口
 */
public class Succeed extends JFrame {
    /**
     * 先声明要使用到的组件
     */
    private JLabel jLabel;//登陆成功的提示
    private JLabel jLabel2;//登陆所需时长的提示

    /**
     * 设置窗体基本信息
     */
    public void succeed(){
        setTitle("登陆成功   图书管理系统v1.5");//设置窗口标题
        setSize(400,280);//设置窗口大小
        setLayout(null);//设置窗口布局，不使用任何布局管理方式
        setResizable(false);//设置窗口是否可以改变大小，false不可改变窗口大小
        this.setLocationRelativeTo(null);//窗口居中显示
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口关闭方式
        setVisible(true);//设置窗体可见
        jLabel = new JLabel("您已经登陆成功");//文本域，登陆成功的信息
        jLabel2 = new JLabel("将在三秒后登陆");//文本域,登陆显示延迟时间的信息
        Font font = new Font("Serif",Font.BOLD,22);//设置文字大小格式
        jLabel.setFont(font);//设置文本字体大小
        jLabel2.setFont(font);//设置文本字体大小
        jLabel.setBounds(116,-24,200,200);//设置成功信息文字的位置大小
        jLabel2.setBounds(116,34,200,200);//设置成功登陆延迟时间文字的位置大小
        add(jLabel);//添加文字文本域到窗体
        add(jLabel2);//添加文字文本域到窗体
        repaint();//刷新重绘

/**
 * 定时器任务方法，网上查询得到的
 */
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);//定时器任务方法，网上查询到的
        executor.schedule(new Runnable() {
            @Override
            public void run() {//线程运行
                setVisible(false);//设置注册窗口隐藏
                new MainApp();//创建图书管理系统的主窗体
            }
        }, 3, TimeUnit.SECONDS);    // 五秒钟后执行任务
        executor.shutdown();


    }
}
