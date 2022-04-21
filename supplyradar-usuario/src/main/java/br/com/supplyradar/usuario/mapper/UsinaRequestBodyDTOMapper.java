package br.com.supplyradar.usuario.mapper;

import br.com.supplyradar.domain.commons.UsinaRequestBody;
import br.com.supplyradar.usuario.dto.UsinaRequestBodyDTO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(builder = @Builder(disableBuilder = true),
        uses = {EnderecoDTOMapper.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UsinaRequestBodyDTOMapper {
    UsinaRequestBody mapFrom(final UsinaRequestBodyDTO usinaRequestBodyDTO);
    UsinaRequestBodyDTO mapFrom(final UsinaRequestBody usinaRequestBody);
}
