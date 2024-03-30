package com.mail.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mail.model.Email;

public interface EmailRepo extends JpaRepository<Email,Long>{

}
