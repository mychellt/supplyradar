package br.com.supplyradar.persistence.mapper;

import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.domain.assinatura.Oferta;
import br.com.supplyradar.domain.commons.PessoaJuridica;
import br.com.supplyradar.persistence.mapper.factory.PessoaJuricaEntityFactory;
import br.com.supplyradar.persistence.mapper.factory.PessoaJuridicaFactory;
import br.com.supplyradar.persistence.model.assinatura.OfertaEntity;
import br.com.supplyradar.persistence.model.commons.PessoaJuridicaEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {
        OfertaEntityMapperImpl.class,
        PessoaJuricaEntityFactory.class,
        PessoaJuridicaFactory.class,
        EmailEntityMapperImpl.class
})
class OfertaEntityMapperTest extends AbstractMapperTest {

    @Autowired
    private OfertaEntityMapper mapper;

    @DisplayName(value = "Deve realizar o map de Domain para Entity.")
    @Test
    void fromDomain() {
        final Oferta oferta = Fixture.from(Oferta.class).gimme("valido");
        final OfertaEntity ofertaEntity = mapper.mapFrom(oferta);

        assertThat(ofertaEntity, notNullValue());
        assertThat(ofertaEntity.getPessoa(), notNullValue());
        assertThat(ofertaEntity.getTipoAssinatura(), notNullValue());
        assertThat(ofertaEntity.getTipoCategoria(), notNullValue());
        assertThat(ofertaEntity.getValidade(), notNullValue());
        assertThat(ofertaEntity.getValor(), notNullValue());
        assertThat(ofertaEntity.getTaxa(), notNullValue());

        assertEquals(ofertaEntity.getTipoAssinatura(), oferta.getTipoAssinatura());
        assertEquals(ofertaEntity.getTipoCategoria(), oferta.getTipoCategoria());
        assertEquals(ofertaEntity.getValidade(), oferta.getValidade());
        assertEquals(ofertaEntity.getValor(), oferta.getValor());
        assertEquals(ofertaEntity.getTaxa(), oferta.getTaxa());

        assertEquals(ofertaEntity.getPessoa().getEmail(), oferta.getPessoa().getEmail().getAddress());
        assertEquals(ofertaEntity.getPessoa().getTelefone(), oferta.getPessoa().getTelefone());
        assertEquals(ofertaEntity.getPessoa().getTipo(), oferta.getPessoa().getTipo());
        assertEquals(((PessoaJuridicaEntity)ofertaEntity.getPessoa()).getInscricaoEstadual(), ((PessoaJuridica)oferta.getPessoa()).getInscricaoEstadual());
        assertEquals(((PessoaJuridicaEntity)ofertaEntity.getPessoa()).getRazaoSocial(), ((PessoaJuridica)oferta.getPessoa()).getRazaoSocial());
        assertEquals(((PessoaJuridicaEntity)ofertaEntity.getPessoa()).getCnpj(), ((PessoaJuridica)oferta.getPessoa()).getCnpj().getNumber());
        assertEquals(((PessoaJuridicaEntity)ofertaEntity.getPessoa()).getNomeFantasia(), ((PessoaJuridica)oferta.getPessoa()).getNomeFantasia());

    }

    @DisplayName(value = "Deve realizar o map de Entity para Domain.")
    @Test
    void fromEntity() {
        final OfertaEntity ofertaEntity = Fixture.from(OfertaEntity.class).gimme("valido");
        final Oferta oferta = mapper.mapFrom(ofertaEntity);

        assertThat(oferta, notNullValue());
        assertThat(oferta.getPessoa(), notNullValue());
        assertThat(oferta.getTipoAssinatura(), notNullValue());
        assertThat(oferta.getTipoCategoria(), notNullValue());
        assertThat(oferta.getValidade(), notNullValue());
        assertThat(oferta.getValor(), notNullValue());
        assertThat(oferta.getTaxa(), notNullValue());

        assertEquals(oferta.getTipoAssinatura(), ofertaEntity.getTipoAssinatura());
        assertEquals(oferta.getTipoCategoria(), ofertaEntity.getTipoCategoria());
        assertEquals(oferta.getValidade(), ofertaEntity.getValidade());
        assertEquals(oferta.getValor(), ofertaEntity.getValor());
        assertEquals(oferta.getTaxa(), ofertaEntity.getTaxa());

        assertEquals(oferta.getPessoa().getEmail().getAddress(), oferta.getPessoa().getEmail().getAddress());
        assertEquals(oferta.getPessoa().getTelefone(), oferta.getPessoa().getTelefone());
        assertEquals(oferta.getPessoa().getTipo(), oferta.getPessoa().getTipo());
        assertEquals(((PessoaJuridica)oferta.getPessoa()).getInscricaoEstadual(), ((PessoaJuridicaEntity)ofertaEntity.getPessoa()).getInscricaoEstadual());
        assertEquals(((PessoaJuridica)oferta.getPessoa()).getRazaoSocial(), ((PessoaJuridicaEntity)ofertaEntity.getPessoa()).getRazaoSocial());
        assertEquals(((PessoaJuridica)oferta.getPessoa()).getCnpj().getNumber(), ((PessoaJuridicaEntity)ofertaEntity.getPessoa()).getCnpj());
        assertEquals(((PessoaJuridica)oferta.getPessoa()).getNomeFantasia(), ((PessoaJuridicaEntity)ofertaEntity.getPessoa()).getNomeFantasia());
    }
}
