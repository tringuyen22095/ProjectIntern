package com.intern.service;

import com.intern.model.*;

public interface UserAccountService {
	public UserAccount findUserAccountByUserName(String userName);

	public UserAccount findUserAccountByEmail(String email);

	public String save(UserAccount newUserAccount);

	public UserAccount update(UserAccount newUserAccount);

	public UserAccount delete(String userName);
}
