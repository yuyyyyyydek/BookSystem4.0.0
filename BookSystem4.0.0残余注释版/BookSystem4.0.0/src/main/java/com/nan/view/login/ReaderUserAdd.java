package com.nan.view.login;


import com.nan.middle.ReaderUserAddMid;
import com.nan.tool.Gain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static com.nan.tool.Gain.gain;
import static com.nan.tool.Gain.gain2;
import static com.nan.tool.Only.readerRegisterCount;
import static com.nan.tool.Only.readerUserAddCount;

/**
 * 读者注册账号界面
 */
public class ReaderUserAdd extends JFrame {

    //amount方法中的声明项
    private JLabel jLblank;//"账号注册信息中不能有空框"文本域声明
    private JButton bdef;//"账号注册信息中不能有空框"弹出窗的确定按钮

    /**
     * 声明使用的组件
     */
    private String addReaderAccount;//新注册的读者账号，接收数据用的字符串

    private String addReaderPass;//新注册的读者密码，接收数据用的字符串

    private String account;	//读者账号字符串
    private String password;//读者密码字符串

    Font font2 = new Font("Serif", Font.BOLD, 28);//设置文字大小

    private JButton bre;//按钮1  重置为空信息

    private JButton blog;//注册按钮 的声明

    private JLabel jLaccount;//请输入您的读者账号
    private JLabel jLpass;//请输入您的读者密码

    private JLabel jLaccount2;//请输入用户的账号

    private JLabel jLpass2;//请输入用户的密码

    private JTextField textField;//文本框，信息为输入的读者注册账号

    private JTextField textField2;// 文本框，信息为输入的读者注册账号的密码

    private JTextField jUser;//文本框，信息为输入的用户账号

    //private JTextField textField4;//文本框，信息为输入的管理员密码
    private JPasswordField jPassword;//密码文本框 用户密码用这个


    private  String getAccount() {//获取读者账号信息
        account = gain(textField);//gain方法获取账号文本框textField中的内容，内容存储在account中
        return account;//返回account 给调用者
    }

    private  String getPassword() {//获取读者密码信息
        password = gain(textField2);//gain方法获取密码框jPassword中的内容,内容存储在password中
        return password;//返回password 给调用者
    }

    private String getDatabaseAccount(){//获取用户账号信息
        addReaderAccount = gain(jUser);//使用gain方法获取用户账号文本框中的数据信息
        return addReaderAccount; //返回获取到的用户账号文本框中的数据
    }

    private String getDatabasePassword(){//获取用户密码信息
        addReaderPass = gain2(jPassword);//使用gain方法获取用户密码文本框中的数据信息
        return addReaderPass;// 返回获取到的用户密码文本框中的数据
    }


