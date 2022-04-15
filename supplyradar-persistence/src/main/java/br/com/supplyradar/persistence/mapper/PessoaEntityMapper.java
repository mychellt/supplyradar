package br.com.supplyradar.persistence.mapper;


import br.com.supplyradar.domain.commons.PessoaFisica;
import br.com.supplyradar.domain.commons.PessoaJuridica;
import br.com.supplyradar.persistence.mapper.factory.PessoaEntityFactory;
import br.com.supplyradar.persistence.mapper.factory.PessoaFactory;
import br.com.supplyradar.persistence.model.commons.PessoaFisicaEntity;
import br.com.supplyradar.persistence.model.commons.PessoaJuridicaEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;


@Mapper(builder = @Builder(disableBuilder = true),
        uses = {
            PessoaEntityFactory.class,
            PessoaFactory.class,
            EmailEntityMapper.class,
            CNPJEntityMapper.class
        },
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PessoaEntityMapper {
    PessoaJuridica mapFrom(PessoaJuridicaEntity source);
    PessoaJuridicaEntity mapFrom(PessoaJuridica source);
    PessoaFisica mapFrom(PessoaFisicaEntity source);
    PessoaFisicaEntity mapFrom(PessoaFisica source);
}
