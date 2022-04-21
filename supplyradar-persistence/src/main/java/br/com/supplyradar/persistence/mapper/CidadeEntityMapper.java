package br.com.supplyradar.persistence.mapper;


import br.com.supplyradar.domain.commons.Cidade;
import br.com.supplyradar.persistence.model.commons.CidadeEntity;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;


@Mapper(builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CidadeEntityMapper {
    Cidade mapFrom(CidadeEntity source);
    CidadeEntity mapFrom(Cidade source);
}
