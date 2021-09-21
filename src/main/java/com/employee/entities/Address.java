package com.employee.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	@JoinColumn (name = "address_Id")
	private Integer address_Id;
	
	private Integer city_Id;
	private Integer employee_Id;
	private Integer dept_Id;
	private String address;
	
}


