/**
 * 
 */
package org.herb.dbtesting;


import org.herb.dbtesting.util.HibernateUtil;
import org.hibernate.Session;

/**
 * @author herb
 *
 */
public class DatabaseSandbox {
	 public static void main( String[] args )
	    {
	    	Session session = HibernateUtil.createSessionFactory().openSession();
	    	System.out.println(session.isConnected() ? "Yes, we're connected!" : "Nope, we're not connected...");
	    	session.close();
	    }
}
