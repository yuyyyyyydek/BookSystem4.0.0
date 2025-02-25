package com.nan.view.userandreader;

import com.nan.dao.DelUserByIdDao;
import com.nan.dao.ReaderDao;
import com.nan.tool.Gain;
import com.nan.tool.Only;
import com.nan.tool.StaticData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 删除读者主界面
 */
public class DelReader extends JFrame{


        private String usertext;//接受删除用户ID的文本框


        private String delAccount;//新注册的账号//貌似用不着这行

        private String delPass;//删除账号的密码//貌似用不着这行

        private String account;	//用户账号字符串
        private String password;//用户密码字符串

        Font font2 = new Font("Serif", Font.BOLD, 28);//设置文字大小

        private JButton bse;//查询按钮********

        private JButton bdel;//删除按钮 的声明

        private JLabel jLaccount;//请输入您的读者账号ID
        private JLabel jLName;//显示您的读者账号

//        private JLabel jLaccount2;//请输入管理员的账号
//
//        private JLabel jLpass2;//请输入管理员的密码

        private JTextField textField;//文本框，信息为 输入的删除账号ID

        private JTextField textField2;// 文本框，信息为 指定ID的账号字符串,读者名称，读者账号

        //private JTextField jAdmini;//文本框，信息为输入的管理员账号

        //private JTextField textField4;//文本框，信息为输入的管理员密码
        //private JPasswordField jPassword;//密码文本框 管理员密码用这个


        public void delReaderUser(){


            Only.delReaderUserCount = 1;

            setTitle("删除用户信息");//设置窗口标题
            setSize(500,285);//设置窗口大小
            setLayout(null);//设置窗口布局
            setResizable(false);//设置窗口是否可以改变大小
            this.setLocationRelativeTo(null);//窗口居中显示
            setVisible(true);//设置窗口可见
            jLaccount = new JLabel("读者ID");//实例化账号ID文本域，并为账号文本域赋值
            jLaccount.setFont(font2);//设置账号文本域的文字的大小格式
            jLaccount.setBounds(30,20,220,55);//账号ID文本域的位置大小设置
            jLName = new JLabel("读者为:");//实例化账号内容文本域,初始化内容为  账号为：
            jLName.setFont(font2);//设置密码文本域的字体大小格式
            jLName.setBounds(30,95,220,55);//"账号为"文本域的位置大小设置
            add(jLName);//将“账号为”文本域添加到窗口
            add(jLaccount); //将"账号ID"文本域添加到窗口
            textField = new JTextField();//实例化文本框，该文本框为 输入的账号ID
            textField.setFont(font2);//为文本框设置字体大小格式
            textField.setBounds(150,20,280,55);//账号ID文本框的位置大小设置
            textField2 = new JTextField("此框显示账号信息");//实例化“账号为”文本框，该文本框为 账号为 的账号字符
            textField2.setEnabled(false);//设置此文本框不可使用
            textField2.setFont(font2);//为账号字符文本框设置文字大小格式
            textField2.setBounds(150,95,280,55);//账号字符文本框位置大小格式
            add(textField);//将账号ID文本框添加到窗口
            add(textField2);//将账号为文本框添加到窗口

            bse = new JButton("查询读者");//按钮实例化，按钮为重置查询用户按钮
            bse.setFont(font2);//查询用户按钮文字大小格式的设置
            bse.setBounds(40,170,170,55);
            bdel = new JButton("删除读者");//删除账户的按钮  实例化
            bdel.setFont(font2);//删除账户的按钮字体大小格式设置
            bdel.setBounds(270,170,170,55);
            bdel.setEnabled(false);//删除账号按钮不可用设置
            add(bdel);//将删除账号按钮添加到窗口中
            add(bse);//将查询用户按钮添加到注册窗口中
            //blog.addActionListener(listener);//给注册账号按钮添加监听事件

            bdel.addMouseListener(new MouseListener() {//为删除按钮添加事件监听器
                @Override
                public void mouseClicked(MouseEvent e) {



                    new ReaderDao().delReaderUser();//根据静态变量ID进行删除
                    textField.setText("");
                    textField2.setText("");



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

            repaint();//窗口重绘

            bse.addMouseListener(new MouseListener() {//为重置按钮添加鼠标监听器
                @Override
                public void mouseClicked(MouseEvent e) {//添加鼠标单击事件

                    usertext = Gain.gain(textField);//使用gain方法获得文本框中的内容信息并赋值给booktext


                    new ReaderDao().findDelReaderUser(usertext);//获得需要查询的文本框内容并进行数据库查找,查找书籍的ID
                    textField2.setText(StaticData.delReaderUsername);//修改文本框内容，内容为要修改的书籍名称

                    if(StaticData.delReaderUsername != ""){  //当静态字符串bokname2不为空，bokname2有内容时进行此判断
                        bdel.setEnabled(true);//删除"删除用户"按钮进入激活可按状态
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


            //设置窗体关闭执行的代码
            addWindowListener(new WindowAdapter() {//添加窗体监听器

                public void windowClosing(WindowEvent e) {//窗口关闭时执行的代码
                    super.windowClosing(e);
                    Only.delReaderUserCount = 0;  //countup重置为0
                }

            });



        }//delUser()方法  end



}
