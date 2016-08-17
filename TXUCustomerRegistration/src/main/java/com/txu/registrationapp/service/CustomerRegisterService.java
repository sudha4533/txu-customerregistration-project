package com.txu.registrationapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.txu.registrationapp.dao.CustomerRegisterDAO;
import com.txu.registrationapp.model.Customer;
import com.txu.webserviceclients.rest.RestClient;

@Service
public class CustomerRegisterService {

	@Autowired
	private ServicePlanProvider servicePlan;

	private CustomerRegisterDAO customerDAO;

	public void setCustomerDAO(CustomerRegisterDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Transactional
	public boolean addCustomer(Customer customer) {

		if (customerDAO.addCustomer(customer)) {
			if (servicePlan.addServicePlan(customer)) {
				return true;
			}
		}
		return false;

	}

	public Customer getCustomerDetails() {

		Customer customer = new Customer();

		customer = RestClient.getCustomerById(customerDAO.getCustomerId());

		return customer;

	}

}
