/**   
 * Copyright © 2018 
 * @Package: BaseController.java 
 * @author: Administrator   
 * @date: 2018年5月6日 上午11:40:19 
 */
package com.kenhome.controller;


import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.kenhome.utils.response.RspUtil;


/**
 * @Description:统一异常处理
 * @author: cmk
 * @date: 2018年5月6日 上午11:40:19

 */
@ControllerAdvice
public class ExceptionController {


	@ExceptionHandler(value=Exception.class)
    public Object handleBaseException(HttpServletRequest request,HttpServletResponse response, Exception e) {
		
		e.printStackTrace();
		StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw, true));
        String exception = sw.toString();
		
        if(isJson(request)) {
            return RspUtil.error(500, "抱歉，系统繁忙，请稍后再试");
        } else {
        	ModelAndView model =new ModelAndView();
        	model.setViewName("redirect:/html/error/500.html");
        	return model;
        }
    }
    
    private Boolean isJson(HttpServletRequest request) {
    	String header = request.getHeader("content-type");
    	return header != null && header.contains("json");
    }
}


