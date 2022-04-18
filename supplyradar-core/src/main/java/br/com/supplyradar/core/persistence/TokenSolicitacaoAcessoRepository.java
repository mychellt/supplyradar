package br.com.supplyradar.core.persistence;

import br.com.supplyradar.domain.commons.TokenSolicitacaoAcesso;

public interface TokenSolicitacaoAcessoRepository {
    TokenSolicitacaoAcesso save(final TokenSolicitacaoAcesso tokenSolicitacaoAcesso);
    TokenSolicitacaoAcesso findByKey(final String key);
}
