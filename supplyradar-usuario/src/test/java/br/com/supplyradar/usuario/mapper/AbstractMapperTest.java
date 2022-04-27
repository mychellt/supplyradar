package br.com.supplyradar.usuario.mapper;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
public abstract class AbstractMapperTest {
    @BeforeAll
    protected static void before() {
        FixtureFactoryLoader.loadTemplates("br.com.supplyradar.usuario.six2six.fixture.templates");
        FixtureFactoryLoader.loadTemplates("br.com.supplyradar.six2six.fixture.templates.domain.commons");
    }
}
