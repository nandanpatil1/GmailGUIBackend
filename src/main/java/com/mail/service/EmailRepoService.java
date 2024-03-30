package com.mail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mail.model.Email;
import com.mail.repository.EmailRepo;

@Service
public class EmailRepoService {

	@Autowired
	private EmailRepo emailRepo;

	public void saveEmail(Email email) {
		emailRepo.save(email);
	}

	public List<Email> getAllHistories() {
		List<Email> list = emailRepo.findAll();
		return list;
	}
	
	public void delete(Long id) {
		emailRepo.deleteById(id);
	}

}
