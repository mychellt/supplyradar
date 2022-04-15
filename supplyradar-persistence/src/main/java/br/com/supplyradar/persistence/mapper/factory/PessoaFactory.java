package br.com.supplyradar.persistence.mapper.factory;

import br.com.supplyradar.domain.commons.*;
import br.com.supplyradar.persistence.adapter.jpa.PessoaJpaRepository;
import br.com.supplyradar.persistence.model.commons.PessoaEntity;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PessoaFactory {
    private final PessoaJpaRepository repository;

    @ObjectFactory
    public Pessoa build(PessoaEntity pessoaEntity) {
        final Pessoa pessoa = pessoaEntity.getTipo().equals(TipoPessoa.PESSOA_JURIDICA) ? new PessoaJuridica() :  new PessoaFisica();
        pessoa.setId(pessoaEntity.getId());
        pessoa.setDateOfCreate(pessoaEntity.getDateOfCreate());
        pessoa.setDateOfChange(pessoaEntity.getDateOfChange());
        pessoa.setAtivo(pessoaEntity.isAtivo());
        pessoa.setTelefone(pessoaEntity.getTelefone());
        pessoa.setTipo(pessoaEntity.getTipo());
        pessoa.setEmail(Email.builder().address(pessoaEntity.getEmail()).build());
        return pessoa;
    }
}
