package com.example.jwt.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.resource.CreditCardDAO;
import com.example.jwt.service.PaymetProcessor;

@RestController
public class PaymentProcessorController {

	@Autowired
	PaymetProcessor paymentService;
	
	@PostMapping("/process")
	@RolesAllowed("admin")
	public String processCreditCard(CreditCardVO payment) {

		CreditCardDAO creditCardDAO = new CreditCardDAO();
		creditCardDAO.setName(payment.getName());
		creditCardDAO.setNumber(payment.getNumber());
		
		
		paymentService.processPayment(creditCardDAO, payment.getPayment());
		
		//CreditCardDAO cc, double amount
		return "Success";
	}
}
