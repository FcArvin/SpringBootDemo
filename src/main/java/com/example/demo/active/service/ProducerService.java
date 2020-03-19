/**
 * @author Arvin_Cheng
 *
 */
package com.example.demo.active.service;

import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.active.common.ActiveConnectionInfo;
import com.example.demo.resource.PropertiesResource;
import com.example.demo.util.GlobalUseMethod;

@Service
public class ProducerService {
	

	private static Session session;
	
	private static MessageProducer producer;
	
	@Autowired
	private ActiveConnectionInfo activeConnectionInfo;
	
	/**
	 * 向指定队列发送消息
	 */
	public boolean producer(JSONObject jsonObj){
		try {
			
			session = activeConnectionInfo.getSession();
			
			Destination destination = session.createQueue(PropertiesResource.getActiveMq_Service_Queue_Name());
			
			producer = session.createProducer(destination);//创建创建者
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			
			producer.send(session.createObjectMessage(jsonObj));//发送消息
			
			System.out.println(GlobalUseMethod.getSessionLoginName() + " 成功发送一条消息，消息内容：" + jsonObj.toJSONString());
			
			producer.close();//关闭创建者
			
		} catch (JMSException e) {
			System.out.println("消息发送失败！！！");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}