package br.com.supplyradar.persistence.mapper;

import br.com.supplyradar.domain.commons.Usina;
import br.com.supplyradar.persistence.mapper.factory.PessoaEntityFactory;
import br.com.supplyradar.persistence.mapper.factory.PessoaFactory;
import br.com.supplyradar.persistence.model.commons.UsinaEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        uses = {PessoaEntityFactory.class,
                PessoaFactory.class,
                EmailEntityMapper.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UsinaEntityMapper {
    UsinaEntity mapFrom(final Usina usina);

    @Mapping(target = "vinculos", ignore = true)
    Usina mapFrom(final UsinaEntity usinaEntity);
}
