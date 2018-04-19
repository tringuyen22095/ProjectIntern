package com.intern.res;

public class SingleRes extends BaseRes {
	private Object result;

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

	public SingleRes() {
		super();
	}

}
