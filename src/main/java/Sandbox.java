import org.herb.dbtesting.domain.Employee;
import org.herb.dbtesting.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 
 */

/**
 * @author herb
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages="org.herb.dbtesting")
public class Sandbox {
	
	@Autowired
	EmployeeRepository repository;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Sandbox.class, args);

	}
	
	public void run(String...strings) throws Exception {
		System.out.println("Hello Herb!");
		Employee emp = repository.findEmployee(1);
		System.out.println(emp.toString());
	}

}
