package com.nan.user;

/**
 * 一个数据库读者对应一个读者对象,读者的信息表
 */
public class ReaderUser {


    private String readerUser;
    private String readerPassword;
    private int id;

    public ReaderUser() {
    }

    public ReaderUser(String readerUser, String readerPassword, int id) {
        this.readerUser = readerUser;
        this.readerPassword = readerPassword;
        this.id = id;
    }

    @Override
    public String toString() {
        return "ReaderUser{" +
                "readerUser='" + readerUser + '\'' +
                ", readerPassword='" + readerPassword + '\'' +
                ", id=" + id +
                '}';
    }

    public String getReaderUser() {
        return readerUser;
    }

    public void setReaderUser(String readerUser) {
        this.readerUser = readerUser;
    }

    public String getReaderPassword() {
        return readerPassword;
    }

    public void setReaderPassword(String readerPassword) {
        this.readerPassword = readerPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
