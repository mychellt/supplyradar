package br.com.supplyradar.persistence.adapter;

import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.core.persistence.TokenSolicitacaoAcessoRepository;
import br.com.supplyradar.domain.commons.TokenSolicitacaoAcesso;
import br.com.supplyradar.persistence.AbstractPersistenceTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenSolicitacaoAcessoRepositoryAdapterTest extends AbstractPersistenceTest {
    @Autowired
    private TokenSolicitacaoAcessoRepository repository;

    @DisplayName(value = "Deve realizar a pesistência do Token de uma Solicitação de acesso")
    @Test
    void save() {
        TokenSolicitacaoAcesso token = Fixture.from(TokenSolicitacaoAcesso.class).gimme("valido");
        TokenSolicitacaoAcesso tokenPersistido = repository.save(token);
        assertThat(tokenPersistido, notNullValue());
        assertThat(tokenPersistido.getId(), notNullValue());
        assertEquals(tokenPersistido.getKey(), token.getKey());
        assertEquals(tokenPersistido.isExpirado(), token.isExpirado());
    }
}
