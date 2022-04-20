package br.com.supplyradar.usuario.mapper;

import br.com.supplyradar.domain.commons.CreateUsina;
import br.com.supplyradar.domain.commons.CreateUsuario;
import br.com.supplyradar.usuario.dto.CreateUsinaDTO;
import br.com.supplyradar.usuario.dto.CreateUsuarioDTO;
import br.com.supplyradar.usuario.dto.UsuarioCadastradoDTO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(builder = @Builder(disableBuilder = true),
        uses = {EnderecoDTOMapper.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CreateUsinaDTOMapper {
    CreateUsina mapFrom(final CreateUsinaDTO createUsinaDTO);
    CreateUsinaDTO mapFrom(final CreateUsina createUsina);
}
