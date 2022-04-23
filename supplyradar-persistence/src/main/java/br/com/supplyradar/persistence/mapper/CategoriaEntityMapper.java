package br.com.supplyradar.persistence.mapper;

import br.com.supplyradar.domain.commons.Categoria;
import br.com.supplyradar.persistence.model.commons.CategoriaEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CategoriaEntityMapper {
    Categoria mapFrom(final CategoriaEntity source);
    CategoriaEntity mapFrom(final Categoria source);
}
