package com.xxx.springboot.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.xxx.springboot.error.BusinessException;
import com.xxx.springboot.error.EmBusinessError;
import com.xxx.springboot.http.ResponseData;

public class BaseController {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception ex){
        Map<String,Object> result = new HashMap<>();
        if(ex instanceof BusinessException){
            BusinessException exception = (BusinessException)ex;
            result.put("errCode",exception.getErrCode());
            result.put("errMsg",exception.getErrMsg());
        }else{
            result.put("errCode", EmBusinessError.UNKOWN_ERROR.getErrCode());
            result.put("errMsg",EmBusinessError.UNKOWN_ERROR.getErrMsg());
        }
        return ResponseData.create(result,"fail");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder,WebRequest request) {
    	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }
}
