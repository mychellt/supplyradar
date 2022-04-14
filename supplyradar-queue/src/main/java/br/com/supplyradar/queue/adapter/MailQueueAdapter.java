package br.com.supplyradar.queue.adapter;

import br.com.supplyradar.core.queue.mail.MailQueue;
import br.com.supplyradar.domain.mail.MailMessage;
import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class MailQueueAdapter implements MailQueue {
    private final JmsTemplate jmsTemplate;

    @Override
    public void push(MailMessage mailMessage) {
        jmsTemplate.convertAndSend("mailQueue", mailMessage);
    }
}
