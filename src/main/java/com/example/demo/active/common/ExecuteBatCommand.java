/**
 * 执行此类中的main方法，即可启动ActiveMQ服务
 */
package com.example.demo.active.common;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.stereotype.Component;

import com.example.demo.util.DateUtil;


/**
 * 启动Tomcat即时初始化次类
 * @author Arvin_Cheng
 *
 */
@Component
public class ExecuteBatCommand implements ServletContextListener{
	
	
	public static void main(String[] args) {
		String strcmd = "cmd /c start D:\\ActiveMQ\\apache-activemq-5.14.4\\bin\\win64\\activemq.bat";
		run_cmd(strcmd);
	}

	public static void run_cmd(String strcmd){
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("关闭监听的ActiveMQ服务！");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		System.out.println("监听启动ActiveMQ服务！");
		System.out.println("批处理执行开始时间" + DateUtil.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		
		String strcmd = "cmd /c start D:\\ActiveMQ\\apache-activemq-5.14.4\\bin\\win64\\activemq.bat";
		
		Runtime rt = Runtime.getRuntime(); // Runtime.getRuntime()返回当前应用程序的Runtime对象
		Process ps = null; // Process可以控制该子进程的执行或获取该子进程的信息。
		try {
			ps = rt.exec(strcmd); // 该对象的exec()方法指示Java虚拟机创建一个子进程执行指定的可执行程序，并返回与该子进程对应的Process对象实例。
			ps.waitFor(); // 等待子进程完成再往下执行。
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int i = ps.exitValue(); // 接收执行完毕的返回值
		if (i == 0) {
			System.out.println("启动ActiveMQ服务成功；  通过地址：  http://127.0.0.1:8161/admin/  可以访问ActiveMQ服务首页，登录ActiveMQ服务首页的账号请咨询Arvin。");
			System.out.println("批处理执行结束时间" + DateUtil.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		} else {
			System.out.println("启动ActiveMQ服务失败！");
		}

		ps.destroy(); // 销毁子进程
		ps = null;
	}
}
