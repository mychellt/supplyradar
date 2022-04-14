package br.com.supplyradar.persistence.adapter;

import br.com.supplyradar.core.persistence.TokenSolicitacaoAcessoRepository;
import br.com.supplyradar.domain.commons.TokenSolicitacaoAcesso;
import org.springframework.stereotype.Repository;

@Repository
public class TokenSolicitacaoAcessoRepositoryAdapter implements TokenSolicitacaoAcessoRepository {

    @Override
    public TokenSolicitacaoAcesso save(TokenSolicitacaoAcesso tokenSolicitacaoAcesso) {
        return null;
    }
}
