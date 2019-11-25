package dkbank;

import java.util.HashMap;
import database.CustomerDaoImp;

public class HashMaps {
	CustomerDaoImp dataObject = new CustomerDaoImp();
	HashMap<String, Customers> hashMapCust;
	HashMap<String, Accounts> hashMapAcc; 
	
	HashMaps(){
		this.hashMapCust = dataObject.getCustHashMap();  
		this.hashMapAcc = dataObject.getAccHashMap();; 
	}

	public CustomerDaoImp getDataObject() {
		return dataObject;
	}

	public void setDataObject(CustomerDaoImp dataObject) {
		this.dataObject = dataObject;
	}

	public HashMap<String, Customers> getHashMapCust() {
		return hashMapCust;
	}

	public void setHashMapCust(HashMap<String, Customers> hashMapCust) {
		this.hashMapCust = hashMapCust;
	}

	public HashMap<String, Accounts> getHashMapAcc() {
		return hashMapAcc;
	}

	public void setHashMapAcc(HashMap<String, Accounts> hashMapAcc) {
		this.hashMapAcc = hashMapAcc;
	}
	

}
