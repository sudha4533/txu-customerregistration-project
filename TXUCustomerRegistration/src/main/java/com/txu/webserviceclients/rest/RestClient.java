package com.txu.webserviceclients.rest;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.txu.registrationapp.model.Customer;

public class RestClient {
	
	public static Customer getCustomerById(int id) {
		
		Customer cust = new Customer();
		
		try {

			DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
			defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
			Client client = Client.create(defaultClientConfig);

			WebResource webResource = client
					.resource("http://localhost:8080/TXUCustomerRegistrationServices/restservices/customerById/" + id);

			ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			cust = response.getEntity(Customer.class);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cust;
	}

}