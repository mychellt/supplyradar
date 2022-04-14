package br.com.supplyradar.core.queue.mail;

import br.com.supplyradar.domain.mail.MailMessage;

public interface MailQueue {
    void push(final MailMessage mailMessage);
}
