package br.com.supplyradar.persistence.adapter.jpa;

import br.com.supplyradar.persistence.model.commons.PessoaEntity;
import br.com.supplyradar.persistence.model.commons.UsuarioEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface PessoaJpaRepository extends PagingAndSortingRepository<PessoaEntity, UUID> {

}
