package com.niit.ekartfront.util;

import org.springframework.mail.SimpleMailMessage;

public class SendMail {

	
	public static SimpleMailMessage sendingMail(String recipientAddress, String subject, String message){
		
		  SimpleMailMessage email = new SimpleMailMessage();
	        email.setTo(recipientAddress);
	        email.setSubject(subject);
	        email.setText(message);
	        
		return email;
		
	}
		
}
