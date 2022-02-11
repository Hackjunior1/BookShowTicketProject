package com.daoLayer;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.JPA.Entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
		Root<Customer> root = cq.from(Customer.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer book = session.byId(Customer.class).load(id);
		session.delete(book);
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer theCustomer = currentSession.get(Customer.class, theId);
		return theCustomer;
	}

	@Override
	public List<Customer> searchCustomers(String theMobile) {
		/*
		 *
		 * CriteriaBuilder cb =
		 * session.getCriteriaBuilder();
		 * 
		 * 
		 * CriteriaQuery<Customer> criteriaQuery =cb.createQuery(Customer.class);
		 * 
		 * Root<Customer> root = criteriaQuery.from(Customer.class); In<Object> inClause
		 * = cb.in(root.get("mobile"));
		 * 
		 * criteriaQuery.select(root).where(inClause); 
		 * Query query = session.createQuery(criteriaQuery);
		 * 
		 * 
		 * CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
		 * 
		 * Root<Customer> root = cq.from(Customer.class);
		 * System.out.println("the mobile number is " + root.get("mobile"));
		 * 
		 * In<Object> inClause = cb.in(root.get("mobile")); cq.where(inClause);
		 * //cq.select(root) .where(root.get("mobile").in(titles)); TypedQuery<Customer>
		 * query = session.createQuery(cq);
		 * 
		 * System.out.println("Hibernate Query in customerDAOImpl class is "+query);
		 */
		
	    /*@Query("SELECT c FROM Customer c WHERE c.firstName LIKE %?1%"
	            + " OR c.lastName LIKE %?1%"
	            + " OR c.email LIKE %?1%"
	            + " OR CONCAT(c.mobile, '') LIKE %?1%")*/
		 Session session = sessionFactory.getCurrentSession(); 
	    String hql=("SELECT c FROM Customer c WHERE c.firstName LIKE %?1%"
	            + " OR c.lastName LIKE %?1%"
	            + " OR c.email LIKE %?1%"
	            + " OR CONCAT(c.mobile, '') LIKE %?1%");
	    Query query = session.createQuery(hql);
		return query.getResultList();

	}
}