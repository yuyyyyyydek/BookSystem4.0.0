package com.nan.Exception;

/**
 * 异常类，该类为，窗体文本框内不能有空文本框
 */
public class NotNullException extends Exception{
    private String errorMessage;//要输出的异常文本信息

    public NotNullException(String errorMessage){
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
