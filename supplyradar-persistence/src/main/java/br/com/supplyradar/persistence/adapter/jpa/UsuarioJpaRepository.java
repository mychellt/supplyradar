package br.com.supplyradar.persistence.adapter.jpa;

import br.com.supplyradar.persistence.model.commons.UsuarioEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface UsuarioJpaRepository extends PagingAndSortingRepository<UsuarioEntity, UUID> {

    @Modifying
    @Query(value = "update UsuarioEntity usuario set usuario.autorizado = true where usuario.id = ?1")
    void autorizarById(UUID id);
}
