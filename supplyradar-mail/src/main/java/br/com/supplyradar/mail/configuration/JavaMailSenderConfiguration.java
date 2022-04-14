package br.com.supplyradar.mail.configuration;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.Session;
import java.util.Properties;


@AllArgsConstructor
@Configuration
@PropertySource(
		value = {"classpath:/javamail-sender.properties", "classpath:/application.properties"},
		ignoreResourceNotFound = true)
@ComponentScan("br.com.supplyradar.mail")
@EnableConfigurationProperties(value = JavaMailProperties.class)
public class JavaMailSenderConfiguration {

	private final JavaMailProperties javaMailProperties;

	@Bean
	public JavaMailSender getJavaMailSender() {
		final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setPassword(javaMailProperties.getPassword());
		mailSender.setHost(javaMailProperties.getHost());
		mailSender.setUsername(javaMailProperties.getUsername());
		mailSender.setPort(javaMailProperties.getPort());

		final Properties properties = new Properties();
		properties.setProperty("mail.smtp.starttls.enable", String.valueOf(javaMailProperties.isSmtpStarttlsEnable()));
		properties.setProperty("mail.smtp.ssl.enable", String.valueOf(javaMailProperties.isSmtpSslEnable()));
		final Session session = Session.getInstance(properties);
		mailSender.setSession(session);
		return mailSender;
	}
}
