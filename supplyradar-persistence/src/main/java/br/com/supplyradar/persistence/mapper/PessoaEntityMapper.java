package br.com.supplyradar.persistence.mapper;


import br.com.supplyradar.domain.commons.PessoaFisica;
import br.com.supplyradar.domain.commons.PessoaJuridica;
import br.com.supplyradar.persistence.mapper.factory.PessoaFisicaEntityFactory;
import br.com.supplyradar.persistence.mapper.factory.PessoaFactory;
import br.com.supplyradar.persistence.model.commons.PessoaFisicaEntity;
import br.com.supplyradar.persistence.model.commons.PessoaJuridicaEntity;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;


@Mapper(builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {
            PessoaFisicaEntityFactory.class,
            PessoaFactory.class,
            EmailEntityMapper.class,
            CNPJEntityMapper.class,
            EnderecoEntityMapper.class
        }, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PessoaEntityMapper {
    PessoaJuridica mapFrom(PessoaJuridicaEntity source);
    PessoaJuridicaEntity mapFrom(PessoaJuridica source);
    PessoaFisica mapFrom(PessoaFisicaEntity source);
    PessoaFisicaEntity mapFrom(PessoaFisica source);
}
