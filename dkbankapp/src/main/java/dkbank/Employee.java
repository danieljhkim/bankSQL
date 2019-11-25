package dkbank;
import java.util.Scanner;

public class Employee {
	
	static String password = "123"; 
	static String id = "employee";
	
	HashMaps getEmpOptions(HashMaps hashMaps) {
		boolean logout = false; 
		Scanner sc = new Scanner(System.in);
		while (logout == false) {
			System.out.println("\n**************************** COMMANDS ********************************");
			System.out.println("   View All Accounts[1], View Account Info[2], View Customer Info[3]");
			System.out.println("         Approve Accounts[4], Deny Accounts[5],  Exit[6]");
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
				System.out.println("Bye now.");
				logout = true;
				break; 
			}else {
				System.out.println("*ERROR*: Invalid input");
			}
		}
		return hashMaps; 
	}
	
	void emp_viewAllAcc(HashMaps hashMaps){
		System.out.println("\n------------------------All Accounts-------------------------");
		System.out.println(hashMaps.hashMapAcc); 
		System.out.println("--------------------------------------------------------------");
	}
	
	HashMaps emp_approveAcc(HashMaps hashMaps){
		Scanner sc = new Scanner(System.in);
		System.out.println("[INPUT]: Account number to be approved?");
		String custAccNum = sc.nextLine(); 
		boolean accFound = hashMaps.hashMapAcc.containsKey(custAccNum);
		if (accFound==false) {
			System.out.println("*ERROR*: Account number not found.");
		}else {
			//updating account object
			System.out.println("#SUCCESS#: The account status was: " + hashMaps.hashMapAcc.get(custAccNum).status);
			hashMaps.hashMapAcc.get(custAccNum).status = "approved";
			System.out.println("#SUCCESS#: The account status is now: 'approved'");
		}
		return hashMaps; 
	}
	
	HashMaps emp_denyAcc(HashMaps hashMaps){
		Scanner sc = new Scanner(System.in);
		System.out.println("[INPUT]: Account number to be denied?");
		String custAccNum = sc.nextLine(); 
		boolean accFound = hashMaps.hashMapAcc.containsKey(custAccNum);
		if (accFound==false) {
			System.out.println("*ERROR*: Account number not found.");
		}else {
			//updating account object
			System.out.println("#SUCCESS#: The account status was: " + hashMaps.hashMapAcc.get(custAccNum).status);
			hashMaps.hashMapAcc.get(custAccNum).status = "denied";
			System.out.println("#SUCCESS#: The account status is now: 'denied'");
		}
		return hashMaps; 
	}
	
	void emp_viewAcc(HashMaps hashMaps) {
		Scanner sc = new Scanner(System.in);
		System.out.println("[INPUT]: Account number?");
		String custAcc = sc.nextLine(); 
		boolean accFound = hashMaps.hashMapAcc.containsKey(custAcc);
		if (accFound==false) {
			System.out.println("*ERROR*: Account number not found.");
		}else {
			Accounts acc = hashMaps.hashMapAcc.get(custAcc);
			Accounts.printAccInfo(acc);
		}
	}
	
	void emp_viewCust(HashMaps hashMaps) {
		Scanner sc = new Scanner(System.in);
		System.out.println("[INPUT]: Customer ID?");
		String custId = sc.nextLine(); 
		boolean accFound = hashMaps.hashMapCust.containsKey(custId);
		if (accFound==false) {
			System.out.println("*ERROR*: Customer ID number not found.");
		}else {
			Customers cust = hashMaps.hashMapCust.get(custId);
			Customers.printCustInfo(cust);
		}
	}	
	
	static void verifyEmployee() {
		boolean correct = false;
		Scanner sc = new Scanner(System.in);
		String id;
		while (correct == false) {
			System.out.println("[INPUT]: Account ID?");
			id = sc.nextLine();
			System.out.println("[INPUT]: Account Password?");
			String employeePswd = sc.nextLine();
			if (id.equals(Employee.id )&& employeePswd.equals(Employee.password)) {
				correct=true;
				break;
			}else {
				System.out.println("*ERROR*: Access denied. Please try again.");
			}
		}
		System.out.println("#SUCCESS#: Sign in success.");
	}

}
