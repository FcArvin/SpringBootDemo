package com.example.demo.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.active.service.ConsumerService;
import com.example.demo.active.service.ProducerService;
import com.example.demo.exception.CustomExceptionClass;
import com.example.demo.service.LoginService;

/**
 * 自定义异常类
 * @author Arvin_Cheng
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	private ConsumerService consumerService;
	
	@Autowired
	private LoginService loginService;
	
	/**
	 *	显示登录页面（使用thymeleaf模板引擎）
	 * @param map
	 * @return
	 */
	@RequestMapping("/loginPage")
    public String loginActionClas(ModelMap map) {
        return "login/login";
    }
	
	/**
	 * 	登录请求
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/loginRequest")
	public @ResponseBody String loginFunction(HttpServletRequest request, HttpServletResponse response) {

		String loginJsonStr = request.getParameter("loginObj").toString();
		
		Map mapObj = JSON.parseObject(loginJsonStr);
		
		String loginName = mapObj.get("loginName").toString();
		String loginPassword = mapObj.get("loginPassword").toString();
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("loginName", loginName);
		jsonObj.put("loginPassword", loginPassword);
		
		HttpSession session = request.getSession();
		session.setAttribute("loginName", loginName);
		session.setAttribute("loginPassword", loginPassword);
		
		producerService.producer(jsonObj);
		
		String msgStr = consumerService.consumer(); 
		jsonObj.put("msgStr", msgStr);

		if (StringUtils.isBlank(loginName) && StringUtils.isBlank(loginPassword)) {
			try {
				throw new CustomExceptionClass("EC001-001", "用户名和密码为空！");
			} catch (CustomExceptionClass e) {
				try {
					response.getWriter().write(e.getErrorCode());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				return "F";
			}
		}
		
		jsonObj = loginService.getLoginStatus(loginName,loginPassword);
		
		
		return jsonObj.toString();
	}
	
	/**
	 *	跳转到系统首页（使用thymeleaf模板引擎）
	 * @param map
	 * @return
	 */
	@RequestMapping("/homePageRequest")
    public String homePageRequest(ModelMap map) {
        return "index/index";
    }
}
