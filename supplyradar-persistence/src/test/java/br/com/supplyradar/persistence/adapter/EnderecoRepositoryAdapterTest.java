package br.com.supplyradar.persistence.adapter;

import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.core.persistence.CidadeRepository;
import br.com.supplyradar.core.persistence.EnderecoRepository;
import br.com.supplyradar.core.persistence.UnidadeFederativaRepository;
import br.com.supplyradar.domain.commons.Cidade;
import br.com.supplyradar.domain.commons.Endereco;
import br.com.supplyradar.domain.commons.UnidadeFederativa;
import br.com.supplyradar.persistence.AbstractPersistenceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

class EnderecoRepositoryAdapterTest extends AbstractPersistenceTest {
    @Autowired
    private EnderecoRepository repository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private UnidadeFederativaRepository unidadeFederativaRepository;

    @DisplayName(value = "Deve ser capaz de realizar persistência de endereços.")
    @Test
    void save() {
        final Endereco endereco = Fixture.from(Endereco.class).gimme("valido");
        final Cidade cidade = Fixture.from(Cidade.class).gimme("valido");
        final UnidadeFederativa unidadeFederativa = Fixture.from(UnidadeFederativa.class).gimme("valido");

        final UnidadeFederativa unidadeFederativaPersistida = unidadeFederativaRepository.save(unidadeFederativa);
        cidade.setUnidadeFederativa(unidadeFederativaPersistida);
        final Cidade cidadePersistida = cidadeRepository.save(cidade);

        endereco.setIdCidade(cidadePersistida.getId());

        final Endereco enderecoPersistido = repository.save(endereco);
        assertThat(enderecoPersistido, notNullValue());
        assertThat(enderecoPersistido.getId(), notNullValue());
    }
}
