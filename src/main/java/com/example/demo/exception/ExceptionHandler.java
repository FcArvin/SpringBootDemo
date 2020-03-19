package com.example.demo.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.util.JSONResult;

/**
 * 异常捕获类
 * @author Arvin_Cheng
 *
 */	
@ControllerAdvice
public class ExceptionHandler {

	public static final String IMOOC_ERROR_VIEW = "error";//配置的error页面

	/**
	 * 处理捕获web端的异常
	 * @param reqest
	 * @param response
	 * @param e
	 * @return
	 * @throws Exception
	 */
	/*@ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest reqest, 
    		HttpServletResponse response, Exception e) throws Exception {
    	
    	e.printStackTrace();
    	
		ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", reqest.getRequestURL());
        mav.setViewName(IMOOC_ERROR_VIEW);
        return mav;
    }*/
	
	/**
	 * 捕获ajax调用异常或者web端的异常，并且处理
	 * @param reqest
	 * @param response
	 * @param e
	 * @return
	 * @throws Exception
	 */
	/*@ExceptionHandler(value = Exception.class)
	public SpringBootDemoJSONResultUtil defaultErrorHandler(HttpServletRequest req, 
			Exception e) throws Exception {

		e.printStackTrace();
		return SpringBootDemoJSONResultUtil.failMsg(e.getMessage());
	}*/
	
	/**
	 * 捕获并且区分ajax调用异常
	 * @param reqest
	 * @param response
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest reqest, 
    		HttpServletResponse response, Exception e) throws Exception {
    	
    	e.printStackTrace();
    	
    	if (isAjax(reqest)) {
    		return JSONResult.failMsg(e.getMessage());
    	} else {
    		ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", reqest.getRequestURL());
            mav.setViewName(IMOOC_ERROR_VIEW);
            return mav;
    	}
    }
	
	/**
	 * 
	 * @Title: IMoocExceptionHandler.java
	 * @Package com.imooc.exception
	 * @Description: 判断是否是ajax请求
	 * Copyright: Copyright (c) 2017
	 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
	 * 
	 * @author Arvin_Feng
	 * @date 2018年6月3日 下午1:40:39
	 * @version V1.0
	 */
	public static boolean isAjax(HttpServletRequest httpRequest){
		return  (httpRequest.getHeader("X-Requested-With") != null  
					&& "XMLHttpRequest"
						.equals( httpRequest.getHeader("X-Requested-With").toString()) );
	}
}
