package bankapptest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import junitTest.MainDriver;

public class MainDriverTest {
	
	@Test
	public void verifyCustomer() {
		assertEquals("I should return pass", "pass", MainDriver.verifyCustomer("asdf", "adsf"));
	}

	@Test
	public void etchCustomerw() {
		assertEquals("I should return pass", "pass", MainDriver.fetchCustomer("11", "asdf"));
	}
	
	@Test
	public void checkSSN() {
		assertEquals("I should return pass", "pass", MainDriver.checkSSN(1981));
	}
	@Test
	public void checkId() {
		assertEquals("I should return pass", "pass", MainDriver.checkId("11"));
	}

}
