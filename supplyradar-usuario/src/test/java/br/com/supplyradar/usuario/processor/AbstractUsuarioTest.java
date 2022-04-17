package br.com.supplyradar.usuario.processor;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.jupiter.api.BeforeAll;

public abstract class AbstractUsuarioTest {
    @BeforeAll
    protected static void before() {
        FixtureFactoryLoader.loadTemplates("br.com.supplyradar.usuario.processor.six2six.fixture.templates");
        FixtureFactoryLoader.loadTemplates("br.com.supplyradar.six2six.fixture.templates.domain.commons");
    }
}
