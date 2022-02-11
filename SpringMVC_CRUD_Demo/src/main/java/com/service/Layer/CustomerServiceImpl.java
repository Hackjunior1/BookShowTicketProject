package com.service.Layer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daoLayer.CustomerDAO;
import com.JPA.Entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List < Customer > getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        customerDAO.saveCustomer(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {
        return customerDAO.getCustomer(theId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
        customerDAO.deleteCustomer(theId);
    }
    
	/*
	 * @Override
	 * 
	 * @Transactional public List<Customer> searchCustomer(int theMobile) { return
	 * (List<Customer>) customerDAO.searchCustomers(theMobile);
	 * 
	 * }
	 */
    
    
    @Override
    @Transactional
    public List<Customer> searchCustomer(String theMobile) {
        if (theMobile != null) {
            return customerDAO.searchCustomers(theMobile);
        }
        return customerDAO.getCustomers();
    }
}
