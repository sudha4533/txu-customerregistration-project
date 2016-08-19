package com.txu.registrationapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.txu.registrationapp.dao.CustomerRegisterDAO;
import com.txu.registrationapp.model.Customer;
import com.txu.webserviceclients.rest.RestClient;

/**
 * @author Sudha Gunamgari
 */

/**
 * Saves customer details, adds service plan to the customer and sends back the registration details along with utility plan attached.
 */
@Service
public class CustomerRegisterService {

	@Autowired
	private ServicePlanProvider servicePlan;

	private CustomerRegisterDAO customerDAO;

	/**
	 * @param customerDAO
	 */
	public void setCustomerDAO(CustomerRegisterDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	/**
	 * @param customer
	 * @returns true when customer is registered
	 */
	@Transactional
	public boolean addCustomer(Customer customer) {

		if (customerDAO.addCustomer(customer)) {
			if (servicePlan.addServicePlan(customer)) {
				return true;
			}
		}
		return false;

	}

	/**
	 * Rest call is made to Service provider application
	 * @returns customer details 
	 */
	public Customer getCustomerDetails() {

		Customer customer = new Customer();

		customer = RestClient.getCustomerById(customerDAO.getCustomerId());

		return customer;

	}

}
