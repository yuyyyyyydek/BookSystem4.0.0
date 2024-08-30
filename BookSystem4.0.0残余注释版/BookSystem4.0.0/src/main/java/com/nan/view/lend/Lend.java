package com.nan.view.lend;

import com.nan.dao.LendDao;
import com.nan.dao.LendTableDao;
import com.nan.tool.Gain;
import com.nan.tool.Only;
import com.nan.tool.StaticData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;

/**
 * 借阅系统窗体设计
 */
public class Lend extends JFrame {

    private String booktext;//获取要查询的ID 的文本信息转存,并根据此ID查询图书内容

    Font font2 = new Font("Serif", Font.BOLD, 28);//设置文字大小
    Font font = new Font("Serif", Font.BOLD, 20);//设置文字大小
    private JLabel jLabel;//借阅系统大标题
    private JLabel jLabel2;//请输入您要借阅的图书ID
    private JLabel jLabel3;//借阅图书的图书信息，图书名称的标签
    private JLabel jLabel4;//借阅图书的图书信息，图书作者的标签
    private JLabel jLabel5;//借阅图书的图书价格,图书价格的标签
    private JLabel jLabel6;//借阅图书的图书数量,图书数量的标签
    private JLabel jLabel7;//请填写您的信息，借阅者信息填写提示的标签
    private JLabel jLabel8;//借阅者姓名的标签
    private JLabel jLabel9;//借阅者手机的标签
    private JLabel jLabel10;//借阅者借书押金标签
    private JLabel jLabel11;//借阅时间标签
    private JLabel jLabel12;//借阅图书的类型的标签

    private JTextField textField;//要借阅的图书ID的文本框
    private JTextField textField2;//要显示图书名称的文本框
    private JTextField textField3;//要显示的图书作者的文本框
    private JTextField textField4;//要显示的图书价格的文本框
    private JTextField textField5;//要显示的图书数量的文本框
    private JTextField textField6;//借阅者姓名文本框
    private JTextField textField7;//借阅者手机号文本框
    private JTextField textField8;//借阅者押金文本框
    private JTextField textField9;//借阅时间文本框
    private JTextField textField10;//借阅图书的图书类型文本框

    private JButton bsee;//查询图书信息的按钮，根据ID查找图书信息的按钮
    private JButton blend;//确认借阅按钮，




