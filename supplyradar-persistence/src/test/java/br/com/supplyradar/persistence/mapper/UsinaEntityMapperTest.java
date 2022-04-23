package br.com.supplyradar.persistence.mapper;


import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.domain.commons.PessoaJuridica;
import br.com.supplyradar.domain.commons.Usina;
import br.com.supplyradar.persistence.mapper.factory.*;
import br.com.supplyradar.persistence.model.commons.PessoaJuridicaEntity;
import br.com.supplyradar.persistence.model.commons.UsinaEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {
        UsinaEntityMapperImpl.class,
        PessoaJuridicaFactory.class,
        PessoaJuricaEntityFactory.class,
        ContratoUsinaEntityFactory.class,
        ContratoUsinaFactory.class,
        EmailEntityMapperImpl.class,
        CycleAvoidingMappingJpaContext.class
})
class UsinaEntityMapperTest extends AbstractMapperTest {
    @Autowired
    private UsinaEntityMapper usinaEntityMapper;

    @DisplayName(value = "Deve realizar o map de Domain para Entity")
    @Test
    void fromDomain() {
        final Usina usina = Fixture.from(Usina.class).gimme("valido");
        final UsinaEntity usinaEntity = usinaEntityMapper.mapFrom(usina);
        assertThat(usinaEntity, notNullValue());
        assertThat(usinaEntity.getPessoa(), notNullValue());
        assertThat(usinaEntity.getTipo(), notNullValue());
        assertThat(usinaEntity.getSituacao(), notNullValue());
        assertThat(usinaEntity.getNome(), emptyOrNullString());
        assertThat(usinaEntity.getWebsite(), emptyOrNullString());
        assertEquals(usinaEntity.getTipo(), usina.getTipo());
        assertEquals(usinaEntity.getSituacao(), usina.getSituacao());
        assertEquals(usinaEntity.getNome(), usina.getNome());
        assertEquals(usinaEntity.getWebsite(), usina.getWebsite());
        assertEquals(usinaEntity.getNome(), usina.getNome());
        assertEquals(usinaEntity.getPessoa().getEmail(), usina.getPessoa().getEmail().getAddress());
        assertEquals(usinaEntity.getPessoa().getTelefone(), usina.getPessoa().getTelefone());
        assertEquals(usinaEntity.getPessoa().getTipo(), usina.getPessoa().getTipo());
        assertEquals(((PessoaJuridicaEntity)usinaEntity.getPessoa()).getInscricaoEstadual(), ((PessoaJuridica)usina.getPessoa()).getInscricaoEstadual());
        assertEquals(((PessoaJuridicaEntity)usinaEntity.getPessoa()).getRazaoSocial(), ((PessoaJuridica)usina.getPessoa()).getRazaoSocial());
        assertEquals(((PessoaJuridicaEntity)usinaEntity.getPessoa()).getCnpj(), ((PessoaJuridica)usina.getPessoa()).getCnpj().getNumber());
        assertEquals(((PessoaJuridicaEntity)usinaEntity.getPessoa()).getNomeFantasia(), ((PessoaJuridica)usina.getPessoa()).getNomeFantasia());
    }

    @DisplayName(value = "Deve realizar o map de Entity para Domain")
    @Test
    void fromEntity() {
        final UsinaEntity usinaEntity = Fixture.from(UsinaEntity.class).gimme("valido");
        final Usina usina = usinaEntityMapper.mapFrom(usinaEntity);
        assertThat(usina, notNullValue());
        assertThat(usina.getPessoa(), notNullValue());
        assertThat(usina.getTipo(), notNullValue());
        assertThat(usina.getSituacao(), notNullValue());
        assertThat(usina.getNome(), emptyOrNullString());
        assertThat(usina.getWebsite(), emptyOrNullString());
        assertEquals(usina.getTipo(), usinaEntity.getTipo());
        assertEquals(usina.getSituacao(), usinaEntity.getSituacao());
        assertEquals(usina.getNome(), usinaEntity.getNome());
        assertEquals(usina.getWebsite(), usinaEntity.getWebsite());
        assertEquals(usina.getNome(), usinaEntity.getNome());
        assertEquals(usina.getPessoa().getEmail().getAddress(), usinaEntity.getPessoa().getEmail());
        assertEquals(usina.getPessoa().getTelefone(), usinaEntity.getPessoa().getTelefone());
        assertEquals(usina.getPessoa().getTipo(), usinaEntity.getPessoa().getTipo());
        assertEquals(((PessoaJuridica)usina.getPessoa()).getInscricaoEstadual(), ((PessoaJuridicaEntity)usinaEntity.getPessoa()).getInscricaoEstadual());
        assertEquals(((PessoaJuridica)usina.getPessoa()).getRazaoSocial(), ((PessoaJuridicaEntity)usinaEntity.getPessoa()).getRazaoSocial());
        assertEquals(((PessoaJuridica)usina.getPessoa()).getCnpj().getNumber(), ((PessoaJuridicaEntity)usinaEntity.getPessoa()).getCnpj());
        assertEquals(((PessoaJuridica)usina.getPessoa()).getNomeFantasia(), ((PessoaJuridicaEntity)usinaEntity.getPessoa()).getNomeFantasia());
    }
}