    public void register() {
        //MainApp.staticdata.countreg = 1;
        readerUserAddCount = 1;// 设置该窗口是否存在，1表示存在

        setTitle("读者账户注册");//设置窗口标题
        setSize(500,440);//设置窗口大小
        setLayout(null);//设置窗口布局
        setResizable(false);//设置窗口是否可以改变大小
        this.setLocationRelativeTo(null);//窗口居中显示
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗体关闭方式
        setVisible(true);//设置窗口可见
        jLaccount = new JLabel("读者账号");//实例化账号文本域，并为账号文本域赋值
        jLaccount.setFont(font2);//设置账号文本域的文字的大小格式
        jLaccount.setBounds(20,20,220,55);//账号文本域的位置大小设置
        jLpass = new JLabel("读者密码");//实例化密码文本域,并为密码文本域赋值
        jLpass.setFont(font2);//设置密码文本域的字体大小格式
        jLpass.setBounds(19,95,220,55);//密码文本域的位置大小设置
        jLaccount2 = new JLabel("用户账号");//实例化文本域  管理员账户文本域
        jLaccount2.setFont(font2);//管理员账号文本域文字大小格式设置
        jLaccount2.setBounds(20,160,220,55);//设置管理员账号文本域的位置大小
        jLpass2 = new JLabel("用户密码");//实例化文本域 管理员密码文本域
        jLpass2.setFont(font2);//管理员密码文本域字体大小设置
        jLpass2.setBounds(20,230,220,55);//设置管理员密码文本域的位置大小
        add(jLpass2);//将“管理员密码”文本域添加到窗口
        add(jLaccount2);//将“管理员账户”文本域添加到窗口
        add(jLpass);//将“密码”文本域添加到窗口
        add(jLaccount); //将"账号"文本域添加到窗口
        textField = new JTextField();//实例化文本框，该文本框为 输入的账号
        textField.setFont(font2);//为文本框设置字体大小格式
        textField.setBounds(150,20,280,55);//账号文本框的位置大小设置
        textField2 = new JTextField();//实例化密码文本框，该文本框为 输入的密码
        textField2.setFont(font2);//为密码文本框设置文字大小格式
        textField2.setBounds(150,95,280,55);//密码文本框位置大小格式
        jUser = new JTextField();//管理员账户文本框实例化文本框对象
        jUser.setFont(font2);//管理员账号文本框设置字体大小格式
        jUser.setBounds(150,160,280,55);//管理员账户文本框大小位置
        jPassword = new JPasswordField();//管理员密码文本框 实例化文本框对象
        jPassword.setFont(font2);//管理员密码文本框 字体大小格式的设置
        jPassword.setBounds(150,230,280,55);//管理员密码文本框大小位置
        add(textField);//将账号文本框添加到窗口
        add(textField2);//将密码文本框添加到窗口
        add(jUser);//将管理员账号文本框添加到窗口
        add(jPassword);//将管理员密码文本框添加到窗口
        bre = new JButton("重置信息");//按钮实例化，按钮为重置注册信息按钮
        bre.setFont(font2);//重置按钮文字大小格式的设置
        bre.setBounds(40,310,170,55);
        blog = new JButton("注册账号");//注册账户的按钮  实例化
        blog.setFont(font2);//注册账户的按钮字体大小格式设置
        blog.setBounds(270,310,170,55);
        add(blog);//将注册按钮添加到窗口中
        add(bre);//将重置按钮添加到注册窗口中
        blog.addActionListener(listener);//给注册账号按钮添加监听事件

        repaint();//窗口重绘

        bre.addMouseListener(new MouseListener() {//为重置按钮添加鼠标监听器
            @Override
            public void mouseClicked(MouseEvent e) {//添加鼠标单击事件
                textField.setText("");//将账号文本框设置为空
                textField2.setText("");//将密码文本框设置为空
                jUser.setText("");//将管理员账号文本框设置为空
                jPassword.setText("");//将管理员密码文本框设置为空

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
                readerUserAddCount = 0;//读者注册窗口只能存在一个，0表示该窗口不存在
            }

        });




    }//register注册方法  end

    ActionListener listener = new ActionListener(){//声明事件监听器
      public void actionPerformed(ActionEvent e){//添加事件

          ReaderUserAddMid readerUserAddMid = new ReaderUserAddMid(); //实例化读者添加的中间类
          try {
              //调用读者添加中间类，将信息传进去，以进行注册账号，前两个形式参数为填入的账号和密码，后两个参数是数据库中的账号密码
              //readerUserAddMid.readerUserAddMid(getAccount(),getPassword(),getDatabaseAccount(),getDatabasePassword());
              readerUserAddMid.readerUserAddMid(getAccount(),getPassword(),getDatabaseAccount(),getDatabasePassword());


          } catch (ClassNotFoundException ex) {
              throw new RuntimeException(ex);
          }

      }
    };










//    ActionListener listener = new ActionListener() {//添加事件监听
//
//        @Override
//        public void actionPerformed(ActionEvent e) {//重写方法
//            account= Gain.gain(jAdmini);//调用此方法获取管理员账号文本框信息
//            System.out.println("您输入的账号为" + account);//输出管理员用户输入的账号
//            password = Gain.gain2(jPassword);//获取管理员密码框中的内容信息
//
//            System.out.println("您输入的密码为：" + password);//输出管理员用户输入的密码
//
//
//            addAccount = Gain.gain(textField);//将从新注册账号的账号文本框获取的文本信息赋值到已经声明的注册账号字符串中
//            addPass = Gain.gain(textField2);//将从新注册账号的密码文本框获取的文本信息赋值到已经声明的注册账号的密码字符串中
//
//            if(new AddUserAdminiDAO().jdbc(account,password))  {  //管理员账号密码和数据库横纵的密码进行比对
//
//                new AddUserDAO().addUser(addAccount,addPass);
//                MainApp.staticdata.countreg = 0;//设置此注册窗口不存在，重置为0方便下次创建
//                dispose();
//
//
//            }
//
//
//        }
//    };//listener  END

}
