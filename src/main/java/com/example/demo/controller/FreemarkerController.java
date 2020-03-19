package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.resource.PropertiesResource;

@Controller//使用SpringMVC  Controller
public class FreemarkerController {

	@Autowired
	private PropertiesResource resource;
	
	@RequestMapping("/Method_6")
    public String center() {
        return "freemarker/center/center";
    }
	
	@RequestMapping("/Method_7")
    public String index(ModelMap map) {
        map.addAttribute("resource", resource);
        return "freemarker/index";
    }
}