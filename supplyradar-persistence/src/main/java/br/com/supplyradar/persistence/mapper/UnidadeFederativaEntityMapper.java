package br.com.supplyradar.persistence.mapper;


import br.com.supplyradar.domain.commons.UnidadeFederativa;
import br.com.supplyradar.persistence.model.commons.UnidadeFederativaEntity;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;


@Mapper(builder = @Builder(disableBuilder = true),
        componentModel = "spring")
public interface UnidadeFederativaEntityMapper {
    UnidadeFederativa mapFrom(UnidadeFederativaEntity source);
    UnidadeFederativaEntity mapFrom(UnidadeFederativa source);
}
