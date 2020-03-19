/**
 * @author Arvin_Cheng
 *
 */
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.resource.PropertiesResource;

@RestController
public class InterceptorController{
	
	@Autowired
	private PropertiesResource resource;
	
	@RequestMapping("/First")
    public String First() {
        return "freemarker/center/center";
    }
	
	@RequestMapping("/Tow")
    public String Tow(ModelMap map) {
        map.addAttribute("resource", resource);
        return "freemarker/index";
    }
	
	@RequestMapping("/Three")
	public String Three(){
		return "成功请求到SpringBootController,第一个方法";
	}
}