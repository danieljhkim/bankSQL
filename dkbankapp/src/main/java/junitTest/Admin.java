package junitTest;

import java.util.HashMap;
import java.util.Scanner;

public class Admin extends Employee{

	static String password = "345"; 
	static String id = "admin";
	Customers cust = new Customers("a", "1", "dan", 2);
	static HashMap<String, Accounts> hashMapAcc = new HashMap<>();
	static HashMap<String, Customers> hashMapCust = new HashMap<>();
	
	
	public String getAdminOptions(String userInput) {
		boolean logout = false; 
		//Scanner sc = new Scanner(System.in);
		while (logout == false) {
//			System.out.println("\n**************************** COMMANDS ********************************");
//			System.out.println("  View All Accounts[1], View Account Info[2], View Customer Info[3]");
//			System.out.println("     Approve Accounts[4], Deny Accounts[5], Cancel Account[6]");
//			System.out.println("         Deposit[7], Withdraw[8], Transfer[9], Exit[10]");
//			System.out.println("**********************************************************************");
			//System.out.println("[INPUT] Type available command:");
			//String userInput = sc.nextLine();
			if (userInput.equals("1")) {
				//emp_viewAllAcc();
				return "fail";
			}else if(userInput.equals("2")) {
				//emp_viewAcc();
				return "fail";
			}else if(userInput.equals("3")) {
				//emp_viewCust();	
				return "fail";
			}else if(userInput.equals("4")) {
				//emp_approveAcc();
				return "fail";
			}else if(userInput.equals("5")) {
				//emp_denyAcc();
				return "fail";
			}else if(userInput.equals("6")) {
				//adminCancel();
				return "pass";
			}else if(userInput.equals("7")) {
				//adminDeposit();	
				return "fail";
			}else if(userInput.equals("8")) {
				//adminWithdraw();
				return "fail";
			}else if(userInput.equals("9")) {
				//adminTransfer();	
				return "fail";
			}else if(userInput.equals("10")) {
				System.out.println("Bye now.");
				logout = true;
				return "fail";
			}else {
				System.out.println("*ERROR*: Invalid input");
				return "fail";
			}
		}
		return "fail";
	}
	
	public String adminDeposit(String accNum) {
		//Scanner sc = new Scanner(System.in);
		//System.out.println("[INPUT]: What is the account number?");
		//String accNum = sc.nextLine();
		boolean accFound = hashMapAcc.containsKey(accNum);
		if (accFound==false) {
			System.out.println("*ERROR*: Account number not found.");
			return "pass";
		}else {
			System.out.println("#SUCCESS#: Account number found.");
			//Customers.depositCustomer(accNum);
			return "fail";
		}	
	}
	
	public String adminWithdraw(String accNum) {
		//Scanner sc = new Scanner(System.in);
		//System.out.println("[INPUT]: What is the account number?");
		//String accNum = sc.nextLine();
		boolean accFound = hashMapAcc.containsKey(accNum);
		if (accFound==false) {
			System.out.println("*ERROR*: Account number not found.");
			return "pass";
		}else {
			Customers.withdrawCustomer(accNum);
			return "fail";
			
		}
	}
	public String adminTransfer(String accNum) {
		//Scanner sc = new Scanner(System.in);
		//System.out.println("[INPUT]: What is the account number?");
		//String accNum = sc.nextLine();
		boolean accFound = hashMapAcc.containsKey(accNum);
		if (accFound==false) {
			System.out.println("*ERROR*: Account number not found.");
			return "pass";
		}else {
			System.out.println("#SUCCESS#: Account number found.");
			//Customers.transferCustomer(accNum);
			return "fail";
		}
	}
	
	public String adminCancel(String accNum) {
		//Scanner sc = new Scanner(System.in);
		//System.out.println("[INPUT]: What is the account number?");
		//String accNum = sc.nextLine();
		boolean accFound = hashMapAcc.containsKey(accNum);
		if (accFound==false) {
			System.out.println("*ERROR*: Account number not found.");
			return "pass";
		}else {
			System.out.println("#SUCCESS#: Account number found.");
			int arrayCustSize = hashMapAcc.get(accNum).arrayCust.size();
			for (int i=0;i<arrayCustSize; i++) {
				System.out.println("Fetching the account's customer #"+ i + " information...");
				String id = hashMapAcc.get(accNum).arrayCust.get(i);
				int arrayAccSize = hashMapCust.get(id).arrayAcc.size();
				for (int x=0; i<arrayAccSize; i++) {
					System.out.println("Customer #" + i + ": finding the right account...");
					if (hashMapCust.get(id).arrayAcc.get(x).equals(accNum)) {
						System.out.println("Customer #" + i + ": correct account found.");
						System.out.println("Executing cancellation...");
						hashMapCust.get(id).arrayAcc.remove(x);
						System.out.println("Customer #" + i + ": cancellation complete.");
						return "fail";
					}
				}				
			}
			System.out.println("#SUCCESS#: Account cancelled.");
			return "fail";
		}
	}
	
	public String verifyAdmin(String id, String employeePswd) {
		boolean correct = false;
		//Scanner sc = new Scanner(System.in);
		//String id;
		while (correct ==false) {
			//System.out.println("[INPUT]: Account ID?");
			//id = sc.nextLine();
			//System.out.println("[INPUT]: Account Password?");
			//String employeePswd = sc.nextLine();
			if (id.equals(Admin.id) && employeePswd.equals(Admin.password)) {
				correct=true;
				return "fail";
			}else {
				System.out.println("*ERROR*: Access denied. Please try again.");
				return "pass";
			}
		}
		System.out.println("#SUCCESS#: Sign in success.");
		return "fail";
	}
}


