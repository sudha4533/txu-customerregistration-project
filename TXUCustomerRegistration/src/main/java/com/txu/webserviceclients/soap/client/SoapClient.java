package com.txu.webserviceclients.soap.client;

import java.util.ArrayList;
import java.util.List;

import com.txu.registrationapp.soapservice.ServicePlan;
import com.txu.registrationapp.soapservice.UtilityPlanService;
import com.txu.registrationapp.soapservice.UtilityPlanServiceImpl;

public class SoapClient {

	
	public List<ServicePlan> getServices() {

		List<ServicePlan> srlist = new ArrayList<ServicePlan>();

		UtilityPlanServiceImpl soapser = new UtilityPlanServiceImpl();

		UtilityPlanService splport = soapser.getUtilityPlanServiceImplPort();

		srlist = splport.getServicePlans();

		if (srlist != null) {

			return srlist;
		} else
			return srlist;

	}

}
