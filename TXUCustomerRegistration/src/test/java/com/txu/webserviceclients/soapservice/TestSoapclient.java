package com.txu.webserviceclients.soapservice;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.txu.registrationapp.model.ServicePlan;

public class TestSoapclient {

	private SoapClient soapCl;
	
	@Before
	public void setUp() {
		soapCl = mock(SoapClient.class);
	} 
	
	@Test
	public void testGetServicePlans() {
		
		
		List<ServicePlan> serviceplans = new ArrayList<ServicePlan>();
		
		ServicePlan service_plan1 = new ServicePlan();
		service_plan1.setService_id(1);
		service_plan1.setPlan_name("TXU plan A");
		service_plan1.setDescription("TXU Energy Saver");
		service_plan1.setEnd_date(null);
		service_plan1.setEnd_date(null);
		
		ServicePlan service_plan2 = new ServicePlan();
		service_plan2.setService_id(1);
		service_plan2.setPlan_name("TXU Plan B");
		service_plan2.setDescription("TXU Market Edge");
		service_plan2.setEnd_date(null);
		service_plan2.setEnd_date(null);
		
		
		serviceplans.add(service_plan1);
		serviceplans.add(service_plan2);
		
		when(soapCl.getServicePlans()).thenReturn(serviceplans);
				
		assertThat(serviceplans, is(soapCl.getServicePlans()));
		assertEquals(serviceplans.size(), soapCl.getServicePlans().size());
	}
}
