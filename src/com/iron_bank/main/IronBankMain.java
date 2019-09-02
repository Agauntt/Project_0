package com.iron_bank.main;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import org.apache.log4j.Logger;

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
//				log.info("Username = " + username + "\nPassword = " + password);
				// Code to service layer
				mainMenu();
				
				break;
			case 2:
				boolean b = true;
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
				
				log.info(") Enter your social security number");
				int ssn = sc.nextInt();
				
				log.info("Thank you. Please confirm the information provided is correct...");
				
				UserDetails uDetails = new UserDetails(firstName, lastName, contact, email, address, city, state, zip, sdf.parse(s), ssn);
				
				log.info("\n"+uDetails.toStringDetails());
				boolean b1 = false;
				do {
					log.info("Is everything correct? [Y / N]");
					String confirm = sc.next();
					confirm = confirm.toUpperCase();
					if (confirm == "Y") {
						b1 = true;
						b = true;
						log.info("Info captured");
					} else if(confirm == "N") {
						log.info("Please re-enter your personal information");
					} else {
						log.info("Invalid response, please enter either 'Y' or 'N'");
						log.info(confirm);
					}
					log.info("Boolean to leave details section "+b);
					log.info("Boolean to leave confirmation check "+b1);
				} while (b1 = false);

				} catch (BusinessException | ParseException e){
					System.out.println(e);
//					throw new BusinessException("Invalid");
////					b = false;
				}
			} while (b = false);
				try {
					log.info("Personal details portion completed successfully");
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
				log.info("\nInput should only be numeric only..Please try again\n");
			}
		} while(ch!=3);
		
	}
	
	public static void mainMenu() {
		
		Scanner sc = new Scanner(System.in);
		int ch = 0;
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
