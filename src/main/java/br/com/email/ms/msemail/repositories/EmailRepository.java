package br.com.email.ms.msemail.repositories;

import br.com.email.ms.msemail.entity.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<EmailModel, UUID> {
}
