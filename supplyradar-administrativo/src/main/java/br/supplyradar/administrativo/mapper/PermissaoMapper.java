package br.supplyradar.administrativo.mapper;


import br.com.supplyradar.domain.commons.Permissao;
import br.supplyradar.administrativo.dto.PermissaoDTO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public abstract class PermissaoMapper {

    private static final PermissaoMapper instance = Mappers.getMapper(PermissaoMapper.class);

    public static PermissaoMapper getInstance() {
        return instance;
    }

    public abstract Permissao mapFrom(PermissaoDTO source);

    public abstract PermissaoDTO mapFrom(Permissao source);
}
