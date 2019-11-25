package database;
import java.util.ArrayList;
import java.util.HashMap;

import dkbank.Accounts;
import dkbank.Customers;

public interface CustomerDao {
	public int insertAllCust(HashMap<String,Customers> hashMapCust);
	//public Customers selectCustById(String id); 
	public HashMap<String, Customers> selectAllCust();
	//public int updateCust(Customers cust);
	//public int deleteCust(Customers cust); 
	public ArrayList<Keys> selectAllKeys();
	public HashMap<String, Accounts> selectAllAcc();
	public void truncateCust();
	public int insertAllAcc(HashMap<String, Accounts>hashMapAcc);
	public void truncateAcc();
	public void truncateKeys();
}