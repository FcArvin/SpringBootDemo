/**
 * 
 */
/**
 * @author Arvin_Cheng
 *
 */
package com.example.demo.active.common;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.resource.PropertiesResource;

@Component
public class ActiveConnectionInfo{
	
	@Autowired
	private static PropertiesResource resource;
	
	
	@SuppressWarnings("static-access")
	public Session getSession() {
		Session session = null;
		try {
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
					resource.getActiveMq_Service_Login_Name(), 
					resource.getActiveMq_Service_Login_Password(), 
					resource.getActiveMq_Service_Path());
			
			Connection connection = connectionFactory.createConnection();
			connection.start();
			
			//第一个参数是是否是事务型消息，设置为true,第二个参数无效
			session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return session;
	}
}