package com.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.mail.model.Email;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public boolean sendmail(String to1, String subject, String messagee) {
		
		boolean flag = false;
		
		try {
			MimeMessage message= javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message);
			helper.setFrom("naanuyt1@gmail.com");
			helper.setTo(to1);
			helper.setSubject(subject);
			helper.setText(messagee);
			
			javaMailSender.send(message);
			
			flag=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
}

