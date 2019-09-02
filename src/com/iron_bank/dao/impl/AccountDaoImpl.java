package com.iron_bank.dao.impl;

import java.sql.Connection;

import com.dbutil.OracleConnection;
import com.iron_bank.dao.AccountDAO;
import com.iron_bank.exceptions.BusinessException;
import com.iron_bank.model.Account;

public class AccountDaoImpl  implements AccountDAO{

	@Override
	public Account registerAccount(Account account) throws BusinessException {
		try (Connection connection = OracleConnection.getConnection()){
			String sql = "insert into acct_table";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return account;
	}

}
