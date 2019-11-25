package junitTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;


public class Accounts implements java.io.Serializable {

	//private static final long serialVersionUID = -3167965051830509317L;
	String accNum;
	String status;
	double balance;
	boolean singleAcc;
	ArrayList<String> arrayCust = new ArrayList<>();
	
	
	Accounts(){
	}
	
	Accounts(Customers customer1){
		this.status = "pending";
		this.accNum = generateAccNum(customer1.ssn);
		this.singleAcc = true;
		this.balance = 0;
		this.arrayCust.add(customer1.id);
	}
	
	Accounts(Customers customer1, Customers customer2){
		this.status = "pending";
		this.accNum = generateAccNum(customer1.ssn, customer2.ssn);
		this.singleAcc = false;
		this.balance = 0;
		this.arrayCust.add(customer1.id);
		this.arrayCust.add(customer2.id);
		
	}	
	
	public static void main(String[] args) {

//		Customers cust = new Customers("a", "1", "dan", 2);
//		Accounts account = new Accounts(cust); 
//		cust.arrayAcc.add(account.accNum);
//		HashMap<String, Accounts> hashMapAcc = new HashMap<>();
//		HashMap<String, Customers> hashMapCust = new HashMap<>();
//		hashMapAcc.put(account.accNum, account);
//		hashMapCust.put(cust.id, cust);
//		serializeAccount(hashMapAcc);
//		Customers.serializeCustomer(hashMapCust);
		
	}
	
	static HashMap<String, Accounts> deSerializeAccount() {
		String filename = "accounts.ser";
		HashMap<String, Accounts> hashMapAcc = null; 
		try { 
			FileInputStream file = new FileInputStream(filename); 
			ObjectInputStream in = new ObjectInputStream(file); 
			hashMapAcc = (HashMap<String, Accounts>)in.readObject(); 	
			in.close(); 
			file.close(); 
			System.out.println("Retrieving account information... "); 
			System.out.println("[Number of accounts]: " + hashMapAcc.size());
			
		} 
		catch(IOException ex) { 
			System.out.println("IOException is caught"); 
		} 
		catch(ClassNotFoundException ex){ 
			System.out.println("ClassNotFoundException is caught"); 
		}
		return hashMapAcc; 
	}
	
	public static void serializeAccount(HashMap<String, Accounts> hashMapAcc) {
		String filename = "accounts.ser";
		boolean append = false;
		//HashMap<String, Accounts> hashMapAcc = deSerializeAccount();
		//HashMap<String, Accounts> hashMapAcc = new HashMap<String, Accounts>(); 
		//hashMapAcc.put(newAccount.accNum, newAccount);
		try{ 
			FileOutputStream file = new FileOutputStream(filename, append); 
			ObjectOutputStream out = new ObjectOutputStream(file); 
			out.writeObject(hashMapAcc); 
			out.close(); 
			file.close(); 
			System.out.println("Accounts have been serialized"); 
			System.out.println("[Number of accounts]: "+hashMapAcc.size());
		} 
		catch(IOException ex) { 
			System.out.println("IOException is caught"); 
		} 
	}
		
	public static String generateAccNum(int ssn){
	    int acc = ssn * ssn; 
		String st = Integer.toString(acc);
	    return st;
	}
	
	public static String generateAccNum(int ssn1, int ssn2){
		int acc = ssn1 * ssn2; 
		String st = Integer.toString(acc);
	    return st;
	}
	
	public String toString() {
	return "[Account Number: "+accNum + "] [Balance: "+balance+ "] [Single Account: "+singleAcc + "] [Account Status: "+status+"]\n[Customers: " + arrayCust +"]"; 
	}
	
	public static void printAccInfo(Accounts acc) {
		System.out.println("\n-----------------------------" + "Account Info" + "----------------------------");
		System.out.println(acc);
		System.out.println("--------------------------------Thanks--------------------------------");
	}

}


