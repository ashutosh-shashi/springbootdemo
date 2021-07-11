package com.example.demo.exception;

public class BusinessException extends RuntimeException {

	private String errId;
	private String msg;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BusinessException(String errId, String msg) {
		super();
		this.errId = errId;
		this.msg = msg;
	}

	public String getErrId() {
		return errId;
	}

	public void setErrId(String errId) {
		this.errId = errId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
}
