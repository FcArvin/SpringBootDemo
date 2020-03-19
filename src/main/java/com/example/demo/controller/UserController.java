package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.po.TbSbuser;
import com.example.demo.service.UserService;
import com.example.demo.util.JSONResult;

@RestController
public class UserController {

	@Autowired
	private UserService springBootDemoService;
	
	/**
	 * 通过id查询用户信息
	 */
	@RequestMapping("/queryUserInfoById/{id}")
	public JSONResult queryUserInfoById(@PathVariable String id) {
		Object obj = springBootDemoService.queryUserInfoById(id);
		TbSbuser TbSbuser = new TbSbuser();
		BeanUtils.copyProperties(obj, TbSbuser);
		return JSONResult.ok(TbSbuser);
	}
	
	/**
	 * 通过id查询用户信息
	 */
	@RequestMapping("/queryUserInfoPaged")
	public JSONResult queryUserInfoPaged() {
		Integer page = 1;//当前第几页
		Integer pageSize = 10;//每页显示多少条数据
		
		TbSbuser TbSbuser = new TbSbuser();
		TbSbuser.setUsername("Arvin_Cheng");
		
		List<TbSbuser> userList = springBootDemoService.queryUserInfoPaged(TbSbuser,page,pageSize);
		return JSONResult.ok(userList);
	}
}
