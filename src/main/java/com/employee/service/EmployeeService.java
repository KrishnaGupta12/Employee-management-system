package com.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeRepository;
import com.employee.entities.Employee;

@Service
public class EmployeeService {
     
    @Autowired
    EmployeeRepository employeeRepository;
     
    public List<Employee> getAllEmployees()
    {
        List<Employee> employeeList = employeeRepository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<Employee>();
        }
    }
     
    public Employee getEmployeeById(Long id) throws RecordNotFoundException 
    {
        Optional<Employee> employee = employeeRepository.findById(id);
         
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
     
    public Employeee createOrUpdateEmployee(Employee entity) throws RecordNotFoundException 
    {
        Optional<Employee> employee = employeeRepository.findById(entity.getId());
         
        if(employee.isPresent()) 
        {
            Employee newEntity = employee.get();
            newEntity.setEmp_Name(entity.getEmp_Name());
            newEntity.setPhone_No(entity.getPhone_No());
            newEntity.setEmp_Email(entity.getEmp_Email());
            newEntity.setEmp_Gender(entity.getEmp_Gender());
            newEntity.setDepartment(entity.getDepartment());
            newEntity.setCity(entity.getCity());
            newEntity.setAddress(entity.getAddress());
            newEntity.setStatus(entity.getStatus());
 
            newEntity = employeeRepository.save(newEntity);
             
            return newEntity;
        } else {
            entity = employeeRepository.save(entity);
             
            return entity;
        }
    } 
     
    public void deleteEmployeeById(Long id) throws RecordNotFoundException 
    {
        Optional<Employee> employee = employeeRepository.findById(id);
         
        if(employee.isPresent()) 
        {
        	employeeRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    } 
}