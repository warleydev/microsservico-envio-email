package com.warleydev.emails.repositories;

import com.warleydev.emails.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
