package com.txu.registrationapp.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.txu.registrationapp.model.Customer;

@Repository
public class CustomerRegisterDAO {

	
	private int cust_id;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerRegisterDAO.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean addCustomer(Customer customer) {

		if (sessionFactory != null) {
			Session session = sessionFactory.getCurrentSession();
			if (session != null) {
				if (session.save(customer) != null) {
					
					Query query = session.createQuery("select id from Customer where email= :email");
					
					query.setParameter("email", customer.getEmail());
					
					
					cust_id = (int) query.uniqueResult();
					
					logger.info("Customer registered successfully, Customer Details : " + customer);
					return true;
				} else {
					logger.info("Could not save the customer details");
					return false;
				}
			} else {
				logger.info("Could not establish a session");
				return false;
			}
		} else {
			logger.info("SessionFactory is null");
			return false;
		}

	}


	public int getCustomerId() {
		return cust_id;
	}
	


}
