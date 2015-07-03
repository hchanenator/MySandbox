/**
 * 
 */
package org.herb.dbtesting;

import java.util.ArrayList;
import java.util.List;

import org.herb.dbtesting.domain.Employee;
import org.herb.dbtesting.repository.EmployeeRepository;
import org.herb.dbtesting.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author herb
 * 
 */
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan(basePackages = "org.herb.dbtesting")
@SpringBootApplication
public class DatabaseSandbox implements CommandLineRunner {

	@Autowired
	EmployeeRepository repository;

	public static void main(String[] args) {
		// Session session =
		// HibernateUtil.createSessionFactory("hsql.cfg.xml").openSession();
		// System.out.println(session.isConnected() ? "Yes, we're connected!" :
		// "Nope, we're not connected...");
		// session.close();
		SpringApplication.run(DatabaseSandbox.class, args);
		
	}
	
	public void run(String... strings) throws Exception {
		System.out.println("Hello Herb! ###########################################");
		ArrayList<Employee> emps = (ArrayList<Employee>) repository.findAll();
		for (Employee emp : emps) {
			System.out.println(emp.toString());
		}
	}
}
