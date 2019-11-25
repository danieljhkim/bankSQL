package junitTest;

import java.util.HashMap;
import java.util.Scanner;

public class MainDriver {
//	static HashMap<String, Customers> hashMapCust = Customers.deSerializeCustomer();
//	static HashMap<String, Accounts> hashMapAcc = Accounts.deSerializeAccount();
	static Customers cust = new Customers("a", "1", "dan", 2);
	static Accounts account = new Accounts(cust); 
	static HashMap<String, Accounts> hashMapAcc = new HashMap<>();
	static HashMap<String, Customers> hashMapCust = new HashMap<>();
	
	MainDriver(){
	}
	
	public static void main(String[] args) {
		//menu();
	}
	
	public static void menu() {
//		Scanner sc_user = new Scanner(System.in);
//		System.out.println("\n************************************ COMMANDS ************************************");
//		System.out.println("Apply for an account[1], Customer sign in[2], Employee sign in[3], Admin sign in[4]");
//		System.out.println("**********************************************************************************");
//		System.out.println("[INPUT] Type available command:");
//		String userInput = sc_user.nextLine();
//		switch (userInput){
//			case "1":
//				System.out.println("[INPUT]: Single account? (Y/N)");
//				String singleAcc = sc_user.nextLine();
//				if (singleAcc.equals("Y")==true) {
//					applySingleAccount();
//				}else {
//					applyJointAccount();
//				}
//				break;		
//			case "2":
//				Customers loggedInCust = fetchCustomer();
//				provideCustomerOptions(loggedInCust);
//				break;
//			case "3":
//				Employee.verifyEmployee();
//				Employee employee = new Employee();
//				employee.getEmpOptions(); 
//				
//				break;
//			case "4":
//				Admin.verifyAdmin(); 
//				Admin admin = new Admin();
//				admin.getAdminOptions();
//				break;
//		}
//		Customers.serializeCustomer(hashMapCust);
//		Accounts.serializeAccount(hashMapAcc);
//		System.out.println("Bye now.");
		//System.exit(0);
	}
	

		

//	public static void applySingleAccount() {
//		String person = "Person";
//		Customers customerInfo = makeCustomer(person);
//		Accounts single_acc = new Accounts(customerInfo);
//		customerInfo.arrayAcc.add(single_acc.accNum);
//		hashMapAcc.put(single_acc.accNum, single_acc);
//		hashMapCust.put(customerInfo.id, customerInfo);
//		Accounts.printAccInfo(single_acc);
//		//menu();
//	}
	
//	public static void applyJointAccount() {
//		String person1 = "Person #1";
//		String person2 = "Person #2";
//		Customers customerInfo1 = fetchOrMakeCustomer(person1);
//		Customers customerInfo2 = fetchOrMakeCustomer(person2);
//		Accounts joint_acc = new Accounts(customerInfo1, customerInfo2);
//		customerInfo1.arrayAcc.add(joint_acc.accNum);
//		customerInfo2.arrayAcc.add(joint_acc.accNum);
//		hashMapCust.put(customerInfo1.id, customerInfo1);
//		hashMapCust.put(customerInfo2.id, customerInfo2);
//		hashMapAcc.put(joint_acc.accNum, joint_acc);
//		Accounts.printAccInfo(joint_acc);
//		//menu();
//	}
	
//	public static Customers makeCustomer(String person_num) {
//		Scanner sc = new Scanner(System.in);
//		String userName2;
//		String userPassword2;
//		String userId2;
//		int ssn2;
//		System.out.println("[INPUT]: " + person_num+ ", what is your full name?");
//		userName2 = sc.nextLine();
//		userId2 = checkId(person_num);
//		System.out.println("[INPUT]: " + person_num + ", password?");
//		userPassword2 = sc.nextLine();
//		ssn2 = checkSSN(person_num);
//		Customers customerInfo2 = new Customers(userId2, userPassword2, userName2, ssn2);
//		return customerInfo2;
//	}

//	public static Customers fetchOrMakeCustomer(String person_num) {
//		String userId;
//		String userPassword;
//		String existingAccount;
//		Customers customerInfo = null;
//		boolean correct = false;
//		String verify;
//		Scanner sc = new Scanner(System.in);
//		while (correct == false) {
//			System.out.println("[INPUT]: " +person_num+ ", do you have an account with us? (Y/N)");
//			existingAccount = sc.nextLine();
//			if (existingAccount.equals("N")==true) {
//				customerInfo = makeCustomer(person_num);
//				correct = true; 
//			}else if (existingAccount.equals("Y")==true){	
//				System.out.println("[INPUT]: "+ person_num + ", what is your account Id?");
//				userId = sc.nextLine();
//				System.out.println("[INPUT]: " + person_num + ", what is your password?");
//				userPassword = sc.nextLine();
//				verify = verifyCustomer(userId, userPassword);
//				if (verify.equals("pass") == true) {
//					customerInfo = hashMapCust.get(userId);
//					correct = true;
//				} else correct = false; 
//			} else {
//				System.out.println("*ERROR*: Invalid input. Please retry.");
//				correct = false; 
//			} 
//		}
//		return customerInfo;
//	}
		
