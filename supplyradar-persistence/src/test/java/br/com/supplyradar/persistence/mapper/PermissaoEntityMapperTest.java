package br.com.supplyradar.persistence.mapper;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import br.com.supplyradar.domain.commons.Permissao;
import br.com.supplyradar.persistence.AbstractPersistenceTest;
import br.com.supplyradar.persistence.model.commons.PermissaoEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {PermissaoEntityMapperImpl.class})
class PermissaoEntityMapperTest  extends AbstractMapperTest{
    @Autowired
    private PermissaoEntityMapper mapper;

    @BeforeAll
    protected static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.supplyradar.persistence.six2six.fixture.templates");
        FixtureFactoryLoader.loadTemplates("br.com.supplyradar.six2six.fixture.templates.domain.commons");
    }

    @DisplayName(value = "Deve ser capaz de mapear os dados de Entity para Domain")
    @Test
    void mapFromEntity() {
        PermissaoEntity entity = Fixture.from(PermissaoEntity.class).gimme("valido");
        Permissao permissao = mapper.mapFrom(entity);
        assertThat(permissao, notNullValue());
        assertEquals(permissao.getDescricao(), entity.getDescricao());
        assertEquals(permissao.getNome(), entity.getNome());
        assertEquals(permissao.getOrdem(), entity.getOrdem());
        assertEquals(permissao.getSigla(), entity.getSigla());
        assertEquals(permissao.getTipo(), entity.getTipo());
        assertEquals(permissao.getDateOfChange(), entity.getDateOfChange());
        assertEquals(permissao.getDateOfCreate(), entity.getDateOfCreate());
    }

    @DisplayName(value = "Deve ser capaz de mapear os dados de Domain para Entity")
    @Test
    void mapFromDomain() {
        Permissao permissao = Fixture.from(Permissao.class).gimme("valido");
        PermissaoEntity entity = mapper.mapFrom(permissao);
        assertThat(entity, notNullValue());
        assertEquals(entity.getDescricao(), permissao.getDescricao());
        assertEquals(entity.getNome(), permissao.getNome());
        assertEquals(entity.getOrdem(), permissao.getOrdem());
        assertEquals(entity.getSigla(), permissao.getSigla());
        assertEquals(entity.getTipo(), permissao.getTipo());
        assertEquals(entity.getDateOfChange(), permissao.getDateOfChange());
        assertEquals(entity.getDateOfCreate(), permissao.getDateOfCreate());
    }
}
