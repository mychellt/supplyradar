package br.com.supplyradar.core.persistence;

import br.com.supplyradar.domain.commons.Cidade;

import java.util.UUID;

public interface CidadeRepository {
    Cidade save(final Cidade cidade);
    Cidade findById(final UUID id);
}
