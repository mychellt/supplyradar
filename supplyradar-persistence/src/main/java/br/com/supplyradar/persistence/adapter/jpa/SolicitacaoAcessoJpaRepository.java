package br.com.supplyradar.persistence.adapter.jpa;

import br.com.supplyradar.persistence.model.commons.SolicitacaoAcessoEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface SolicitacaoAcessoJpaRepository extends PagingAndSortingRepository<SolicitacaoAcessoEntity, UUID> {

}
