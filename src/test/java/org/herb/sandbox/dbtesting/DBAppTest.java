package org.herb.sandbox.dbtesting;


import java.util.List;

import org.herb.dbtesting.domain.Employee;
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

	public void testApp() { 
		Session session = HibernateUtil.createSessionFactory("hsql.cfg.xml").openSession();
		assertNotNull("HibernateUtil did not return a valid session", session);
		session.close();
		
	}

	public void testWriteRecord() {
//		Session session = HibernateUtil.getSessionFactory().openSession();
		Session session = HibernateUtil.createSessionFactory("hsql.cfg.xml").openSession();
		Transaction trx = session.beginTransaction();
		// String hql = "from Employee e where e.empId = :employeeID";
		
		Employee emp1 = new Employee();
		emp1.setFirstName("Herb");
		emp1.setLastName("Chan");
		session.save(emp1);
		
		Employee emp2 = new Employee();
		emp2.setFirstName("Nicole");
		emp2.setLastName("Chan");
		
		session.save(emp2);	
		
		
		
		String hql = "from Employee e where e.empId = 1";
		List<?> results = session.createQuery(hql).list();
		Employee emp = (Employee) results.get(0);
		log.debug(emp.getLastName());
		assertEquals("Mick", emp.getFirstName());
		
		String hql2 = "from Employee e";
		results = session.createQuery(hql2).list();
		
		for (Object o: results) {
			System.out.println(((Employee)o).toString());
		}
		
		trx.commit();
		session.close();

	}
	
	public void testReadRecords() {
		Session session = HibernateUtil.createSessionFactory("hsql.cfg.xml").openSession();
		String hql = "from Employee e where e.empId = 1";
		List<?> results = session.createQuery(hql).list();
		Employee emp = (Employee) results.get(0);
		log.debug(emp.getLastName());
		assertEquals("Mick", emp.getFirstName());
		
		String hql2 = "from Employee e";
		results = session.createQuery(hql2).list();
		for (Object o: results) {
			System.out.println(((Employee)o).toString());
		}
		session.close();

	}
	
	
}
