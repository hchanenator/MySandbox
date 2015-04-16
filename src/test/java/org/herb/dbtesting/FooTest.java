package org.herb.dbtesting;

import org.herb.dbtesting.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FooTest {
	
	@Autowired
	EmployeeRepository repository;

  @Test
  public void greet() {
    Assert.assertNotNull(repository);
  }
}
