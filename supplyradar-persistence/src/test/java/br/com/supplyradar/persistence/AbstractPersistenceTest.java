package br.com.supplyradar.persistence;


import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import br.com.supplyradar.persistence.configuration.PersistenceConfiguration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@DataJpaTest
@ContextConfiguration(classes = {PersistenceConfiguration.class})
@TestPropertySource(properties = {
        "spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect",
        "spring.jpa.hibernate.ddl-auto=none"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public abstract class AbstractPersistenceTest {
    @BeforeAll
    protected static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.supplyradar.persistence.six2six.fixture.templates");
        FixtureFactoryLoader.loadTemplates("br.com.supplyrdar.six2six.fixture.templates.domain.commons");
    }

}
