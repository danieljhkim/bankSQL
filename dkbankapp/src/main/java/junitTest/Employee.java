package junitTest;
import java.util.HashMap;
import java.util.Scanner;

public class Employee {
	
	static String password = "123"; 
	static String id = "employee";
	static Customers cust = new Customers("a", "1", "dan", 2);
	static Accounts account = new Accounts(cust); 
	static HashMap<String, Accounts> hashMapAcc = new HashMap<>();
	static HashMap<String, Customers> hashMapCust = new HashMap<>();
	
	
	
//	public String getEmpOptions(String userInput) {
//		boolean logout = false; 
//		//Scanner sc = new Scanner(System.in);
//		while (logout == false) {
////			System.out.println("\n**************************** COMMANDS ********************************");
////			System.out.println("   View All Accounts[1], View Account Info[2], View Customer Info[3]");
////			System.out.println("         Approve Accounts[4], Deny Accounts[5],  Exit[6]");
////			System.out.println("**********************************************************************");
////			System.out.println("[INPUT] Type available command:");
//			userInput = sc.nextLine();
//			if (userInput.equals("1")) {
//				emp_viewAllAcc();
//			}else if(userInput.equals("2")) {
//				emp_viewAcc();
//			}else if(userInput.equals("3")) {
//				emp_viewCust();	
//			}else if(userInput.equals("4")) {
//				emp_approveAcc();	
//			}else if(userInput.equals("5")) {
//				emp_denyAcc();	
//			}else if(userInput.equals("6")) {
//				System.out.println("Bye now.");
//				logout = true;
//				break; 
//			}else {
//				System.out.println("*ERROR*: Invalid input");
//			}
//		}
//	}
	
	void emp_viewAllAcc(){
		System.out.println("\n------------------------All Accounts-------------------------");
		System.out.println(MainDriver.hashMapAcc); 
		System.out.println("--------------------------------------------------------------");
	}
	
	public String emp_approveAcc(String custAccNum){
		//Scanner sc = new Scanner(System.in);
		//System.out.println("[INPUT]: Account number to be approved?");
		//String custAccNum = sc.nextLine(); 
		boolean accFound = hashMapAcc.containsKey(custAccNum);
		if (accFound==false) {
			System.out.println("*ERROR*: Account number not found.");
			return "pass";
		}else {
			//updating account object
			System.out.println("#SUCCESS#: The account status was: " + hashMapAcc.get(custAccNum).status);
			hashMapAcc.get(custAccNum).status = "approved";
			System.out.println("#SUCCESS#: The account status is now: 'approved'");
			return "fail";
		}
	}
	
	public String emp_denyAcc(String custAccNum){
		//Scanner sc = new Scanner(System.in);
		//System.out.println("[INPUT]: Account number to be denied?");
		//String custAccNum = sc.nextLine(); 
		boolean accFound = hashMapAcc.containsKey(custAccNum);
		if (accFound==false) {
			System.out.println("*ERROR*: Account number not found.");
			return "pass";
		}else {
			//updating account object
			System.out.println("#SUCCESS#: The account status was: " + hashMapAcc.get(custAccNum).status);
			hashMapAcc.get(custAccNum).status = "denied";
			System.out.println("#SUCCESS#: The account status is now: 'denied'");
			return "fail";
		}
	}
	
	public String emp_viewAcc(String custAcc) {
		//Scanner sc = new Scanner(System.in);
		//System.out.println("[INPUT]: Account number?");
		//String custAcc = sc.nextLine(); 
		boolean accFound = hashMapAcc.containsKey(custAcc);
		if (accFound==false) {
			System.out.println("*ERROR*: Account number not found.");
			return "pass";
		}else {
			Accounts acc = hashMapAcc.get(custAcc);
			//Accounts.printAccInfo(acc);
			return "fail";
		}
	}
	
	
	public String emp_viewCust(String custId) {
		//Scanner sc = new Scanner(System.in);
		//System.out.println("[INPUT]: Customer ID?");
		//String custId = sc.nextLine(); 
		boolean accFound = hashMapCust.containsKey(custId);
		if (accFound==false) {
			System.out.println("*ERROR*: Customer ID number not found.");
			return "pass";
		}else {
			Customers cust = hashMapCust.get(custId);
			return "fail";
			//Customers.printCustInfo(cust);
		}
	}	
	
	public String verifyEmployee(String id, String employeePswd) {
		boolean correct = false;
		//Scanner sc = new Scanner(System.in);
		//String id;
		while (correct == false) {
			//System.out.println("[INPUT]: Account ID?");
			//id = sc.nextLine();
			//System.out.println("[INPUT]: Account Password?");
			//String employeePswd = sc.nextLine();
			if (id.equals(Employee.id )&& employeePswd.equals(Employee.password)) {
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
