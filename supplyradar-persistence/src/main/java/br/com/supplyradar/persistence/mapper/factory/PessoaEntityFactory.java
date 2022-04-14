package br.com.supplyradar.persistence.mapper.factory;

import br.com.supplyradar.domain.commons.Pessoa;
import br.com.supplyradar.persistence.adapter.jpa.PessoaJpaRepository;
import br.com.supplyradar.persistence.model.commons.PessoaEntity;
import br.com.supplyradar.persistence.model.commons.PessoaFisicaEntity;
import br.com.supplyradar.persistence.model.commons.PessoaJuridicaEntity;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor
public class PessoaEntityFactory {
    private final PessoaJpaRepository repository;

    @ObjectFactory
    public PessoaEntity build(Pessoa pessoa) {
        if(Objects.nonNull(pessoa.getId())){
            return repository.findById(pessoa.getId()).orElse(getNewInstance(pessoa));
        }
        return getNewInstance(pessoa);
    }

    public PessoaEntity getNewInstance(Pessoa pessoa) {
        return pessoa.isPessoaFisica() ?  new PessoaFisicaEntity() : new PessoaJuridicaEntity();
    }
}
