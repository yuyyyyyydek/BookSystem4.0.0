package com.nan.view;

import com.nan.hint.UpdataDef;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;

/**
 * 图书管理系统主界面
 */
public class MainApp extends JFrame {


    /**
     * 此代码块为添加菜单栏到窗体中，左上角显示
     */
    {
        setSize(1000,650);//设置窗口大小
        JMenuBar menuBar;//菜单栏
        JMenu menuse;//菜单显示选项  图书系统
        JMenu menuyh;//菜单显示选项  用户管理
        JMenu menulend;//菜单显示选项  图书借阅
        JMenuItem[] jmenuzsgc;//菜单操作选项
        menuBar = new JMenuBar();//创建菜单栏
        menuse = new JMenu("图书系统");//创建菜单选项"图书系统"
        menulend = new JMenu("图书借阅");//创建菜单选项"借阅系统"
        menuyh = new JMenu("用户管理");//创建菜单选项"用户管理"
        menuBar.add(menuse);//添加图书系统到菜单栏

        menuBar.add(menulend);//添加图书借阅系统菜单栏到窗体
        menuBar.add(menuyh);//添加用户管理到菜单栏
        JMenuItem jmenuzsgcse = new JMenuItem("图书查询");//图书查询菜单选项
        JMenuItem jmenuzsgcup = new JMenuItem("图书修改");//图书修改菜单选项
        JMenuItem jmenuzsgcde = new JMenuItem("图书删除");//图书删除菜单选项
        JMenuItem jmenuzsgcin = new JMenuItem("图书增添");//图书增添菜单选项
        JMenuItem jmenulend = new JMenuItem("图书借阅");//图书借阅菜单项
        JMenuItem jmenureturn = new JMenuItem("图书归还");//图书归还菜单项
        JMenuItem jmenulendwater = new JMenuItem("借阅流水");//借阅流水菜单项
        JMenuItem jmenuyhxz = new JMenuItem("新增用户");//图书管理系统使用者增加
        JMenuItem jmenuyhsc = new JMenuItem("删除用户");//图书管理系统使用者删除
        menuse.add(jmenuzsgcse);//添加图书查询选项到图书管理系统菜单栏中
        menuse.add(jmenuzsgcup);//添加图书修改选项到图书系统菜单栏中
        menuse.add(jmenuzsgcde);//添加图书删除选项到图书系统菜单栏中
        menuse.add(jmenuzsgcin);//添加图书增添选项到图书系统菜单栏中
        menuyh.add(jmenuyhxz);//添加新增用户选项到用户管理菜单栏中
        menuyh.add(jmenuyhsc);//添加用户删除选项到用户管理菜单栏中
        menulend.add(jmenulend);//添加图书借阅选项到用借阅系统菜单栏中
        menulend.add(jmenulendwater);//添加借阅流水选项到用借阅系统菜单栏中
        menulend.add(jmenureturn);//添加图书归还选项到用借阅系统菜单栏中
        this.setJMenuBar(menuBar);//添加菜单栏到主窗体


        /**
         * 该处要添加选项的监听事件，待补
         */
        //以下为用户管理菜单栏的选项按钮，此段添加选项点击事件
        //以下为用户管理菜单栏的选项按钮，此段添加选项点击事件
        jmenuyhxz.addActionListener(new ActionListener() {//为菜单栏选项"用户新增"添加监听事件
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MainApp.staticdata.countreg == 0) {//如果注册用户窗口不存在，按下此按钮弹出注册窗口
                    staticdata.countreg = 1;
                    new UpdataDef().updatadef();//操作失败信息框提示
                    new AddUser().register(); //显示注册窗口
                }

            }
        });

        jmenuyhsc.addActionListener(new ActionListener() {//为菜单栏选项"用户删除添加监听事件"
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MainApp.staticdata.countuserdel == 0) { //如果删除用户窗口不存在，点击此按钮弹出删除用户窗口
                    staticdata.countuserdel = 1;
                    new UpdataDef().updatadef();//操作失败信息框提示
                    new DelUser().delUser();//创建一个删除用户窗口
                }
            }
        });


        jmenuzsgcse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (staticdata.count == 0) {//如果查询窗口不存在，数值0表示不存在,不存在则创建窗口
                    staticdata.count = 1;//设置窗口状态为1，表示窗口已经存在
                    new See().see2();//调用see查询功能的第二个版本类文件//实例化类以及调用该类的方法、

                }

            }
        });//添加图书查询选项的点击事件
        jmenuzsgcup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (staticdata.countup == 0) {//如果修改窗口不存在，0表示不存在，不存在则创建修改窗口
                    staticdata.countup = 1;//修改窗口存在，设置为1,1表示存在窗口
                    new Upd().upd();//实例化类以及调用该类的方法、
                }


            }
        });//添加图书修改选项的点击事件
        jmenuzsgcde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (staticdata.countdel == 0) {//如果图书删除窗口不存在，0表示不存在，不存在则创建删除图书窗口
                    staticdata.countdel = 1;//设置图书删除窗口已经存在，设置值为1，防止创建多个删除图书的窗口
                    new Del().del();//实例化类以及调用该类的方法
                }


            }
        });//添加图书删除选项的点击事件
        jmenuzsgcin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (staticdata.countadd == 0) {//如果新增图书窗口不存在，0表示不存在，不存在则创建新增图书窗口
                    staticdata.countadd = 1;//设置新增图书窗口存在，1表示存在
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

                if (staticdata.countjy == 0) {//如果新增图书窗口不存在，0表示不存在，不存在则创建新增图书窗口
                    staticdata.countjy = 1;//设置新增图书窗口存在，1表示存在

                    new Lend().lend();//借阅窗口new，借阅系统的设置
                }

            }
        });//添加图书借阅系统选项的点击事件

        jmenulendwater.addActionListener(new ActionListener() {//为图书借阅流水选项添加事件监听器
            @Override
            public void actionPerformed(ActionEvent e) {

                if (staticdata.countlendwater == 0) {//如果借阅流水窗口不存在，0表示不存在，不存在则创建借阅流水窗口
                    staticdata.countlendwater = 1;//设置借阅流水窗口存在，1表示存在

                    new LendWater().lendWater();//借阅流水窗口new，借阅系统的设置
                }

            }
        });//添加借阅流水选项的点击事件


        jmenureturn.addActionListener(new ActionListener() {//为图书归还项添加事件监听器
            @Override
            public void actionPerformed(ActionEvent e) {

                if (staticdata.countgh == 0) {//如果归还图书窗口不存在，0表示不存在，不存在则创建借阅流水窗口
                    staticdata.countgh = 1;//设置归还图书窗口存在，1表示存在

                    new Return().returnBook();//归还图书窗口new，归还图书窗体的设置
                }

            }
        });//添加图书贵喊选项的点击事件



        setVisible(true);//设置菜单栏可见
        repaint();//重绘刷新
        mainap();//创建图书管理系统总目录总页面

    }

    /**
     * 先声明要使用到的组件
     */
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
     * 主界面的组件设置方法，主界面窗口的界面设计
     */
    void mainap(){
        jPanel = new JPanel();//创建面板对象
        getContentPane().add(jPanel);//面板加入到显示容器中
        setTitle("图书管理系统   v1.5.0");//设置窗口标题
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
        Font font = new Font("Serif", Font.BOLD, 45);//设置文字大小
        Font font2 = new Font("Serif", Font.BOLD, 28);//设置文字大小
        jLabel.setFont(font);//图书管理系统总标题文字大小
        jLabel2.setFont(font2);//图书操作标题应用文字大小
        //jLabel.setBounds(374,-60,500,200);//"图书管理系统"总标题位置大小设定
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
         * 按钮事件添加
         */
        bse.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (staticdata.count == 0) {//如果查询窗口不存在，数值0表示不存在,不存在则创建窗口
                    staticdata.count = 1;//设置窗口状态为1，表示窗口已经存在
                    new See().see2();//调用see查询功能的第二个版本类文件//实例化类以及调用该类的方法、

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

                if (staticdata.countup == 0) {//如果修改窗口不存在，0表示不存在，不存在则创建修改窗口
                    staticdata.countup = 1;//修改窗口存在，设置为1,1表示存在窗口
                    new Upd().upd();//实例化类以及调用该类的方法、
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

                if (staticdata.countdel == 0) {//如果图书删除窗口不存在，0表示不存在，不存在则创建删除图书窗口
                    staticdata.countdel = 1;//设置图书删除窗口已经存在，设置值为1，防止创建多个删除图书的窗口
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

                if (staticdata.countadd == 0) {//如果新增图书窗口不存在，0表示不存在，不存在则创建新增图书窗口
                    staticdata.countadd = 1;//设置新增图书窗口存在，1表示存在
                    new UpdataDef().updatadef();//新增失败信息框提示
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
        bjy.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {


                if (staticdata.countjy == 0) {//如果新增图书窗口不存在，0表示不存在，不存在则创建新增图书窗口
                    staticdata.countjy = 1;//设置新增图书窗口存在，1表示存在

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


        bjyls.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {



                if (staticdata.countlendwater == 0) {//如果借阅流水窗口不存在，0表示不存在，不存在则创建借阅流水窗口
                    staticdata.countlendwater = 1;//设置借阅流水窗口存在，1表示存在

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

        bhs.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {


                if (staticdata.countgh == 0) {//如果归还图书窗口不存在，0表示不存在，不存在则创建借阅流水窗口
                    staticdata.countgh = 1;//设置归还图书窗口存在，1表示存在

                    new Return().returnBook();//归还图书窗口new，归还图书窗体的设置
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



    /**
     * 用于控制每一个窗体的数量上限，即每个窗体只能有一个
     */

    public static class staticdata {


        static int countreg = 0;//用于注册窗口界面只能存在一个

        public static int countregwin = 0;//用于注册窗口注册成功后弹出的成功注册窗口只能存在一个

        static int count = 0;//用于使查询界面只能存在一个

        static int countup = 0;//用于界面修改数据界面只能存在一个

        static int countdel = 0;//用于删除图书界面只能存在一个

        static int countadd = 0;//用于新增图书界面只能存在一个

        static int countupdata = 0;//用于修改图书信息窗口界面只能存在一个

        public static int countwin = 0;//用于修改成功弹出的窗口只能存在一个

        public static int countwinadd = 0;//用于删除成功弹出的成功窗口只能存在一个

        public static int countdewin = 0;//用于删除成功弹出的窗口只能存在一个

        static int countdef = 0;//用于修改失败弹出的信息窗口只能存在一个
        public static String bokname = "";//用于获取要修改的图书的书名//要修改的图书书名

        public static String bokname2 = "";//用于获取要删除的图书的书名//要删除的图书书名

        public static String bokauthor = "";//用于获取要修改的图书的作者

        public static BigDecimal bokprice = null;//用于获取要修改的图书的价格

        public static int bokamount = 0;//用于获取要修改的图书的数量

        public static String boktype = "";//用于获取要修改的图书的类型

        /**
         * 以下新加静态变量
         */
        public static String staticlengder = "";//用于获取借阅者的姓名
        public static String staticmobile = "";//用于获取借阅者的手机号
        public static BigDecimal staticmoney = null;//用于获取借阅者的押金
        public static String statictime = "";//用于获取借阅者借阅图书的时间
        public static int staticbookid = 0;//用于获取借阅者借阅图书的原图书ID

        public static int upid = 0; //用于确定要修改的是哪一个ID，以ID为信息修改其他信息

        public static int deid2 = 0; //用于确定要删除的是哪一个ID，以ID为信息删除指定图书

        //以下为删除用户信息的静态变量
        public static int deid3 = 0;//用于确定要删除的是哪一个用户ID，以ID为准删除指定用户

        public static String user = "";//用于获取要删除的用户字符串信息

        public static int countuserdel = 0;//用于使用户删除窗口界面只能存在一个

        public static int countuserdelwin = 0;//用于用户删除成功后的提示窗只能存在一个


        /**
         * 借阅系统变量设置在下面
         */
        public static int countjy = 0;//用于借阅图书界面窗体只有一个，第一个
        public static int countjymoneyminus = 0;//用于借阅图书中押金价格低于图书价格或者图书数量为0的 窗体只能有一个
        public static int countlendwater = 0;//用于借阅系统的借阅流水窗口只能存在一个
        public static int countgh = 0;//用于借阅系统中归还图书窗体只能存在一个

        public static int countrewin = 0;//用于归还图书成功窗口只能存在一个


        public static int returndel = 0;//删除借阅流水


    }
}
