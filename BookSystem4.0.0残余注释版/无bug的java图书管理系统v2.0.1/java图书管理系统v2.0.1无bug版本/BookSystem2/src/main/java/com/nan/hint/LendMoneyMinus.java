package com.nan.hint;

import com.nan.view.MainApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 此窗体为借阅操作失败后的警告窗口，表示押金价格不能低于图书价格以及借阅图书数量为0
 */
public class LendMoneyMinus extends JFrame {
        Font font2 = new Font("Serif", Font.BOLD, 24);//设置文字大小
        Font font = new Font("Serif", Font.BOLD, 28);//设置文字大小
        JLabel jLabel;//文本域标签，内容为：押金不能低于价格或图书数量为0
        JButton ben;//确认按钮，

    public void lendMoneyMinus(){
        MainApp.staticdata.countjymoneyminus = 1;
        JFrame jframelendmoney = new JFrame();
        setSize(470,200);//设置窗体大小
        setTitle("押金不能低于价格或图书数量为0");//标题内容
        setLocationRelativeTo(null);//窗体居中显示
        setResizable(false);//设置窗体不可改变大小
        setLayout(null);//设置窗体布局为绝对布局
        setVisible(true);//设置窗体可见
        setAlwaysOnTop(true);//设置窗体前置
        jLabel = new JLabel("押金不能低于图书价格或图书数量已为0");//押金不能低于价格或图书数量为0   的标签
        jLabel.setFont(font2);//设置标签字体大小
        jLabel.setBounds(10,15,500,55);//押金不能低于价格或图书数量为0  标签大小位置设定
        add(jLabel);//将标签加入到窗体中

        ben = new JButton("确认信息");//实例化按钮对象并初始化按钮信息
        ben.setFont(font);//设置标签字体大小
        ben.setBounds(129,80,180,55);
        add(ben);

        //为ben，确认按钮 添加事件

        ben.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                MainApp.staticdata.countjymoneyminus = 0;
                //按钮单击事件
                    dispose();//关闭窗口

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



        //押金不能低于价格的警告界面关闭后，是否存在一个该窗口的静态变量要恢复为0，方便下次判断
        this.addWindowListener(new WindowAdapter() {//添加窗体监听器

            public void windowClosing(WindowEvent e) {//窗口关闭时执行的代码
                super.windowClosing(e);
                MainApp.staticdata.countjymoneyminus = 0;  //countjymoneyminus重置为0
            }

        });

    }

}
