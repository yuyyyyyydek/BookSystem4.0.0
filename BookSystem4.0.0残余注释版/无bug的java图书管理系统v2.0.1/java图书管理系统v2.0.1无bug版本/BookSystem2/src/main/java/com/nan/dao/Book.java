package com.nan.dao;

import java.math.BigDecimal;

/**
 * book类
 */
public class Book {
    private int id;
    private String bookname;
    private String bookauthor;
    private BigDecimal bookprice;
    private int bookamount;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String booktype;

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public BigDecimal getBookprice() {
        return bookprice;
    }

    public void setBookprice(BigDecimal bookprice) {
        this.bookprice = bookprice;
    }

    public int getBookamount() {
        return bookamount;
    }

    public void setBookamount(int bookamount) {
        this.bookamount = bookamount;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }
}
