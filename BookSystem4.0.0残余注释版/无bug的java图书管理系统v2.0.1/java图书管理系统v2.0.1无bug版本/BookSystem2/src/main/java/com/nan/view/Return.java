package com.nan.view;

import com.nan.dao.*;
import com.nan.tool.Gain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;

/**
 * 借阅系统中的  图书归还功能   窗体设计
 */
public class Return extends JFrame {
    private String lendId;//用于存储在ID文本框中输入的ID
    Font font2 = new Font("Serif", Font.BOLD, 28);//设置文字大小
    Font font = new Font("Serif", Font.BOLD, 20);//设置文字大小

    private JLabel jLabel;//图书归还大标题的标签声明
    private JLabel jLabel2;//请输入借阅图书时的序列ID 标签的声明
    private JLabel jLabel3;//借阅图书ID序列号  标签的声明
    private JLabel jLabel4;//图书原ID  标签的声明
    private JLabel jLabel5;//图书名称  标签的声明
    private JLabel jLabel6;//图书作者  标签的声明
    private JLabel jLabel7;//借阅者姓名  标签的声明
    private JLabel jLabel8;//借阅者手机号  标签的声明
    private JLabel jLabel9;//借阅者押金  标签的声明
    private JLabel jLabel10;//借书时间  标签的声明

    private JTextField textField;//借阅图书信息中的ID序列文本框   声明
    private JTextField textField2;//图书原ID 的文本框声明
    private JTextField textField3;//图书名称  的文本框的声明
    private JTextField textField4;//图书作者  的文本框声明
    private JTextField textField5;//借阅者姓名  的文本框声明
    private JTextField textField6;//借阅者手机号 的文本框声明
    private JTextField textField7;//借阅者押金   的文本框声明
    private JTextField textField8;//借阅图书的时间  的文本框声明

    private JButton bseeid;//根据借阅系统ID查询  的按钮声明
    private JButton breturn;//确认归还图书


