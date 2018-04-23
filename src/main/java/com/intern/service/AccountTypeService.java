package com.intern.service;

import java.util.List;

import com.intern.model.AccountType;

public interface AccountTypeService {
	List<AccountType> findAccountTypeLikeName(String name);

	List<AccountType> findAccountType();
}
