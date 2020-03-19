/**
 * 
 */
/**
 * @author Arvin_Cheng
 *
 */
package com.example.demo.util;

import javax.jms.Message;
import javax.jms.MessageListener;

public class CustomListener implements MessageListener {

	@Override
	public void onMessage(Message arg0) {
		System.out.println("自己定义一个监听器！");
	}
 }