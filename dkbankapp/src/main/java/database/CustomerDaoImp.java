package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import dkbank.Accounts;
import dkbank.Customers;


public class CustomerDaoImp implements CustomerDao{
	private static String url = "jdbc:oracle:thin:@dbdkim.caavz7hkeber.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "danieljhkim";
	private static String password = "123456789";
	
	public HashMap<String, Customers> getCustHashMap(){
		HashMap<String, Customers>hashMapCust =selectAllCust(); 
		ArrayList<Keys> keys_list = selectAllKeys();
		for(Keys key: keys_list) {
			hashMapCust.get(key.id).arrayAcc.add(key.accNum); 
		}
		return hashMapCust;
	}
	
	public HashMap<String, Accounts> getAccHashMap(){
		HashMap<String, Accounts>hashMapAcc = selectAllAcc(); 
		ArrayList<Keys> keys_list = selectAllKeys();
		for(Keys key: keys_list) {
			hashMapAcc.get(key.accNum).arrayCust.add(key.id); 
		}
		return hashMapAcc;
	}
	
	@Override
	public ArrayList<Keys> selectAllKeys(){
		ArrayList<Keys> keys_list = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM keys_table");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Keys key = new Keys(rs.getString("id"), rs.getString("accNum"));
				keys_list.add(key);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return keys_list;
	}
	
	@Override
	public HashMap<String, Customers> selectAllCust(){
		HashMap<String, Customers> HashMapCust = new HashMap<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM customers");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Customers cust = new Customers(rs.getString("id"), rs.getString("password"), rs.getString("name"), rs.getInt("ssn"));
				HashMapCust.put(cust.id, cust);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return HashMapCust;
	}
	
	@Override
	public HashMap<String, Accounts> selectAllAcc(){
		HashMap<String, Accounts> HashMapAcc = new HashMap<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM accounts");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Accounts acc = new Accounts(rs.getString("accNum"), rs.getString("status"), rs.getDouble("balance"), rs.getInt("singleAcc"));
				HashMapAcc.put(acc.getAccNum(), acc);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return HashMapAcc;
	}
	
	@Override
	public void truncateCust() {
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement t = conn.prepareStatement("TRUNCATE TABLE customers");
			t.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Truncating customers table failed.");
		}
	}
	
	@Override
	public void truncateAcc() {
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("TRUNCATE TABLE accounts");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Truncating accounts table failed.");
		}
	}
	
	@Override
	public void truncateKeys() {
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement tt = conn.prepareStatement("TRUNCATE TABLE keys_table");
			tt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Truncating keys_table failed.");
		}
	}
	
	@Override
	public int insertAllCust(HashMap<String, Customers>hashMapCust) {
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			Iterator<Map.Entry<String, Customers>> hmIterator = hashMapCust.entrySet().iterator(); 
	        while (hmIterator.hasNext()) { 
	            Map.Entry<String, Customers> mapElement = (Map.Entry<String, Customers>)hmIterator.next(); 
	            Customers cust = (Customers)mapElement.getValue();
	            PreparedStatement ps = conn.prepareStatement("INSERT INTO customers VALUES(?,?,?,?)");
				ps.setString(1, cust.getId());
				ps.setString(2, cust.getPassword());
				ps.setString(3, cust.getName());
				ps.setInt(4, cust.getSsn());
				ps.executeUpdate();
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int insertAllAcc(HashMap<String, Accounts>hashMapAcc) {
		try (Connection conn = DriverManager.getConnection(url, username, password)){
			Iterator<Map.Entry<String, Accounts>>hmIterator = hashMapAcc.entrySet().iterator(); 
	        while (hmIterator.hasNext()) { 
	            Map.Entry <String,Accounts> mapElement = (Map.Entry<String,Accounts>)hmIterator.next(); 
	            Accounts acc = (Accounts)mapElement.getValue();
	            PreparedStatement ps = conn.prepareStatement("INSERT INTO accounts VALUES(?,?,?,?)");
				ps.setString(1, acc.getAccNum());
				ps.setString(2, acc.getStatus());
				ps.setDouble(3, acc.getBalance());
				ps.setInt(4, acc.getSingleAcc());
				ps.executeUpdate();
				for(String s : acc.arrayCust) {
					PreparedStatement p = conn.prepareStatement("INSERT INTO keys_table VALUES(?,?)");
					p.setString(1, s);
					p.setString(2, acc.getAccNum());
					p.executeUpdate();
				}
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
//	@Override
//	public Customers selectCustById(String id) {
//		Customers cust= null;
//		try(Connection conn = DriverManager.getConnection(url, username, password)){
//			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customers WHERE id=?");
//			ps.setString(1, id);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				cust = new Customers(rs.getString("id"), rs.getString("password"), rs.getString("name"), rs.getInt("ssn"));
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return cust;
//	}
//	
//	@Override
//	public int updateCust(Customers cust) {
//		try(Connection conn = DriverManager.getConnection(url, username, password)){
//			PreparedStatement ps = conn.prepareStatement("UPDATE customers SET blank=? WHERE id=?");
//			ps.setString(1, cust.getId());
//			ps.setString(2, cust.getPassword());
//			ps.executeUpdate();
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}
//	
//	@Override
//	public int deleteCust(Customers cust) {
//		try(Connection conn = DriverManager.getConnection(url, username, password)){
//			PreparedStatement ps = conn.prepareStatement("DELETE FROM customers WHERE id=?");
//			ps.setString(1, cust.getName());
//			ps.executeUpdate();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}
//	

}
