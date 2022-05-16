package br.com.supplyradar.persistence.adapter;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.ObjectFactory;
import br.com.supplyradar.core.persistence.OfertaRepository;
import br.com.supplyradar.core.persistence.PessoaRepository;
import br.com.supplyradar.domain.assinatura.Oferta;
import br.com.supplyradar.domain.commons.Pessoa;
import br.com.supplyradar.domain.commons.PessoaJuridica;
import br.com.supplyradar.persistence.AbstractPersistenceTest;
import br.com.supplyradar.persistence.model.commons.PessoaJuridicaEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OfertaRepositoryAdapterTest extends AbstractPersistenceTest {
    @Autowired
    private OfertaRepository ofertaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;


    @DisplayName(value = "Deve ser capaz de persistir ofertas.")
    @Test
    void save() {
        final Oferta oferta = Fixture.from(Oferta.class).gimme("valido");
        final Pessoa pessoa = Fixture.from(PessoaJuridica.class).gimme("valido");

        oferta.setPessoa(pessoaRepository.save(pessoa));

        final Oferta ofertaPersistida = ofertaRepository.save(oferta);
        assertThat(ofertaPersistida, notNullValue());
        assertThat(ofertaPersistida.getId(), notNullValue());
        

        final Oferta ofertaRecuperada = ofertaRepository.findById(ofertaPersistida.getId());
        assertThat(ofertaRecuperada, notNullValue());
        assertThat(ofertaRecuperada.getId(), notNullValue());
        assertThat(ofertaRecuperada.getPessoa(), notNullValue());
        assertThat(ofertaRecuperada.getTipoAssinatura(), notNullValue());
        assertThat(ofertaRecuperada.getTipoCategoria(), notNullValue());
        assertThat(ofertaRecuperada.getValidade(), notNullValue());
        assertThat(ofertaRecuperada.getValor(), notNullValue());
        assertThat(ofertaRecuperada.getTaxa(), notNullValue());

        assertEquals(ofertaRecuperada.getTipoAssinatura(), oferta.getTipoAssinatura());
        assertEquals(ofertaRecuperada.getTipoCategoria(), oferta.getTipoCategoria());
        assertEquals(ofertaRecuperada.getValidade(), oferta.getValidade());
        assertEquals(ofertaRecuperada.getValor(), oferta.getValor());
        assertEquals(ofertaRecuperada.getTaxa(), oferta.getTaxa());

        assertThat(ofertaRecuperada.getPessoa(), notNullValue());
        assertThat(ofertaRecuperada.getPessoa().getId(), notNullValue());
        assertEquals(ofertaRecuperada.getPessoa().getEmail().getAddress(), oferta.getPessoa().getEmail().getAddress());
        assertEquals(ofertaRecuperada.getPessoa().getTelefone(), oferta.getPessoa().getTelefone());
        assertEquals(ofertaRecuperada.getPessoa().getTipo(), oferta.getPessoa().getTipo());
        assertEquals(((PessoaJuridica)ofertaRecuperada.getPessoa()).getInscricaoEstadual(), ((PessoaJuridica)oferta.getPessoa()).getInscricaoEstadual());
        assertEquals(((PessoaJuridica)ofertaRecuperada.getPessoa()).getRazaoSocial(), ((PessoaJuridica)oferta.getPessoa()).getRazaoSocial());
        assertEquals(((PessoaJuridica)ofertaRecuperada.getPessoa()).getCnpj().getNumber(), ((PessoaJuridica)oferta.getPessoa()).getCnpj().getNumber());
        assertEquals(((PessoaJuridica)ofertaRecuperada.getPessoa()).getNomeFantasia(), ((PessoaJuridica)oferta.getPessoa()).getNomeFantasia());
    }

}
