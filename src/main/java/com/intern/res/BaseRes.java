package com.intern.res;

public class BaseRes {
	private String callStatus;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCallStatus() {
		return callStatus;
	}

	public void setCallStatus(String callStatus) {
		this.callStatus = callStatus;
	}

	public BaseRes() {
		this.callStatus = "Success";
		this.message = "";
	}
}
