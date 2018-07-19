package com.ssmvue.common;



public class JSONResult{
	
	private boolean success;
	private String message;
	private String code;
	private Object content;

	/** 
	* <p>Title: </p> 
	* <p>Description: </p>  
	*/
	public JSONResult() {
	}
	
	
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @param success
	* @param message 
	*/
	public JSONResult(boolean success, String message) {
		this.success = success;
		this.message = message;
	}


	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @param success
	* @param message
	* @param content 
	*/
	public JSONResult(boolean success, String message, Object content) {
		this.success = success;
		this.message = message;
		this.content = content;
	}


	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @param success
	* @param message
	* @param code
	* @param content 
	*/
	public JSONResult(boolean success, String message, String code, Object content) {
		super();
		this.success = success;
		this.message = message;
		this.code = code;
		this.content = content;
	}

	/**
	 * @return the code
	 *
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 *
	 */
	public JSONResult setCode(String code) {
		this.code = code;
		return this;
	}
	/**
	 * @return the content
	 *
	 */
	public Object getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 *
	 */
	public JSONResult setContent(Object content) {
		this.content = content;
		return this;
	}
	/**
	 * @return the message
	 *
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 *
	 */
	public JSONResult setMessage(String message) {
		this.message = message;
		return this;
	}
	/**
	 * @return the success
	 *
	 */
	public boolean isSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 *
	 */
	public JSONResult setSuccess(boolean success) {
		this.success = success;
		return this;
	}

}
