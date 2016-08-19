package com.txu.registrationapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.txu.registrationapp.dao.CustomerRegisterDAO;
import com.txu.registrationapp.model.Customer;
import com.txu.registrationapp.soapservice.ServicePlan;
import com.txu.webserviceclients.jms.MessageSender;
import com.txu.webserviceclients.soap.client.SoapClient;

/**
 * @author Sudha Gunamgari
 */

/**
 * Assigns the service plan to the customer
 */
public class ServicePlanProvider {

	@Autowired
	MessageSender msgSender;
	
	@Autowired
	CustomerRegisterDAO customerDAO;
	
	/**
	 * Soap call to get the service plans from the Service provider Application
	 * then sending the cust_id, Service_id to the JMS receiver service.
	 * @param customer
	 * @returns true when service plan is assigned to the customer
	 */
	public boolean addServicePlan(Customer customer) {

		List<ServicePlan> serviceplans = null;

		try {

			serviceplans = new SoapClient().getServices();

			if (serviceplans != null && serviceplans.size() >= 0) {
				
				ServicePlan plan = serviceplans.get(0);
				int service_id = plan.getServiceId();

				String msg = service_id + ":" + customerDAO.getCustomerId();

				msgSender.sendMessage(msg);

				return true;
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	
}
