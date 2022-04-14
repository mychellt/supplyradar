package br.com.supplyradar.domain.mail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MailMessage {

	private String from;

	private String replyTo;

	private String to;

	private String subject;

	private String content;

	private MailMessageType type;

	private String template;

	private Map<String, Object> properties;

	public boolean isTemplateBased() {
		return (MailMessageType.TEMPLATE.equals(type));
	}

	public boolean isHtml() {
		return (MailMessageType.HTML.equals(type));
	}

	public boolean isText() {
		return (MailMessageType.TEXT.equals(type));
	}

	public boolean isContainsAttachments(){
		return Objects.nonNull(this.properties) && properties.containsKey(MailProperties.ATTACHMENTS.name());
	}
}
