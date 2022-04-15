package br.com.supplyradar.persistence.adapter;

import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.core.persistence.SolicitacaoAcessoRepository;
import br.com.supplyradar.core.persistence.TokenSolicitacaoAcessoRepository;
import br.com.supplyradar.domain.commons.SolicitacaoAcesso;
import br.com.supplyradar.domain.commons.TokenSolicitacaoAcesso;
import br.com.supplyradar.persistence.AbstractPersistenceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolicitacaoAcessoRepositoryAdapterTest extends AbstractPersistenceTest {
    @Autowired
    private SolicitacaoAcessoRepository repository;

    @DisplayName(value = "Deve realizar a pesistência da solicitação de acesso")
    @Test
    void save() {
        final SolicitacaoAcesso solicitacao = Fixture.from(SolicitacaoAcesso.class).gimme("valido");
        final SolicitacaoAcesso solicitacaoPersistida = repository.save(solicitacao);
        assertThat(solicitacaoPersistida, notNullValue());
        assertThat(solicitacaoPersistida.getId(), notNullValue());
    }
}
