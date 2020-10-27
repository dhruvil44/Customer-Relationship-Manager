package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	
	@Autowired
	private CustomerService customerService;
	
	//add a mapping for "/list"
	@GetMapping("/list")
	public String listCustomers(Model theModel)
	{
		theModel.addAttribute("customers", customerService.findAllAsc());
		return "customers/list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		//create model attribute
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		
		return "customers/customer-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,Model theModel)
	{
		//get the employee from the service
		Customer theCustomer = customerService.findById(theId);
		
		//set the employee as model attribute
		theModel.addAttribute(theCustomer);
		
		//send over to the form
		return"customers/customer-form";
		
	}
	
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
	{
		//save the employee
		customerService.save(theCustomer);
		
		//use a redirect to prevent duplicate submissions
		return "redirect:/customers/list";
		
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId)
	{
		//delete the employee
		customerService.deleteById(theId);
		
		//redirect to the list
		return "redirect:/customers/list";
	}

	@GetMapping("/findByName")
	public String findByName(@RequestParam("search") String name, Model theModel)
	{
		List<Customer> customers = customerService.findByName(name);

		theModel.addAttribute("customers", customers);


		return "/customers/list-customers";

	}
	
}