    void returnBook(){
        MainApp.staticdata.countgh = 1;//归还图书窗口唯一判断
        setSize(550,630);//设置归还功能窗体大小
        setTitle("归还图书");//标题内容设定
        setLocationRelativeTo(null);//窗体居中显示
        setVisible(true);//设置窗体可见
        setResizable(false);//设置窗体不可改变大小
        setLayout(null);//设置窗体布局为绝对布局

        jLabel = new JLabel("图书归还");//实例化标签 “图书归还”文本域
        jLabel.setFont(font2);//标签字体大小设定
        jLabel.setBounds(205,0,180,65);//标签大小位置设定
        add(jLabel);//将标签添加到窗体

        jLabel2 = new JLabel("请输入借阅图书时的序列ID");//实例化标签   文本域
        jLabel2.setFont(font);//标签字体大小设定
        jLabel2.setBounds(20,45,280,65);//设置标签的位置大小
        add(jLabel2);//将标签添加至窗体

        jLabel3 = new JLabel("借阅ID");//实例化文本域标签
        jLabel3.setFont(font);//标签设定字体大小
        jLabel3.setBounds(20,85,230,65);//标签位置大小设定
        add(jLabel3);//标签添加到窗体

        textField = new JTextField();//借阅系统借阅ID序列号文本框  的实例化
        textField.setFont(font);//借阅系统借阅ID文本框 设置字体大小
        textField.setBounds(120,100,210,35);//文本框设置位置大小
        add(textField);//文本框添加至窗体

        bseeid = new JButton("根据借阅ID查询");//按钮实例化
        bseeid.setFont(font);//按钮设置字体大小
        bseeid.setBounds(340,94,180,45);//设置按钮大小位置
        add(bseeid);//将按钮添加到窗体

        jLabel4 = new JLabel("图书原ID");//图书原ID 标签的实例化
        jLabel4.setFont(font);//文本域标签设定字体大小
        jLabel4.setBounds(20,135,230,65);//设置标签的位置大小
        add(jLabel4);//添加标签到窗体

        textField2 = new JTextField();//图书原ID 文本框的实例化
        textField2.setFont(font);//文本框字体大小设定
        textField2.setBounds(120,150,210,35);//文本框与上一个文本框间隔50个单位，设置文本框位置大小
        add(textField2);//将文本框添加至窗体

        jLabel5 = new JLabel("图书名称");//图书名称标签的实例化
        jLabel5.setFont(font);//标签字体大小设定
        jLabel5.setBounds(20,185,230,65);//文本域也是50个单位   ,标签的位置大小设定
        add(jLabel5);//添加标签到窗体

        textField3 = new JTextField();//图书名称的文本框  的实例化
        textField3.setFont(font);//文本框字体大小设定
        textField3.setBounds(120,200,210,35);//文本框的位置大小设定
        add(textField3);//添加文本框到窗体

        jLabel6 = new JLabel("图书作者");//图书作者 标签的实例化
        jLabel6.setFont(font);//标签字体大小设定
        jLabel6.setBounds(20,235,230,65);//标签位置大小设定
        add(jLabel6);//将标签添加到窗体

        textField4 = new JTextField();//图书作者文本框 的实例化
        textField4.setFont(font);//图书作者文本框  字体大小设定
        textField4.setBounds(120,250,210,35);//图书作者文本框 位置大小设定
        add(textField4);//将文本框添加到窗体

        jLabel7 = new JLabel("借阅者姓名");//借阅者姓名  标签的实例化
        jLabel7.setFont(font);//标签字体大小设定
        jLabel7.setBounds(8,285,230,65);//标签位置大小设定
        add(jLabel7);

        textField5 = new JTextField();//借阅者姓名  文本框的实例化
        textField5.setFont(font);//文本框字体大小设定
        textField5.setBounds(120,300,210,35);//文本框位置大小
        add(textField5);//将文本框添加到窗体

        jLabel8 = new JLabel("手机号");//借阅者手机号 标签的实例化
        jLabel8.setFont(font);//标签字体大小设定
        jLabel8.setBounds(20,335,230,65);
        add(jLabel8);

        textField6 = new JTextField();//借阅者手机号  文本框的实例化
        textField6.setFont(font);//文本框字体大小设定
        textField6.setBounds(120,350,210,35);//文本框位置大小设定
        add(textField6);//将文本框添加到窗体

        jLabel9 = new JLabel("借阅押金");//借阅者押金 标签的实例化
        jLabel9.setFont(font);//标签字体大小设定
        jLabel9.setBounds(20,385,230,65);//标签位置大小设定
        add(jLabel9);//标签添加到窗体

        textField7 = new JTextField();//借阅者押金  文本框的实例化
        textField7.setFont(font);//文本框字体大小设定
        textField7.setBounds(120,400,210,35);//文本框位置大小设定
        add(textField7);//将文本框添加到窗体

        jLabel10 = new JLabel("借书时间");//借阅书籍的时间 的标签实例化
        jLabel10.setFont(font);//标签字体大小设定
        jLabel10.setBounds(20,435,230,65);//标签位置大小设定
        add(jLabel10);//将标签添加至窗体

        textField8 = new JTextField();//借阅图书时间 的文本框实例化
        textField8.setFont(font);//文本框字体大小设定
        textField8.setBounds(120,450,210,35);//文本框位置大小设定
        add(textField8);//将文本框添加至窗体

        breturn = new JButton("确认归还");//确认归还按钮  的实例化
        breturn.setFont(font2);//按钮字体大小设定
        breturn.setBounds(168,500,180,55);
        add(breturn);

        //按钮添加事件监听器
        bseeid.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //这里要写代码记住了
                lendId = Gain.gain(textField);//获取借阅信息ID序列文本框的内容，将内容传入变量lendId中
                new ReturnDAO().findReturn(lendId);//获取需要查找的借阅系统借阅ID序号查询借阅信息
                textField2.setText(String.valueOf(MainApp.staticdata.staticbookid));//修改文本框内容，内容为要归还图书的原ID
                textField3.setText(MainApp.staticdata.bokname);//修改文本框内容，内容为要归还图书的图书名称
                textField4.setText(MainApp.staticdata.bokauthor);//修改文本框内容，内容为要归还图书的作者
                textField5.setText(MainApp.staticdata.staticlengder);//修改文本框内容，内容为要归还图书的借阅者姓名
                textField6.setText(MainApp.staticdata.staticmobile);//修改文本框内容，内容为要归还图书的借阅者手机号码
                textField7.setText(String.valueOf(MainApp.staticdata.staticmoney));//修改文本框内容，内容为要归还图书的押金
                textField8.setText(MainApp.staticdata.statictime);//修改文本框内容，内容为要归还图书的借书时间



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


        breturn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if(MainApp.staticdata.bokname.equals("")||MainApp.staticdata.bokauthor.equals("")||String.valueOf(MainApp.staticdata.bokprice).equals("")||String.valueOf(MainApp.staticdata.bokamount).equals("")||MainApp.staticdata.boktype.equals("")){
                            throw new RuntimeException();
                }

                String BOKname = MainApp.staticdata.bokname;//临时接收从数据库中查询到的图书名称
                String BOKauthor = MainApp.staticdata.bokauthor;//接收从数据库中查询到的图书作者
                BigDecimal BOKprice = MainApp.staticdata.bokprice;//接收从数据库中查询到的图书价格
                int BOKamount = MainApp.staticdata.bokamount;//接收从数据库中查询到的图书数量
                String BOKtype = MainApp.staticdata.boktype;//接收从数据库中查询到的图书类型

                //这边根据图书的原ID查询该本图书是否还存在于数据库表中
                //new See().see(String.valueOf(MainApp.staticdata.staticbookid));//这边根据图书的原ID查询该本图书是否还存在于数据库表中

                //归还时图书数量增加
                        new UpdataDAO().updata(String.valueOf(MainApp.staticdata.staticbookid));//获得需要查询的文本框内容并进行数据库查找,查找书籍的ID
                        new UpdataTableDAO().updata2(BOKname, BOKauthor, BOKprice, MainApp.staticdata.bokamount + 1, BOKtype);//传入参数以进行修改数据库信息


                    //下面的代码不起作用
                    if(new See().seeRe(String.valueOf(MainApp.staticdata.staticbookid))){
                        MainApp.staticdata.bokamount=0;//查询到改本图书不在数据库中，自动重置图书数量为0，并新增该本图书，数量为1
                        new AddDAO().addBook(MainApp.staticdata.bokname,MainApp.staticdata.bokauthor,MainApp.staticdata.bokprice,MainApp.staticdata.bokamount+1,MainApp.staticdata.boktype);//传入参数以进行修改数据库信息

                    }


                new ReturnDelDAO().del();

                    //静态变量重置为空
                MainApp.staticdata.bokname = "";//将静态变量的内容重置为空
                MainApp.staticdata.bokauthor = "";
                MainApp.staticdata.bokprice = null;
                MainApp.staticdata.bokamount = 0;
                MainApp.staticdata.boktype = "";
                MainApp.staticdata.staticbookid = 0;
                MainApp.staticdata.staticlengder = "";
                MainApp.staticdata.staticmobile = "";
                MainApp.staticdata.staticmoney = null;
                MainApp.staticdata.statictime = "";
                MainApp.staticdata.staticbookid = 0;



                //这里写归还图书的内容




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




        repaint();//刷新重绘

        addWindowListener(new WindowAdapter() {//窗口关闭执行的代码


            public void windowClosing(WindowEvent e) {//关闭窗口时执行的事件
                super.windowClosing(e);
                MainApp.staticdata.countgh = 0;//设置该窗口是否存在，这里重置为0，方便下次创建
            }

        });

    }


}
