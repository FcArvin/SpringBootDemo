/**
 * 异步请求Controller
 * @author Arvin_Cheng
 *
 */
package com.example.demo.controller;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.task.AsyncTask;

@RestController//使用SpringBoot中@RestController =  SpringMVC中的@Controller + @ResponseBody
public class AsyncTaskController{
	
	@Autowired
	private AsyncTask springBootDemoAsyncTask;
	
	@RequestMapping("/asyncRequest")
	public String asyncRequest() {
		long start = System.currentTimeMillis();
		
		Future<Boolean> a = springBootDemoAsyncTask.firstSpringBootAsyncTask();
		Future<Boolean> b = springBootDemoAsyncTask.towSpringBootAsyncTask();
		Future<Boolean> c = springBootDemoAsyncTask.threeSpringBootAsyncTask();
		
		while (!a.isDone() || !b.isDone() || !c.isDone()) {
			if(a.isDone() && b.isDone() && c.isDone()) {
				break;
			}
		}
		
		long end = System.currentTimeMillis();
		String time = "所有任务全部完成,所需要的时间是：" + (end - start) + "毫秒！";
		System.out.println(time);
		
		return time;
	}
	
}