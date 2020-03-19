/**
 * 第一个拦截器类
 * @author Arvin_Cheng
 *
 */
package com.example.demo.configuration.interceptor;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.util.JsonUtils;
import com.example.demo.util.JSONResult;

public class FirstInterceptor implements HandlerInterceptor{
	
	/**
	 * 在请求处理之前进行调用（Controller方法调用之前）
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object object) throws Exception {
		
		System.out.println("第一个拦截器拦截到请求，检查中......，通过检查，第二个拦截器可以拦截 并检查，放行...");
		
		return true;
		
		/*
		if (true) {
			returnErrorResponse(response, SpringBootDemoJSONResult.errorMsg("被one拦截..."));
		}
		
		return false;
		*/
	}
	
	/**
	 * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, 
			Object object, ModelAndView mv)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行
	 * （主要是用于进行资源清理工作）
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
			Object object, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void returnErrorResponse(HttpServletResponse response, JSONResult result) 
			throws IOException, UnsupportedEncodingException {
		OutputStream out=null;
		try{
		    response.setCharacterEncoding("utf-8");
		    response.setContentType("text/json");
		    out = response.getOutputStream();
		    out.write(JsonUtils.objectToJson(result).getBytes("utf-8"));
		    out.flush();
		} finally{
		    if(out!=null){
		        out.close();
		    }
		}
	}
}