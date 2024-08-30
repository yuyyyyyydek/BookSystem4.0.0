package com.nan.tool;

import java.math.BigDecimal;

public class StaticData {

    private StaticData(){}//工具类无参构造私有化，防止实例化

    public static int upId2 = 0; //用于确定叠加数量的ID图书
    public static int upId = 0; //用于确定要修改的是哪一个ID，以ID为信息修改其他信息

    public static String bokName = "";//用于获取要修改的图书的书名//要修改的图书书名
    public static String bokAuthor = "";//用于获取要修改的图书的作者
    public static BigDecimal bokPrice = null;//用于获取要修改的图书的价格
    public static int bokAmount = 0;//用于获取要修改的图书的数量
    public static String bokType = "";//用于获取要修改的图书的类型

    public static int deId2 = 0; //用于确定要删除的是哪一个ID，以ID为信息删除指定图书
    public static String bokName2 = "";//用于获取要删除的图书的书名//要删除的图书书名

    /**
     *以下是新静态属性
     */
    public static String staticlengder = "";//用于获取借阅者的姓名
    public static String staticmobile = "";//用于获取借阅者的手机号
    public static BigDecimal staticmoney = null;//用于获取借阅者的押金
    public static String statictime = "";//用于获取借阅者借阅图书的时间
    public static int staticbookid = 0;//用于获取借阅者借阅图书的原图书ID

    /**
     * 借阅系统需要的静态数据
     */
    public static int returndel = 0;//删除借阅流水

    /**
     * 用于创建没用的图书ID的静态ID，存在不创建，不存在则创建
     *
     */
    public static int myIdJian;//此静态变量未使用

    /**
     * 以下为删除用户的功能
     */
    public static int delId3;//查询到的需要删除用户的ID，
    public static String delUsername;//查询到的需要删除的用户的用户名

    /**
     * 以下为删除读者的功能
     */
    public static int delReaderId4;//查询到的需要删除读者的ID，
    public static String delReaderUsername;//查询到的需要删除的读者的读者名,读者账号


}
