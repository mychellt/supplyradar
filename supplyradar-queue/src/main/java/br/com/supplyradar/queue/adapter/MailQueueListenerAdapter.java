package br.com.supplyradar.queue.adapter;

import br.com.supplyradar.core.queue.mail.MailQueueListener;
import br.com.supplyradar.core.queue.mail.MailSender;
import br.com.supplyradar.domain.mail.MailMessage;
import lombok.AllArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class MailQueueListenerAdapter implements MailQueueListener {

    private final MailSender mailSender;

    @JmsListener(destination = "mailQueue", containerFactory = "connectionFactory")
    @Override
    public void push(final MailMessage message) {
        mailSender.sendMessage(message);
    }
}
