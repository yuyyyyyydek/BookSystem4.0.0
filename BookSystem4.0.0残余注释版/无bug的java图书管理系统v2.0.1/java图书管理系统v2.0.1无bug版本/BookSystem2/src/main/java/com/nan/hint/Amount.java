package com.nan.hint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 图书价格与数量不能为负数提示窗口
 */
public class Amount extends JFrame {

    /**
     * 图书数量不能为负数
     */
    private JLabel jLabel;//数量内容不为负数，体术信息框内容

    private JButton bdef;//确认信息按钮，图书数量不为负数窗体的确认按钮

    Font font2 = new Font("Serif", Font.BOLD, 28);//设置文字大小

    //图书数量不为负数：
    public void amount(){

        //图书数量提示框修改内容：
        setSize(410, 200);//设置窗体大小
        setTitle("数量价格不能为负数");
        setLocationRelativeTo(null);//窗口居中显示
        setResizable(false);//设置窗口是否可以改变大小
        setLayout(null);//设置窗体布局为绝对布局
        setVisible(true);//设置窗体可见
        setAlwaysOnTop(true);//设置窗口前置
        jLabel = new JLabel("图书数量与价格不能为负数");//实例化文本域信息，并初始化信息内容
        jLabel.setFont(font2);//修改提示信息文本域的字体大小格式
        jLabel.setBounds(10,15,400,55);//设置信息文本域出现的位置以及大小
        add(jLabel);//添加文本域到此窗口
        bdef = new JButton("确认信息");//实例化按钮对象并初始化按钮信息
        bdef.setFont(font2);//设置按钮文字大小格式
        bdef.setBounds(100,75,180,55);
        add(bdef);

        //按下按钮关闭窗口
        bdef.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //按钮单击事件
                dispose();
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
