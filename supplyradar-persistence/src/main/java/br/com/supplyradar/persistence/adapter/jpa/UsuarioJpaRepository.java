package br.com.supplyradar.persistence.adapter.jpa;

import br.com.supplyradar.persistence.model.commons.UsuarioEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface UsuarioJpaRepository extends PagingAndSortingRepository<UsuarioEntity, UUID> {

}
