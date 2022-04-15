package br.com.supplyradar.persistence.mapper;

import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.domain.commons.Cidade;
import br.com.supplyradar.domain.commons.UnidadeFederativa;
import br.com.supplyradar.persistence.AbstractPersistenceTest;
import br.com.supplyradar.persistence.model.commons.CidadeEntity;
import br.com.supplyradar.persistence.model.commons.UnidadeFederativaEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UnidadeFederativaEntityMapperTest extends AbstractPersistenceTest {
    @Autowired
    private UnidadeFederativaEntityMapper mapper;

    @DisplayName(value = "Deve ser capaz de mapear os dados de Entity para Domain")
    @Test
    void mapFromEntity() {
        UnidadeFederativaEntity unidadeFederativaEntity = Fixture.from(UnidadeFederativaEntity.class).gimme("valido");
        UnidadeFederativa unidadeFederativa = mapper.mapFrom(unidadeFederativaEntity);
        assertThat(unidadeFederativa, notNullValue());
        assertEquals(unidadeFederativa.getSigla(), unidadeFederativaEntity.getSigla());
        assertEquals(unidadeFederativa.getNome(), unidadeFederativaEntity.getNome());
        assertEquals(unidadeFederativa.isAtivo(), unidadeFederativaEntity.isAtivo());
        assertEquals(unidadeFederativa.getDateOfChange(), unidadeFederativaEntity.getDateOfChange());
        assertEquals(unidadeFederativa.getDateOfCreate(), unidadeFederativaEntity.getDateOfCreate());
    }

    @DisplayName(value = "Deve ser capaz de mapear os dados de Domain para Entity")
    @Test
    void mapFromDomain() {
        UnidadeFederativa unidadeFederativa = Fixture.from(UnidadeFederativa.class).gimme("valido");
        UnidadeFederativaEntity unidadeFederativaEntity = mapper.mapFrom(unidadeFederativa);
        assertThat(unidadeFederativaEntity, notNullValue());
        assertEquals(unidadeFederativaEntity.getSigla(), unidadeFederativa.getSigla());
        assertEquals(unidadeFederativaEntity.getNome(), unidadeFederativa.getNome());
        assertEquals(unidadeFederativaEntity.isAtivo(), unidadeFederativa.isAtivo());
        assertEquals(unidadeFederativaEntity.getDateOfChange(), unidadeFederativa.getDateOfChange());
        assertEquals(unidadeFederativaEntity.getDateOfCreate(), unidadeFederativa.getDateOfCreate());
    }
}
