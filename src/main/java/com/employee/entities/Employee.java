package com.employee.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.tomcat.jni.Address;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer employee_id;
	@Column(name="Name",nullable=false)
	private String emp_Name;
	@Column(name="PhoneNo",nullable=false)
	private Integer phone_No;
	@Column(name="Email",nullable=false)
	private String emp_Email;
	@Column(name="Gender",nullable = false)
	private String emp_Gender;
	
	@Enumerated(EnumType.STRING)
	private Department department;
	
	 @OneToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="city_id")
	 private City city;
	
	
	 @OneToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="address_id")
	 private Address address;

	@Column(name="Status" , nullable=false)
	private String status;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer employee_id, String emp_Name, Integer phone_No, String emp_Email, String emp_Gender,
			Department department, City city, Address address, String status) {
		super();
		this.employee_id = employee_id;
		this.emp_Name = emp_Name;
		this.phone_No = phone_No;
		this.emp_Email = emp_Email;
		this.emp_Gender = emp_Gender;
		this.department = department;
		this.city = city;
		this.address = address;
		this.status = status;
	}

	public Integer getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmp_Name() {
		return emp_Name;
	}

	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}

	public Integer getPhone_No() {
		return phone_No;
	}

	public void setPhone_No(Integer phone_No) {
		this.phone_No = phone_No;
	}

	public String getEmp_Email() {
		return emp_Email;
	}

	public void setEmp_Email(String emp_Email) {
		this.emp_Email = emp_Email;
	}

	public String getEmp_Gender() {
		return emp_Gender;
	}

	public void setEmp_Gender(String emp_Gender) {
		this.emp_Gender = emp_Gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", emp_Name=" + emp_Name + ", phone_No=" + phone_No
				+ ", emp_Email=" + emp_Email + ", emp_Gender=" + emp_Gender + ", department=" + department + ", city="
				+ city + ", address=" + address + ", status=" + status + "]";
	}

	
}


