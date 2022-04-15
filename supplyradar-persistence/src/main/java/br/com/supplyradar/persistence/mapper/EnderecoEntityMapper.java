package br.com.supplyradar.persistence.mapper;


import br.com.supplyradar.domain.commons.Endereco;
import br.com.supplyradar.persistence.mapper.factory.PessoaEntityFactory;
import br.com.supplyradar.persistence.mapper.factory.PessoaFactory;
import br.com.supplyradar.persistence.model.commons.EnderecoEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;


@Mapper(builder = @Builder(disableBuilder = true),
        uses = {PessoaEntityMapper.class, PessoaEntityFactory.class, PessoaFactory.class, EmailEntityMapper.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface EnderecoEntityMapper {
    Endereco mapFrom(EnderecoEntity source);
    EnderecoEntity mapFrom(Endereco source);
}
