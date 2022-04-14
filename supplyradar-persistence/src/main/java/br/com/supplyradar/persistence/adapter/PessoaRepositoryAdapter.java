package br.com.supplyradar.persistence.adapter;

import br.com.supplyradar.core.persistence.PessoaRepository;
import br.com.supplyradar.domain.commons.Pessoa;
import org.springframework.stereotype.Repository;

@Repository
public class PessoaRepositoryAdapter implements PessoaRepository {
    @Override
    public Pessoa save(Pessoa pessoa) {
        return null;
    }
}
