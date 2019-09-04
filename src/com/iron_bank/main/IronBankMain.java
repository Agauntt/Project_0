package com.iron_bank.main;

import java.util.Calendar;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import org.apache.log4j.Logger;
import java.time.*;

import com.iron_bank.dao.impl.AccountDaoImpl;
import com.iron_bank.dao.impl.UserDaoImpl;
import com.iron_bank.exceptions.BusinessException;
import com.iron_bank.main.menus.Menus;
import com.iron_bank.model.Account;
import com.iron_bank.model.User;
import com.iron_bank.model.UserDetails;
import com.iron_bank.service.impl.IronBankServiceImpl;

public class IronBankMain implements Menus{
	
	private static final Logger log = Logger.getLogger(IronBankMain.class);

	public static void main(String[] args) throws BusinessException {
		Scanner sc = new Scanner(System.in);
		IronBankServiceImpl service = new IronBankServiceImpl();
		int ch = 0;
		do {
			Menus.IntroMenu();
			try {
			ch = Integer.parseInt(sc.next());
			switch (ch) {
			case 1: 
				Menus.LoginMenu();
				User user = new User();
				log.info("Enter your username...");
				user.setUserName(sc.next());
				log.info("Enter your password...");
				String password = sc.next();
				String hashpass = service.hashBrowns(password);
				user.setPassWord(hashpass);
				service.login(user);
				break;
			case 2:
				UserDetails uDetails = new UserDetails();
				int signupCheck = 0;
				do {
				log.info("\nThank you for choosing the Iron Bank as your financial institution");
				try {
				log.info("Enter your first name"); 
				String firstName = sc.next();
				
				log.info("Enter last name");
				String lastName = sc.next();
				
				log.info("Enter your primary phone number in the format of 'xxx-xxx-xxxx' \n** This is for contact purposes only. "
						+ "Iron Bank will never sell any personal information. This applies to all \"\r\n" + 
						"personal information collected for this form**");
				String contact = sc.next();
				if (contact.matches("[0-9]{3}-[0-9]{3}-[0-9]{4}")) {	
				} else {
					throw new BusinessException("contact number is not formatted properly, please try again");
				}
				log.info("Enter your email address, this will serve as your username when logging in");
				String email = sc.next();
				if(email.matches("^(.+)@(.+)$")) {	
				} else {
					throw new BusinessException("Invalid email format");
				}
				log.info("Enter your home address");
				String address = sc.next(); 
						address += sc.nextLine();
				
				log.info("Enter your City");
				String city = sc.next();
				
				log.info("Enter your State");
				String state = sc.next();
				
				log.info("Enter your ZIP code");
				int zip = sc.nextInt();
				
				log.info("Enter your date of birth in the format of dd-mm-yyyy");
				String s = sc.next();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				
				log.info("Enter your social security number");
				int ssn = sc.nextInt();
				
				log.info("\nThank you. Please confirm the information provided is correct...");
				
				uDetails = new UserDetails(firstName, lastName, contact, email, address, city, state, zip, sdf.parse(s), ssn);
				uDetails.setUserName(email);
				log.info("\n"+uDetails.toStringDetails());
				int confirmCheck = 0;
				do {
					log.info("Is everything correct? [Y / N]");
					String confirm = sc.next();
					confirm = confirm.toUpperCase();
					if (confirm.equals("Y")) {
						confirmCheck = 1;
						signupCheck = 1;
						log.info("Info captured");
					} else if(confirm.equals("N")) {
						log.info("Please re-enter your personal information");
						
					} else {
						log.info("Invalid response, please enter either 'Y' or 'N'");
						log.info(confirm);
					}

				} while (confirmCheck != 1);

				} catch (BusinessException | ParseException e){
					System.out.println(e);
				}
			} while (signupCheck != 1);
				int passLoop = 0;
				do {
					log.info("\nEnter a password for your account...Please do your best to remember it");
					String pass = sc.next();
					log.info("Please re-enter your password to confirm...");
					String passCheck = sc.next();
					if (pass.equals(passCheck)) {
						log.info("Password verified");
						passLoop = 1;
						IronBankServiceImpl hash = new IronBankServiceImpl();
						String hashedpass = hash.hashBrowns(pass);
						uDetails.setPassWord(hashedpass);
					} else {
						log.info("Passwords do not match...Please try again");
					}
				} while(passLoop != 1);
				
				log.info("Finally, please select a 4-digit PIN number");
				uDetails.setPin(sc.nextInt());

				try {
					UserDaoImpl dao = new UserDaoImpl();
					uDetails = dao.registerDetails(uDetails);
					if(uDetails.getAcctId()!=0) {
						log.info("User added with the following details...");
						log.info(uDetails);
						mainMenu(uDetails);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				break;
			case 3: log.info("Goodbye...Thank you for using the Iron Bank");
				break;
			default: log.info("\nInput should only be numbers 1-3...Please try again\n");
				break;
			}
			} catch (NumberFormatException e) {
				log.info("\nInput should be numeric only..Please try again\n");
			}
		} while(ch!=3);
		
	}
	
	public static void mainMenu(User user) throws BusinessException {
		AccountDaoImpl acctDao = new AccountDaoImpl();
		IronBankServiceImpl service = new IronBankServiceImpl();
		UserDaoImpl uDau = new UserDaoImpl();
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		log.info("\nWelcome back " + user.getUserName());
		do {
			Menus.MainMenu();
			try {
				ch = Integer.parseInt(sc.next());
			switch (ch) {
			case 1:
				List<Account> aList = null;
				int option = 0;
				log.info("Please select the account you would like to deposit into");
				try {
					aList = new AccountDaoImpl().displayAccounts(user.getAcctId());
					int c = 1;
					for (Account a: aList) {
						log.info((c++) + ") " + a.getAcctId() + " $" + a.getBalance() + " " + a.getAcct_type());
					}
					option = Integer.parseInt(sc.next());
					if (option > aList.size()) {
						log.info("Invalid selection");
					} else {
						try {
//							log.info(aList.get(option - 1));
							log.info("How much would you like to deposit?");
							double dep = sc.nextDouble();
							double newBal = aList.get(option - 1).getBalance() + dep;
							acctDao.makeTransaction(aList.get(option - 1).getAcctId(), user.getAcctId(), newBal);
							log.info("Success! New account balance is " + newBal);
						} catch (Exception e) {
							log.info(e);
						}
					}
				
				} catch (Exception e) {
					log.info(e);
				}
				break;
			case 2:
				aList = null;
				option = 0;
				log.info("Please select the account you would like to withdrawal from");
				try {
					aList = new AccountDaoImpl().displayAccounts(user.getAcctId());
					int c = 1;
					for (Account a: aList) {
						log.info((c++) + ") " + a.getAcctId() + " $" + a.getBalance() + " " + a.getAcct_type());
					}
					option = Integer.parseInt(sc.next());
					if (option > aList.size()) {
						log.info("Invalid selection");
					} else {
						try {
							log.info("Please enter your PIN to continue...");
							int PIN = sc.nextInt();
							if (PIN == user.getPin()) {
								log.info("PIN confirmed! How much would you like to withdrawal?");
								double currBal = aList.get(option - 1).getBalance();
								double dep = sc.nextDouble();
								double newBal = currBal - dep;
								if(newBal < 0) {
									log.info("Woah there big spender... Your cannot withdrawal more than your current balance.");
								} else {
									acctDao.makeTransaction(aList.get(option - 1).getAcctId(), user.getAcctId(), newBal);
									log.info("Success! New account balance is " + newBal);
								}
							}
						} catch (Exception e) {
							log.info(e);
						}
					}
				} catch (Exception e) {
					log.info(e);
				}
				break;
			case 3:
				aList = null;
				option = 0;
					log.info("Displaying active accounts with current balances");
					aList = new AccountDaoImpl().displayAccounts(user.getAcctId());
					int c = 1;
					for (Account a: aList) {
						log.info((c++) + ") " + a.getAcctId() + " $" + a.getBalance() + " " + a.getAcct_type());
					}
					log.info("Press any key to return to the menu");
					String s = sc.next();
				break;
			case 4:
				aList = null;
				option = 0;
					log.info("Select an account to view its transaction history");
					aList = new AccountDaoImpl().displayAccounts(user.getAcctId());
					c = 1;
					for (Account a: aList) {
						log.info((c++) + ") " + a.getAcctId() + " $" + a.getBalance() + " " + a.getAcct_type());
					}
					option = Integer.parseInt(sc.next());
					
				break;
			case 5:
				log.info("Please confirm your PIN to view account details...");
				int PIN = sc.nextInt();
				if(PIN == user.getPin()) {
					log.info("\nGenerating account details...");
					UserDetails uDetails =  uDau.displayDetails(user.getAcctId());
					log.info(uDetails.toStringDetails());
					log.info("Press any key to return to the menu");
					s = sc.next();
				} else {
					log.info("Incorrect PIN...Please try again");
				}
				break;
			case 6:
				log.info("Create New checking account? [Y / N]");
				String c1 = sc.next().toUpperCase();
				if (c1.equals("Y")) {
					double startingBal = 5.0;
					java.util.Date currentDate = Calendar.getInstance().getTime();
					Account acct = new Account(startingBal, currentDate, "Checking", 0.00, user.getAcctId());
					log.info(acct.getBalance());
					acctDao.registerAccount(acct);
					if(acct.getAcctId()!=0) {
						log.info("New checking account added...");
					}
				}
				break;
			case 7: 
				log.info("Create New Saving account? [Y / N]");
				c1 = sc.next().toUpperCase();
				if (c1.equals("Y")) {
					double startingBal = 5.0;
					java.util.Date currentDate = Calendar.getInstance().getTime();
					Account acct = new Account(startingBal, currentDate, "Savings", 5.00, user.getAcctId());
					log.info(acct.getBalance());
					acctDao.registerAccount(acct);
					if(acct.getAcctId()!=0) {
						log.info("New savings account added...");
					}
				}
				break;
			case 8: 
				log.info("\nGoodbye...Thank you for using the Iron Bank");
				break;
			default:
				log.info("Invalid response, please enter only ");
				break;
			}
			}
			catch (NumberFormatException e) {
				throw new BusinessException("Input should be numeric only...Please try again");
			}
			catch (Exception e) {
				System.out.println(e);
				log.info("Invalid input");
			}
		} while (ch!=8);
	}
	}
