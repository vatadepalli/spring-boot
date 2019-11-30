package com.mdt.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdt.pma.dto.EmployeeProject;
import com.mdt.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Override
	public List<Employee> findAll();
	
	@Query(nativeQuery = true, value = "select e.first_name firstName, e.last_name lastName, COUNT(pe.employee_id) projectCount " + 
			"from employee e left join project_employee pe on pe.employee_id = e.employee_id " + 
			"group by e.first_name, e.last_name " + 
			"order by 3 desc")
	public List<EmployeeProject> employeeProjects();
}
