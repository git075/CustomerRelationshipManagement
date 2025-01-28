package com.CustomerRelationshipManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustomerRelationshipManagement.Entity.Customer;
import com.CustomerRelationshipManagement.dao.CustomerDAO;
import com.CustomerRelationshipManagement.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	//Constructor injection can also be done here and constructor injection is better than Autowiring.
	CustomerDAO customerdao;
	

	@Override
	public String insertCustomer(Customer customer) {
		String status = customerdao.insertCustomer(customer);
		return status;
		
	}

	@Override
	public List<Customer> getCustomer() {
		return customerdao.getCustomer();
	}

	@Override
	public Customer getCustomerById(int id) {
		return customerdao.getCustomerById(id);
	}

	@Override 
	public String updateCustomer(Customer customer) {
		return customerdao.updateCustomer(customer);
	}

	@Override
	public String deleteCustomerById(int id) {
		return customerdao.deleteCustomerById(id);
	}

	@Override
	public String insertMultipleCustomers(List<Customer> customer) {
		return customerdao.insertMultipleCustomers(customer);
	}

	@Override
	public List<Customer> getCustomersByFirstName(String firstName) {
		return customerdao.getCustomerByFirstName(firstName);
	}

	@Override
	public List<Customer> getCustomersByAgeLessThan(int age) {
		return customerdao.getCustomersByAgeLessThan(age);
	}

	@Override
	public List<Customer> getCustomersByAgeMoreThan(int age) {
		return customerdao.getCustomersByAgeMoreThan(age);
	}

	@Override
	public List<Customer> getCustomersByAge(int age) {
		return customerdao.getCustomersByAge(age);
	}
	
	

}
