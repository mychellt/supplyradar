package br.com.supplyradar.persistence.adapter;

import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.core.persistence.UsinaRepository;
import br.com.supplyradar.domain.commons.PessoaJuridica;
import br.com.supplyradar.domain.commons.Usina;
import br.com.supplyradar.persistence.AbstractPersistenceTest;
import br.com.supplyradar.persistence.model.commons.PessoaJuridicaEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UsinaRepositoryAdapterTest extends AbstractPersistenceTest {
    @Autowired
    private UsinaRepository usinaRepository;

    @DisplayName(value = "Deve realizar a persistência de usina")
    @Test
    void save() {
        final Usina usina = Fixture.from(Usina.class).gimme("valido");
        final Usina usinaPersistida = usinaRepository.save(usina);
        assertThat(usinaPersistida, notNullValue());
        assertThat(usinaPersistida.getId(), notNullValue());
        assertThat(usinaPersistida.getPessoa(), notNullValue());
        assertThat(usinaPersistida.getSituacao(), notNullValue());
        assertThat(usinaPersistida.getNome(), emptyOrNullString());
        assertThat(usinaPersistida.getWebsite(), emptyOrNullString());
        assertThat(usinaPersistida.getSituacao(), notNullValue());
        assertThat(usinaPersistida.getPessoa().getId(), notNullValue());
        assertEquals(usinaPersistida.getNome(), usina.getNome());
        assertEquals(usinaPersistida.getWebsite(), usina.getWebsite());
        assertEquals(usinaPersistida.getTipo(), usina.getTipo());
        assertEquals(usinaPersistida.getSituacao(), usina.getSituacao());
        assertEquals(usinaPersistida.getPessoa().getEmail().getAddress(), usina.getPessoa().getEmail().getAddress());
        assertEquals(usinaPersistida.getPessoa().getTelefone(), usina.getPessoa().getTelefone());
        assertEquals(usinaPersistida.getPessoa().getTipo(), usina.getPessoa().getTipo());
        assertEquals(((PessoaJuridica)usinaPersistida.getPessoa()).getInscricaoEstadual(), ((PessoaJuridica)usina.getPessoa()).getInscricaoEstadual());
        assertEquals(((PessoaJuridica)usinaPersistida.getPessoa()).getRazaoSocial(), ((PessoaJuridica)usina.getPessoa()).getRazaoSocial());
        assertEquals(((PessoaJuridica)usinaPersistida.getPessoa()).getCnpj().getNumber(), ((PessoaJuridica)usina.getPessoa()).getCnpj().getNumber());
        assertEquals(((PessoaJuridica)usinaPersistida.getPessoa()).getNomeFantasia(), ((PessoaJuridica)usina.getPessoa()).getNomeFantasia());
    }
}
