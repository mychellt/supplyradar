package br.com.supplyradar.persistence.mapper.factory;

import br.com.supplyradar.domain.commons.Pessoa;
import br.com.supplyradar.persistence.model.commons.PessoaEntity;
import br.com.supplyradar.persistence.model.commons.PessoaFisicaEntity;
import br.com.supplyradar.persistence.model.commons.PessoaJuridicaEntity;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PessoaEntityFactory {

    @ObjectFactory
    public PessoaEntity build(Pessoa pessoa) {
        PessoaEntity pessoaEntity = pessoa.isPessoaFisica() ?  new PessoaFisicaEntity() : new PessoaJuridicaEntity();
        pessoaEntity.setId(pessoa.getId());
        pessoaEntity.setDateOfCreate(pessoa.getDateOfCreate());
        pessoaEntity.setDateOfChange(pessoa.getDateOfChange());
        pessoaEntity.setAtivo(pessoa.isAtivo());
        pessoaEntity.setTelefone(pessoa.getTelefone());
        pessoaEntity.setTipo(pessoa.getTipo());
        pessoaEntity.setEmail(pessoa.getEmail().getAddress());
        return pessoaEntity;
    }
}
