package com.txu.webserviceclients.soapservice;

import java.util.List;

import com.txu.registrationapp.model.ServicePlan;

public interface SoapClient {

	public List<ServicePlan> getServicePlans();
}
