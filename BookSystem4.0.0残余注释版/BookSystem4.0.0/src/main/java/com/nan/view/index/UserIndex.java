package com.nan.view.index;


import com.nan.hint.UpdataDef;
import com.nan.tool.Only;
import com.nan.view.book.Add;
import com.nan.view.book.Del;
import com.nan.view.book.See2;
import com.nan.view.book.UpdSee;
import com.nan.view.lend.Lend;
import com.nan.view.lend.LendWater;
import com.nan.view.lend.ReturnBook;
import com.nan.view.login.UserAdd;
import com.nan.view.userandreader.DelReader;
import com.nan.view.userandreader.DelUser;
import com.nan.view.userandreader.SeeReader;
import com.nan.view.userandreader.SeeUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;

/**
 * 图书管理系统主界面,用户端的，图书管理系统用户端主界面
 */
public class UserIndex extends JFrame {


    /**
     * 此代码块为添加菜单栏到窗体中，左上角显示
     */
    {
        setSize(1000,650);//设置窗口大小
        JMenuBar menuBar;//菜单栏
        JMenu menuse;//菜单显示选项  图书系统
        JMenu menuzh;//菜单显示选项  账号管理
        JMenu menulend;//菜单显示选项  图书借阅
        JMenuItem[] jmenuzsgc;//菜单操作选项
        menuBar = new JMenuBar();//创建菜单栏
        menuse = new JMenu("图书系统");//创建菜单选项"图书系统"
        menulend = new JMenu("图书借阅");//创建菜单选项"借阅系统"
        menuzh = new JMenu("账号管理");//创建菜单选项"账号管理"
        menuBar.add(menuse);//添加图书系统到菜单栏

        menuBar.add(menulend);//添加图书借阅系统菜单栏到窗体
        menuBar.add(menuzh);//添加用户管理到菜单栏
        JMenuItem jmenuzsgcse = new JMenuItem("图书查询");//图书查询菜单选项
        JMenuItem jmenuzsgcup = new JMenuItem("图书修改");//图书修改菜单选项
        JMenuItem jmenuzsgcde = new JMenuItem("图书删除");//图书删除菜单选项
        JMenuItem jmenuzsgcin = new JMenuItem("图书增添");//图书增添菜单选项
        JMenuItem jmenulend = new JMenuItem("图书借阅");//图书借阅菜单项
        JMenuItem jmenureturn = new JMenuItem("图书归还");//图书归还菜单项
        JMenuItem jmenulendwater = new JMenuItem("借阅流水");//借阅流水菜单项
        JMenuItem jmenuyhxz = new JMenuItem("新增用户");//图书管理系统使用者增加
        JMenuItem jmenuyhsc = new JMenuItem("删除用户");//图书管理系统使用者删除
        JMenuItem jmenuyhsee = new JMenuItem("查询用户");//图书管理系统使用者查询
        JMenuItem jmenuReaderUserSee = new JMenuItem("查询读者");//图书管理系统读者查询
        JMenuItem jmenuReaderUserDel = new JMenuItem("删除读者");//图书管理系统读者删除
        menuse.add(jmenuzsgcse);//添加图书查询选项到图书管理系统菜单栏中
        menuse.add(jmenuzsgcup);//添加图书修改选项到图书系统菜单栏中
        menuse.add(jmenuzsgcde);//添加图书删除选项到图书系统菜单栏中
        menuse.add(jmenuzsgcin);//添加图书增添选项到图书系统菜单栏中
        menuzh.add(jmenuyhxz);//添加新增用户选项到账号管理菜单栏中
        menuzh.add(jmenuyhsee);//添加查询用户选项到账号管理菜单栏中
        menuzh.add(jmenuyhsc);//添加删除用户选项到账号管理菜单栏中
        menuzh.add(jmenuReaderUserSee);//添加查询读者选项到账号管理菜单栏中
        menuzh.add(jmenuReaderUserDel);//添加删除读者选项到账号管理菜单栏中
        menulend.add(jmenulend);//添加图书借阅选项到用借阅系统菜单栏中
        menulend.add(jmenureturn);//添加图书归还选项到用借阅系统菜单栏中
        menulend.add(jmenulendwater);//添加借阅流水选项到用借阅系统菜单栏中

        this.setJMenuBar(menuBar);//添加菜单栏到主窗体


        /**
         * 该处要添加选项的监听事件，待补
         * 账号管理事件监听器添加，账号管理功能添加
         */

        jmenuReaderUserSee.addActionListener(new ActionListener() {//读者查询，菜单栏选项事件监听器添加
            @Override
            public void actionPerformed(ActionEvent e) {

                //此处添加读者查询功能
                if (Only.seeReaderCount == 0) {//如果查询窗口不存在，数值0表示不存在,不存在则创建窗口
                    new SeeReader().seeReader();//调用see查询功能的第二个版本类文件//实例化类以及调用该类的方法、
                }

            }
        });

        jmenuReaderUserDel.addActionListener(new ActionListener() {//读者删除,菜单栏选项事件监听器添加
            @Override
            public void actionPerformed(ActionEvent e) {

                //此处添加读者删除功能的实现
                if (Only.delReaderUserCount == 0) {//如果查询窗口不存在，数值0表示不存在,不存在则创建窗口
                    new DelReader().delReaderUser();//调用see查询功能的第二个版本类文件//实例化类以及调用该类的方法、
                }

            }
        });


        //以下为用户管理菜单栏的选项按钮，此段添加选项点击事件
        jmenuyhxz.addActionListener(new ActionListener() {//为菜单栏选项"用户新增"添加监听事件
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Only.UserAddCount == 0) {//如果注册用户窗口不存在，按下此按钮弹出注册窗口

                    new UpdataDef().updatadef();//操作失败信息框提示
                    new UserAdd().userAdd(); //显示注册窗口
                }

            }
        });


        jmenuyhsee.addActionListener(new ActionListener(){//查询用户

            @Override
            public void actionPerformed(ActionEvent e) {
                if (Only.seeUserCount == 0) { //如果查询用户窗口不存在，点击此按钮弹出查询用户窗口

                    new SeeUser().see();//创建一个查询用户窗口
                }
            }
        });


        /**
         * 账号删除
         */
        jmenuyhsc.addActionListener(new ActionListener() {//为菜单栏选项"用户删除添加监听事件"
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Only.delUserCount == 0) { //如果删除用户窗口不存在，点击此按钮弹出删除用户窗口
                    //staticdata.countuserdel = 1;
                    new UpdataDef().updatadef();//操作失败信息框提示
                    new DelUser().delUser();//创建一个删除用户窗口
                }
            }
        });


        jmenuzsgcse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Only.SeeCount == 0) {//如果查询窗口不存在，数值0表示不存在,不存在则创建窗口
                    //staticdata.count = 1;//设置窗口状态为1，表示窗口已经存在
                    new See2().see2();//调用see查询功能的第二个版本类文件//实例化类以及调用该类的方法、

                }

            }
        });//添加图书查询选项的点击事件
        jmenuzsgcup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Only.UpdSeeCount == 0) {//如果修改窗口不存在，0表示不存在，不存在则创建修改窗口
                    //staticdata.countup = 1;//修改窗口存在，设置为1,1表示存在窗口
                    new UpdSee().upd();//实例化类以及调用该类的方法、
                }


            }
        });//添加图书修改选项的点击事件
        jmenuzsgcde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Only.DelCount == 0) {//如果图书删除窗口不存在，0表示不存在，不存在则创建删除图书窗口
                    //staticdata.countdel = 1;//设置图书删除窗口已经存在，设置值为1，防止创建多个删除图书的窗口
                    new Del().del();//实例化类以及调用该类的方法
                }


            }
        });//添加图书删除选项的点击事件

        jmenuzsgcin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Only.AddCount == 0) {//如果新增图书窗口不存在，0表示不存在，不存在则创建新增图书窗口
                    //staticdata.countadd = 1;//设置新增图书窗口存在，1表示存在
                    new UpdataDef().updatadef();//操作失败信息框提示
                    new Add().add();//创建新增图书窗口//实例化类以及调用该类的方法
                }

            }
        });//添加图书增添选项的点击事件

        /**
         * 下面为借阅系统添加选项单击事件
         */

        jmenulend.addActionListener(new ActionListener() {//为图书借阅系统选项添加事件监听器
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Only.jyCount == 0) {//如果新增图书窗口不存在，0表示不存在，不存在则创建新增图书窗口
                    new Lend().lend();//借阅窗口new，借阅系统的设置
                }

            }
        });//添加图书借阅系统选项的点击事件

        jmenulendwater.addActionListener(new ActionListener() {//为图书借阅流水选项添加事件监听器
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Only.lendWaterCount == 0) {//如果借阅流水窗口不存在，0表示不存在，不存在则创建借阅流水窗口
                    //staticdata.countlendwater = 1;//设置借阅流水窗口存在，1表示存在

                    new LendWater().lendWater();//借阅流水窗口new，借阅系统的设置
                }

            }
        });//添加借阅流水选项的点击事件


        jmenureturn.addActionListener(new ActionListener() {//为图书归还项添加事件监听器
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Only.ghCount == 0) {//如果归还图书窗口不存在，0表示不存在，不存在则创建借阅流水窗口
//                    staticdata.countgh = 1;//设置归还图书窗口存在，1表示存在

                    new ReturnBook().returnBook();//归还图书窗口new，归还图书窗体的设置
                }

            }
        });//添加图书贵喊选项的点击事件



        repaint();//重绘刷新

    }

    /**
     * 先声明要使用到的组件
     */
    private JLabel jLabelUser;
    private JPanel jPanel;//面板对象
    private JLabel jLabel;//图书管理系统总标题
    private JLabel jLabel2;//图书系统操作总标题
    private JButton bse;//查看图书按钮
    private JButton bup;//修改更修图书按钮
    private JButton bde;//删除图书按钮
    private JButton bin;//增加图书按钮


    /**
     * 借阅系统组件声明
     */
    private JLabel jLabel3;//借阅系统总标题
    private JButton bjy;//借阅书籍按钮
    private JButton bhs;//归还书籍按钮
    private JButton bjyls;//借阅流水
    private JButton bwtj;//未添加

    /**
     * 账号管理系统
     * 组件声明
     */

    private JLabel jLabelReader;//读者管理系统总标题
    private JButton bReaderSee;//读者查询按钮
    private JButton bReaderDel;//读者删除按钮
    private JButton bUserSee;//用户查询按钮
    private JButton bUserDel;//用户删除按钮



    /**
     * 主界面的组件设置方法，主界面窗口的界面设计
     */
    public void mainap(){
        jPanel = new JPanel();//创建面板对象
        getContentPane().add(jPanel);//面板加入到显示容器中
        setTitle("图书管理系统  用户端   v4.0.0");//设置窗口标题
        setSize(1000,650);//设置窗口大小
        setResizable(false);//设置窗口是否可以改变大小
        setLocationRelativeTo(null);//窗口居中显示
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口关闭方式
        this.setVisible(true);//设置容器窗口可见
        jPanel.setVisible(true);//设置面板窗口可见


        jPanel.setSize(300, 650);//设置面板对象的大小
        //jPanel.setLocation(0,0);//窗口居中显示
        jPanel.setLayout(null);//面板布局样式
        jLabel = new JLabel("图书管理系统");//创建文本域，显示"图书管理系统"6个大字
        jLabel2 = new JLabel("图书系统");    //显示图书系统小标题
        jLabelUser = new JLabel("用户端");
        Font font = new Font("Serif", Font.BOLD, 45);//设置文字大小
        Font font2 = new Font("Serif", Font.BOLD, 28);//设置文字大小
        Font font3 = new Font("Serif", Font.BOLD, 20);//设置文字大小
        jLabel.setFont(font);//图书管理系统总标题文字大小
        jLabel2.setFont(font2);//图书操作标题应用文字大小
        jLabelUser.setFont(font3);//文字信息”读者段设置字体大小28号“
        //jLabel.setBounds(374,-60,500,200);//"图书管理系统"总标题位置大小设定
        jLabelUser.setBounds(654,-35,200,150);
        jLabelUser.setForeground(Color.RED);//设置字体颜色
        jPanel.add(jLabelUser);
        jLabel.setBounds(374, -70, 500, 200);//"图书管理系统"总标题位置大小设定
        //jLabel2.setBounds(135,100,180,65);//“图书系统”小标题位置大小设定
        jLabel2.setBounds(135, 60, 180, 65);//“图书系统”小标题位置大小设定
        jLabel.setForeground(Color.RED);//设置字体颜色
        bse = new JButton("图书查询");//图书查询按钮创建
        bup = new JButton("图书修改");//图书修改按钮创建
        bde = new JButton("图书删除");//图书删除按钮创建
        bin = new JButton("图书增添");//图书增添按钮创建
        bse.setFont(font2);//按钮文字采用28号
        bup.setFont(font2);//按钮文字采用28号
        bde.setFont(font2);//按钮文字采用28号
        bin.setFont(font2);//按钮文字采用28号
        bse.setBounds(100, 150, 180, 65);//按钮的X，Y坐标，以及按钮的长,宽
        bup.setBounds(100, 250, 180, 65);//按钮的X，Y坐标，以及按钮的长,宽
        bde.setBounds(100, 350, 180, 65);//按钮的X，Y坐标，以及按钮的长,宽
        bin.setBounds(100, 450, 180, 65);//按钮的X，Y坐标，以及按钮的长,宽
        jPanel.add(bup);//按钮添加到面板容器
        jPanel.add(bse);//按钮添加到面板容器
        jPanel.add(bde);//按钮添加到面板容器
        jPanel.add(bin);//按钮添加到面板容器
        jPanel.add(jLabel2);//文本域添加到面板容器"图书系统"标题
        jPanel.add(jLabel);//文本域添加到面板容器"图书管理系统大标题"


        /**
         * 借阅系统按钮位置设置
         */
        jLabel3 = new JLabel("借阅系统");//借阅系统总标题初始化
        jLabel3.setFont(font2);//图书系统总标题字体设置
        jLabel3.setBounds(730,-8,500,200);//图书系统总标题位置设置
        jPanel.add(jLabel3);//将图书系统总标题放进面板中
        bjy = new JButton("图书借阅");//图书借阅按钮创建
        bhs = new JButton("图书归还");//图书归还按钮创建
        bjyls = new JButton("借阅流水");//借阅流水按钮创建
        bwtj = new JButton("未添加");//未添加按钮创建
        bjy.setFont(font2);//按钮文字采用28号
        bhs.setFont(font2);//按钮文字采用28号
        bjyls.setFont(font2);//按钮文字采用28号
        bwtj.setFont(font2);//按钮文字采用28号
        bjy.setBounds(699,150,180,65);//图书借阅按钮位置大小设定
        bhs.setBounds(699,250,180,65);//图书归还按钮位置大小设定
        bjyls.setBounds(699,350,180,65);//借阅流水按钮位置大小设定
        jPanel.add(bjy);//借阅按钮添加到面板容器
        jPanel.add(bhs);//图书归还按钮添加到面板容器
        jPanel.add(bjyls);//借阅流水按钮添加到面板容器


        /**
         * 账号管理系统按钮位置
         */
        jLabelReader = new JLabel("账号管理");//读者管理总标题
        jLabelReader.setFont(font2);//读者管理总标题的文字大小采用28号
        jLabelReader.setBounds(428,-8,500,200);//图书系统总标题位置设置
        jPanel.add(jLabelReader);//将图书系统总标题放进面板中

        bReaderSee = new JButton("读者查询");//读者查询按钮实例化
        bReaderSee.setFont(font2);//读者查询按钮文字大小采用28号
        bReaderSee.setBounds(400,150,180,65);//读者查询按钮设置大小位置
        jPanel.add(bReaderSee);//将读者查询按钮添加到面板容器

        bReaderDel = new JButton("读者删除");//读者删除按钮实例化
        bReaderDel.setFont(font2);//设置读者删除按钮文字大小，采用28号
        bReaderDel.setBounds(400,250,180,65);//设置读者删除按钮的位置大小
        jPanel.add(bReaderDel);//添加读者删除按钮到面板容器

        bUserSee = new JButton("用户查询");//用户查询按钮实例化
        bUserSee.setFont(font2);//设置用户查询按钮文字大小，采用28号
        bUserSee.setBounds(400,350,180,65);//设置用户查询按钮的位置大小
        jPanel.add(bUserSee);//添加用户查询按钮到面板容器

        bUserDel = new JButton("用户删除");//用户查询按钮实例化
        bUserDel.setFont(font2);//设置用户删除按钮文字大小，采用28号
        bUserDel.setBounds(400,450,180,65);//设置用户删除按钮的位置大小
        jPanel.add(bUserDel);//添加用户删除按钮到面板容器


        /**
         * 账号管理按钮事件添加
         */

        /**
         * 读者查询按钮的事件监听，功能实现
         */
        bReaderSee.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                //此处添加读者查询功能
                if (Only.seeReaderCount == 0) {//如果查询窗口不存在，数值0表示不存在,不存在则创建窗口
                    new SeeReader().seeReader();//调用see查询功能的第二个版本类文件//实例化类以及调用该类的方法、
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

        /**
         * 读者删除按钮的事件监听，功能实现
         */
        bReaderDel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                //此处添加读者删除功能的实现
                if (Only.delReaderUserCount == 0) {//如果查询窗口不存在，数值0表示不存在,不存在则创建窗口
                    new DelReader().delReaderUser();//调用see查询功能的第二个版本类文件//实例化类以及调用该类的方法、
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


        bUserSee.addMouseListener(new MouseListener() {//用户查询按钮添加监听事件，添加功能
            @Override
            public void mouseClicked(MouseEvent e) {

                if (Only.seeUserCount == 0) { //如果查询用户窗口不存在，点击此按钮弹出查询用户窗口
                    new SeeUser().see();//创建一个查询用户窗口
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

        bUserDel.addMouseListener(new MouseListener() {//用户删除按钮 事件监听器添加 ，功能实现
            @Override
            public void mouseClicked(MouseEvent e) {

                if (Only.delUserCount == 0) { //如果删除用户窗口不存在，点击此按钮弹出删除用户窗口
                    new UpdataDef().updatadef();//操作失败信息框提示
                    new DelUser().delUser();//创建一个删除用户窗口
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



        /**
         * 图书系统按钮事件添加
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

        bup.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (Only.UpdSeeCount == 0) {//如果修改窗口不存在，0表示不存在，不存在则创建修改窗口
                    //staticdata.countup = 1;//修改窗口存在，设置为1,1表示存在窗口
                    new UpdSee().upd();//实例化类以及调用该类的方法、
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
        });//bup end

        bde.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {


                if (Only.DelCount == 0) {//如果图书删除窗口不存在，0表示不存在，不存在则创建删除图书窗口
                    //staticdata.countdel = 1;//设置图书删除窗口已经存在，设置值为1，防止创建多个删除图书的窗口
                    new Del().del();//实例化类以及调用该类的方法
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
        });//bde end

        bin.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (Only.AddCount == 0) {//如果新增图书窗口不存在，0表示不存在，不存在则创建新增图书窗口
                    //staticdata.countadd = 1;//设置新增图书窗口存在，1表示存在
                    new UpdataDef().updatadef();//操作失败信息框提示
                    new Add().add();//创建新增图书窗口//实例化类以及调用该类的方法
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
        });//bin end

        repaint();//刷新重绘
        setVisible(true);//设置窗体可见


        /**
         * 借阅系统按钮监听事件添加
         */
        bjy.addMouseListener(new MouseListener() {//图书借阅按钮功能添加
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


        bjyls.addMouseListener(new MouseListener() {//给借阅流水添加事件监听
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

        bhs.addMouseListener(new MouseListener() {//图书归还按钮功能添加
            @Override
            public void mouseClicked(MouseEvent e) {


                if (Only.ghCount == 0) {//如果归还图书窗口不存在，0表示不存在，不存在则创建借阅流水窗口
//                    staticdata.countgh = 1;//设置归还图书窗口存在，1表示存在

                    new ReturnBook().returnBook();//归还图书窗口new，归还图书窗体的设置
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



    }//mainapp() end



}
