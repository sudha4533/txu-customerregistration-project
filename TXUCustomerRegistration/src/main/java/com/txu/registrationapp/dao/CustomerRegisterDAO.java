package com.txu.registrationapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.txu.registrationapp.model.Customer;

/**
 * Saves customer details to database
 */
@Repository
public class CustomerRegisterDAO {

	private int cust_id;

	private static final Logger logger = LoggerFactory.getLogger(CustomerRegisterDAO.class);

	private SessionFactory sessionFactory;

	/**
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @param customer
	 * @returns true when customer details is saved to database
	 */
	public boolean addCustomer(Customer customer) {

		if (sessionFactory != null) {
			Session session = sessionFactory.getCurrentSession();
			if (session != null) {
				cust_id = (int) session.save(customer);
				if (cust_id > 0) {
					logger.info("Customer registered successfully, Customer Details : " + customer);
					return true;
				} else {
					logger.info("Could not register the customer");
					return false;
				}
			} else {
				logger.info("Could not get the current session");
				return false;
			}
		} else {
			logger.info("SessionFactory is null");
			return false;
		}

	}

	/**
	 * @returns customer id
	 */
	public int getCustomerId() {
		return cust_id;
	}

}
