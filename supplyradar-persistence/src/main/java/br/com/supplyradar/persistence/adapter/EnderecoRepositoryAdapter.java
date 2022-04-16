package br.com.supplyradar.persistence.adapter;

import br.com.supplyradar.core.persistence.EnderecoRepository;
import br.com.supplyradar.domain.commons.Endereco;
import br.com.supplyradar.persistence.adapter.jpa.EnderecoJpaRepository;
import br.com.supplyradar.persistence.mapper.EnderecoEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class EnderecoRepositoryAdapter implements EnderecoRepository {
    private final EnderecoJpaRepository jpa;
    private final EnderecoEntityMapper mapper;

    @Override
    public Endereco save(Endereco endereco) {
        return mapper.mapFrom(jpa.save(mapper.mapFrom(endereco)));
    }
}
