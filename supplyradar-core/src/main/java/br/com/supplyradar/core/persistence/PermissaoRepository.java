package br.com.supplyradar.core.persistence;

import br.com.supplyradar.domain.commons.Permissao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PermissaoRepository {
    Permissao save(final Permissao permissao);
    List<Permissao> save(final Collection<Permissao> permissoes);
    List<Permissao> findAll();
    Optional<Permissao> findOne(final UUID id);
    void remove(final UUID id);
    List<Permissao> findAllForFornecedor();
}
