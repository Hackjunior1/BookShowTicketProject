package com.daoLayer;

import java.util.List;

import com.JPA.Entity.Customer;

public interface CustomerDAO {

    public List < Customer > getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);

	//Customer searchCustomer(int theMobile);

	public List<Customer> searchCustomers(String theMobile);
}