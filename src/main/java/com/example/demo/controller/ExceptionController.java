package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.util.JSONResult;

@Controller
@RequestMapping("/exception")
public class ExceptionController {
	
	
	@RequestMapping("/error")
	public String errors() {
		
		@SuppressWarnings("unused")
		int a = 1 / 0;
		
		return "exception/exception";
	}
	
	@RequestMapping("/ajaxerror")
	public String ajaxerror() {
		
		return "/ajaxerror";
	}
	
	@RequestMapping("/getAjaxerror")
	@ResponseBody
	public JSONResult getAjaxerror() {
		
		@SuppressWarnings("unused")
		int a = 1 / 0;
		
		return JSONResult.ok();
	}
}