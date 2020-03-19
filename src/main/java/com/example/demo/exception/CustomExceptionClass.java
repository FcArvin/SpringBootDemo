/**
 * 
 */
/**
 * @author Arvin_Cheng
 *
 */
package com.example.demo.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;

public class CustomExceptionClass extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**异常编码*/
	private String errorCode = "SGS-000001";
	
	/**异常描述*/
	private String errorMessage = "UNDEFINED";

	@Autowired  
    private static ResourceBundleMessageSource rms;
      
	
	public CustomExceptionClass() {

	}

	public CustomExceptionClass(String code) {
		this.errorCode = code;
		this.errorMessage =rms.getMessage(code, null, null); 
	}

	public CustomExceptionClass(String code, String message) {
		this.errorCode = code;
		this.errorMessage = message;
	}

	public CustomExceptionClass(String code, String message, Throwable cause) {
		super(cause);
		this.errorCode = code;
		this.errorMessage = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}