package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.luv2code.springboot.thymeleafdemo.entity.Customer;
import org.springframework.data.repository.query.Param;

//Entity	//Primary Key Type
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	//no need to write any code here like earlier DAO class....
	
	//add a method to sort by firstName
	@Query("from Customer order by firstName")
	public List<Customer> findAllAsc();

	@Query("from Customer e where e.firstName LIKE %:name%")
	 public List<Customer> findByNameContaining(@Param("name") String name);
	
	
}
