package com.tzb.o2o.dto;

public class Result<T>{
    private Boolean success;
    // 成功时返回的数据
    private T data;
    private String errorMsg;
    private int errorCode;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Result(){
    }
    // 成功时的构造器
    public Result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }
    // 错误时的构造器
    public Result(boolean success, int errorCode,String errorMsg) {
        this.success = success;
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }
    public boolean isSuccess(){
        return success;
    }

}
