package com.intern.service.impl;

import com.intern.model.*;
import com.intern.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intern.dao.*;

@Service
@Transactional
public class AccountTypeServiceImpl implements AccountTypeService {

	@Autowired
	private AccountTypeDao dao;

	@Override
	public List<AccountType> findAccountTypeLikeName(String name) {
		return dao.getAccountTypeLikeName(name);
	}

	@Override
	public List<AccountType> findAccountType() {
		return dao.getAccountTypeLikeName("");
	}

}
