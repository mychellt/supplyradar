package br.com.supplyradar.persistence.configuration;

import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Configuration
@Profile({"homolog", "prod"})
@EnableConfigurationProperties(DataSourceConfiguration.DataSourcePoolProperties.class)
public class DataSourceConfiguration {

    @Getter
    @Setter
    @Validated
    @ConfigurationProperties("app.postgres.datasource")
    public static class DataSourcePoolProperties extends PoolProperties {

        @NotNull
        private Integer port;

        @NotNull
        private String host;
    }

    @Bean
    public DataSource dataSource(final DataSourcePoolProperties dataSourceProperties) {
        final DataSource dataSource = new DataSource();
        dataSource.setUrl(dataSourceProperties.getUrl());
        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getPassword());
        dataSource.setValidationQuery(dataSourceProperties.getValidationQuery());
        dataSource.setValidationInterval(dataSourceProperties.getValidationInterval());
        dataSource.setTimeBetweenEvictionRunsMillis(dataSourceProperties.getTimeBetweenEvictionRunsMillis());
        dataSource.setMaxActive(dataSourceProperties.getMaxActive());
        dataSource.setMaxIdle(dataSourceProperties.getMaxIdle());
        dataSource.setMinIdle(dataSourceProperties.getMinIdle());
        dataSource.setMaxWait(dataSourceProperties.getMaxWait());
        dataSource.setInitialSize(dataSourceProperties.getInitialSize());
        dataSource.setRemoveAbandonedTimeout(dataSourceProperties.getRemoveAbandonedTimeout());
        dataSource.setMinEvictableIdleTimeMillis(dataSourceProperties.getMinEvictableIdleTimeMillis());
        dataSource.setTestOnBorrow(dataSourceProperties.isTestOnBorrow());
        dataSource.setRemoveAbandoned(dataSourceProperties.isRemoveAbandoned());
        dataSource.setJdbcInterceptors(dataSourceProperties.getJdbcInterceptors());
        return dataSource;
    }
}
