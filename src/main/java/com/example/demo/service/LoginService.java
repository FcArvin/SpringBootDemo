/**
 * @author Arvin_Cheng
 *
 */
package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;

public interface LoginService{
	

	public String getNewName(String userName); 
	
	public JSONObject getLoginStatus(String loginName,String loginPassword);
}