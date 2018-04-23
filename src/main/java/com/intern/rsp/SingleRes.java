package com.intern.rsp;

public class SingleRes extends BaseRes {

	// region -- Fields --

	private Object result;

	// end

	// region -- Get set --

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public SingleRes(Object result) {
		super();
		this.result = result;
	}

	// end

	// region -- Methods --

	public SingleRes() {
		super();
	}

	// end
}