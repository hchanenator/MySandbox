package org.herb;
import org.herb.dbtesting.domain.Employee;
import org.herb.dbtesting.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 
 */

/**
 * @author herb
 *
 */
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan(basePackages="org.herb.dbtesting")
//@SpringBootApplication
public class Sandbox implements CommandLineRunner {
	
	@Autowired
	EmployeeRepository repository;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Sandbox.class, args);

	}
	
	public void run(String...strings) throws Exception {
		System.out.println("Hello Herb! ###########################################");
		Employee emp = repository.findByEmpId(1);
		System.out.println(emp.toString());
	}

}
