package bankapptest;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import junitTest.Employee;
public class EmployeeTest {
	
	Employee emp = new Employee(); 
	
	@Test
	public void emp_approveAcc() {
		assertEquals("I should return pass", "pass", emp.emp_approveAcc("88"));
	}

	@Test
	public void emp_denyAccw() {
		assertEquals("I should return pass", "pass", emp.emp_denyAcc("11"));
	}
	
	@Test
	public void emp_viewAcc() {
		assertEquals("I should return pass", "pass", emp.emp_viewAcc("11"));
	}
	@Test
	public void emp_viewCust() {
		assertEquals("I should return pass", "pass", emp.emp_viewCust("11"));
	}
	@Test
	public void verifyAdmin() {
		assertEquals("I should return pass", "pass", emp.verifyEmployee("11", "asdf"));
	}


}
