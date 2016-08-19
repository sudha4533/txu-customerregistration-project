package com.txu.registrationapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.txu.registrationapp.model.Customer;
import com.txu.registrationapp.service.CustomerRegisterService;

@Controller
public class CustomerRegisterController {

	@Autowired
	private CustomerRegisterService customerService;

	/**
	 * @param model
	 * @returns register view page
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String displayForm(ModelMap model) {
	model.put("message", "Register here");
		return "register";
	}

	/**
	 * 
	 * @param customer
	 * @param model
	 * @returns home view page
	 */
	@RequestMapping(value = "/customer/add", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customer") Customer customer, ModelMap model) {

		if (customer != null) {

			if (customerService.addCustomer(customer)) {

				model.put("customer", customerService.getCustomerDetails());
				model.put("message", "Registration successfull");
				return "home";

			} else {
				model.put("message", "Registration failed, Please register again");
				return "register";
			}
		} else {
			model.put("message", "Registration failed, Please register again");
			return "register";

		}
	}

}
