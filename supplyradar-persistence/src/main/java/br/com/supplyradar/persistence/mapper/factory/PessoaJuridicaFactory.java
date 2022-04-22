package br.com.supplyradar.persistence.mapper.factory;

import br.com.supplyradar.domain.commons.*;
import br.com.supplyradar.persistence.model.commons.PessoaEntity;
import br.com.supplyradar.persistence.model.commons.PessoaFisicaEntity;
import br.com.supplyradar.persistence.model.commons.PessoaJuridicaEntity;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
public class PessoaJuridicaFactory {

    @ObjectFactory
    public Pessoa build(PessoaEntity pessoaEntity) {
        final PessoaJuridica pessoa = new PessoaJuridica();
        pessoa.setId(pessoaEntity.getId());
        pessoa.setDateOfCreate(pessoaEntity.getDateOfCreate());
        pessoa.setDateOfChange(pessoaEntity.getDateOfChange());
        pessoa.setAtivo(pessoaEntity.isAtivo());
        pessoa.setTelefone(pessoaEntity.getTelefone());
        pessoa.setTipo(pessoaEntity.getTipo());
        pessoa.setEmail(Email.builder().address(pessoaEntity.getEmail()).build());
        pessoa.setCnpj(Cnpj.builder().number(((PessoaJuridicaEntity)pessoaEntity).getCnpj()).build());
        pessoa.setRazaoSocial(((PessoaJuridicaEntity)pessoaEntity).getRazaoSocial());
        pessoa.setInscricaoEstadual(((PessoaJuridicaEntity)pessoaEntity).getInscricaoEstadual());
        pessoa.setNomeFantasia(((PessoaJuridicaEntity)pessoaEntity).getNomeFantasia());
        pessoa.setWebsite(((PessoaJuridicaEntity)pessoaEntity).getWebsite());
        return pessoa;
    }
}
