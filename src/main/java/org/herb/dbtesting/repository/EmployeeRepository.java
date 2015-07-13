/**
 * 
 */
package org.herb.dbtesting.repository;

import java.util.List;

import org.herb.dbtesting.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author herb
 *
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	List<Employee> findAll();
	Employee findByEmpId(int empId);

}
