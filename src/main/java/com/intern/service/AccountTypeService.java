package com.intern.service;

import java.util.List;

import com.intern.model.AccountType;

public interface AccountTypeService {
	public List<AccountType> findAccountTypeLikeName(String name);

	public List<AccountType> findAccountType();
}
