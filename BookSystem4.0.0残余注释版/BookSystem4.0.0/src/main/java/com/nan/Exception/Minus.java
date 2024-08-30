package com.nan.Exception;


public class Minus extends Exception{

    private String errorMessage;//要输出的异常文本信息

    public Minus(String errorMessage){
        super(errorMessage);
        this.errorMessage = errorMessage;
    }



    @Override
    public String toString() {
        return "NotNullException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
