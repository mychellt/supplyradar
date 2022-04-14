package br.com.supplyradar.persistence.mapper;


import br.com.supplyradar.domain.commons.Usuario;
import br.com.supplyradar.persistence.model.commons.UsuarioEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;


@Mapper(builder = @Builder(disableBuilder = true),
        uses = {PessoaEntityMapper.class, EmailEntityMapper.class, EnderecoEntityMapper.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class UsuarioEntityMapper {
    private static final UsuarioEntityMapper instance = Mappers.getMapper(UsuarioEntityMapper.class);
    public static UsuarioEntityMapper getInstance() {
        return instance;
    }

    public abstract Usuario mapFrom(UsuarioEntity source);
    public abstract UsuarioEntity mapFrom(Usuario source);
}
