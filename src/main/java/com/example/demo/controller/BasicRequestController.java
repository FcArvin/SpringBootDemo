/**
 * @author Arvin_Cheng
 *
 */
package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.po.TestProjectPO;
import com.example.demo.resource.PropertiesResource;
import com.example.demo.util.JSONResult;

@RestController//使用SpringBoot中@RestController =  SpringMVC中的@Controller + @ResponseBody
public class BasicRequestController{
	
	@Autowired
	private PropertiesResource resource;
	
	
	@RequestMapping("/Method_1")
	public Object getFirstDemoInfo_1(){
		return "成功请求到SpringBootController,第一个方法";
	}
	
	@RequestMapping("/Method_2/{name}")
	public Object getFirstDemoInfo_2(@PathVariable String name){
		System.out.println("成功获取到客户端传往服务端的参数，参数是：------->" + name);
		return "成功请求到SpringBootController,第二个方法, 返回从客户端获取到的参数，参数是：------->" + name;
	}
	
	@RequestMapping("/Method_3")
	public Object getFirstDemoInfo_3(){
		TestProjectPO po = new TestProjectPO();
		po.setProjectName("SpringBoot");
		po.setProjectAuthor("Arvin_Feng");
		po.setProjectDate(new Date());
		po.setProjectRemark("第一个SpringBoot项目例子，第三个方法");
		return po;
	}
	
	@RequestMapping("/Method_4")
	public JSONResult getFirstDemoInfo_4(){
		TestProjectPO po = new TestProjectPO();
		po.setProjectName("SpringBoot");
		po.setProjectAuthor("Arvin_Feng");
		po.setProjectDate(new Date());
		po.setProjectRemark("第一个SpringBoot项目例子，第四个方法");
		po.setProjectRemark1("测试注解@JsonIgnore");
		po.setProjectRemark2(null);
		return JSONResult.ok(po);
	}
	
	@RequestMapping("/Method_5")
	public JSONResult getFirstDemoInfo_5(){
		PropertiesResource bean = new PropertiesResource();
		BeanUtils.copyProperties(resource, bean);
		return JSONResult.ok(bean);
	}
	
	
}