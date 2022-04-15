package br.com.supplyradar.persistence.mapper;

import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.domain.commons.Cidade;
import br.com.supplyradar.domain.commons.Permissao;
import br.com.supplyradar.persistence.AbstractPersistenceTest;
import br.com.supplyradar.persistence.model.commons.CidadeEntity;
import br.com.supplyradar.persistence.model.commons.PermissaoEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CidadeEntityMapperTest extends AbstractPersistenceTest {
    @Autowired
    private CidadeEntityMapper mapper;

    @DisplayName(value = "Deve ser capaz de mapear os dados de Entity para Domain")
    @Test
    void mapFromEntity() {
        CidadeEntity cidadeEntity = Fixture.from(CidadeEntity.class).gimme("valido");
        Cidade cidade = mapper.mapFrom(cidadeEntity);
        assertThat(cidade, notNullValue());
        assertThat(cidade.getId(), notNullValue());
        assertThat(cidade.getUnidadeFederativa(), notNullValue());
        assertThat(cidade.getUnidadeFederativa().getId(), notNullValue());
        assertEquals(cidade.getUnidadeFederativa().getNome(), cidadeEntity.getUnidadeFederativa().getNome());
        assertEquals(cidade.getUnidadeFederativa().getSigla(), cidadeEntity.getUnidadeFederativa().getSigla());
        assertEquals(cidade.getUnidadeFederativa().getDateOfChange(), cidadeEntity.getUnidadeFederativa().getDateOfChange());
        assertEquals(cidade.getUnidadeFederativa().getDateOfCreate(), cidadeEntity.getUnidadeFederativa().getDateOfCreate());
        assertEquals(cidade.getUnidadeFederativa().getId(), cidadeEntity.getUnidadeFederativa().getId());
        assertEquals(cidade.getNome(), cidadeEntity.getNome());
        assertEquals(cidade.isAtivo(), cidadeEntity.isAtivo());
        assertEquals(cidade.getDateOfChange(), cidadeEntity.getDateOfChange());
        assertEquals(cidade.getDateOfCreate(), cidadeEntity.getDateOfCreate());
    }

    @DisplayName(value = "Deve ser capaz de mapear os dados de Domain para Entity")
    @Test
    void mapFromDomain() {
        Cidade cidade = Fixture.from(Cidade.class).gimme("valido");
        CidadeEntity cidadeEntity = mapper.mapFrom(cidade);
        assertThat(cidadeEntity, notNullValue());
        assertThat(cidadeEntity.getId(), notNullValue());
        assertThat(cidadeEntity.getUnidadeFederativa(), notNullValue());
        assertThat(cidadeEntity.getUnidadeFederativa().getId(), notNullValue());
        assertEquals(cidadeEntity.getUnidadeFederativa().getNome(), cidade.getUnidadeFederativa().getNome());
        assertEquals(cidadeEntity.getUnidadeFederativa().getSigla(), cidade.getUnidadeFederativa().getSigla());
        assertEquals(cidadeEntity.getUnidadeFederativa().getDateOfChange(), cidade.getUnidadeFederativa().getDateOfChange());
        assertEquals(cidadeEntity.getUnidadeFederativa().getDateOfCreate(), cidade.getUnidadeFederativa().getDateOfCreate());
        assertEquals(cidadeEntity.getUnidadeFederativa().getId(), cidade.getUnidadeFederativa().getId());
        assertEquals(cidadeEntity.getNome(), cidade.getNome());
        assertEquals(cidadeEntity.isAtivo(), cidade.isAtivo());
        assertEquals(cidadeEntity.getDateOfChange(), cidade.getDateOfChange());
        assertEquals(cidadeEntity.getDateOfCreate(), cidade.getDateOfCreate());
    }
}
