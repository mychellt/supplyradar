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

class FornecedorRepositoryAdapterTest extends AbstractPersistenceTest {
    @Autowired
    private FornecedorRepository fornecedorRepository;


    @DisplayName(value = "Deve ser capaz de persistir registros de fornecedores.")
    @Test
    void save() {
        final Fornecedor fornecedor = Fixture.from(Fornecedor.class).gimme("valido");
        Fornecedor fornecedorPersistido = fornecedorRepository.save(fornecedor);
        assertThat(fornecedorPersistido, notNullValue());

    }
}
