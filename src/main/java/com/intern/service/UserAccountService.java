package com.intern.service;

import com.intern.model.UserAccount;

public interface UserAccountService {
	UserAccount findUserAccountByUserName(String userName);

	UserAccount findUserAccountByEmail(String email);

	String save(UserAccount newUserAccount);

	UserAccount update(UserAccount newUserAccount);

	UserAccount delete(String userName);
}