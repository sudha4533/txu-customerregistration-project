package com.txu.webserviceclients.rest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.txu.registrationapp.model.Customer;

public class TestRestclient {

	Customer customer = new Customer();
	
	
	Restclient restclient;
	
	@Before
	public void setUp() {

		restclient = mock(Restclient.class);
		customer.setFirstname("sudha");
		customer.setId(1);
		customer.setLastname("gunamgari");
		customer.setPhone("3132125851");
		customer.setEmail("sudha@gmail.com");
	} 
	
	@Test
	public void testgetCustomerById() {
		
		
		
		when(restclient.getCustomerById(1)).thenReturn(customer);
		
		
		assertEquals(customer, restclient.getCustomerById(1));
	}
}
