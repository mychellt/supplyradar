package br.com.supplyradar.persistence.mapper;


import br.com.supplyradar.domain.commons.Cidade;
import br.com.supplyradar.persistence.model.commons.CidadeEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(builder = @Builder(disableBuilder = true))
public abstract class CidadeEntityMapper {
    private static final CidadeEntityMapper instance = Mappers.getMapper(CidadeEntityMapper.class);
    public static CidadeEntityMapper getInstance() {
        return instance;
    }

    public abstract Cidade mapFrom(CidadeEntity source);
    public abstract CidadeEntity mapFrom(Cidade source);
}
