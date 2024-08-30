package com.nan.user;
/**
 * 超级管理员的类，属性等
 * 用于输出数据访问层数据库查询到的信息，用户表遍历，一个对象一条信息
 */
public class Admini {

    private String admini;
    private String admpass;

    @Override
    public String toString() {
        return "Admini{" +
                "admini='" + admini + '\'' +
                ", admpass='" + admpass + '\'' +
                '}';
    }

    public Admini() {
    }

    public Admini(String admini, String admpass) {
        this.admini = admini;
        this.admpass = admpass;
    }

    public String getAdmini() {
        return admini;
    }

    public void setAdmini(String admini) {
        this.admini = admini;
    }

    public String getAdmpass() {
        return admpass;
    }

    public void setAdmpass(String admpass) {
        this.admpass = admpass;
    }
}
