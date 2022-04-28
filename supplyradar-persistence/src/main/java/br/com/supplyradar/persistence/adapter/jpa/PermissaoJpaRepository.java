package br.com.supplyradar.persistence.adapter.jpa;

import br.com.supplyradar.persistence.model.commons.PermissaoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

public interface PermissaoJpaRepository extends PagingAndSortingRepository<PermissaoEntity, UUID> {

    @Query("select permissao " +
            "from PermissaoEntity permissao " +
            "where permissao.ativo = true " +
                " and  (permissao.tipo =  br.com.supplyradar.domain.commons.TipoAtribuicao.FORNECEDOR " +
                " or permissao.tipo =  br.com.supplyradar.domain.commons.TipoAtribuicao.CONTRATANTE_FORNECEDOR) " +
                " order by permissao.ordem")
    List<PermissaoEntity> findAllForFornecedor();
}
