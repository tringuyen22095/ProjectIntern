package com.intern.req;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserAccountReq {

	// region -- Fields --

	@JsonProperty("user_name")
	private String userName;
	@JsonProperty("password")
	private String password;
	@JsonProperty("full_name")
	private String fullName;
	@JsonProperty("email")
	private String email;
	@JsonProperty("telephone")
	private String telephone;
	@JsonProperty("status")
	private String status;

	// end

	// region -- Get set --

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	// end

	// region -- Methods --

	public UserAccountReq() {
		super();
	}

	// end
}