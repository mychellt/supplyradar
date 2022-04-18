package br.com.supplyradar.persistence.adapter;

import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.core.persistence.UsuarioRepository;
import br.com.supplyradar.domain.commons.Usuario;
import br.com.supplyradar.persistence.AbstractPersistenceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class UsuarioRepositoryAdapterTest extends AbstractPersistenceTest {
    @Autowired
    private UsuarioRepository repository;


    @DisplayName(value = "Deve ser capaz de realizar persistência de usuário.")
    @Test
    void save() {
        final Usuario usuario = Fixture.from(Usuario.class).gimme("valido");

        Usuario usuarioPersistido = repository.save(usuario);
        assertThat(usuarioPersistido, notNullValue());
        assertThat(usuarioPersistido.getId(), notNullValue());
        assertThat(usuarioPersistido.getPessoa(), notNullValue());
        assertThat(usuarioPersistido.getPessoa().getId(), notNullValue());
    }
}
