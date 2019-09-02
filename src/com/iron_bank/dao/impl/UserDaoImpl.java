package com.iron_bank.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import com.dbutil.OracleConnection;
import com.iron_bank.dao.UserDAO;
import com.iron_bank.exceptions.BusinessException;
import com.iron_bank.model.UserDetails;

public class UserDaoImpl implements UserDAO{

//	@Override
//	public UserDetails registerUser(UserDetails uDetails) throws BusinessException {
//		try (Connection connection = OracleConnection.getConnection()){
//			String sql = "{call register_User(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
//			CallableStatement callableStatement = connection.prepareCall(sql);
//			callableStatement.setString(2, user.getUserName());
//			callableStatement.setString(3, user.getPassWord());
//			callableStatement.setInt(4,  user.getPin());
//			callableStatement
//			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
//			
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return user;
//	}

	@Override
	public UserDetails registerDetails(UserDetails uDetails) throws BusinessException {
		try (Connection connection = OracleConnection.getConnection()){
			String sql = "{call register_User(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			CallableStatement callableStatement = connection.prepareCall(sql);
			callableStatement.setString(2, uDetails.getUserName());
			callableStatement.setString(3, uDetails.getPassWord());
			callableStatement.setInt(4,  uDetails.getPin());
			callableStatement.setString(5,  uDetails.getFirstName());
			callableStatement.setString(6,  uDetails.getLastName());
			callableStatement.setString(7, uDetails.getContact());
			callableStatement.setString(8,  uDetails.getEmail());
			callableStatement.setString(9,  uDetails.getAddress());
			callableStatement.setString(10,  uDetails.getCity());
			callableStatement.setString(11,  uDetails.getState());
			callableStatement.setInt(12,  uDetails.getZip());
			callableStatement.setDate(13, new java.sql.Date(uDetails.getDob().getTime()));
			callableStatement.setInt(14, uDetails.getSsn());
			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			
			callableStatement.execute();
			uDetails.setAcctId(callableStatement.getInt(1));
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occured");
		}
		return uDetails;
	}

	

}
