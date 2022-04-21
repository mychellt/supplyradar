package br.com.supplyradar.persistence.mapper;


import br.com.supplyradar.domain.commons.Usuario;
import br.com.supplyradar.persistence.mapper.factory.PessoaEntityFactory;
import br.com.supplyradar.persistence.mapper.factory.PessoaFactory;
import br.com.supplyradar.persistence.model.commons.UsuarioEntity;
import org.mapstruct.*;


@Mapper(builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {PessoaEntityMapper.class, PessoaEntityFactory.class, PessoaFactory.class, EmailEntityMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UsuarioEntityMapper {
    @Mapping(target = "vinculos", ignore = true)
    Usuario mapFrom(UsuarioEntity usuarioEntity);

    UsuarioEntity mapFrom(Usuario usuario);
}
