package com.nan.tool;

import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;

/**
 * 用于判断窗体是否唯一存在，是否已经存在
 * 起的变量名不符合规则，第一个字母应该是小写，后面的单词第一个字母要大写，以后要注意
 * 属性名第一个字母要小写  以后需要记住
 */
public class Only {

    private Only() {//工具类无参构造方法私有化，防止该类实例化
    }

    public static byte readerLoginSucceed = 0;//读者的登陆窗口是否登陆成功，若成功则为1，未成功则为0，注意这里是读者的登陆
    public static byte UserLoginSucceed = 0;//用户的登陆窗口是否登陆成功，成功则为1，未成功则为0,注意这里是用户的登陆窗口
    public static byte adminiLoginWindow = 0;//用户登陆窗口是否存在，且仅可存在一个该窗口
    public static byte readerRegisterCount = 0;//读者注册窗口是否存在，且仅可存在一个该窗口
    public static byte readerUserAddCount = 0;// 用于读者注册窗口是否存在，且仅可存在一个该窗口
    public static byte UserAddCount = 0;// 用于用户注册窗口是否存在，且仅可存在一个该窗口，值为1和0
    public static byte SeeCount = 0;//用于图书查询界面是否存在，且仅可存在一个该窗口，值为1和0
    public static byte UpdSeeCount = 0;//用于图书修改界面的前置查询指定ID图书界面的是否存在判定，且仅可存在一个该窗口，前置修改图书
    public static byte UpdataCount = 0;//真正的图书修改界面，只能存在一个
    public static byte DelCount = 0;//图书删除窗口只能存在一个，状态码为0为不存在
    public static byte AddCount = 0;//图书增添窗口只能存在一个
    public static byte jyCount = 0;//图书借阅窗口只能存在一个
    public static byte ghCount = 0;//图书归还窗口只能存在一个
    public static byte lendWaterCount = 0;//借阅流水窗口只能存在一个
    public static byte delUserCount = 0;//删除用户窗口只能存在一个
    public static byte seeUserCount = 0;//查询用户窗口只能存在一个
    public static byte seeReaderCount = 0;//查询读者窗口只能存在一个
    public static byte delReaderUserCount = 0;//删除读者账号窗口只能存在一个



    /**
     * 以下为其他静态变量,是否需要重新写，
     */







    static int countreg = 0;//用于注册窗口界面只能存在一个

    public static int countregwin = 0;//用于注册窗口注册成功后弹出的成功注册窗口只能存在一个



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
