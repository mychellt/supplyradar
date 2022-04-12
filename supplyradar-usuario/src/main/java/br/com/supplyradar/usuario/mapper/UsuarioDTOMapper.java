package br.com.supplyradar.usuario.mapper;

import br.com.supplyradar.domain.commons.Usuario;
import br.com.supplyradar.usuario.dto.CreateUsuarioDTO;
import br.com.supplyradar.usuario.dto.UsuarioCadastradoDTO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true))
public interface UsuarioDTOMapper {
    Usuario mapFrom(final CreateUsuarioDTO createUsuarioDTO);
    UsuarioCadastradoDTO mapFrom(final Usuario usuario);
}
