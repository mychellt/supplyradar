package br.com.supplyradar.persistence.mapper.factory;

import br.com.supplyradar.domain.commons.Pessoa;
import br.com.supplyradar.domain.commons.PessoaFisica;
import br.com.supplyradar.domain.commons.TipoPessoa;
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

        if(pessoaEntity.getTipo().equals(TipoPessoa.PESSOA_FISICA)){
            assert pessoaEntity instanceof PessoaFisicaEntity;
            ((PessoaFisicaEntity)pessoaEntity).setNome(((PessoaFisica)pessoa).getNome());
            ((PessoaFisicaEntity)pessoaEntity).setCpfPassaporte(((PessoaFisica)pessoa).getCpfPassaporte());
            ((PessoaFisicaEntity)pessoaEntity).setPassaporte(((PessoaFisica)pessoa).isPassaporte());
        }

        return pessoaEntity;
    }
}
