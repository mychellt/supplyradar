package br.com.supplyradar.persistence.adapter.jpa;

import br.com.supplyradar.persistence.model.commons.EnderecoEntity;
import br.com.supplyradar.persistence.model.commons.TokenSolicitacaoAcessoEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface EnderecoJpaRepository extends PagingAndSortingRepository<EnderecoEntity, UUID> {

}
