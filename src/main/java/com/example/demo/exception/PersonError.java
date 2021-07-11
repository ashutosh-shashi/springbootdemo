package com.example.demo.exception;

public class PersonError {

	private String errorid;
	private String errorMsg;
	
	public PersonError() {}
	
	public PersonError(String errorid, String errorMsg) {
		super();
		this.errorid = errorid;
		this.errorMsg = errorMsg;
	}

	public String getErrorid() {
		return errorid;
	}

	public void setErrorid(String errorid) {
		this.errorid = errorid;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
}
