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

public class SolicitacaoAcessoRepositoryAdapterTest extends AbstractPersistenceTest {
    @Autowired
    private SolicitacaoAcessoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @DisplayName(value = "Deve realizar a pesistência da solicitação de acesso")
    @Test
    void save() {
        final SolicitacaoAcesso solicitacao = Fixture.from(SolicitacaoAcesso.class).gimme("valido");
        final Usuario usuario = Fixture.from(Usuario.class).gimme("valido");
        final Usuario usuarioPersistido = usuarioRepository.save(usuario);
        solicitacao.setUsuario(usuarioPersistido);

        final SolicitacaoAcesso solicitacaoPersistida = repository.save(solicitacao);
        assertThat(solicitacaoPersistida, notNullValue());
        assertThat(solicitacaoPersistida.getId(), notNullValue());
        assertThat(solicitacaoPersistida.getUsuario(), notNullValue());
        assertThat(solicitacaoPersistida.getUsuario().getId(), notNullValue());
        assertThat(solicitacaoPersistida.getUsuario().getPessoa(), notNullValue());
        assertThat(solicitacaoPersistida.getUsuario().getPessoa().getId(), notNullValue());
        assertThat(solicitacaoPersistida.getUsuario().getPessoa().getId(), notNullValue());
        assertEquals(solicitacaoPersistida.getUsuario().getPessoa().getTipo(), solicitacao.getUsuario().getPessoa().getTipo());
        assertEquals(solicitacaoPersistida.getUsuario().getPessoa().getEmail(), solicitacao.getUsuario().getPessoa().getEmail());
        assertEquals(solicitacaoPersistida.getUsuario().getPessoa().getTelefone(), solicitacao.getUsuario().getPessoa().getTelefone());
        assertThat(solicitacaoPersistida.getUsuario().getPessoa().getDateOfChange(), notNullValue());
        assertThat(solicitacaoPersistida.getUsuario().getPessoa().getDateOfCreate(), notNullValue());
    }
}
