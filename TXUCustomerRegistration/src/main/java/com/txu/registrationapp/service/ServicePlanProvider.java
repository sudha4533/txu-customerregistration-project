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

public class ServicePlanProvider {

	@Autowired
	MessageSender msgSender;
	
	@Autowired
	CustomerRegisterDAO customerDAO;
	
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
