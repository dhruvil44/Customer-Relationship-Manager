package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	//need to inject the CustomerDAO
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		//getting customers from DAO
		return customerDAO.getCustomers();
	}


	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		customerDAO.saveCustomer(theCustomer);
	}


	@Override
	@Transactional
	public Customer getCustomer(int theID) {
		
		return customerDAO.getCustomer(theID);
	}


	@Override
	@Transactional
	public void deleteCustomer(int theID) {
	
		customerDAO.deleteCustomer(theID);
	}


	@Override
	@Transactional
	public List<Customer> searchNames(String searchName) {
		
		List<Customer> customers=customerDAO.searchCustomer(searchName);
		
		for(Customer tempCustomer:customers)
		{
			System.out.println(tempCustomer);
		}
		
		return customers;
	}
	
	

}
