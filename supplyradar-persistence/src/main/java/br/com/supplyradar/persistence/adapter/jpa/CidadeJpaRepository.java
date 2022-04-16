package br.com.supplyradar.persistence.adapter.jpa;

import br.com.supplyradar.persistence.model.commons.CidadeEntity;
import br.com.supplyradar.persistence.model.commons.EnderecoEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface CidadeJpaRepository extends PagingAndSortingRepository<CidadeEntity, UUID> {

}
