package br.com.supplyradar.persistence.adapter;

import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.core.persistence.SolicitacaoAcessoRepository;
import br.com.supplyradar.core.persistence.TokenSolicitacaoAcessoRepository;
import br.com.supplyradar.core.persistence.UsuarioRepository;
import br.com.supplyradar.domain.commons.SolicitacaoAcesso;
import br.com.supplyradar.domain.commons.TokenSolicitacaoAcesso;
import br.com.supplyradar.domain.commons.Usuario;
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

    @Autowired
    private SolicitacaoAcessoRepository solicitacaoAcessoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @DisplayName(value = "Deve realizar a pesistência do Token de uma Solicitação de acesso")
    @Test
    void save() {
        final TokenSolicitacaoAcesso token = Fixture.from(TokenSolicitacaoAcesso.class).gimme("valido");
        final TokenSolicitacaoAcesso tokenPersistido = repository.save(token);
        assertThat(tokenPersistido, notNullValue());
        assertThat(tokenPersistido.getId(), notNullValue());
        assertEquals(tokenPersistido.getKey(), token.getKey());
        assertEquals(tokenPersistido.isExpirado(), token.isExpirado());
    }

    @DisplayName(value = "Deve realizar a busca por token de solicitação de acesso pela key.")
    @Test
    void findByKey() {
        final TokenSolicitacaoAcesso token = Fixture.from(TokenSolicitacaoAcesso.class).gimme("valido");
        final SolicitacaoAcesso solicitacaoAcesso = Fixture.from(SolicitacaoAcesso.class).gimme("valido");
        final Usuario usuario = Fixture.from(Usuario.class).gimme("valido");

        Usuario usuarioPersistido = usuarioRepository.save(usuario);

        solicitacaoAcesso.setUsuario(usuarioPersistido);
        SolicitacaoAcesso solicitacaoAcessoPersistida = solicitacaoAcessoRepository.save(solicitacaoAcesso);
        token.setSolicitacao(solicitacaoAcessoPersistida);

        final TokenSolicitacaoAcesso tokenPersistido = repository.save(token);
        assertThat(tokenPersistido, notNullValue());
        assertThat(tokenPersistido.getId(), notNullValue());
        assertEquals(tokenPersistido.getKey(), token.getKey());
        assertEquals(tokenPersistido.isExpirado(), token.isExpirado());

        TokenSolicitacaoAcesso tokenRecuperadoPelaKey = repository.findByKey(tokenPersistido.getKey());
        assertThat(tokenRecuperadoPelaKey, notNullValue());
        assertThat(tokenRecuperadoPelaKey.getId(), notNullValue());
        assertEquals(tokenRecuperadoPelaKey.getKey(), tokenPersistido.getKey());
    }
}
