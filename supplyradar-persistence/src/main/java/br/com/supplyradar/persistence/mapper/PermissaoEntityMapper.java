package br.com.supplyradar.persistence.mapper;


import br.com.supplyradar.domain.commons.Permissao;
import br.com.supplyradar.persistence.model.commons.PermissaoEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(builder = @Builder(disableBuilder = true))
public abstract class PermissaoEntityMapper {
    private static final PermissaoEntityMapper instance = Mappers.getMapper(PermissaoEntityMapper.class);
    public static PermissaoEntityMapper getInstance() {
        return instance;
    }

    public abstract Permissao mapFrom(PermissaoEntity source);
    public abstract PermissaoEntity mapFrom(Permissao source);
}
