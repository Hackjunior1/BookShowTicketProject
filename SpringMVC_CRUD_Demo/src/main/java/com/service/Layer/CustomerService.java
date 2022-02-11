package com.service.Layer;

import java.util.List;

import org.springframework.ui.Model;

import com.JPA.Entity.Customer;

public interface CustomerService {

    public List < Customer > getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);

	//public List < Customer >  searchCustomer(Customer theMobile);

	public List<Customer> searchCustomer(String theMobile);

	



}