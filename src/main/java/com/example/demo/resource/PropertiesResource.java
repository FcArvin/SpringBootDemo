/**
 * 
 */
/**
 * @author Arvin_Cheng
 *
 */
package com.example.demo.resource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix="com.example.demo")
@PropertySource(value="classpath:resources.properties")
public class PropertiesResource{
	
	private static String name;
	private static String website;
	private static String java;
	
	/**
	 * ActiveMq服务地址
	 */
	private static String ActiveMq_Service_Path;
	
	/**
	 * ActiveMq服务队列名
	 */
	private static String ActiveMq_Service_Queue_Name;
	
	/**
	 * ActiveMq服务登录名
	 */
	private static String ActiveMq_Service_Login_Name;
	
	/**
	 * ActiveMq服务登录密码
	 */
	private static String ActiveMq_Service_Login_Password;

	private static String MAIL_TRUEVALUE;
	private static String MAIL_FALSEVALUE;
	private static String MAIL_PROXYSET;
	private static String MAIL_SOCKSPROXYHOST;
	private static String MAIL_SOCKSPROXYPORT;
	private static String MAIL_SMTP_HOST;
	private static String MAIL_SMTP_AUTH;
	private static String MAIL_SMTP_SSL_ENABLE;
	
	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		PropertiesResource.name = name;
	}

	public static String getWebsite() {
		return website;
	}

	public static void setWebsite(String website) {
		PropertiesResource.website = website;
	}

	public static String getJava() {
		return java;
	}

	public static void setJava(String java) {
		PropertiesResource.java = java;
	}
	

	public static String getActiveMq_Service_Path() {
		return ActiveMq_Service_Path;
	}

	
	public void setActiveMq_Service_Path(String activeMq_Service_Path) {
		ActiveMq_Service_Path = activeMq_Service_Path;
	}


	public  static String getActiveMq_Service_Queue_Name() {
		return ActiveMq_Service_Queue_Name;
	}


	public static void setActiveMq_Service_Queue_Name(String activeMq_Service_Queue_Name) {
		ActiveMq_Service_Queue_Name = activeMq_Service_Queue_Name;
	}


	public static String getActiveMq_Service_Login_Name() {
		return ActiveMq_Service_Login_Name;
	}


	public static void setActiveMq_Service_Login_Name(String activeMq_Service_Login_Name) {
		ActiveMq_Service_Login_Name = activeMq_Service_Login_Name;
	}


	public static String getActiveMq_Service_Login_Password() {
		return ActiveMq_Service_Login_Password;
	}


	public static void setActiveMq_Service_Login_Password(String activeMq_Service_Login_Password) {
		ActiveMq_Service_Login_Password = activeMq_Service_Login_Password;
	}


	public static String getMAIL_TRUEVALUE() {
		return MAIL_TRUEVALUE;
	}


	public static void setMAIL_TRUEVALUE(String mAIL_TRUEVALUE) {
		MAIL_TRUEVALUE = mAIL_TRUEVALUE;
	}


	public static String getMAIL_FALSEVALUE() {
		return MAIL_FALSEVALUE;
	}


	public static void setMAIL_FALSEVALUE(String mAIL_FALSEVALUE) {
		MAIL_FALSEVALUE = mAIL_FALSEVALUE;
	}


	public static String getMAIL_PROXYSET() {
		return MAIL_PROXYSET;
	}


	public static void setMAIL_PROXYSET(String mAIL_PROXYSET) {
		MAIL_PROXYSET = mAIL_PROXYSET;
	}


	public static String getMAIL_SOCKSPROXYHOST() {
		return MAIL_SOCKSPROXYHOST;
	}


	public static void setMAIL_SOCKSPROXYHOST(String mAIL_SOCKSPROXYHOST) {
		MAIL_SOCKSPROXYHOST = mAIL_SOCKSPROXYHOST;
	}


	public static String getMAIL_SOCKSPROXYPORT() {
		return MAIL_SOCKSPROXYPORT;
	}


	public static void setMAIL_SOCKSPROXYPORT(String mAIL_SOCKSPROXYPORT) {
		MAIL_SOCKSPROXYPORT = mAIL_SOCKSPROXYPORT;
	}


	public static String getMAIL_SMTP_HOST() {
		return MAIL_SMTP_HOST;
	}


	public static void setMAIL_SMTP_HOST(String mAIL_SMTP_HOST) {
		MAIL_SMTP_HOST = mAIL_SMTP_HOST;
	}


	public static String getMAIL_SMTP_AUTH() {
		return MAIL_SMTP_AUTH;
	}


	public static void setMAIL_SMTP_AUTH(String mAIL_SMTP_AUTH) {
		MAIL_SMTP_AUTH = mAIL_SMTP_AUTH;
	}


	public static String getMAIL_SMTP_SSL_ENABLE() {
		return MAIL_SMTP_SSL_ENABLE;
	}


	public static void setMAIL_SMTP_SSL_ENABLE(String mAIL_SMTP_SSL_ENABLE) {
		MAIL_SMTP_SSL_ENABLE = mAIL_SMTP_SSL_ENABLE;
	}


	@Override
	public String toString() {
		return "PpropertiesResource [ActiveMq_Service_Path=" + ActiveMq_Service_Path + ", ActiveMq_Service_Queue_Name="
				+ ActiveMq_Service_Queue_Name + ", ActiveMq_Service_Login_Name=" + ActiveMq_Service_Login_Name
				+ ", ActiveMq_Service_Login_Password=" + ActiveMq_Service_Login_Password + ", MAIL_TRUEVALUE="
				+ MAIL_TRUEVALUE + ", MAIL_FALSEVALUE=" + MAIL_FALSEVALUE + ", MAIL_PROXYSET=" + MAIL_PROXYSET
				+ ", MAIL_SOCKSPROXYHOST=" + MAIL_SOCKSPROXYHOST + ", MAIL_SOCKSPROXYPORT=" + MAIL_SOCKSPROXYPORT
				+ ", MAIL_SMTP_HOST=" + MAIL_SMTP_HOST + ", MAIL_SMTP_AUTH=" + MAIL_SMTP_AUTH
				+ ", MAIL_SMTP_SSL_ENABLE=" + MAIL_SMTP_SSL_ENABLE + "]";
	}
}