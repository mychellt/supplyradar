package br.com.supplyradar.core.persistence;

import br.com.supplyradar.domain.commons.SolicitacaoAcesso;

public interface SolicitacaoAcessoRepository {
    SolicitacaoAcesso save(final SolicitacaoAcesso solicitacaoAcesso);
}
