package br.com.supplyradar.persistence.adapter;

import br.com.supplyradar.core.persistence.PermissaoRepository;
import br.com.supplyradar.domain.commons.Permissao;
import br.com.supplyradar.persistence.adapter.jpa.PermissaoJpaRepository;
import br.com.supplyradar.persistence.mapper.PermissaoEntityMapper;
import br.com.supplyradar.persistence.model.commons.PermissaoEntity;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;
import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

@RequiredArgsConstructor
@Repository
public class PermissaoRepositoryAdapter implements PermissaoRepository {
    private final PermissaoJpaRepository jpa;
    private final PermissaoEntityMapper mapper;

    @Override
    public Permissao save(final Permissao permissao) {
        return Optional.of(jpa.save(mapper.mapFrom(permissao)))
                .map(mapper::mapFrom)
                .orElse(null);
    }

    @Override
    public List<Permissao> save(final Collection<Permissao> permissoes) {
        final Iterable<PermissaoEntity> entities = jpa.saveAll(emptyIfNull(permissoes)
                .stream()
                .map(mapper::mapFrom)
                .collect(Collectors.toList()));

        return stream(entities.spliterator(), false).map(mapper::mapFrom).collect(Collectors.toList());

    }

    @Override
    public List<Permissao> findAll() {
        return stream(jpa.findAll().spliterator(), false).map(mapper::mapFrom).collect(Collectors.toList());
    }

    @Override
    public Optional<Permissao> findOne(final UUID id) {
        return Optional.of(jpa.findById(id).map(mapper::mapFrom)).orElse(null);
    }

    @Override
    public void remove(UUID id) {
        jpa.deleteById(id);
    }

    @Override
    public List<Permissao> findAllForFornecedor() {
        return emptyIfNull(jpa.findAllForFornecedor())
                .stream()
                .map(mapper::mapFrom)
                .collect(Collectors.toList());
    }
}
