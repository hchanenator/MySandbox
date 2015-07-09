/**
 * 
 */
package org.herb.dbtesting.repository;

import junit.framework.TestCase;







import org.herb.dbtesting.DatabaseSandbox;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author herb
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DatabaseSandbox.class)
public class EmployeeRepositoryTest extends TestCase {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Test
	public void testIsEmployeeRepositoryWired() {
		assertNotNull(employeeRepository);
	}

}
