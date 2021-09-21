package com.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
