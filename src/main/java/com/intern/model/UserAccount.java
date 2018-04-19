package com.intern.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_account", schema = "public")
public class UserAccount implements Serializable {
	@Id
	@Column(name = "user_name", updatable = false, nullable = false)
	private String userName;
	@Column(name = "password", nullable = true)
	private String password;
	@Column(name = "full_name", nullable = true)
	private String fullName;
	@Column(name = "email", nullable = true)
	private String email;
	@Column(name = "telephone", nullable = true)
	private String telephone;
	@Column(name = "status", nullable = false)
	private String status;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserAccount(String userName, String password, String fullName, String email, String telephone,
			String status) {
		super();
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.telephone = telephone;
		this.status = status;
	}

	public UserAccount() {
		super();
	}

}
