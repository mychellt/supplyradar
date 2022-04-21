package br.com.supplyradar.usuario.mapper;

import br.com.supplyradar.domain.commons.Endereco;
import br.com.supplyradar.persistence.mapper.PessoaEntityMapper;
import br.com.supplyradar.persistence.mapper.factory.PessoaEntityFactory;
import br.com.supplyradar.persistence.mapper.factory.PessoaFactory;
import br.com.supplyradar.usuario.dto.EnderecoDTO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(builder = @Builder(disableBuilder = true), uses = {PessoaFactory.class, PessoaEntityFactory.class})
public interface EnderecoDTOMapper {
    @Mapping(ignore = true, target = "dateOfChange")
    @Mapping(ignore = true, target = "dateOfCreate")
    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "ativo")
    Endereco mapFrom(final EnderecoDTO enderecoDTO);

    EnderecoDTO mapFrom(final Endereco endereco);
}
