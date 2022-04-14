package br.com.supplyradar.core.mail;

import br.com.supplyradar.domain.mail.MailMessage;

public interface MailSender {
	void sendMessage(final MailMessage message);
	void sendMessages(final MailMessage... messages);
}
