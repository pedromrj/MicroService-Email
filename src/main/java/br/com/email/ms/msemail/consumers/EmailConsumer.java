package br.com.email.ms.msemail.consumers;

import br.com.email.ms.msemail.dto.EmailDTO;
import br.com.email.ms.msemail.entity.EmailModel;
import br.com.email.ms.msemail.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    private final EmailService service;

    @Autowired
    public EmailConsumer(EmailService service) {
        this.service = service;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDTO email) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(email, emailModel);
        service.sendEmail(emailModel);
    }

}
