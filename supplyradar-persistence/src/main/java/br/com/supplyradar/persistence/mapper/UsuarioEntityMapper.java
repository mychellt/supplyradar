package br.com.supplyradar.persistence.mapper;


import br.com.supplyradar.domain.commons.Usuario;
import br.com.supplyradar.persistence.model.commons.UsuarioEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;


@Mapper(builder = @Builder(disableBuilder = true),
        uses = {PessoaEntityMapper.class, EmailEntityMapper.class, EnderecoEntityMapper.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UsuarioEntityMapper {
    Usuario mapFrom(UsuarioEntity source);
    UsuarioEntity mapFrom(Usuario source);
}
