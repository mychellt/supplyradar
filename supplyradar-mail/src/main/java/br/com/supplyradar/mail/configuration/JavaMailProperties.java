package br.com.supplyradar.mail.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = "spring.mail")
public class JavaMailProperties {
    private String host;
    private int port;
    private String username;
    private String password;
    private boolean smtpStarttlsEnable;
    private boolean smtpStarttlsRequired;
    private boolean smtpAuth;
    private boolean smtpSslEnable;
    private long smtpConnectionTimeout;
    private long smtpWriteTimeout;
}
