package br.com.supplyradar.persistence.adapter;

import br.com.supplyradar.core.persistence.SolicitacaoAcessoRepository;
import br.com.supplyradar.domain.commons.SolicitacaoAcesso;
import org.springframework.stereotype.Repository;

@Repository
public class SolicitacaoAcessoRepositoryAdapter implements SolicitacaoAcessoRepository {
    @Override
    public SolicitacaoAcesso save(SolicitacaoAcesso solicitacaoAcesso) {
        return null;
    }
}
