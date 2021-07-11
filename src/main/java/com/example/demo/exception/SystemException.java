package com.example.demo.exception;

public class SystemException extends RuntimeException {

	private String errId;
	private String msg;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3677675663976396590L;

	public SystemException(String errId, String msg) {
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
