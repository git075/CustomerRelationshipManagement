package com.CustomerRelationshipManagement.service;

import java.util.List;

import com.CustomerRelationshipManagement.Entity.Customer;

public interface CustomerService {

	String insertCustomer(Customer customer);
	List<Customer> getCustomer();
	Customer getCustomerById(int id);
	String updateCustomer(Customer customer);
	String deleteCustomerById(int id);
	String insertMultipleCustomers(List<Customer> customer);
	List<Customer> getCustomersByFirstName(String firstName);
	List<Customer> getCustomersByAgeLessThan(int age);
	List<Customer> getCustomersByAgeMoreThan(int age);
	List<Customer> getCustomersByAge(int age);

}
