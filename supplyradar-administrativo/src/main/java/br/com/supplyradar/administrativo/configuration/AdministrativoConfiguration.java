package br.com.supplyradar.administrativo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"br.com.supplyradar.administrativo"})
public class AdministrativoConfiguration implements WebMvcConfigurer {
    @Bean
    public void test() {
        System.out.println();
    }
}
