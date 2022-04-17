package br.com.supplyradar.usuario.mapper;

import br.com.supplyradar.domain.commons.CreateUsuario;
import br.com.supplyradar.usuario.dto.CreateUsuarioDTO;
import br.com.supplyradar.usuario.dto.UsuarioCadastradoDTO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true))
public interface CreateUsuarioDTOMapper {
    CreateUsuario mapFrom(final CreateUsuarioDTO createUsuarioDTO);
    UsuarioCadastradoDTO mapFrom(final CreateUsuario usuario);
}
