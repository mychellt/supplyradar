package br.com.supplyradar.persistence.adapter;

import br.com.supplyradar.core.persistence.FornecedorRepository;
import br.com.supplyradar.domain.commons.Fornecedor;
import br.com.supplyradar.persistence.adapter.jpa.FornecedorJpaRepository;
import br.com.supplyradar.persistence.mapper.FornecedorEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@RequiredArgsConstructor
@Repository
public class FornecedorRepositoryAdapter implements FornecedorRepository {
    private final FornecedorJpaRepository jpa;
    private final FornecedorEntityMapper mapper;
    @Override
    public Fornecedor save(Fornecedor fornecedor) {
        return mapper.mapFrom(jpa.save(mapper.mapFrom(fornecedor)));
    }

    @Override
    public Fornecedor findById(UUID id) {
        return jpa.findById(id).map(mapper::mapFrom).orElse(null);
    }
}
