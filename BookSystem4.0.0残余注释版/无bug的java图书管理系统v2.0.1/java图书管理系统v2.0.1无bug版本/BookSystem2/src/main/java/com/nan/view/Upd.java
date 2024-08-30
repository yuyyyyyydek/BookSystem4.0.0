package com.nan.view;

import com.nan.dao.UpdataDAO;
import com.nan.hint.UpdataDef;
import com.nan.tool.Gain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 修改图书内容的类  ，采用了面板JPanel添加组件，不推荐使用面板添加组件，代码繁琐
 */
public class Upd extends JFrame {
    /**
     * 声明要使用到的组件
     */
    private String booktext;//修改文本框中的内容

    private JLabel jLabel;//修改书籍 的文本域信息
    private JLabel jLabel2;//所要修改成的书籍 的文本域信息

    private JButton bup;//查询图书按钮
    private JButton bupdata;//修改图书信息按钮声明，进入updata面板界面

    private JTextField textField;//声明图书修改的文本框
    private JTextField textField2;//声明图书所要修改成为的名称的文本框//变更为显示要修改的目标书籍
    Font font2 = new Font("Serif",Font.BOLD,28);//设置文字大小


    /**
     * 修改图书内容的主窗体
     */
    public void upd(){ //修改图书内容的主窗体

        JPanel jPanel = new JPanel();//创建面板1
        JPanel jPanel2 = new JPanel();//创建面板2
        JPanel jPanel3 = new JPanel();//创建面板3
        JPanel jPanel4 = new JPanel();//创建面板4


        this.add(jPanel);//添加面板到窗体容器
        this.add(jPanel2);//将面板2添加到窗体
        this.add(jPanel3);//将面板3添加到窗体
        this.add(jPanel4);//将面板4添加到窗体
        jPanel.setBounds(0,0,300,48);//设置面板1的大小以及位置
        jPanel2.setBounds(0,55,300,98);//设置面板2的大小以及位置
        jPanel3.setBounds(0,155,300,108);//设置面板3的大小以及位置
        jPanel4.setBounds(0,275,300,88);//设置面板4的大小以及位置
        //this.setSize(500,410);//设置窗体大小
        this.setSize(310,410);//设置窗体大小
        setResizable(false);//设置窗口是否可以改变大小
        //this.setResizable(false);

        this.setTitle("图书修改");//设置窗口标题
        this.setLayout(null);//设置窗口布局
        setLayout(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体关闭方式
        this.setLocationRelativeTo(null);//窗口居中显示
        this.setVisible(true);//设置窗体可见

        bupdata = new JButton("修改图书信息");//创建修改图书按钮

        bupdata.setFont(font2);//设置按钮文字大小格式
        bupdata.setBounds(0,400,180,65);
        bup = new JButton("查询书名");
        bup.setFont(font2);//按钮文字采用28号
        bup.setBounds(0,300,180,65);

        jLabel2 = new JLabel("书籍名称为");//创建文本域并赋值，填写内容
        jLabel2.setFont(font2);//为文本域中的内容设定字体大小
        jLabel2.setBounds(0,0,280,55);//设置文本域的位置以及尺寸大小
        jLabel = new JLabel("输入要修改的图书ID");//创建文本域并赋值，填写内容
        jLabel.setFont(font2);//为文本域中的内容设定字体大小
        jLabel.setBounds(0,0,280,55);//设置文本域的位置以及尺寸大小
        textField = new JTextField(10);//创建图书修改的文本框
        textField.setFont(font2);//图书修改文本域文字大小使用28号字体
        textField.setLocation(0,20);//图书修改文本框位置大小设定
        textField2 = new JTextField(10);//创建图书修改的文本框//图书修改文本框变更为目标书籍名称
        textField2.setText("这里显示修改的书");//设置目标修改图书文本框的默认显示内容
        textField2.setFont(font2);//图书修改文本域文字大小使用28号字体
        textField2.setBounds(0,0,280,55);//图书修改文本框位置大小设定
        jPanel2.add(textField);//添加文本框到面板2，文本框为要输入的书籍ID
        jPanel3.add(textField2);//添加文本框到面板3，文本框为目标图书的书名
        jPanel3.add(bup);//查询书籍按钮添加到面板3
        jPanel4.add(bupdata);//修改书籍名称按钮添加到面板4
        repaint();

        jPanel.add(jLabel);//添加文本域到面板1中
        jPanel2.add(jLabel2);//添加文本域到面板1中
        this.setVisible(true);//设置窗体可见
        setVisible(true);//设置窗体可见

        /**
         * 此处将不可用改为不可见
         */

        bupdata.setVisible(false);

        //这里按下按钮可以出现图书名称信息  .另外加一个修改失败后会有怎样的行为的信息窗，已找到，就在这里
        bupdata.addMouseListener(new MouseListener() {//为修改信息按钮添加鼠标监听器
            @Override
            public void mouseClicked(MouseEvent e) {//鼠标单击事件

                if(MainApp.staticdata.countupdata == 0){//当该窗口不存在时可以创建该窗口
                    MainApp.staticdata.countupdata = 1;//设置该窗体状态以及存在，防止创建多个该窗体
                    new UpdataView().updata();//实例化一个修改书籍信息的界面
                    new UpdataDef().updatadef();//修改失败信息框提示

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


        //查询键按下出现书籍信息后，修改图书信息按钮激活，可以按下,这里updata按键要加一个新的指示是否成功修改的信息窗，

        bup.addMouseListener(new MouseListener() {//为查询按钮添加鼠标监听器
            @Override
            public void mouseClicked(MouseEvent e) {//鼠标点击事件
                booktext = Gain.gain(textField);//使用gain方法获得文本框中的内容信息并赋值给booktext

                new UpdataDAO().updata(booktext);//获得需要查询的文本框内容并进行数据库查找,查找书籍的ID
                textField2.setText(MainApp.staticdata.bokname);//修改文本框内容，内容为要修改的书籍名称
                if(MainApp.staticdata.bokname != ""){  //当静态字符串bokname不为空，bokname有内容时进行此判断

                    /**
                     * 此处重要，标记一下，此处将不可用改为不可见
                     */
                    //bupdata.setEnabled(true);//修改"修改图书信息"按钮进入激活可按状态
                    bupdata.setVisible(true);//使"修改图书信息"按钮显示出来

                }
                setVisible(true);//设置窗口内容可见


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


        this.addWindowListener(new WindowAdapter() {//添加窗体监听器

            public void windowClosing(WindowEvent e) {//窗口关闭时执行的代码
                super.windowClosing(e);
                MainApp.staticdata.countup = 0;  //countup重置为0
            }

        });


    }


}
