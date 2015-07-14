/**
 * 
 */
package org.herb.dbtesting.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * @author herb
 *
 */
public class HibernateUtil {
//	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory mySessionFactory;

	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

//	public static SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}

//	public static void shutdown() {
//		// Close caches and connection pools
//		getSessionFactory().close();
//	}
	
	public static SessionFactory createSessionFactory(String configFile) {
		Configuration configuration = new Configuration();
		configuration.configure(configFile);
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		mySessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return mySessionFactory;
	}
}
