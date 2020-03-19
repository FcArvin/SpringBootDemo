/**
 * 数据返回处理类
 * @author Arvin_Cheng
 *
 */
package com.example.demo.util;

import java.util.List;

public class JSONResult{
	
	
	private Integer status;
	
	private String msg;
	
	private Integer total;
	
	private Object data;
	
	public JSONResult(Object data){
		if(data instanceof List) {
			List<?> list = (List<?>) data;
			this.total = list.size();
		}else {
			this.total = 1;
		}
		this.status = 200;
		this.msg = "Success";
		this.data = data;
	}
	
	public JSONResult(){
		this.status = 500;
		this.msg = "Fail";
	}
	
	public JSONResult(String msg){
		this.status = 500;
		this.msg = msg;
	}
	
	public static JSONResult ok(Object data){
		return new JSONResult(data);
	}
	
	public static JSONResult ok(){
		return new JSONResult();
	}
	
	public static JSONResult fail(){
		return new JSONResult();
	}
	
	public static JSONResult failMsg(String msg){
		return new JSONResult(msg);
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}