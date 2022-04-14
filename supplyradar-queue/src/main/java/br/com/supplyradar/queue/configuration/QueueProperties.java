package br.com.supplyradar.queue.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
@ConfigurationProperties("spring.activemq")
public class QueueProperties {
    private String brokerUrl;
    private String user;
    private String password;
}
