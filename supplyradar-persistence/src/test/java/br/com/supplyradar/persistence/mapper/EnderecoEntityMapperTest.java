package br.com.supplyradar.persistence.mapper;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import br.com.supplyradar.domain.commons.Endereco;
import br.com.supplyradar.persistence.mapper.factory.PessoaFisicaEntityFactory;
import br.com.supplyradar.persistence.mapper.factory.PessoaFactory;
import br.com.supplyradar.persistence.mapper.factory.PessoaJuricaEntityFactory;
import br.com.supplyradar.persistence.mapper.factory.PessoaJuridicaFactory;
import br.com.supplyradar.persistence.model.commons.EnderecoEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({MockitoExtension.class})
@SpringBootTest(classes = {
        PessoaFactory.class,
        EnderecoEntityMapperImpl.class,
        PessoaJuridicaFactory.class,
        PessoaJuricaEntityFactory.class,
        EmailEntityMapperImpl.class
})
class EnderecoEntityMapperTest  {
    @Autowired
    private EnderecoEntityMapper mapper;

    private CycleAvoidingMappingJpaContext context;

    @BeforeAll
    protected static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.supplyradar.persistence.six2six.fixture.templates");
        FixtureFactoryLoader.loadTemplates("br.com.supplyradar.six2six.fixture.templates.domain.commons");
    }

    @BeforeEach
    public void beforeEach() {
        context = new CycleAvoidingMappingJpaContext();
    }

    @DisplayName(value = "Deve ser capaz de mapear os dados de Entity para Domain")
    @Test
    void mapFromEntity() {
        EnderecoEntity enderecoEntity = Fixture.from(EnderecoEntity.class).gimme("valido");
        Endereco endereco = mapper.mapFrom(enderecoEntity, context);
        assertThat(endereco, notNullValue());
        assertEquals(endereco.isAtivo(), enderecoEntity.isAtivo());
        assertEquals(endereco.getDateOfChange(), enderecoEntity.getDateOfChange());
        assertEquals(endereco.getDateOfCreate(), enderecoEntity.getDateOfCreate());
    }

    @DisplayName(value = "Deve ser capaz de mapear os dados de Domain para Entity")
    @Test
    void mapFromDomain() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("valido");
        EnderecoEntity enderecoEntity = mapper.mapFrom(endereco, context);
        assertThat(enderecoEntity, notNullValue());
        assertEquals(enderecoEntity.isAtivo(), endereco.isAtivo());
        assertEquals(enderecoEntity.getDateOfChange(), endereco.getDateOfChange());
        assertEquals(enderecoEntity.getDateOfCreate(), endereco.getDateOfCreate());
    }
}
