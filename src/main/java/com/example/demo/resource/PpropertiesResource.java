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
public class PpropertiesResource{
	
	private String name;
	
	private String website;
	
	private String languge;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLanguge() {
		return languge;
	}

	public void setLanguge(String languge) {
		this.languge = languge;
	}

	@Override
	public String toString() {
		return "SpringBootDemoResource [name=" + name + ", website=" + website + ", languge=" + languge + "]";
	}
	
}