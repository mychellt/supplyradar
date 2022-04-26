package br.com.supplyradar.core.persistence;

import br.com.supplyradar.domain.commons.Fornecedor;

import java.util.UUID;

public interface FornecedorRepository {
    Fornecedor save(final Fornecedor fornecedor);
    Fornecedor findById(final UUID id);
}
