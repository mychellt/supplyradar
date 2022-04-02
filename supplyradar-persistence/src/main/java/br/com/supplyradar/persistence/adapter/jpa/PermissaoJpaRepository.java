package br.com.supplyradar.persistence.adapter.jpa;

import br.com.supplyradar.persistence.model.commons.PermissaoEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface PermissaoJpaRepository extends PagingAndSortingRepository<PermissaoEntity, UUID> {

}
