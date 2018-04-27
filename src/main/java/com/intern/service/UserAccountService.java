package com.intern.service;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.intern.model.UserAccount;

public interface UserAccountService {
	UserAccount findUserAccountByUserName(String userName);

	UserAccount findUserAccountByEmail(String email);

	String save(UserAccount newUserAccount);

	UserAccount update(UserAccount newUserAccount);

	UserAccount delete(String userName);

	List<SimpleGrantedAuthority> getAuthorityByUserId();
}