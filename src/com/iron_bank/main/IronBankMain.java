package com.iron_bank.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import org.apache.log4j.Logger;

import com.iron_bank.dao.UserDAO;
import com.iron_bank.dao.impl.UserDaoImpl;
import com.iron_bank.exceptions.BusinessException;
import com.iron_bank.main.menus.Menus;
import com.iron_bank.model.UserDetails;

public class IronBankMain implements Menus{
	
	private static final Logger log = Logger.getLogger(IronBankMain.class);

	public static void main(String[] args) throws BusinessException {
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		do {
			Menus.IntroMenu();
			try {
			ch = Integer.parseInt(sc.next());
			switch (ch) {
			case 1: 
				Menus.LoginMenu();
				log.info("Enter your username...");
				String username = sc.next();
				log.info("Enter your password...");
				String password = sc.next();
				// Code to service layer
//				mainMenu();
				
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
//					log.info("Boolean to leave details section "+b);
//					log.info("Boolean to leave confirmation check "+b1);
				} while (confirmCheck != 1);

				} catch (BusinessException | ParseException e){
					System.out.println(e);
				}
//				log.info("Final line before end of do/while statement...b = "+b);
			} while (signupCheck != 1);
				int passLoop = 0;
				do {
					log.info("\nPerfect! Now enter a password for your account...Please do your best to remember it");
					String pass = sc.next();
					log.info("Please re-enter your password to confirm...");
					String passCheck = sc.next();
					if (pass.equals(passCheck)) {
						log.info("Password verified");
						passLoop = 1;
						uDetails.setPassWord(pass);
					} else {
						log.info("Passwords do not match...Please try again");
					}
				} while(passLoop != 1);
				
				log.info("Finally, please select a 4-digit PIN number");
				uDetails.setPin(sc.nextInt());
				// ======= TEST BLOCK =============
				log.info(uDetails.getUserName());
				log.info(uDetails.getPassWord());
				log.info(uDetails.getPin());
				log.info(uDetails.getFirstName());
				log.info(uDetails.getLastName());
				log.info(uDetails.getContact());
				log.info(uDetails.getEmail());
				log.info(uDetails.getAddress());
				log.info(uDetails.getCity());
				log.info(uDetails.getState());
				log.info(uDetails.getZip());
				log.info(uDetails.getDob());
				log.info(uDetails.getSsn());
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
	
	public static void mainMenu(UserDetails user) {
		
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		log.info("Welcome back " + user.getFirstName());
		do {
			Menus.MainMenu();
			try {
				ch = Integer.parseInt(sc.next());
			switch (ch) {
			case 1:
				log.info("Deposit Stub");
				break;
			case 2:
				log.info("Withdrawal Stub");
				break;
			case 3:
				log.info("View balance Stub");
				break;
			case 4:
				log.info("View Transaction history stub");
				break;
			case 5:
				log.info("View account details stub");
				break;
			case 6:
				log.info("Log out stub");
				break;
			default:
				log.info("Invalid response stub");
				break;
			}
			}  catch (Exception e) {
				System.out.println(e);
				log.info("Invalid input");
			}
		} while (ch!=6);
	}
	}
