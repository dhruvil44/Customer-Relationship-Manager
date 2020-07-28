package com.luv2code.springdemo.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Controller
@RequestMapping("/customers")
public class CustomerControllerPractice {


	
	@RequestMapping("/list")
	public String listCustomers(Model theModel)
	{
		SessionFactory factory = new Configuration()
								.addResource("hibernate.cfg.xml")
								.addAnnotatedClass(Customer.class)
								.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		List<Customer> theCustomers;
		
		try {
			
			session.beginTransaction();
			
			theCustomers = session.createQuery("from Customer").getResultList();
			
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
		
		//add the Customers to the Model
		theModel.addAttribute("customers",theCustomers);
		
		
		return "list-customers";
	}
}
