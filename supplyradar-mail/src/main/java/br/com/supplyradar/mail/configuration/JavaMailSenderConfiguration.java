package br.com.supplyradar.mail.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource(
		value = {"classpath:/javamail-sender.properties", "classpath:/application.properties"},
		ignoreResourceNotFound = true)
@ComponentScan("br.com.supplyradar.mail")
public class JavaMailSenderConfiguration {

}
