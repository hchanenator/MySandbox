package org.herb.sandbox.dbtesting;


import java.util.List;

import org.herb.dbtesting.entity.Employee;
import org.herb.dbtesting.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple MainApp.
 */
public class DBAppTest extends TestCase {

	private static final Logger log = LoggerFactory.getLogger(DBAppTest.class);

	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public DBAppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(DBAppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() { 
		// assertTrue( true ); 
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		assertNotNull("HibernateUtil did not return a valid session", session);
		session.close();
		
	}

	public void testWriteRecord() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		// String hql = "from Employee e where e.empId = :employeeID";
		String hql = "from Employee e where e.empId = 1";
		List<?> results = session.createQuery(hql).list();
		Employee emp = (Employee) results.get(0);
		log.debug(emp.getLastName());
		assertEquals("Herb", emp.getFirstName());
		
		Employee emp2 = new Employee();
		emp2.setFirstName("Nicole");
		emp2.setLastName("Chan");
		
//		session.save(emp2);
//		trx.commit();
		session.close();

	}
}
