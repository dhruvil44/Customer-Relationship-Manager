package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository //(Always applied @Repository to DAO implementations)
public class CustomerDAOImpl implements CustomerDAO {

	
	//need to inject SessionFactory
	@Autowired
	private SessionFactory sessionFactory;
	
	 //(By applying @Transaction we do not need to write session.build & session.commit...Spring automatically does it)
	@Override
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by firstName",
															Customer.class);
		
		//execute query and get customers list
		List<Customer> customers = theQuery.getResultList();
		
		//return the result
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		//get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save/update the Customer
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theID) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer theCustomer = currentSession.get(Customer.class, theID);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theID) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer theCustomer = currentSession.get(Customer.class, theID);
		
		currentSession.delete(theCustomer);
		
	}

	@Override
	public List<Customer> searchCustomer(String searchName) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		
		List<Customer> customers= currentSession.createQuery("from Customer where firstName = '"+searchName+"' ").getResultList();
		
		for(Customer tempCustomer:customers)
		{
			System.out.println(tempCustomer);
		}
	
		  
		return customers;
	}

}
