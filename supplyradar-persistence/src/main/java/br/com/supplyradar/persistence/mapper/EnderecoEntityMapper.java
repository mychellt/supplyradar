package br.com.supplyradar.persistence.mapper;


import br.com.supplyradar.domain.commons.Endereco;
import br.com.supplyradar.persistence.mapper.factory.PessoaFisicaEntityFactory;
import br.com.supplyradar.persistence.mapper.factory.PessoaFactory;
import br.com.supplyradar.persistence.mapper.factory.PessoaJuricaEntityFactory;
import br.com.supplyradar.persistence.mapper.factory.PessoaJuridicaFactory;
import br.com.supplyradar.persistence.model.commons.EnderecoEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;


@Mapper(builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        uses = {PessoaEntityMapper.class,
                PessoaJuridicaFactory.class,
                PessoaJuricaEntityFactory.class,
                EmailEntityMapper.class,
                CNPJEntityMapper.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface EnderecoEntityMapper {
    Endereco mapFrom(EnderecoEntity source);
    EnderecoEntity mapFrom(Endereco source);
}
