package com.example.demo.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 
 * @author Arvin_Cheng
 *
 */
public class GlobalUseMethod {
	
	/**
	 * 获取request对象，获取当前用户名
	 * @return
	 */
	public static String getSessionLoginName(){
		
		if(RequestContextHolder.getRequestAttributes() == null){
			return null;
		}
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
				
		HttpSession session = request.getSession();
		
		String loginName = session.getAttribute("loginName").toString();
		
		return loginName;
	}
}
