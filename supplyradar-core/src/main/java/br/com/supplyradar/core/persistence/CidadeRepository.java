package br.com.supplyradar.core.persistence;

import br.com.supplyradar.domain.commons.Cidade;

public interface CidadeRepository {
    Cidade save(final Cidade cidade);
}
