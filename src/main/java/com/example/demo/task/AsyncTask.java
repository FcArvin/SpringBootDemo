/**
 * @author Arvin_Cheng
 *
 */
package com.example.demo.task;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask{
	
	//表示此方法是异步处理的
	@Async
	public Future<Boolean> firstSpringBootAsyncTask() {
		
		long start = System.currentTimeMillis();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("这是第一个异步任务,所需要的时间是：" + (end - start) + "毫秒！");
		
		return new AsyncResult<>(true);
	}
	
	@Async
	public Future<Boolean> towSpringBootAsyncTask() {
		
		long start = System.currentTimeMillis();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("这是第二个异步任务,所需要的时间是：" + (end - start) + "毫秒！");
		
		return new AsyncResult<>(true);
	}
	
	@Async
	public Future<Boolean> threeSpringBootAsyncTask() {

		long start = System.currentTimeMillis();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("这是第三个异步任务,所需要的时间是：" + (end - start) + "毫秒！");
		
		return new AsyncResult<>(true);
	}
}