package br.com.supplyradar.core.queue.mail;

import br.com.supplyradar.domain.mail.MailMessage;

public interface MailSender {
    void sendMessage(final MailMessage mailMessage);
}
