package bankapptest;
import static org.junit.Assert.assertEquals;
import junitTest.Accounts;

import org.junit.Test;


public class AccountsTest {
	@Test
	public void generateAccNum() {
		assertEquals("I should return 16", "16", Accounts.generateAccNum(4));
	}
	@Test
	public void generateAccNum2() {
		assertEquals("I should return 8", "8", Accounts.generateAccNum(4, 2));
	}
	

}
