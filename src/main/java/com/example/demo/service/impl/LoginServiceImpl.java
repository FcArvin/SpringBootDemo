/**
 * @author Arvin_Cheng
 *
 */
package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.active.service.ConsumerService;
import com.example.demo.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	public ConsumerService consumerService;
	
	public String getNewName(String userName) {
		  
		 return userName;
	}

	@Override
	public JSONObject getLoginStatus(String loginName,String loginPassword) {
		
		JSONObject jsonO = new JSONObject();
		
		jsonO.put("loginUserName", loginName);
		
		jsonO.put("status", "S");
		
		return jsonO;
	}
}