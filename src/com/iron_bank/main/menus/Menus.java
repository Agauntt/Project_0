package com.iron_bank.main.menus;

import org.apache.log4j.Logger;

import com.iron_bank.main.IronBankMain;


	public interface Menus {
		
		static final Logger log = Logger.getLogger(IronBankMain.class);

		public static void IntroMenu() {
			log.info("Welcome to the Iron Bank");
			log.info("===========================");
			log.info("1) Log in");
			log.info("2) Create account");
			log.info("3) Exit");
		}
		
		public static void MainMenu() {
			log.info("Main Menu");  // Maybe add "welcome back + firstName"
 			log.info("==================");
			log.info("1) Make a deposit");
			log.info("2) Make a withdrawal");
			log.info("3) View account balance");
			log.info("4) View transaction history");
			log.info("5) View account details");
			log.info("6) Log out");
		}
		
		public static void LoginMenu() {
			log.info("Main Menu");
			log.info("=========================");
			log.info("Enter your credentials to continue");
		}
	}

