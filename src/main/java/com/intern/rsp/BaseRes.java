package com.intern.rsp;

public class BaseRes {

	// region -- Fields --

	private String callStatus;
	private String message;

	// end

	// region -- Get set --

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

	// end

	// region -- Methods --

	public BaseRes() {
		this.callStatus = "Success";
		this.message = "";
	}

	// end
}