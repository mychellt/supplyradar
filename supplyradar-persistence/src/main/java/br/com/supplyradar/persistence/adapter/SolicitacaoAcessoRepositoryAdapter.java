package br.com.supplyradar.persistence.adapter;

import br.com.supplyradar.core.persistence.SolicitacaoAcessoRepository;
import br.com.supplyradar.domain.commons.SolicitacaoAcesso;
import br.com.supplyradar.persistence.adapter.jpa.SolicitacaoAcessoJpaRepository;
import br.com.supplyradar.persistence.mapper.SolicitacaoAcessoEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class SolicitacaoAcessoRepositoryAdapter implements SolicitacaoAcessoRepository {
    private final SolicitacaoAcessoJpaRepository jpa;
    private final SolicitacaoAcessoEntityMapper mapper;
    @Override
    public SolicitacaoAcesso save(SolicitacaoAcesso solicitacaoAcesso) {
        return mapper.mapFrom(jpa.save(mapper.mapFrom(solicitacaoAcesso)));
    }
}
