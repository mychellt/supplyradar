package br.com.supplyradar.persistence.mapper.factory;

import br.com.supplyradar.domain.commons.Email;
import br.com.supplyradar.domain.commons.Pessoa;
import br.com.supplyradar.domain.commons.PessoaFisica;
import br.com.supplyradar.persistence.model.commons.PessoaEntity;
import br.com.supplyradar.persistence.model.commons.PessoaFisicaEntity;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
public class PessoaFactory {

    @ObjectFactory
    public Pessoa build(PessoaEntity pessoaEntity) {
        final PessoaFisica pessoa = new PessoaFisica();
        pessoa.setId(pessoaEntity.getId());
        pessoa.setDateOfCreate(pessoaEntity.getDateOfCreate());
        pessoa.setDateOfChange(pessoaEntity.getDateOfChange());
        pessoa.setAtivo(pessoaEntity.isAtivo());
        pessoa.setTelefone(pessoaEntity.getTelefone());
        pessoa.setTipo(pessoaEntity.getTipo());
        pessoa.setEmail(Email.builder().address(pessoaEntity.getEmail()).build());
        pessoa.setNome(((PessoaFisicaEntity)pessoaEntity).getNome());
        pessoa.setCpfPassaporte(((PessoaFisicaEntity)pessoaEntity).getCpfPassaporte());
        pessoa.setPassaporte(((PessoaFisicaEntity)pessoaEntity).isPassaporte());
        return pessoa;
    }
}
