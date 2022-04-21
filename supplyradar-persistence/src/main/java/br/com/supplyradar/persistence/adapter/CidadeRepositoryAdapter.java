package br.com.supplyradar.persistence.adapter;

import br.com.supplyradar.core.persistence.CidadeRepository;
import br.com.supplyradar.core.persistence.EnderecoRepository;
import br.com.supplyradar.domain.commons.Cidade;
import br.com.supplyradar.domain.commons.Endereco;
import br.com.supplyradar.persistence.adapter.jpa.CidadeJpaRepository;
import br.com.supplyradar.persistence.adapter.jpa.EnderecoJpaRepository;
import br.com.supplyradar.persistence.mapper.CidadeEntityMapper;
import br.com.supplyradar.persistence.mapper.EnderecoEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@AllArgsConstructor
@Repository
public class CidadeRepositoryAdapter implements CidadeRepository {
    private final CidadeJpaRepository jpa;
    private final CidadeEntityMapper mapper;

    @Override
    public Cidade save(Cidade cidade) {
        return mapper.mapFrom(jpa.save(mapper.mapFrom(cidade)));
    }

    @Override
    public Cidade findById(UUID id) {
        return jpa.findById(id).map(mapper::mapFrom).orElse(null);
    }
}
