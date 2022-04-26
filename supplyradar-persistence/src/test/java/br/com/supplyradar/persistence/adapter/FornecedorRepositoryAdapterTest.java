package br.com.supplyradar.persistence.adapter;

import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.core.persistence.FornecedorRepository;
import br.com.supplyradar.domain.commons.Fornecedor;
import br.com.supplyradar.persistence.AbstractPersistenceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FornecedorRepositoryAdapterTest extends AbstractPersistenceTest {
    @Autowired
    private FornecedorRepository fornecedorRepository;


    @DisplayName(value = "Deve ser capaz de persistir registros de fornecedores.")
    @Test
    void save() {
        final Fornecedor fornecedor = Fixture.from(Fornecedor.class).gimme("valido");
        Fornecedor fornecedorPersistido = fornecedorRepository.save(fornecedor);
        assertThat(fornecedorPersistido, notNullValue());

        Fornecedor fornecedorRecuperado = fornecedorRepository.findById(fornecedorPersistido.getId());
        assertThat(fornecedorRecuperado, notNullValue());
        assertThat(fornecedorRecuperado.getAtuacao(), notNullValue());
        assertThat(fornecedorRecuperado.getAtendimento(), notNullValue());
        assertThat(fornecedorRecuperado.getDateOfCreate(), notNullValue());
        assertThat(fornecedorRecuperado.getDateOfChange(), notNullValue());
        assertEquals(fornecedorRecuperado.getDateOfCreate(), fornecedor.getDateOfCreate());
        assertEquals(fornecedorRecuperado.getDateOfChange(), fornecedor.getDateOfChange());
        assertEquals(fornecedorRecuperado.getAtuacao().getDescricao(), fornecedor.getAtuacao().getDescricao());
        assertEquals(fornecedorRecuperado.getAtuacao().getResumo(), fornecedor.getAtuacao().getResumo());
        assertEquals(fornecedorRecuperado.getAtendimento().isAtendimento24Horas(), fornecedor.getAtendimento().isAtendimento24Horas());
        assertEquals(fornecedorRecuperado.getAtendimento().isContingencia(), fornecedor.getAtendimento().isContingencia());
    }
}
