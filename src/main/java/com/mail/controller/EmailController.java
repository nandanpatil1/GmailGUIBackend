package com.mail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;


import com.mail.model.Email;
import com.mail.model.EmailResponse;
import com.mail.service.EmailRepoService;
import com.mail.service.EmailService;


@Controller
@CrossOrigin
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private EmailRepoService emailRepoService;

	@GetMapping("/")
	public void index() {
		System.out.println("Hello");
	}
	//localhost:8080/
	
//	@PostMapping("/sendemail")
//	public String sendMail(@ModelAttribute Email email,HttpSession session) {
//		
//	emailService.sendmail(email);
//	session.setAttribute("msg","Email send sucessfuly");
//		return "redirect:/";
//	}
	
	// api to send email
		@RequestMapping(value = "/sendemail" , method = RequestMethod.POST)
		public ResponseEntity<?> sendEmail(@RequestBody Email email)
		{
			boolean result = this.emailService.sendmail(email.getTo(),email.getSubject(),email.getMessage());
			System.out.println(email);
			emailRepoService.saveEmail(email);
			if(result) {
			      return ResponseEntity.ok(new EmailResponse("Email is sent succusfully..."));
			}else {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EmailResponse("Emailnot sended "));
			}
		}
		
		@GetMapping("/emailhistory")
		@ResponseBody
		public List<Email> showHistory() {
			return emailRepoService.getAllHistories();
		}
		
		@DeleteMapping("/deleteemail")
		@ResponseBody
		public void deleteEmail(@RequestParam Long id) {
			emailRepoService.delete(id);
		}
	
}






