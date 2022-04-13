package br.com.supplyradar.core.persistence;

import br.com.supplyradar.domain.commons.Pessoa;

public interface PessoaRepository {
    Pessoa save(final Pessoa pessoa);
}
