/**
 * @author Arvin_Cheng
 *
 */
package com.example.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimingTask{
	
	//3000表示3秒，定义没三秒执行一次定时任务
	@Scheduled(fixedRate = 3000)
	public void firstSpringBootTask() {
		System.out.println("这是第一个定时任务！");
	}
}