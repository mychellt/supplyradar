package br.com.supplyradar.persistence.mapper;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import br.com.supplyradar.domain.commons.Cnpj;
import br.com.supplyradar.domain.commons.PessoaFisica;
import br.com.supplyradar.domain.commons.PessoaJuridica;
import br.com.supplyradar.persistence.AbstractPersistenceTest;
import br.com.supplyradar.persistence.model.commons.PessoaFisicaEntity;
import br.com.supplyradar.persistence.model.commons.PessoaJuridicaEntity;
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

@SpringBootTest(classes = {PessoaEntityMapperImpl.class, EmailEntityMapperImpl.class, CNPJEntityMapperImpl.class})
class PessoaEntityMapperTest extends AbstractMapperTest{
    @Autowired
    private PessoaEntityMapper mapper;

    @DisplayName(value = "Deve ser capaz de mapear os dados de Entity para Domain")
    @Test
    void mapFromEntity() {
        PessoaFisicaEntity pessoaFisicaEntity = Fixture.from(PessoaFisicaEntity.class).gimme("valido");
        PessoaFisica pessoaFisica = mapper.mapFrom(pessoaFisicaEntity);
        assertThat(pessoaFisica, notNullValue());
        assertThat(pessoaFisica.getId(), notNullValue());
        assertEquals(pessoaFisica.getNome(), pessoaFisicaEntity.getNome());
        assertEquals(pessoaFisica.getTelefone(), pessoaFisicaEntity.getTelefone());
        assertEquals(pessoaFisica.getCpfPassaporte(), pessoaFisicaEntity.getCpfPassaporte());
        assertEquals(pessoaFisica.isPassaporte(), pessoaFisicaEntity.isPassaporte());
        assertEquals(pessoaFisica.isAtivo(), pessoaFisicaEntity.isAtivo());
        assertEquals(pessoaFisica.getDateOfChange(), pessoaFisicaEntity.getDateOfChange());
        assertEquals(pessoaFisica.getDateOfCreate(), pessoaFisicaEntity.getDateOfCreate());

        PessoaJuridicaEntity pessoaJuridicaEntity = Fixture.from(PessoaJuridicaEntity.class).gimme("valido");
        PessoaJuridica pessoaJuridica = mapper.mapFrom(pessoaJuridicaEntity);
        assertThat(pessoaJuridica, notNullValue());
        assertThat(pessoaJuridica.getId(), notNullValue());
        assertEquals(pessoaJuridica.getCnpj().getNumber(), pessoaJuridicaEntity.getCnpj());
        assertEquals(pessoaJuridica.getNomeFantasia(), pessoaJuridicaEntity.getNomeFantasia());
        assertEquals(pessoaJuridica.getWebsite(), pessoaJuridicaEntity.getWebsite());
        assertEquals(pessoaJuridica.getRazaoSocial(), pessoaJuridicaEntity.getRazaoSocial());
        assertEquals(pessoaJuridica.getInscricaoEstadual(), pessoaJuridicaEntity.getInscricaoEstadual());
        assertEquals(pessoaJuridica.getTelefone(), pessoaJuridicaEntity.getTelefone());
        assertEquals(pessoaJuridica.isAtivo(), pessoaJuridicaEntity.isAtivo());
        assertEquals(pessoaJuridica.getDateOfChange(), pessoaJuridicaEntity.getDateOfChange());
        assertEquals(pessoaJuridica.getDateOfCreate(), pessoaJuridicaEntity.getDateOfCreate());
    }

    @DisplayName(value = "Deve ser capaz de mapear os dados de Domain para Entity")
    @Test
    void mapFromDomain() {
        PessoaFisica pessoaFisica = Fixture.from(PessoaFisica.class).gimme("valido");
        PessoaFisicaEntity pessoaFisicaEntity = mapper.mapFrom(pessoaFisica);
        assertThat(pessoaFisicaEntity, notNullValue());
        assertEquals(pessoaFisicaEntity.getNome(), pessoaFisica.getNome());
        assertEquals(pessoaFisicaEntity.getTelefone(), pessoaFisica.getTelefone());
        assertEquals(pessoaFisicaEntity.getCpfPassaporte(), pessoaFisica.getCpfPassaporte());
        assertEquals(pessoaFisicaEntity.isPassaporte(), pessoaFisica.isPassaporte());
        assertEquals(pessoaFisicaEntity.isAtivo(), pessoaFisica.isAtivo());
        assertEquals(pessoaFisicaEntity.getDateOfChange(), pessoaFisica.getDateOfChange());
        assertEquals(pessoaFisicaEntity.getDateOfCreate(), pessoaFisica.getDateOfCreate());

        PessoaJuridica pessoaJuridica = Fixture.from(PessoaJuridica.class).gimme("valido");
        PessoaJuridicaEntity pessoaJuridicaEntity = mapper.mapFrom(pessoaJuridica);
        assertThat(pessoaJuridicaEntity, notNullValue());
        assertEquals(pessoaJuridicaEntity.getTelefone(), pessoaJuridica.getTelefone());
        assertEquals(pessoaJuridicaEntity.isAtivo(), pessoaJuridica.isAtivo());
        assertEquals(pessoaJuridicaEntity.getCnpj(), pessoaJuridica.getCnpj().getNumber());
        assertEquals(pessoaJuridicaEntity.getNomeFantasia(), pessoaJuridica.getNomeFantasia());
        assertEquals(pessoaJuridicaEntity.getWebsite(), pessoaJuridica.getWebsite());
        assertEquals(pessoaJuridicaEntity.getRazaoSocial(), pessoaJuridica.getRazaoSocial());
        assertEquals(pessoaJuridicaEntity.getInscricaoEstadual(), pessoaJuridica.getInscricaoEstadual());
        assertEquals(pessoaJuridicaEntity.getDateOfChange(), pessoaJuridica.getDateOfChange());
        assertEquals(pessoaJuridicaEntity.getDateOfCreate(), pessoaJuridica.getDateOfCreate());
    }
}
