package com.iron_bank.dao;

import java.util.List;

import com.iron_bank.exceptions.BusinessException;
import com.iron_bank.model.Account;

public interface AccountDAO {

	public List<Account> displayAccounts(long acctId) throws BusinessException;
	public Account registerAccount(Account account) throws BusinessException;
	
}
