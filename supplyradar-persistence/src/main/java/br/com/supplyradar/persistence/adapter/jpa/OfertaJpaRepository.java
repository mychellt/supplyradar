package br.com.supplyradar.persistence.adapter.jpa;

import br.com.supplyradar.persistence.model.assinatura.OfertaEntity;
import br.com.supplyradar.persistence.model.commons.CidadeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface OfertaJpaRepository extends PagingAndSortingRepository<OfertaEntity, UUID> {

}
