package com.nan.Exception;

//此类没有用到好像
/**
 * 此类好像没有用到
 * 异常类，自定义异常类，该类用于弹出 读者账号已存在，请注册其它账号 的文本信息
 */
public class ReaderUserRepetitionException extends Exception{
    private String errorMessage;

    public ReaderUserRepetitionException(String errorMessage){
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ReaderUserRepetitionException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
