package com.example.jwt.service;

import org.springframework.stereotype.Service;

import com.example.jwt.resource.CreditCardDAO;

@Service
public class PaymetProcessor {

	public boolean processPayment(CreditCardDAO cc, double amount) {
		
		return true;
		
	}
}
