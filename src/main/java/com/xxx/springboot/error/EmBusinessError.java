package com.xxx.springboot.error;

public enum  EmBusinessError implements CommonError {
    UNKOWN_ERROR(10000,"未知错误"),
    PARAMETER_VALIDATION_ERROR(10001,"参数不合法"),
    USER_NOT_EXIST(20001,"用户不存在");

    private EmBusinessError(int errCode,String errMsg){
        this.errCode =errCode;
        this.errMsg = errMsg;
    }

    private int errCode;
    private String errMsg;

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
