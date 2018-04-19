package com.intern.service;

import java.util.List;
import com.intern.model.Account;

public interface AccountService {
	public Account findAccountByOwner(String owner);

	public List<Account> findAccountLikeName(String name);
	
	public Account save(Account newAccount);
	
	public Account update(Account newAccount);

	public Account delete(String owner);
}
