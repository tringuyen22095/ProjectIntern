package com.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intern.dao.AccountTypeDao;
import com.intern.model.AccountType;
import com.intern.service.AccountTypeService;

@Service
@Transactional
public class AccountTypeServiceImpl implements AccountTypeService {

	// region -- Fields --

	@Autowired
	private AccountTypeDao dao;

	// end

	// region -- Methods --

	@Override
	public List<AccountType> findAccountTypeLikeName(String name) {
		return dao.getAccountTypeLikeName(name);
	}

	@Override
	public List<AccountType> findAccountType() {
		return dao.getAccountTypeLikeName("");
	}

	// end
}
