package br.com.supplyradar.core.persistence;

import br.com.supplyradar.domain.commons.Fornecedor;

public interface FornecedorRepository {
    Fornecedor save(final Fornecedor fornecedor);
}
