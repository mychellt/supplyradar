package br.com.supplyradar.persistence.mapper.factory;

import br.com.supplyradar.domain.commons.*;
import br.com.supplyradar.persistence.adapter.jpa.PessoaJpaRepository;
import br.com.supplyradar.persistence.model.commons.PessoaEntity;
import br.com.supplyradar.persistence.model.commons.PessoaFisicaEntity;
import br.com.supplyradar.persistence.model.commons.PessoaJuridicaEntity;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PessoaFactory {

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

        if(pessoa.isPessoaFisica()){
            assert pessoa instanceof PessoaFisica;
            ((PessoaFisica)pessoa).setNome(((PessoaFisicaEntity)pessoaEntity).getNome());
            ((PessoaFisica)pessoa).setCpfPassaporte(((PessoaFisicaEntity)pessoaEntity).getCpfPassaporte());
            ((PessoaFisica)pessoa).setPassaporte(((PessoaFisicaEntity)pessoaEntity).isPassaporte());
        }
        else {
            assert pessoa instanceof PessoaJuridica;
            ((PessoaJuridica)pessoa).setCnpj(Cnpj.builder().number(((PessoaJuridicaEntity)pessoaEntity).getCnpj()).build());
            ((PessoaJuridica)pessoa).setRazaoSocial(((PessoaJuridicaEntity)pessoaEntity).getRazaoSocial());
            ((PessoaJuridica)pessoa).setInscricaoEstadual(((PessoaJuridicaEntity)pessoaEntity).getInscricaoEstadual());
            ((PessoaJuridica)pessoa).setNomeFantasia(((PessoaJuridicaEntity)pessoaEntity).getNomeFantasia());
            ((PessoaJuridica)pessoa).setWebsite(((PessoaJuridicaEntity)pessoaEntity).getWebsite());
        }
        return pessoa;
    }
}
