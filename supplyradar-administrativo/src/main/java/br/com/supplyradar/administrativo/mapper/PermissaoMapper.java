package br.com.supplyradar.administrativo.mapper;


import br.com.supplyradar.domain.commons.Permissao;
import br.com.supplyradar.administrativo.dto.PermissaoDTO;
import org.mapstruct.Builder;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface PermissaoMapper {
    Permissao mapFrom(PermissaoDTO source);

    PermissaoDTO mapFrom(Permissao source);
}
