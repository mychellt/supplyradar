package br.com.supplyradar.persistence.mapper;

import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.domain.commons.Endereco;
import br.com.supplyradar.persistence.AbstractPersistenceTest;
import br.com.supplyradar.persistence.model.commons.EnderecoEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EnderecoEntityMapperTest extends AbstractPersistenceTest {
    @Autowired
    private EnderecoEntityMapper mapper;

    @DisplayName(value = "Deve ser capaz de mapear os dados de Entity para Domain")
    @Test
    void mapFromEntity() {
        EnderecoEntity enderecoEntity = Fixture.from(EnderecoEntity.class).gimme("valido");
        Endereco endereco = mapper.mapFrom(enderecoEntity);
        assertThat(endereco, notNullValue());
        assertThat(endereco.getId(), notNullValue());
        assertEquals(endereco.isAtivo(), enderecoEntity.isAtivo());
        assertEquals(endereco.getDateOfChange(), enderecoEntity.getDateOfChange());
        assertEquals(endereco.getDateOfCreate(), enderecoEntity.getDateOfCreate());
    }

    @DisplayName(value = "Deve ser capaz de mapear os dados de Domain para Entity")
    @Test
    void mapFromDomain() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("valido");
        EnderecoEntity enderecoEntity = mapper.mapFrom(endereco);
        assertThat(enderecoEntity, notNullValue());
        assertThat(enderecoEntity.getId(), notNullValue());
        assertEquals(enderecoEntity.isAtivo(), endereco.isAtivo());
        assertEquals(enderecoEntity.getDateOfChange(), endereco.getDateOfChange());
        assertEquals(enderecoEntity.getDateOfCreate(), endereco.getDateOfCreate());
    }
}
