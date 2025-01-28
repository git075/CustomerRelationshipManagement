package com.CustomerRelationshipManagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerRelationshipManagement.Entity.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;
import com.CustomerRelationshipManagement.service.impl.CustomerServiceImpl;


@RestController() //The insertCustomer method returns a string, and @RestController ensures it is converted to a JSON response.
@RequestMapping("/api/customers") //Maps all HTTP requests with the base URL /api/customers to methods in this controller.
public class CustomerController {
	 
	CustomerServiceImpl customerserviceimpl;
	
	CustomerService customerservice;
	
	public CustomerController(CustomerService customerservice) {
		this.customerservice=customerservice;
	}

	public CustomerController(CustomerServiceImpl customerserviceimpl) {
		super();
		this.customerserviceimpl = customerserviceimpl;
	}
	
	@PostMapping("/insert")  //Maps HTTP POST requests with the URL /api/customers/insert to the insertCustomer method.
	public String insertCustomer( @RequestBody Customer customer) {
		String status = customerserviceimpl.insertCustomer(customer);
		return status;
	}
	
	@GetMapping
	public List<Customer> getCustomers(){
		return customerserviceimpl.getCustomer();
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerById( @PathVariable int id) {
		return customerserviceimpl.getCustomerById(id);
	}
	 
	@PutMapping
	public String updateCustomer(@RequestBody Customer customer) {
		return customerserviceimpl.updateCustomer(customer);
		
	} 
	
	@DeleteMapping("/{id}")
	public String deleteCustomerById(@PathVariable int id) {
		return customerserviceimpl.deleteCustomerById(id);
	}
	
	@PostMapping("/insertmultiple")
	public String insertMultipleCustomers(@RequestBody List<Customer> customer) {
		return customerserviceimpl.insertMultipleCustomers(customer);
	}
	
	@GetMapping("/byname/{firstName}")
	public List<Customer> getCustomersByFirstName(@PathVariable String firstName){
		return customerserviceimpl.getCustomersByFirstName(firstName);
	}
	@GetMapping("/byageLessThan/{age}")
	public List<Customer> getCustomerByAgeLessThan(@PathVariable int age){
		return customerserviceimpl.getCustomersByAgeLessThan(age);
		
	}
	
	@GetMapping("/byageMoreThan/{age}")
	public List<Customer> getCustomerByAgeMoreThan(@PathVariable int age){
		return customerserviceimpl.getCustomersByAgeMoreThan(age);
		
	}
	
	@GetMapping("/byage/{age}")
	public List<Customer> getCustomerByAge(@PathVariable int age){
		return customerserviceimpl.getCustomersByAge(age);
		
	}


}

// the controller class makes use of URIs (Uniform Resource Identifiers) to define endpoints for various customer-related operations.


/*
@RequestBody
Purpose:
Maps the HTTP request body to a Java object.
In this case, it converts the incoming JSON payload into a Customer object.
How It Works:
Spring uses Jackson (by default) to handle the deserialization from JSON to Java.
*/