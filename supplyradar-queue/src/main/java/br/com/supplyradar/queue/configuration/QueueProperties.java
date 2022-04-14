package br.com.supplyradar.queue.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Validated
@ConfigurationProperties("spring.activemq")
public class QueueProperties {
    @NotNull
    private String brokerUrl;

    @NotNull
    private String user;

    @NotNull
    private String password;
}
