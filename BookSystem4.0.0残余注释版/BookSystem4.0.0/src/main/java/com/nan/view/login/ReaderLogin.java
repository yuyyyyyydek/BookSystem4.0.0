package com.nan.view.login;

import com.nan.middle.ReadLoginMid;
import com.nan.tool.JTextFieldLimit;
import com.nan.tool.Only;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.nan.tool.Gain.gain;
import static com.nan.tool.Gain.gain2;
import static com.nan.tool.Only.readerUserAddCount;

/**
 * 读者的登录窗口
 */

public class ReaderLogin extends JFrame {
    /**
     * 声明所有要使用的组件
     * 账号文本框，密码文本框，显示"账号","密码"文字,"登录"，"注册"按钮，
     */

    private static JTextField textFieldL;//账号文本框
    private static JPasswordField jPassword;//密码文本框
    private JLabel jLabel;//显示账号文字
    private JLabel jLabel2;//显示密码文字
    private JButton bLogin;//登录按钮，账号登录按钮
    private JButton bregister;//注册账号按钮,这里换一下
    private  String account;//账号字符串
    private  String password;//密码字符串

    //新增组件-->
    private JLabel jLabel3;//"图书管理系统读者端登录"文本声明
    private JButton badmini;//管理员登录按钮，

    Font font = new Font("Serif",Font.BOLD,20);//设置文字大小

    private  String getAccount() {//获取账号信息
        account = gain(textFieldL);//gain方法获取文本框textFieldL中的内容，内容存储在account中
        return account;//返回account 给调用者
    }

    private  String getPassword() {//获取密码信息
        password = gain2(jPassword);//gain2方法获取密码框jPassword中的内容,内容存储在password中
        return password;//返回password 给调用者
    }

    /**
     * void initFrame()
     * 初始化登录界面，登录界面的编写
     */
    public void login() {
        setTitle("读者登录   图书管理系统读者端v4.0.0");//设置登录窗口标题
        setSize(400, 350);//设置登录窗体大小
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
        textFieldL.setBounds(120, 60, 200, 30);//账户文本框位置大小设定
        jPassword.setBounds(120, 110, 200, 30);//密码文本框位置大小设定
        jLabel = new JLabel("读者账号");//实例化账号文字文本域
        jLabel2 = new JLabel("读者密码");//实例化密码文字文本域
        jLabel3 = new JLabel("图书管理系统读者端登录");//实例化该文本域，内容为"图书管理系统读者端登录"
        Font font = new Font("Serif", Font.BOLD, 22);//设置字体大小
        jLabel.setFont(font);//应用账户文字大小
        jLabel2.setFont(font);//应用密码文字大小
        jLabel3.setFont(font);//设置"图书管理系统登录"的字体大小
        jLabel3.setForeground(Color.RED);//"图书管理系统读者端登录"设置颜色为红色
        jLabel.setBounds(15, 24, 100, 100);//账号文本框位置大小设定
        jLabel2.setBounds(15, 75, 100, 100);//密码文本框位置大小设定
        jLabel3.setBounds(60,15,300,30);
        bLogin = new JButton("登陆");//登陆按钮初始化
        bregister = new JButton("注册");//注册按钮
        badmini = new JButton("管理用户");
        bLogin.setSize(110, 40);//设置登陆按钮大小 80  40
        bregister.setSize(110, 40);//设置注册按钮大小  80  40
        badmini.setSize(150,40);
        bLogin.setLocation(63, 170);//设置登陆按钮的位置  90  160
        bregister.setLocation(205, 170);//设置注册按钮的位置     235  160
        badmini.setLocation(110,240);//添加用户登陆按钮到登陆窗体
        bLogin.setFont(font);//设置登陆按钮的字体大小
        bregister.setFont(font);//设置注册按钮字体大小
        badmini.setFont(font);
        add(badmini);
        add(jLabel3);//添加"图书管理系统读者端登录"文本域到登录窗口
        add(jLabel);//添加账户文字到登陆窗口
        add(jLabel2);//添加密码文字到登陆窗口
        add(textFieldL);//添加账户文本框到登陆窗口
        add(jPassword);//添加密码文本框到登陆窗口
        add(bLogin);//添加登陆按钮到登陆窗口
        add(bregister);//添加注册按钮到登陆窗口
        repaint();//重绘画面

        badmini.addActionListener(listener3);
        bLogin.addActionListener(listener);//给登陆按钮添加监听事件
        bregister.addActionListener(listener2);//给注册按钮添加监听事件


    }//init() end

    ActionListener listener = new ActionListener(){//事件监听器

      public void actionPerformed(ActionEvent e){//行为监听

            new ReadLoginMid().readLoginMid(getAccount(),getPassword());//调用中间层 的读者登陆 中间类 ReadLoginMid类 的方法
            if(Only.readerLoginSucceed == 1){//读者登录，该量变为1时，登录窗口隐藏
                setVisible(false);//设置窗口不可见
            }

      }

    };


    ActionListener listener2 = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e){
            //此处跳转到读者注册界面
            if(readerUserAddCount == 0){//注册界面只能存在一个
                new ReaderUserAdd().register();
            }
        }

    };





//    /**
//     * 登陆按钮的事件监听器内容编写
//     */
//    ActionListener listener = new ActionListener() { //事件监听器
//        @Override
//        public void actionPerformed(ActionEvent e) {//行为监听//接收操作事件
//            System.out.println("您输入的账号为:" + getAccount());//显示用户输入的账号
//            System.out.println("您输入的密码为:" + getPassword());//显示用户输入的密码
//
//            LoginDao log = new LoginDao();//实例化LoginDao类
//            java.util.List<User> users = null;//创建list集合//----======》很重要的地方，很难搞，无数次失败才出现这个的成功
//            try {
//                users = log.getAllUsers();//users中存有所有的数据库表中的用户账号密码
//            } catch (ClassNotFoundException ex) {//捕获异常
//                throw new RuntimeException(ex);//异常处理
//            }
//
//            for(User user : users){ //遍历循环User集合
//                //System.out.println("user:" + user.getUsername() + ",pass:" + user.getPassword());//显示数据库中所有账号密码
//                if(user.getUsername().equals(getAccount())){//如果用户输入的账号与数据库中的账号一样，进入此if
//                    if(user.getPassword().equals(getPassword())){//如果用户输入的密码与数据库中的密码一样，进入此if
//                        System.out.println("终于登录成功");
//                        setVisible(false);
//                        new Succeed().succeed();
//                    }
//                }else{
//                    System.out.println("登陆失败，请重新登陆");
//                }
//
//
//            }
//
//
//        }
//    };


//    /**
//     * 注册按钮的事件监听器编写
//     */
//    ActionListener listener2 = new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//
//            if(MainApp.staticdata.countreg == 0) {//如果注册窗口不存在，按下此按钮弹出注册窗口
//                new AddUser().register(); //显示注册窗口
//            }
//
//        }
//    };


    ActionListener listener3 = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            if(Only.adminiLoginWindow == 0) {//如果注册窗口不存在，按下此按钮弹出注册窗口
                new UseriLogin().login(); //显示管理员登陆窗口
                   setVisible(false);
            }
        }
    };




}
