package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import com.luv2code.springboot.thymeleafdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> findAllAsc() {
		
		return customerRepository.findAllAsc();
	}

	@Override
	public Customer findById(int theId) {
		
		Optional<Customer> result = customerRepository.findById(theId);
		
		Customer theCustomer =null;
		
		if(result.isPresent())
		{
			theCustomer =result.get();
		}
		else {
			throw new RuntimeException("Did not find the ID "+theId);
		}
		
		return theCustomer;
	
	}

	@Override
	public void save(Customer theCustomer) {
		customerRepository.save(theCustomer);

	}

	@Override
	public void deleteById(int theId) {
		customerRepository.deleteById(theId);

	}

	@Override
	public List<Customer> findByName(String name) {
		return customerRepository.findByNameContaining(name);
	}
}
