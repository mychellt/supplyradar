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
public abstract class EnderecoEntityMapper {
    private static final EnderecoEntityMapper instance = Mappers.getMapper(EnderecoEntityMapper.class);
    public static EnderecoEntityMapper getInstance() {
        return instance;
    }

    public abstract Endereco mapFrom(EnderecoEntity source);
    public abstract EnderecoEntity mapFrom(Endereco source);
}
