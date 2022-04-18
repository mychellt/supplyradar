package br.com.supplyradar.persistence.adapter;

import br.com.supplyradar.core.persistence.TokenSolicitacaoAcessoRepository;
import br.com.supplyradar.domain.commons.TokenSolicitacaoAcesso;
import br.com.supplyradar.persistence.adapter.jpa.TokenSolicitacaoAcessoJpaRepository;
import br.com.supplyradar.persistence.mapper.TokenSolicitacaoAcessoEntityMapper;
import br.com.supplyradar.persistence.model.commons.TokenSolicitacaoAcessoEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class TokenSolicitacaoAcessoRepositoryAdapter implements TokenSolicitacaoAcessoRepository {
    private final TokenSolicitacaoAcessoEntityMapper mapper;
    private final TokenSolicitacaoAcessoJpaRepository jpa;

    @Override
    public TokenSolicitacaoAcesso save(final TokenSolicitacaoAcesso tokenSolicitacaoAcesso) {
        return mapper.mapFrom(jpa.save(mapper.mapFrom(tokenSolicitacaoAcesso)));
    }

    @Override
    public TokenSolicitacaoAcesso findByKey(final String key) {
        return mapper.mapFrom(jpa.findByKey(key));
    }
}
