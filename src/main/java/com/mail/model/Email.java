package com.mail.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Email {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String to1;
	private String subject;
	private String message;
	
	public Long getId() {
		return id;
	}
	
	public String getTo() {
		return to1;
	}
	public void setTo(String to1) {
		this.to1 = to1;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Email [id=" + id + ", to1=" + to1 + ", subject=" + subject + ", message=" + message + "]";
	}
	
}
