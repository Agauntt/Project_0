package com.iron_bank.dao;

import com.iron_bank.exceptions.BusinessException;
import com.iron_bank.model.Account;

public interface AccountDAO {

	public Account registerAccount(Account account) throws BusinessException;
	
}
