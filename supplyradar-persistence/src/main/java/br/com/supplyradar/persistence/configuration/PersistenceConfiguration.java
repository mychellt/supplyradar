package br.com.supplyradar.persistence.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@ComponentScan(basePackages = {"br.com.supplyradar.persistence"})
@EntityScan(basePackages = {"br.com.supplyradar.persistence.model"})
@EnableJpaRepositories(basePackages = {"br.com.supplyradar.persistence.adapter"})
@EnableTransactionManagement
@EnableJpaAuditing
public class PersistenceConfiguration {

}
