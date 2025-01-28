package com.CustomerRelationshipManagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.CustomerRelationshipManagement.Entity.Customer;


@Repository
public class CustomerDAO {
	
//	Database ka code
//	@Autowired
	SessionFactory sf;
    //constructor injection
	public CustomerDAO(SessionFactory sf) {
		super();
		this.sf = sf;
	}
	
	public String insertCustomer(Customer customer) {
		Session session = sf.openSession();
		//insert, update, delete --> you have to use transaction
		Transaction tr = session.beginTransaction();
		session.save(customer);
		tr.commit();
		session.close();
		
		return "Customer inserted succesfully";
	}
	
	public List<Customer> getCustomer() {
		Session session = sf.openSession();
		//Query query = session.createQuery("from Customers").list()
		return session.createQuery("from Customers").list();
		
	} 
	
	public Customer getCustomerById(int id) {
		Session session = sf.openSession();
		return session.get(Customer.class, id);
		//get->gives null if object not found in db.
		//load->gives object not found exception if object not found in db.
	}
	
	public String updateCustomer(Customer customer) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.update(customer);
		tr.commit();
		session.clear();
		return "Customer updated successfully";
	}
	
	public String deleteCustomerById(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		session.delete(customer);
		tr.commit();
		session.close();
		return "Customer with id: "+id+" deleted successfilly";
	}
	
	public String insertMultipleCustomers(List<Customer> customers) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		for(Customer customer : customers) {
			session.save(customer);
		}
		tr.commit();
		session.close();
		return "List of customers added successfully.";
	}
	
	public List<Customer> getCustomerByFirstName(String firstName){
		Session session = sf.openSession();
		Query<Customer> query = session.createQuery("from Customer c where c.firstName=:firstName", Customer.class);
		query.setParameter("firstName", firstName);
		List<Customer> list = query.list();
		return list;
		
	}
	
	public List<Customer> getCustomersByAgeLessThan(int age){
		Session session = sf.openSession();
		Query<Customer> query = session.createQuery("from Customer c where c.age<:age",Customer.class);
		query.setParameter("age", age);
		List<Customer> customers = query.list();
		return customers;
		
	}
	
	public List<Customer> getCustomersByAgeMoreThan(int age){
		Session session = sf.openSession();
		Query<Customer> query = session.createQuery("from Customer c where c.age>:age",Customer.class);
		query.setParameter("age", age);
		List<Customer> customers = query.list();
		return customers;
		
	}
	
	public List<Customer> getCustomersByAge(int age){
		Session session = sf.openSession();
		String hql = "from Customer c where c.age=:age";
		Query<Customer> query = session.createQuery(hql,Customer.class);
		query.setParameter("age", age);
		List<Customer> customers = query.list();
		return customers;
	}

	

}
