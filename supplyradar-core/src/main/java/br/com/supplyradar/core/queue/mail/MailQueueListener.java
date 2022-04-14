package br.com.supplyradar.core.queue.mail;

import br.com.supplyradar.domain.mail.MailMessage;

public interface MailQueueListener {
	void push(final MailMessage message);
}
