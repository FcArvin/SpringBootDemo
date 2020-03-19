package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.po.TestProjectPO;
import com.example.demo.resource.PropertiesResource;

@Controller
public class ThymeleafController {
	
	@Autowired
	private PropertiesResource resource;

	@RequestMapping("/Method_8")
    public String index(ModelMap map) {
        map.addAttribute("projectName", "StringBoot-thymeleaf");
        return "thymeleaf/index";
    }
	
	@RequestMapping("/Method_9")
    public String index2(ModelMap map) {
        map.addAttribute("resource", resource);
        return "thymeleaf/index2";
    }
	
	@RequestMapping("/Method_10")
    public String center() {
        return "thymeleaf/center/center";
    }
	
	@RequestMapping("/Method_11")
    public String test(ModelMap map) {
		
		TestProjectPO po = new TestProjectPO();
		po.setProjectName("SpringBoot___");
		po.setProjectAuthor("Arvin_Feng");
		po.setProjectDate(new Date());
		po.setProjectRemark("第一个SpringBoot项目例子，第四个方法");
		po.setProjectRemark1("测试注解@JsonIgnore");
		po.setProjectRemark2("<font color='green'><b>hello imooc</b></font>");
		po.setAge(18);
		map.addAttribute("user", po);
		
		TestProjectPO po1 = new TestProjectPO();
		po1.setProjectName("SpringBoot___1");
		po1.setProjectAuthor("Arvin_Feng");
		po1.setProjectDate(new Date());
		po1.setProjectRemark("第一个SpringBoot项目例子，第四个方法");
		po1.setProjectRemark1("测试注解@JsonIgnore");
		po1.setProjectRemark2("<font color='green'><b>hello imooc</b></font>");
		
		TestProjectPO po2 = new TestProjectPO();
		po2.setProjectName("SpringBoot___2");
		po2.setProjectAuthor("Arvin_Feng");
		po2.setProjectDate(new Date());
		po2.setProjectRemark("第一个SpringBoot项目例子，第四个方法");
		po2.setProjectRemark1("测试注解@JsonIgnore");
		po2.setProjectRemark2("<font color='green'><b>hello imooc</b></font>");
		
		List<TestProjectPO> userList = new ArrayList<>();
		userList.add(po);
		userList.add(po1);
		userList.add(po2);
		
		map.addAttribute("userList", userList);
		
		return "thymeleaf/thymeleafTest";
    }
	
	@PostMapping("/Method_12")
    public String postform(TestProjectPO po) {
		
		po.setProjectName("SpringBoot___1");
		po.setProjectAuthor("Arvin_Feng_一号");
		po.setProjectDate(new Date());
		po.setProjectRemark("第一个SpringBoot项目例子，第四个方法");
		po.setProjectRemark1("测试注解@JsonIgnore");
		po.setProjectRemark2("<font color='green'><b>hello imooc</b></font>");
		
		
		System.out.println("项目名称：" + po.getProjectName());
		System.out.println("项目作者：" + po.getProjectAuthor());
		return "redirect:/Method_11";
    }
	
}