package com.nan.view.index;

import com.nan.tool.Only;
import com.nan.view.book.See2;
import com.nan.view.lend.Lend;
import com.nan.view.lend.LendWater;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 读者图书管理系统主界面，此界面应该包括三个功能
 * 图书查询，图书借阅，借阅流水，三个功能
 */
public class ReaderIndex extends JFrame {

    //首先声明要使用到的组件
    private JPanel jPanel;//面板对象
    private JLabel jLabel;//图书管理系统总标题

    /**
     * 借阅系统组件声明
     */
    private JButton bjy;//借阅书籍按钮
    private JButton bjyls;//借阅流水

    /**
     * 图书查询
     */
    private JButton bse;//查看图书按钮

    /**
     * 读者图书管理系统，
     */
    public void readerIndex(){
        Font font = new Font("Serif", Font.BOLD, 45);//设置文字大小
        Font font2 = new Font("Serif", Font.BOLD, 28);//设置文字大小
        jLabel = new JLabel("图书管理系统读者端");//创建文本域，显示"图书管理系统"6个大字

        jPanel = new JPanel();//创建面板对象
        jPanel.setSize(300, 650);//设置面板对象的大小
        getContentPane().add(jPanel);//面板加入到显示容器中
        setTitle("图书管理系统 读者端   v4.0.0");//设置窗口标题
        setSize(500,550);//设置窗口大小
        setResizable(false);//设置窗口是否可以改变大小
        setLocationRelativeTo(null);//窗口居中显示
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口关闭方式
        jPanel.setLayout(null);//面板布局样式
        this.setVisible(true);//设置容器窗口可见

        jLabel.setFont(font);//图书管理系统总标题文字大小
        jLabel.setForeground(Color.RED);//设置字体颜色
        jLabel.setBounds(33, -70, 500, 200);//"图书管理系统"总标题位置大小设定
        bse = new JButton("图书查询");//图书查询按钮创建

        jPanel.add(jLabel);//文本域添加到面板容器"图书管理系统大标题"

        bse = new JButton("图书查询");//图书查询按钮创建
        bse.setFont(font2);//按钮文字采用28号
        bse.setBounds(150, 140, 180, 65);//按钮的X，Y坐标，以及按钮的长,宽
        jPanel.add(bse);//按钮添加到面板容器

        /**
         * 借阅系统如下
         */
        bjy = new JButton("图书借阅");//图书借阅按钮创建
        bjyls = new JButton("借阅流水");//借阅流水按钮创建
        bjy.setFont(font2);//按钮文字采用28号
        bjyls.setFont(font2);//按钮文字采用28号

        bjy.setBounds(150,230,180,65);//图书借阅按钮位置大小设定  y+了90
        bjyls.setBounds(150,320,180,65);//图书借阅按钮位置大小设定

        jPanel.add(bjy);//借阅按钮添加到面板容器
        jPanel.add(bjyls);//借阅流水按钮添加到面板容器

        //此后记得添加按钮的监听事件
        /**
         * 按钮事件添加
         */
        bse.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (Only.SeeCount == 0) {//如果查询窗口不存在，数值0表示不存在,不存在则创建窗口
                    //staticdata.count = 1;//设置窗口状态为1，表示窗口已经存在
                    new See2().see2();//调用see查询功能的第二个版本类文件//实例化类以及调用该类的方法、

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
        });//see end

        bjyls.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {



                if (Only.lendWaterCount == 0) {//如果借阅流水窗口不存在，0表示不存在，不存在则创建借阅流水窗口
                    //staticdata.countlendwater = 1;//设置借阅流水窗口存在，1表示存在

                    new LendWater().lendWater();//借阅流水窗口new，借阅系统的设置
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


        bjy.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {


                if (Only.jyCount == 0) {//如果新增图书窗口不存在，0表示不存在，不存在则创建新增图书窗口
//                    staticdata.countjy = 1;//设置新增图书窗口存在，1表示存在

                    new Lend().lend();//借阅窗口new，借阅系统的设置
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

    }






}