    /**
     * 借阅窗体设计
     */
    public void lend(){
        Only.jyCount = 1;//借阅窗口设置已经存在，不可再次创建

        //借阅窗体基本设置
        //JPanel jPanel = new JPanel();//创建面板
        setSize(850,600);//设置借阅系统窗体大小
        setTitle("借阅系统");//设置窗体标题
        setLocationRelativeTo(null);//窗体居中显示
        setVisible(true);//设置窗体可见
        setResizable(false);//设置窗体不可改变大小
        setLayout(null);//设置窗体布局为绝对布局

        //按钮标签文本框设计
        //根据图书ID查询图书信息的设计
        jLabel = new JLabel("借阅系统");//实例化借阅系统文本域标签
        jLabel.setFont(font2);//设置字体
        jLabel.setBounds(360,0,180,65);//设置标签位置大小
        add(jLabel);//添加标签至面板容器

        jLabel2 = new JLabel("请输入您要借阅的图书ID");//请输入借阅系统ID 的标签实例化
        jLabel2.setFont(font);//标签设置字体
        jLabel2.setBounds(40,50,230,65);//设置标签位置大小
        add(jLabel2);//添加标签至面板容器

        textField = new JTextField();//输入借阅图书的ID   的文本框
        textField.setFont(font);//设置文本框字体大小
        textField.setBounds(300,69,230,35);//设置文本框位置大小
        add(textField);//添加文本框至窗体


        bsee = new JButton("查询图书信息");//查询图书信息的按钮实例化
        bsee.setFont(font);//设置按钮字体大小
        bsee.setBounds(560,60,180,45);//设置按钮位置大小
        add(bsee);//添加按钮至窗体


        //图书信息，被查询出来的图书信息的展示区
        jLabel3 = new JLabel("图书名称");//图书名称的标签
        jLabel3.setFont(font);//设置标签字体大小
        jLabel3.setBounds(40,120,230,65);//设置标签大小位置，图书名称的标签
        add(jLabel3);//添加标签至窗体     图书名称的标签

        textField2 = new JTextField();//显示图书名称文本框
        textField2.setFont(font);//图书名称文本框字体大小设定
        textField2.setBounds(140,135,200,35);//图书名称文本框大小位置   //65个单位与上一行间隔
        add(textField2);//添加图书名称文本框到窗体

        jLabel4 = new JLabel("图书作者");//图书作者标签实例化
        jLabel4.setFont(font);//图书作者标签字体大小设置
        jLabel4.setBounds(400,120,230,65);//图书作者标签位置大小
        add(jLabel4);//图书作者标签添加到窗体

        textField3 = new JTextField();//显示图书作者的文本框
        textField3.setFont(font);//图书作者文本框字体大小设定
        textField3.setBounds(500,135,200,35);
        add(textField3);//图书作者文本框添加至窗体

        jLabel5 = new JLabel("图书价格");//图书价格标签实例化
        jLabel5.setFont(font);//图书价格标签字体大小
        jLabel5.setBounds(40,190,230,65);//y上下与上一行间隔70个单位//图书价格标签位置大小设定
        add(jLabel5);//图书价格标签添加至窗体

        textField4 = new JTextField();//显示图书价格的文本框
        textField4.setFont(font);//图书价格文本框字体大小
        textField4.setBounds(140,205,200,35);//文本框与上一行间隔70个单位,图书价格文本框大小位置
        add(textField4);//图书价格文本框添加至窗体

        jLabel6 = new JLabel("图书数量");//显示图书数量的标签
        jLabel6.setFont(font);//图书数量标签的字体大小
        jLabel6.setBounds(400,190,230,65);//图书数量标签的大小位置
        add(jLabel6);//图书数量标签添加至窗体

        textField5 = new JTextField();//显示图书数量的文本框
        textField5.setFont(font);//图书数量文本框的字体大小
        textField5.setBounds(500,205,200,35);//显示图书数量的文本框大小位置
        add(textField5);//显示图书数量文本框添加至窗体

        jLabel7 = new JLabel("借阅者的信息填写");//借阅者信息填写的标签实例化
        jLabel7.setFont(font);//标签字体大小设定
        jLabel7.setBounds(40,260,230,65);//借阅者信息填写位置大小
        add(jLabel7);//借阅者信息填写标签添加至窗体

        jLabel12 = new JLabel("图书类型");//显示借阅图书的图书类型标签实例化
        jLabel12.setFont(font);//借阅图书类型的标签的字体大小设定
        jLabel12.setBounds(400,255,230,65);//借阅的图书类型大小位置设定
        add(jLabel12);//添加借阅图书的类型标签到窗体

        textField10 = new JTextField();//借阅图书的类型文本框实例化
        textField10.setFont(font);//借阅图书的类型文本框字体大小设定
        textField10.setBounds(500,270,200,35);//借阅图书的类型文本框大小位置设定
        add(textField10);//将借阅图书的类型文本框添加至窗体

        //借阅者信息的填写
        jLabel8 = new JLabel("借阅者姓名");//借阅者姓名标签实例化
        jLabel8.setFont(font);//借阅者姓名标签字体大小
        jLabel8.setBounds(40,320,230,65);//标签行与上一行间隔60个单位。借阅者姓名标签位置大小
        add(jLabel8);//借阅者姓名标签添加至窗体

        textField6 = new JTextField();//借阅者姓名文本框
        textField6.setFont(font);//借阅者姓名文本框字体大小
        textField6.setBounds(160,335,200,35);//借阅者姓名文本框位置大小
        add(textField6);//借阅者姓名文本框添加至窗体

        jLabel9 = new JLabel("手机号");//借阅者手机号标签实例化
        jLabel9.setFont(font);//借阅者手机号标签字体大小
        jLabel9.setBounds(410,320,230,65);//借阅者手机号标签位置大小
        add(jLabel9);//借阅者手机号标签添加至窗体

        textField7 = new JTextField();//借阅者手机号文本框
        textField7.setFont(font);//借阅者手机号文本框字体大小设定
        textField7.setBounds(500,335,200,35);//借阅者手机号文本框位置大小设定  Z
        add(textField7);//借阅者手机号文本框添加至窗体

        jLabel10 = new JLabel("借阅押金");//借阅押金标签实例化
        jLabel10.setFont(font);//借阅者押金标签字体大小
        jLabel10.setBounds(40,380,230,65);//借阅者押金标签位置大小设定
        add(jLabel10);//借阅者押金标签添加至窗体

        textField8 = new JTextField();//借阅押金文本框实例化
        textField8.setFont(font);//借阅押金文本框字体大小设定
        textField8.setBounds(160,395,200,35);//借阅押金文本框位置大小设定
        add(textField8);//借阅押金文本框添加至窗体

        jLabel11 = new JLabel("借阅时间");//借阅时间标签实例化
        jLabel11.setFont(font);//借阅时间标签字体大小设定
        jLabel11.setBounds(400,380,230,65);//借阅时间标签大小位置设定
        add(jLabel11);//借阅时间标签添加至窗体

        textField9 = new JTextField();//借阅时间文本框实例化
        textField9.setFont(font);//借阅时间文本框字体大小设定
        textField9.setBounds(500,395,200,35);//借阅时间文本框位置大小设定
        add(textField9);//借阅时间文本框添加至窗体

        blend = new JButton("确认借阅");//创建"确认借阅"按钮，实例化
        blend.setFont(font2);//“确认借阅”按钮字体大小设定
        blend.setBounds(300,465,180,65);//"确认借阅"按钮位置大小设定
        add(blend);//"确认借阅"按钮添加至窗体




        repaint();//重绘刷新

/**
 * 根据输入的ID查询图书信息
 */
        bsee.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                booktext = Gain.gain(textField);//获取ID文本框中的ID，并将ID转存如booktext变量中
                new LendDao().findLend(booktext);//使用LendDAO中的方法，将数据库表中的图书信息传入静态变量中
                textField2.setText(StaticData.bokName);//将图书名称文本框更改为数据库中指定ID的图书名称
                textField3.setText(StaticData.bokAuthor);//将图书作者文本框的内容更改为数据库表中指定ID的图书作者
                textField4.setText(StaticData.bokPrice.toString());//将图书价格文本框中的内容更改为数据库表中指定ID的图书价格
                textField5.setText(String.valueOf(StaticData.bokAmount));//将图书数量文本框中的内容更改为数据库表中指定的ID的图书数量
                textField10.setText(StaticData.bokType);//将图书类型文本框中的内容更改为数据库表中指定的ID的图书类型


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
         * 借阅系统的确认借阅按钮事件监听器添加，确认借阅按钮
         */
        blend.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                //借阅系统确认借阅按钮事件
                //创建变量接收文本框中的数据
                String BOKname = StaticData.bokName;//临时接收从数据库中查询到的图书名称
                String BOKauthor = StaticData.bokAuthor;//接收从数据库中查询到的图书作者
                BigDecimal BOKprice = StaticData.bokPrice;//接收从数据库中查询到的图书价格
                int BOKamount = StaticData.bokAmount;//接收从数据库中查询到的图书数量
                String BOKtype = StaticData.bokType;//接收从数据库中查询到的图书类型

                String lendname = Gain.gain(textField6);//从借阅者姓名文本框中获取借阅者姓名
                String lendmobile = Gain.gain(textField7);//从借阅者手机号文本框中获取借阅者手机号
                BigDecimal lendmoney = BigDecimal.valueOf(Double.parseDouble(Gain.gain(textField8)));//从借阅者押金文本框中获取借阅者押金
                String lendtime = Gain.gain(textField9);//从借阅者借阅时间文本框中获取借阅时间
                int lendbookid = StaticData.upId;//从查询借阅书籍ID的文本框中获取借阅图书的ID

                new LendTableDao().lendTable(BOKname,BOKauthor,BOKprice,BOKamount-1,BOKtype,lendname,lendmobile, lendmoney,lendtime,lendbookid);
                //此处创建修改图书信息的方法，将图书数量减一更新到图书数据库表的数量中，即数据库表图书数量减1  -1
                //借阅时图书数量减少
                new LendDao().updata2(BOKname, BOKauthor, BOKprice,BOKamount-1, BOKtype);
                //MainApp.staticdata.bokamount = -1;
                StaticData.bokName = "";//借阅完成后静态变量重置
                StaticData.bokAuthor = "";//借阅完成后静态变量重置
                StaticData.bokPrice = null;//借阅完成后静态变量重置
                StaticData.bokAmount = -1;//借阅完成后静态变量重置
                StaticData.bokType = "";//借阅完成后静态变量重置

                textField2.setText("");//将图书名称文本框更改为空
                textField3.setText("");//将图书作者文本框的内容更改为空
                textField4.setText("");//将图书价格文本框中的内容更改为空
                textField5.setText("");//将图书数量文本框中的内容更改为空
                textField10.setText("");//将图书类型文本框中的内容更改为空


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





        repaint();//重绘刷新




        addWindowListener(new WindowAdapter() {//窗口关闭执行的代码


            public void windowClosing(WindowEvent e) {//关闭窗口时执行的事件
                super.windowClosing(e);
                //MainApp.staticdata.countjy = 0;//设置该窗口是否存在，这里重置为0，方便下次创建
                Only.jyCount = 0;//设置借阅窗口不存在，方便再次创建
            }

        });

    }


}
