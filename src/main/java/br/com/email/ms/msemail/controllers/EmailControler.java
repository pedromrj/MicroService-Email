package br.com.email.ms.msemail.controllers;

import br.com.email.ms.msemail.dto.EmailDTO;
import br.com.email.ms.msemail.entity.EmailModel;
import br.com.email.ms.msemail.services.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmailControler {

    private EmailService service;

    @PostMapping("/send-email")
    public ResponseEntity<EmailModel> senddingEmail(@RequestBody @Valid EmailDTO emailDTO) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDTO, emailModel);
        emailModel = service.sendEmail(emailModel);
        return new ResponseEntity<EmailModel>(emailModel, HttpStatus.CREATED);
    }

}
