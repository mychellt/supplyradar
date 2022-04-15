package br.com.supplyradar.persistence.mapper;


import br.com.supplyradar.domain.commons.Permissao;
import br.com.supplyradar.persistence.model.commons.PermissaoEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(builder = @Builder(disableBuilder = true))
public interface PermissaoEntityMapper {
    Permissao mapFrom(PermissaoEntity source);
    PermissaoEntity mapFrom(Permissao source);
}
