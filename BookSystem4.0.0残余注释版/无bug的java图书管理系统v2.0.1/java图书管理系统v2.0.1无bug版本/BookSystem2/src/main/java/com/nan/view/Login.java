package com.nan.view;

import com.nan.dao.LoginDao;
import com.nan.dao.User;
import com.nan.hint.Succeed;
import com.nan.tool.JTextFieldLimit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static com.nan.tool.Gain.gain;
import static com.nan.tool.Gain.gain2;

/**
 * 登陆窗口
 */
public class Login extends JFrame {
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
    void login() {
        setTitle("登录      图书管理系统v1.5");//设置登录窗口标题
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
        textFieldL.setBounds(120, 40, 200, 30);//账户文本框位置大小设定
        jPassword.setBounds(120, 90, 200, 30);//密码文本框位置大小设定
        jLabel = new JLabel("账号");//显示账号文字
        jLabel2 = new JLabel("密码");//显示密码文字
        Font font = new Font("Serif", Font.BOLD, 22);//设置字体大小
        jLabel.setFont(font);//应用账户文字大小
        jLabel2.setFont(font);//应用密码文字大小
        jLabel.setBounds(50, 4, 50, 100);//账号文本框位置大小设定
        jLabel2.setBounds(50, 55, 50, 100);//密码文本框位置大小设定
        bLogin = new JButton("登陆");//登陆按钮初始化
        bregister = new JButton("注册");//注册按钮
        bLogin.setSize(80, 40);//设置登陆按钮大小
        bregister.setSize(80, 40);//设置注册按钮大小
        bLogin.setLocation(80, 150);//设置登陆按钮的位置
        bregister.setLocation(225, 150);//设置注册按钮的位置
        bLogin.setFont(font);//设置登陆按钮的字体大小
        bregister.setFont(font);//设置注册按钮字体大小
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

    /**
     * 登陆按钮的事件监听器内容编写
     */
    ActionListener listener = new ActionListener() { //事件监听器
        @Override
        public void actionPerformed(ActionEvent e) {//行为监听//接收操作事件
            System.out.println("您输入的账号为:" + getAccount());//显示用户输入的账号
            System.out.println("您输入的密码为:" + getPassword());//显示用户输入的密码

            LoginDao log = new LoginDao();//实例化LoginDao类
            java.util.List<User> users = null;//创建list集合//----======》很重要的地方，很难搞，无数次失败才出现这个的成功
            try {
                users = log.getAllUsers();//users中存有所有的数据库表中的用户账号密码
            } catch (ClassNotFoundException ex) {//捕获异常
                throw new RuntimeException(ex);//异常处理
            }

            for(User user : users){ //遍历循环User集合
                //System.out.println("user:" + user.getUsername() + ",pass:" + user.getPassword());//显示数据库中所有账号密码
                if(user.getUsername().equals(getAccount())){//如果用户输入的账号与数据库中的账号一样，进入此if
                    if(user.getPassword().equals(getPassword())){//如果用户输入的密码与数据库中的密码一样，进入此if
                        System.out.println("终于登录成功");
                        setVisible(false);
                        new Succeed().succeed();
                    }
                }else{
                    System.out.println("登陆失败，请重新登陆");
                }


            }




        }
    };

    /**
     * 注册按钮的事件监听器编写
     */
    ActionListener listener2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(MainApp.staticdata.countreg == 0) {//如果注册窗口不存在，按下此按钮弹出注册窗口
                new AddUser().register(); //显示注册窗口
            }

        }
    };




}
