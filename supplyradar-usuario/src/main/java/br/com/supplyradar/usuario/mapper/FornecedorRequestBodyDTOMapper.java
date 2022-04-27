package br.com.supplyradar.usuario.mapper;

import br.com.supplyradar.domain.api.FornecedorRequestBody;
import br.com.supplyradar.usuario.dto.FornecedorRequestBodyDTO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(builder = @Builder(disableBuilder = true),
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface FornecedorRequestBodyDTOMapper {
    FornecedorRequestBody mapFrom(final FornecedorRequestBodyDTO source);
    FornecedorRequestBodyDTO mapFrom(final FornecedorRequestBody source);
}
