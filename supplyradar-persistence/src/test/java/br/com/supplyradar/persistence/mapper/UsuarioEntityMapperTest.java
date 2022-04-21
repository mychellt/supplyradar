package br.com.supplyradar.persistence.mapper;

import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.domain.commons.*;
import br.com.supplyradar.persistence.AbstractPersistenceTest;
import br.com.supplyradar.persistence.mapper.factory.PessoaEntityFactory;
import br.com.supplyradar.persistence.mapper.factory.PessoaFactory;
import br.com.supplyradar.persistence.model.commons.UsuarioEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {
        UsuarioEntityMapperImpl.class,
        PessoaEntityFactory.class,
        PessoaFactory.class,
        EmailEntityMapperImpl.class
})
class UsuarioEntityMapperTest extends AbstractMapperTest {
    @Autowired
    private UsuarioEntityMapper mapper;

    @DisplayName(value = "Deve ser capaz de mapear os dados de Entity para Domain")
    @Test
    void mapFromEntity() {
        UsuarioEntity usuarioEntity = Fixture.from(UsuarioEntity.class).gimme("valido");
        Usuario usuario = mapper.mapFrom(usuarioEntity);
        assertThat(usuario, notNullValue());
        assertThat(usuario.getPessoa(), notNullValue());
        assertEquals(usuario.getLogin(), usuarioEntity.getLogin());
        assertEquals(usuario.getSenha(), usuarioEntity.getSenha());
        assertEquals(usuario.isAutorizado(), usuarioEntity.isAutorizado());
        assertEquals(usuario.getId(), usuarioEntity.getId());
        assertEquals(usuario.getTipo(), usuarioEntity.getTipo());
        assertEquals(usuario.isAtivo(), usuarioEntity.isAtivo());
        assertEquals(usuario.getDateOfChange(), usuarioEntity.getDateOfChange());
        assertEquals(usuario.getDateOfCreate(), usuarioEntity.getDateOfCreate());
    }

    @DisplayName(value = "Deve ser capaz de mapear os dados de Domain para Entity")
    @Test
    void mapFromDomain() {
        Usuario usuario = Fixture.from(Usuario.class).gimme("valido");
        UsuarioEntity usuarioEntity = mapper.mapFrom(usuario);
        assertThat(usuarioEntity, notNullValue());
        assertThat(usuarioEntity.getPessoa(), notNullValue());
        assertEquals(usuarioEntity.getLogin(), usuario.getLogin());
        assertEquals(usuarioEntity.getSenha(), usuario.getSenha());
        assertEquals(usuarioEntity.isAutorizado(), usuario.isAutorizado());
        assertEquals(usuarioEntity.getId(), usuario.getId());
        assertEquals(usuarioEntity.getTipo(), usuario.getTipo());
        assertEquals(usuarioEntity.isAtivo(), usuario.isAtivo());
        assertEquals(usuarioEntity.getDateOfChange(), usuario.getDateOfChange());
        assertEquals(usuarioEntity.getDateOfCreate(), usuario.getDateOfCreate());
    }
}
