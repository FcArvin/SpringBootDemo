package com.example.demo.active.service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.active.common.ActiveConnectionInfo;
import com.example.demo.resource.PropertiesResource;
import com.example.demo.util.GlobalUseMethod;
 
@Service
public class ConsumerService{
	
	private static Session session;

	private static MessageConsumer consumer;
	
	@Autowired
	private ActiveConnectionInfo activeConnectionInfo;
	
	/** 
     * attention: 
     * Details：接收消息，同时回复消息 
     * @author Arvin_Cheng 
     * 创建时间：2016-7-28 下午2:39:45 
     * @param destination 
     * @return 
     */  
	public String consumer(){
		
		String msgStr = "";
		
		try {
			
			session = activeConnectionInfo.getSession();
			
			Destination destination = session.createQueue(PropertiesResource.getActiveMq_Service_Queue_Name());
			
			consumer = session.createConsumer(destination);//创建消费者
			
			ActiveMQObjectMessage msg =  (ActiveMQObjectMessage) consumer.receive();//接收消息
			
            if(msg!=null) {
            	
                msgStr = msg.getObject().toString();

                System.out.println(GlobalUseMethod.getSessionLoginName() + " 成功接收到一封消息，消息内容是："+msg.getObject());
                
            }
            
            consumer.close();//关闭消费对象
            
		} catch (JMSException e) {
			System.out.println("消息发送失败！！！");
			e.printStackTrace();
		}
		return msgStr;
	}
}
