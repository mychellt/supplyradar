package br.com.supplyradar.mail.adapter;

import br.com.supplyradar.core.queue.mail.MailSender;
import br.com.supplyradar.domain.exceptions.mail.MailException;
import br.com.supplyradar.domain.mail.MailAttachment;
import br.com.supplyradar.domain.mail.MailMessage;
import br.com.supplyradar.domain.mail.MailProperties;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.StringUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Slf4j
@Component
public class MailQueueSenderAdapter implements MailSender {
	private final JavaMailSender javaMailSender;
	private final Configuration freemarkerConfiguration;

	@Override
	public void sendMessage(final MailMessage message) {
		final MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		try {
			final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, message.isContainsAttachments());

			helper.setFrom(message.getFrom());

			if (StringUtils.hasText(message.getReplyTo())) {
				helper.setReplyTo(message.getReplyTo());
			}

			helper.setTo(message.getTo());
			helper.setSubject(message.getSubject());

			if (message.isContainsAttachments()) {
				final Map<String, Object> mapProperties = message.getProperties();

				@SuppressWarnings("unchecked") final List<MailAttachment> attachments = (List<MailAttachment>) mapProperties.get(MailProperties.ATTACHMENTS.name());

				for (MailAttachment attachment : attachments) {
					helper.addAttachment(attachment.getName(), new ByteArrayResource(attachment.getFile()), attachment.getType());
				}
			}

			if (message.isTemplateBased()) {
				helper.setText(FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerConfiguration.getTemplate(message.getTemplate()), message.getProperties()), true);
			} else if (message.isHtml()) {
				helper.setText(message.getContent(), true);
			} else {
				helper.setText(message.getContent());
			}
		} catch (MessagingException | IOException | TemplateException e) {
			log.error(e.getMessage(), e.getCause());
			throw new MailException("Erro ao tentar enviar e-mail.");
		}

		javaMailSender.send(mimeMessage);

		log.info("E-mail enviado com sucesso!");
	}
}
