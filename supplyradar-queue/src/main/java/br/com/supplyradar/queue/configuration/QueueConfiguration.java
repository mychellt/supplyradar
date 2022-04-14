package br.com.supplyradar.queue.configuration;

import lombok.RequiredArgsConstructor;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@RequiredArgsConstructor
@EnableJms
@Configuration
@EnableConfigurationProperties(value = QueueProperties.class)
public class QueueConfiguration {

    private final QueueProperties queueProperties;
    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        if ("".equals(queueProperties.getUser())) {
            return new ActiveMQConnectionFactory(queueProperties.getBrokerUrl());
        }
        return new ActiveMQConnectionFactory(queueProperties.getUser(), queueProperties.getPassword(), queueProperties.getBrokerUrl());
    }

    @Bean
    public JmsListenerContainerFactory<?> jmsFactoryTopic(ConnectionFactory connectionFactory,
                                                       DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setPubSubDomain(true);
        factory.setClientId("producer");
        factory.setSubscriptionDurable(true);
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplateTopic() {
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
        jmsTemplate.setPubSubDomain(true);
        return jmsTemplate;
    }

}
