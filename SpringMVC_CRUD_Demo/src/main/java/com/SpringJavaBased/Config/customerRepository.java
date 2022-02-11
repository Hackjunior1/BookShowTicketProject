package com.SpringJavaBased.Config;


import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.JPA.Entity.Customer;
public interface customerRepository extends JpaRepository<Customer, Long> {
    
    @Query("SELECT c FROM Customer c WHERE c.firstName LIKE %?1%"
            + " OR c.lastName LIKE %?1%"
            + " OR c.email LIKE %?1%"
            + " OR CONCAT(c.mobile, '') LIKE %?1%")
    //@Query("SELECT c FROM Customer c WHERE CONCAT(c.firstName, c.lastName, c.email, c.mobile) LIKE %?1%")
    public List<Customer> search(String keyword);
}