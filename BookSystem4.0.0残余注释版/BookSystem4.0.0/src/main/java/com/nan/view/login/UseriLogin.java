package com.nan.view.login;

import com.nan.middle.UserLoginMid;
import com.nan.tool.JTextFieldLimit;
import com.nan.tool.Only;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.nan.tool.Gain.gain;
import static com.nan.tool.Gain.gain2;

/**
 * 管理用户的登陆窗口
 */
public class UseriLogin extends  JFrame{
        /**
         * 所有要使用到的组件的声明
         * 账号文本框，密码文本框，显示账号密码文字,登录注册按钮，以及账号密码文本字符串
         */
        private static JTextField textFieldL;//账号文本框
        private static JPasswordField jPassword;//密码文本框
        private JLabel jLabel;//显示账号文字
        private JLabel jLabel2;//显示密码文字
        private JButton bLogin;//登录按钮，账号登录按钮
        private JButton bregister;//注册账号按钮
        private  String account;//账号字符串
        private  String password;//密码字符串

        //新增内容--->
        private JLabel jLabel3;//图书管理系统管理用户登陆

        Font font = new Font("Serif",Font.BOLD,20);//设置文字大小

        public  String getAccount() {
            account = gain(textFieldL);
            return account;
        }

        public  String getPassword() {
            password = gain2(jPassword);
            return password;
        }

        /**
         * void initFrame()
         * 初始化登录界面，登录界面的编写
         */
        public void login() {
            setTitle("用户登录   图书管理系统用户端v4.0.0");//设置登录窗口标题
            setSize(400, 280);//设置登录窗体大小
            setLayout(null);//设置登录窗口布局，不使用任何布局方式
            setResizable(false);//设置登录窗口是否可以改变大小，这里设置不可以改变
            this.setLocationRelativeTo(null);//设置登录窗口居中显示
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置登录窗口关闭方式
            setVisible(true);//设置登录窗口可见

            textFieldL = new JTextField();//初始化账号文本框
            textFieldL.setFont(font);//账户文本框字体大小设定
            jPassword = new JPasswordField();//初始化密码文本框
            jPassword.setFont(font);//密码文本框字体大小设定
            textFieldL.setDocument(new JTextFieldLimit(15));//设置登陆账户的文字上限
            jPassword.setDocument(new JTextFieldLimit(15));//设置登陆密码的文字上限
            textFieldL.setText("");//设置账户文本框中的文本信息
            //new Remove().remove(textFieldL);//点击文本框，文本消失的方法
            jPassword.setEchoChar('*');//设置密码不可见
            textFieldL.setBounds(120, 70, 200, 30);//账户文本框位置大小设定  y+30
            jPassword.setBounds(120, 130, 200, 30);//密码文本框位置大小设定
            jLabel = new JLabel("用户账号");//显示账号文字
            jLabel2 = new JLabel("用户密码");//显示密码文字
            jLabel3 = new JLabel("图书管理系统用户端登陆");//显示"图书管理系统用户登陆"
            jLabel3.setForeground(Color.RED);//设置文本域的颜色为红色
            Font font = new Font("Serif", Font.BOLD, 22);//设置字体大小
            jLabel3.setFont(font);
            jLabel.setFont(font);//应用账户文字大小
            jLabel2.setFont(font);//应用密码文字大小
            jLabel.setBounds(15, 34, 100, 100);//账号文本框位置大小设定
            jLabel2.setBounds(15, 85, 100, 100);//密码文本框位置大小设定
            bLogin = new JButton("登陆");//登陆按钮初始化
            bregister = new JButton("注册");//注册按钮
            bLogin.setSize(80, 40);//设置登陆按钮大小
            bregister.setSize(80, 40);//设置注册按钮大小
            bLogin.setLocation(80, 180);//设置登陆按钮的位置
            bregister.setLocation(225, 180);//设置注册按钮的位置
            jLabel3.setBounds(60,15,300,30);
            bLogin.setFont(font);//设置登陆按钮的字体大小
            bregister.setFont(font);//设置注册按钮字体大小
            add(jLabel3);
            add(jLabel);//添加账户文字到登陆窗口
            add(jLabel2);//添加密码文字到登陆窗口
            add(textFieldL);//添加账户文本框到登陆窗口
            add(jPassword);//添加密码文本框到登陆窗口
            add(bLogin);//添加登陆按钮到登陆窗口
            add(bregister);//添加注册按钮到登陆窗口
            repaint();//重绘画面


            bLogin.addActionListener(listener);//给登陆按钮添加监听事件
            bregister.addActionListener(listener2);//给注册按钮添加监听事件


        }//init() end


    ActionListener listener = new ActionListener(){//添加事件监听器
            public void actionPerformed(ActionEvent e){
                new UserLoginMid().userLoginMid(getAccount(),getPassword());//创建中间层类检测登陆的账号密码是否正确
                if(Only.UserLoginSucceed == 1){//如果用户的账号密码存在，且与数据库账号密码一致，则可以登陆
                    setVisible(false);//设置本窗口隐藏
                }
            }
    };


    ActionListener listener2 = new ActionListener(){

        public void actionPerformed(ActionEvent e){
            if(Only.UserAddCount == 0){
                new UserAdd().userAdd();
            }
        }

    };



    }



