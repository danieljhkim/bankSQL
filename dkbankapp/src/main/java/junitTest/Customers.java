package junitTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Customers implements java.io.Serializable{
	
	/*
	 * SerialVersionUID
	 * represents your class's version
	 *
	 * the serialization runtime associates a version number with each serializable class
	 * it is used during deserialization to verify that the sender and the receiver of 
	 * the serialized object have loaded the correct class.
	 */
	
	//private static final long serialVersionUID = 1L;
	String id, password, name;
	int ssn;
	ArrayList<String> arrayAcc; 
	
	Customers(String id, String password, String name, int ssn){
		this.id = id;
		this.password = password;
		this.name = name;
		this.ssn = ssn;
		this.arrayAcc = new ArrayList<>();
	}
	
	
	public static HashMap<String, Customers> deSerializeCustomer() {
		String filename = "customers.ser";
		HashMap<String, Customers> hashMapCust = null; 
		try { 
			FileInputStream file = new FileInputStream(filename); 
			ObjectInputStream in = new ObjectInputStream(file); 
			hashMapCust = (HashMap<String, Customers>)in.readObject(); 	
			in.close(); 
			file.close(); 
			System.out.println("Retrieving customer information..."); 
			System.out.println("[Number of Customers]:" + hashMapCust.size());
		} 
		catch(IOException ex) { 
			System.out.println("IOException is caught"); 
		} 
		catch(ClassNotFoundException ex){ 
			System.out.println("ClassNotFoundException is caught"); 
		}
		return hashMapCust; 
	}
	
	public static void serializeCustomer(HashMap<String, Customers> hashMapCust) {
		String filename = "customers.ser";
		boolean append = false;
		//HashMap<String, Customers> hashMapCust = deSerializeCustomer();
		//HashMap<String, Accounts> hashMapAcc = new HashMap<String, Accounts>(); 
		//hashMapCust.put(newAccount.id, newAccount);
		try{ 
			FileOutputStream file = new FileOutputStream(filename, append); 
			ObjectOutputStream out = new ObjectOutputStream(file); 
			out.writeObject(hashMapCust); 
			out.close(); 
			file.close(); 
			System.out.println("Customer registrations have been serialized"); 
			System.out.println("[Number of Customers]:" + hashMapCust.size());
		} 
		catch(IOException ex) { 
			System.out.println("IOException is caught"); 
		} 
	}
	
	public static String withdrawCustomer(String cust_acc) {
		Scanner sc = new Scanner(System.in);
		double amount;
		if (MainDriver.hashMapAcc.get(cust_acc).status.equals("approved")) {
			amount = MainDriver.checkInputDouble();
			if (MainDriver.hashMapAcc.get(cust_acc).balance >= amount) {
				MainDriver.hashMapAcc.get(cust_acc).balance -= amount;
				System.out.println("#SUCCESS#: Withdrwal complete. The account balance is now: $" + MainDriver.hashMapAcc.get(cust_acc).balance);
				return "fail";
			} else {
				System.out.println("*ERROR*: Insufficient account balance. The account balance is: $" + MainDriver.hashMapAcc.get(cust_acc).balance);
				return "fail";
			}
		} else {
			System.out.println("*ERROR*: Sorry. The status of the account is: " + MainDriver.hashMapAcc.get(cust_acc).status );
			return "pass";
		}
	}
	
	public static String depositCustomer(String cust_acc) {
		Scanner sc = new Scanner(System.in);
		double amount;
		if (MainDriver.hashMapAcc.get(cust_acc).status.equals("approved")) {
			amount = MainDriver.checkInputDouble();
			MainDriver.hashMapAcc.get(cust_acc).balance += amount;
			System.out.println("#SUCCESS#: Deposit complete. The account balance is now: $" + MainDriver.hashMapAcc.get(cust_acc).balance);
			return "fail";
		}else {
			System.out.println("*ERROR*: Sorry. The status of the account is: " +MainDriver.hashMapAcc.get(cust_acc).status );
			return "pass";
		}
	}
	
	public static String transferCustomer(String cust_acc) {
		Scanner sc = new Scanner(System.in);
		double amount;
		String transferAcc; 
		if (MainDriver.hashMapAcc.get(cust_acc).status.equals("approved")) {
			amount = MainDriver.checkInputDouble();
			System.out.println("[INPUT]: What is the account number of the reciepient?");
			transferAcc = sc.nextLine();
			if (MainDriver.hashMapAcc.containsKey(transferAcc)==true && MainDriver.hashMapAcc.get(transferAcc).status.equals("approved")) {
				if (MainDriver.hashMapAcc.get(cust_acc).balance >= amount) {
					MainDriver.hashMapAcc.get(cust_acc).balance -=  amount; 
					MainDriver.hashMapAcc.get(transferAcc).balance += amount; //transfer account balance
					System.out.println("#SUCCESS#: Withdrwal complete. The account balance is now: $" + MainDriver.hashMapAcc.get(cust_acc).balance);
					return "fail";
				} else {
					System.out.println("*ERROR*: Insufficient account balance. The account balance is: $" + MainDriver.hashMapAcc.get(cust_acc).balance);
					return "fail";
				}
			} else {
				System.out.println("*ERROR*: Either the account number provided does not exist or the status is still pending.");
				return "pass";
			}
		} else {
			System.out.println("*ERROR*: Sorry. The status of the account is: " + MainDriver.hashMapAcc.get(cust_acc).status );
			return "fail";
		}
	}
	
	public String toString() {
	return "[ID: "+id + "] [Password: "+password + "] [Name: "+name + "] [SSN: "+ssn +  "]\n[Accounts: " + arrayAcc+"]"; 
	}
	
	public static void printCustInfo(Customers cust) {
		System.out.println("\n--------------------" + "Customer Info" + "--------------------");
		System.out.println(cust);
		System.out.println("------------------------Thanks------------------------");
	}
}
