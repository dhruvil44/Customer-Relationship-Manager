package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> findAllAsc();
	
	public Customer findById(int theId);
	
	public void save(Customer theCustomer);
	
	public void deleteById(int theId);

	public List<Customer> findByName(String name);
	


}
