package br.com.supplyradar.persistence.adapter.jpa;

import br.com.supplyradar.persistence.model.commons.UsinaEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface UsinaJpaRepository extends PagingAndSortingRepository<UsinaEntity, UUID> {

}
