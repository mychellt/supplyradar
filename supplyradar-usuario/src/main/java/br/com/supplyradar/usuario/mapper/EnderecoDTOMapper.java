package br.com.supplyradar.usuario.mapper;

import br.com.supplyradar.domain.commons.Endereco;
import br.com.supplyradar.persistence.mapper.PessoaEntityMapper;
import br.com.supplyradar.persistence.mapper.factory.PessoaEntityFactory;
import br.com.supplyradar.persistence.mapper.factory.PessoaFactory;
import br.com.supplyradar.usuario.dto.EnderecoDTO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EnderecoDTOMapper {
    Endereco mapFrom(final EnderecoDTO enderecoDTO);
    EnderecoDTO mapFrom(final Endereco endereco);
}
