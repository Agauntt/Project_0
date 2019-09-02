package com.iron_bank.service;

import com.iron_bank.exceptions.BusinessException;
import com.iron_bank.model.Account;

public interface IronBankService {

	public Account registerUser(Account account) throws BusinessException;
}
