package br.com.supplyradar.persistence.mapper.factory;

import br.com.supplyradar.domain.commons.Pessoa;
import br.com.supplyradar.domain.commons.PessoaFisica;
import br.com.supplyradar.domain.commons.PessoaJuridica;
import br.com.supplyradar.domain.commons.TipoPessoa;
import br.com.supplyradar.persistence.model.commons.PessoaEntity;
import br.com.supplyradar.persistence.model.commons.PessoaFisicaEntity;
import br.com.supplyradar.persistence.model.commons.PessoaJuridicaEntity;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor
public class PessoaJuricaEntityFactory {

    @ObjectFactory
    public PessoaEntity build(Pessoa pessoa) {
        assert pessoa instanceof  PessoaJuridica;
        PessoaJuridicaEntity pessoaEntity = new PessoaJuridicaEntity();
        pessoaEntity.setId(pessoa.getId());
        pessoaEntity.setDateOfCreate(pessoa.getDateOfCreate());
        pessoaEntity.setDateOfChange(pessoa.getDateOfChange());
        pessoaEntity.setAtivo(pessoa.isAtivo());
        pessoaEntity.setTelefone(pessoa.getTelefone());
        pessoaEntity.setTipo(pessoa.getTipo());
        if(Objects.nonNull(pessoa.getEmail())) {
            pessoaEntity.setEmail(pessoa.getEmail().getAddress());
        }
        pessoaEntity.setCnpj(((PessoaJuridica)pessoa).getCnpj().getNumber());
        pessoaEntity.setRazaoSocial(((PessoaJuridica)pessoa).getRazaoSocial());
        pessoaEntity.setInscricaoEstadual(((PessoaJuridica)pessoa).getInscricaoEstadual());
        pessoaEntity.setNomeFantasia(((PessoaJuridica)pessoa).getNomeFantasia());
        pessoaEntity.setWebsite(((PessoaJuridica)pessoa).getWebsite());

        return pessoaEntity;
    }
}
