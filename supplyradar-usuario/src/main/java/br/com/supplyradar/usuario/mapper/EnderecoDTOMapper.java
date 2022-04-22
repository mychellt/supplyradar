package br.com.supplyradar.usuario.mapper;

import br.com.supplyradar.domain.commons.Endereco;
import br.com.supplyradar.usuario.dto.EnderecoDTO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface EnderecoDTOMapper {

    @Mapping(target = "cidade.id", source = "idCidade")
    @Mapping(target = "pessoa", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateOfChange", ignore = true)
    @Mapping(target = "dateOfCreate", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    Endereco mapFrom(final EnderecoDTO enderecoDTO);


    @Mapping(target = "idCidade", source = "cidade.id")
    EnderecoDTO mapFrom(final Endereco endereco);
}