	public static String verifyCustomer(String userId, String userPassword) {
		if (hashMapCust.containsKey(userId)== true) {
			Customers customer = hashMapCust.get(userId);
			if (customer.password.equals(userPassword)==true) {
				return "fail"; 
			}else {
				System.out.println("*ERROR*: Wrong password." );
			}
		} else {
			System.out.println("*ERROR*: The id does not exist.");
		}
		System.out.println("*ERROR*: Verification failed.");
		return "pass";
	}
	
	public static String fetchCustomer(String userInputId,String userInputPswd) {
		Scanner sc = new Scanner(System.in); 
		Customers customerInfo;
		String pass; 
		//System.out.println("[INPUT]: Account ID?");
		//String userInputId = sc.nextLine();
		//System.out.println("[INPUT]: Account Password?");
		//String userInputPswd = sc.nextLine();
		pass = verifyCustomer(userInputId, userInputPswd);
		if (pass.equals("pass")) {
			//customerInfo = hashMapCust.get(userInputId);
			return "pass";
		}else {
			System.out.println("*ERROR*: Invalid. Please retry.");
			return "fail";
		}
		//return "fail"; 
	}
	
	public static void provideCustomerOptions(Customers loggedInCust) {
		Scanner sc = new Scanner(System.in);
		if (loggedInCust.arrayAcc.size()==1) {
			getCustomerOptions(loggedInCust.arrayAcc.get(0));
		}else if (loggedInCust.arrayAcc.size()==2) {
			String accOption;
			System.out.println("[INPUT] Please choose account: " + loggedInCust.arrayAcc.get(0)+ "[1] or " + loggedInCust.arrayAcc.get(1) + "[2]");
			accOption = sc.nextLine();
			switch (accOption){
			case "1":
				getCustomerOptions(loggedInCust.arrayAcc.get(0));
				break;
			case "2":
				getCustomerOptions(loggedInCust.arrayAcc.get(1));
				break;
			}
		}else {
			String accOption;
			System.out.println("[INPUT] Please choose account: " + loggedInCust.arrayAcc.get(0)+ "[1] or " + loggedInCust.arrayAcc.get(1) + "[2] or " + loggedInCust.arrayAcc.get(2) + "[3]");
			accOption = sc.nextLine();
			switch (accOption){
			case "1":
				getCustomerOptions(loggedInCust.arrayAcc.get(0));
				break;
			case "2":
				getCustomerOptions(loggedInCust.arrayAcc.get(1));
				break;
			case "3":
				getCustomerOptions(loggedInCust.arrayAcc.get(2));
				break;
			}
			
		}
	}
	
	public static void getCustomerOptions(String accNum) {
		boolean logout = false; 
		Scanner sc = new Scanner(System.in);
		while (logout == false) {
			System.out.println("\n**************************** COMMANDS ********************************");
			System.out.println("View account info[1], Deposit[2], Withdraw[3], Transfer[4], Sign Out[5]");
			System.out.println("**********************************************************************");
			System.out.println("[INPUT] Type available command:");
			String userInput = sc.nextLine();
			if (userInput.equals("1")) {
				Accounts.printAccInfo(hashMapAcc.get(accNum));
			}else if(userInput.equals("2")) {
				Customers.depositCustomer(accNum);
			}else if(userInput.equals("3")) {
				Customers.withdrawCustomer(accNum);
			}else if(userInput.equals("4")) {
				Customers.transferCustomer(accNum);		
			}else if(userInput.equals("5")) {
				System.out.println("Bye now.");
				logout = true;
				break; 
			}else {
				System.out.println("*ERROR*: Invalid input");
			}
		}
	}
	
	public static double checkInputDouble() {
		Scanner sc = new Scanner(System.in);
		System.out.println("[INPUT]: How much?");
		double amount;
		try {
			amount = sc.nextDouble();
			if (amount>=0) {
				return amount;	
			} else {
				System.out.println("*ERROR*: Negative input not allowed. again.");
				amount = checkInputDouble();
			}
		} 
		catch (Exception e) {
			System.out.println("*ERROR*: Wrong input type. Numbers only. Try again.");
			amount = checkInputDouble();
		}
		return amount;
	}
	
	public static String checkSSN(int ssn) {
		//Scanner sc = new Scanner(System.in);
		//int ssn;
		//System.out.println("[INPUT]: " + person_num +  ", what is your SSN?");
		try {
			//ssn = sc.nextInt();
			int ssn2 = ssn*ssn;
			if (ssn>0 && hashMapAcc.containsKey(Integer.toString(ssn2))==false) {
				return "pass";
			} else {
				System.out.println("*ERROR*: Either the social security provided already exists in the system or a negative value was inputed.");
				return "fail";
			}
		} catch (Exception e) {
			System.out.println("*ERROR*: Wrong input type. Numbers only. Try again");
			return "fail";
		}
	}
	
	public static String checkId(String id) {
		//Scanner sc = new Scanner(System.in); 
		//String id;
		//System.out.println("[INPUT]: " + person_num + ", choose id?");
		//id = sc.nextLine();
		if (hashMapCust.containsKey(id)== false) {
			return "pass";
		} else {
			System.out.println("*ERROR*: The id already exists. Please try another.");
			return "fail";
		}

	}
	

}

