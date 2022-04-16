package br.com.supplyradar.core.persistence;

import br.com.supplyradar.domain.commons.Endereco;

public interface EnderecoRepository {
    Endereco save(final Endereco endereco);
}
