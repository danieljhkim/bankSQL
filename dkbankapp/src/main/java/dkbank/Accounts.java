package dkbank;

import java.util.ArrayList;

public class Accounts{

	public String accNum;
	public String status;
	public double balance;
	public int singleAcc;
	public ArrayList<String> arrayCust = new ArrayList<>();
	
	public Accounts(){
	}
	
	public Accounts(String accNum, String status, double balance, int singleAcc ){
		this.status = status;
		this.accNum = accNum;
		this.singleAcc = singleAcc;
		this.balance = balance;
		this.arrayCust = new ArrayList<>();
	}
	
	public Accounts(Customers customer1){
		this.status = "pending";
		this.accNum = generateAccNum(customer1.ssn);
		this.singleAcc = 1;
		this.balance = 0;
		this.arrayCust.add(customer1.id);
	}
	
	public Accounts(Customers customer1, double balance){
		this.status = "approved";
		this.accNum = generateAccNum(customer1.ssn);
		this.singleAcc = 1;
		this.balance = balance;
		this.arrayCust.add(customer1.id);
	}

	public Accounts(Customers customer1, Customers customer2){
		this.status = "pending";
		this.accNum = generateAccNum(customer1.ssn, customer2.ssn);
		this.singleAcc = 0;
		this.balance = 0;
		this.arrayCust.add(customer1.id);
		this.arrayCust.add(customer2.id);
	}
	
	public Accounts(Customers customer1, Customers customer2, double balance){
		this.status = "approved";
		this.accNum = generateAccNum(customer1.ssn, customer2.ssn);
		this.singleAcc = 0;
		this.balance = balance;
		this.arrayCust.add(customer1.id);
		this.arrayCust.add(customer2.id);
	}
	
	static String generateAccNum(int ssn){
	    int acc = ssn * ssn; 
		String st = Integer.toString(acc);
	    return st;
	}
	
	static String generateAccNum(int ssn1, int ssn2){
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

	public String getAccNum() {
		return accNum;
	}
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getSingleAcc() {
		return singleAcc;
	}
	public void setSingleAcc(int singleAcc) {
		this.singleAcc = singleAcc;
	}

}


