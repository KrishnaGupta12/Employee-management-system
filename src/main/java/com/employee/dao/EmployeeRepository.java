package com.employee.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findByUserName(String user);

}
