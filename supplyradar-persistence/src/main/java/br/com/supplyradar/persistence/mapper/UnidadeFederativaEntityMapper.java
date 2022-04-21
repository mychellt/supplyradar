package br.com.supplyradar.persistence.mapper;


import br.com.supplyradar.domain.commons.UnidadeFederativa;
import br.com.supplyradar.persistence.model.commons.UnidadeFederativaEntity;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;


@Mapper(builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UnidadeFederativaEntityMapper {
    UnidadeFederativa mapFrom(UnidadeFederativaEntity source);
    UnidadeFederativaEntity mapFrom(UnidadeFederativa source);
}
