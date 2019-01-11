package com.xxx.springboot.http;

public class ResponseData {
    private String status;
    private Object data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResponseData create(Object result){
        return ResponseData.create(result,"success");
    }

    public static ResponseData create(Object result,String status){
        ResponseData responseData = new ResponseData();
        responseData.setStatus(status);
        responseData.setData(result);
        return responseData;
    }
}
