package dkbank;

import java.util.Scanner;

public class Admin extends Employee{

	static String password = "345"; 
	static String id = "admin";
	
	HashMaps getAdminOptions(HashMaps hashMaps) {
		boolean logout = false; 
		Scanner sc = new Scanner(System.in);
		while (logout == false) {
			System.out.println("\n**************************** COMMANDS ********************************");
			System.out.println("  View All Accounts[1], View Account Info[2], View Customer Info[3]");
			System.out.println("     Approve Accounts[4], Deny Accounts[5], Cancel Account[6]");
			System.out.println("         Deposit[7], Withdraw[8], Transfer[9], Exit[10]");
			System.out.println("**********************************************************************");
			System.out.println("[INPUT] Type available command:");
			String userInput = sc.nextLine();
			if (userInput.equals("1")) {
				emp_viewAllAcc(hashMaps);
			}else if(userInput.equals("2")) {
				emp_viewAcc(hashMaps);
			}else if(userInput.equals("3")) {
				emp_viewCust(hashMaps);	
			}else if(userInput.equals("4")) {
				hashMaps = emp_approveAcc(hashMaps);
			}else if(userInput.equals("5")) {
				hashMaps = emp_denyAcc(hashMaps);
			}else if(userInput.equals("6")) {
				hashMaps = adminCancel(hashMaps);
			}else if(userInput.equals("7")) {
				hashMaps = adminDeposit(hashMaps);		
			}else if(userInput.equals("8")) {
				hashMaps = adminWithdraw(hashMaps);
			}else if(userInput.equals("9")) {
				hashMaps = adminTransfer(hashMaps);				
			}else if(userInput.equals("10")) {
				System.out.println("Bye now.");
				logout = true;
				break; 
			}else {
				System.out.println("*ERROR*: Invalid input");
			}
		}
		return hashMaps; 
	}
	
	private HashMaps adminDeposit(HashMaps hashMaps) {
		Scanner sc = new Scanner(System.in);
		System.out.println("[INPUT]: What is the account number?");
		String accNum = sc.nextLine();
		boolean accFound =  hashMaps.hashMapAcc.containsKey(accNum);
		if (accFound==false) {
			System.out.println("*ERROR*: Account number not found.");
		}else {
			System.out.println("#SUCCESS#: Account number found.");
			Customers cust = new Customers(); 
			hashMaps.hashMapAcc = cust.depositCustomer(hashMaps.hashMapAcc, accNum);
		}
		return hashMaps; 
	}
	
	private HashMaps adminWithdraw(HashMaps hashMaps) {
		Scanner sc = new Scanner(System.in);
		System.out.println("[INPUT]: What is the account number?");
		String accNum = sc.nextLine();
		boolean accFound = hashMaps.hashMapAcc.containsKey(accNum);
		if (accFound==false) {
			System.out.println("*ERROR*: Account number not found.");
		}else {
			Customers cust = new Customers(); 
			hashMaps.hashMapAcc = cust.withdrawCustomer(hashMaps.hashMapAcc, accNum);
		}
		return hashMaps;
	}
	private HashMaps adminTransfer(HashMaps hashMaps) {
		Scanner sc = new Scanner(System.in);
		System.out.println("[INPUT]: What is the account number?");
		String accNum = sc.nextLine();
		boolean accFound = hashMaps.hashMapAcc.containsKey(accNum);
		if (accFound==false) {
			System.out.println("*ERROR*: Account number not found.");
		}else {
			System.out.println("#SUCCESS#: Account number found.");
			Customers cust = new Customers(); 
			hashMaps.hashMapAcc = cust.transferCustomer(hashMaps.hashMapAcc, accNum);
		}
		return hashMaps;
	}
	
	private HashMaps adminCancel(HashMaps hashMaps) {
		Scanner sc = new Scanner(System.in);
		System.out.println("[INPUT]: What is the account number?");
		String accNum = sc.nextLine();
		boolean accFound = hashMaps.hashMapAcc.containsKey(accNum);
		if (accFound==false) {
			System.out.println("*ERROR*: Account number not found.");
		}else {
			System.out.println("#SUCCESS#: Account number found.");
			int arrayCustSize = hashMaps.hashMapAcc.get(accNum).arrayCust.size();
			for (int i=0;i<arrayCustSize; i++) {
				System.out.println("Fetching the account's customer #"+ i + " information...");
				String id = hashMaps.hashMapAcc.get(accNum).arrayCust.get(i);
				int arrayAccSize = hashMaps.hashMapCust.get(id).arrayAcc.size();
				for (int x=0; i<arrayAccSize; i++) {
					System.out.println("Customer #" + i + ": finding the right account...");
					if (hashMaps.hashMapCust.get(id).arrayAcc.get(x).equals(accNum)) {
						System.out.println("Customer #" + i + ": correct account found.");
						System.out.println("Executing cancellation...");
						hashMaps.hashMapCust.get(id).arrayAcc.remove(x);
						System.out.println("Customer #" + i + ": cancellation complete.");
						break;
					}
				}				
			}
			System.out.println("#SUCCESS#: Account cancelled.");
		}
		return hashMaps;
	}
	
	static void verifyAdmin() {
		boolean correct = false;
		Scanner sc = new Scanner(System.in);
		String id;
		while (correct ==false) {
			System.out.println("[INPUT]: Account ID?");
			id = sc.nextLine();
			System.out.println("[INPUT]: Account Password?");
			String employeePswd = sc.nextLine();
			if (id.equals(Admin.id) && employeePswd.equals(Admin.password)) {
				correct=true;
				break;
			}else {
				System.out.println("*ERROR*: Access denied. Please try again.");
			}
		}
		System.out.println("#SUCCESS#: Sign in success.");
	}
}


