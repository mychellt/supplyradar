package br.com.supplyradar.persistence.mapper;

import br.com.supplyradar.domain.commons.Usina;
import br.com.supplyradar.persistence.mapper.factory.FactoryContratoEntityUsina;
import br.com.supplyradar.persistence.mapper.factory.FactoryContratoUsina;
import br.com.supplyradar.persistence.mapper.factory.PessoaJuricaEntityFactory;
import br.com.supplyradar.persistence.mapper.factory.PessoaJuridicaFactory;
import br.com.supplyradar.persistence.model.commons.UsinaEntity;
import org.mapstruct.*;

@Mapper(builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        uses = {PessoaJuricaEntityFactory.class,
                PessoaJuridicaFactory.class,
                FactoryContratoUsina.class,
                FactoryContratoEntityUsina.class,
                EmailEntityMapper.class,
                CycleAvoidingMappingJpaContext.class
        },
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UsinaEntityMapper {
    UsinaEntity mapFrom(final Usina usina);

    @Mapping(target = "vinculos", ignore = true)
    Usina mapFrom(final UsinaEntity usinaEntity);
}
