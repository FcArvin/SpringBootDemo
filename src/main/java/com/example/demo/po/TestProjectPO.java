/**
 * 
 */
/**
 * @author Arvin_Cheng
 *
 */
package com.example.demo.po;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class TestProjectPO{
	
	private String projectName;
	
	private String projectAuthor;
	
	//通过这个注解格式化日期，注解中的参数，第一个表示格式化的格式，第二个表示中国，第三个表示东八区
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale="zh",timezone="GMT+8")
	private Date projectDate;
	
	private String projectRemark;
	
	//通过这个注解使projectRemark1字段不返回到客户端或者忽略掉
	@JsonIgnore
	private String projectRemark1;
	
	//这个注解表示如果字段为空，则不返回，不为空则返回
	@JsonInclude(Include.NON_NULL)
	private String projectRemark2;
	
	private int age;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectAuthor() {
		return projectAuthor;
	}

	public void setProjectAuthor(String projectAuthor) {
		this.projectAuthor = projectAuthor;
	}

	public Date getProjectDate() {
		return projectDate;
	}

	public void setProjectDate(Date projectDate) {
		this.projectDate = projectDate;
	}

	public String getProjectRemark() {
		return projectRemark;
	}

	public void setProjectRemark(String projectRemark) {
		this.projectRemark = projectRemark;
	}
	
	public String getProjectRemark1() {
		return projectRemark1;
	}

	public void setProjectRemark1(String projectRemark1) {
		this.projectRemark1 = projectRemark1;
	}

	public String getProjectRemark2() {
		return projectRemark2;
	}

	public void setProjectRemark2(String projectRemark2) {
		this.projectRemark2 = projectRemark2;
	}

	@Override
	public String toString() {
		return "SpringBootDemoPO [projectName=" + projectName + ", projectAuthor=" + projectAuthor + ", projectDate="
				+ projectDate + ", projectRemark=" + projectRemark + ", projectRemark1=" + projectRemark1
				+ ", projectRemark2=" + projectRemark2 + "]";
	}
	
}