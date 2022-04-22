package br.com.supplyradar.persistence.mapper.factory;

import br.com.supplyradar.domain.commons.Pessoa;
import br.com.supplyradar.domain.commons.PessoaFisica;
import br.com.supplyradar.persistence.model.commons.PessoaEntity;
import br.com.supplyradar.persistence.model.commons.PessoaFisicaEntity;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor
public class PessoaFisicaEntityFactory {

    @ObjectFactory
    public PessoaEntity build(Pessoa pessoa) {
        PessoaFisicaEntity pessoaEntity =  new PessoaFisicaEntity();
        pessoaEntity.setId(pessoa.getId());
        pessoaEntity.setDateOfCreate(pessoa.getDateOfCreate());
        pessoaEntity.setDateOfChange(pessoa.getDateOfChange());
        pessoaEntity.setAtivo(pessoa.isAtivo());
        pessoaEntity.setTelefone(pessoa.getTelefone());
        pessoaEntity.setTipo(pessoa.getTipo());
        if(Objects.nonNull(pessoa.getEmail())) {
            pessoaEntity.setEmail(pessoa.getEmail().getAddress());
        }
        pessoaEntity.setNome(((PessoaFisica)pessoa).getNome());
        pessoaEntity.setCpfPassaporte(((PessoaFisica)pessoa).getCpfPassaporte());
        pessoaEntity.setPassaporte(((PessoaFisica)pessoa).isPassaporte());
        return pessoaEntity;
    }
}
