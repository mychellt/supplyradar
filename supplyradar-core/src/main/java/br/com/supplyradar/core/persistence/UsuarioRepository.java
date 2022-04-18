package br.com.supplyradar.core.persistence;

import br.com.supplyradar.domain.commons.TokenSolicitacaoAcesso;
import br.com.supplyradar.domain.commons.Usuario;

public interface UsuarioRepository {
    Usuario save(final Usuario usuario);
    Usuario findByLogin(final String login);
    Usuario findByTokenSolicitacaoAcesso(final TokenSolicitacaoAcesso tokenSolicitacaoAcesso);
    void autorizar(final Usuario usuario);
}
