package br.com.supplyradar.persistence.adapter.jpa;

import br.com.supplyradar.persistence.model.commons.FornecedorEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface FornecedorJpaRepository extends PagingAndSortingRepository<FornecedorEntity, UUID> {

}
