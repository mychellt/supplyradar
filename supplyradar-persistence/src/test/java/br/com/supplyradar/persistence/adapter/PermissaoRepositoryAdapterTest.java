package br.com.supplyradar.persistence.adapter;

import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.core.persistence.PermissaoRepository;
import br.com.supplyradar.domain.commons.Permissao;
import br.com.supplyradar.persistence.AbstractPersistenceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

class PermissaoRepositoryAdapterTest extends AbstractPersistenceTest {
    @Autowired
    private PermissaoRepository repository;

    @DisplayName(value = "Dado uma permissão válida, deve ser capaz de realizar a persistência.")
    @Test
    void save() {
        final Permissao permissao = Fixture.from(Permissao.class).gimme("valido");
        final Permissao savedPermissao = repository.save(permissao);
        assertThat(savedPermissao, notNullValue());
        assertThat(savedPermissao.getId(), notNullValue());

        final Optional<Permissao> foundPermissao = repository.findOne(savedPermissao.getId());
        assertTrue(foundPermissao.isPresent());
        assertThat(foundPermissao.get(), notNullValue());
        assertThat(foundPermissao.get().getId(), notNullValue());
    }

    @DisplayName(value = "Deve ser capaz de retornar todos as permissões.")
    @Test
    void testFindAll() {
        List<Permissao> permissoes = Arrays.asList(
                Fixture.from(Permissao.class).gimme("valido"),
                Fixture.from(Permissao.class).gimme("valido"),
                Fixture.from(Permissao.class).gimme("valido"));

        permissoes.forEach(permissao -> permissao.setSigla(UUID.randomUUID().toString()));
        repository.save(permissoes);

        List<Permissao> permissoesPersistidas = repository.findAll();
        assertFalse(permissoesPersistidas.isEmpty());
        assertEquals(3, permissoes.size());
    }
}
