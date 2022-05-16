package br.com.supplyradar.persistence.adapter;

import br.com.supplyradar.core.persistence.PessoaRepository;
import br.com.supplyradar.domain.commons.Pessoa;
import br.com.supplyradar.persistence.adapter.jpa.PessoaJpaRepository;
import br.com.supplyradar.persistence.mapper.PessoaEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class PessoaRepositoryAdapter implements PessoaRepository {
    private final PessoaJpaRepository jpa;
    private final PessoaEntityMapper mapper;

    @Override
    public Pessoa save(final Pessoa pessoa) {
        return mapper.mapFrom(jpa.save(mapper.mapFrom(pessoa)));
    }
}
