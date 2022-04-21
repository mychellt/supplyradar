package br.com.supplyradar.usuario.validator;

import br.com.fluentvalidator.AbstractValidator;
import br.com.supplyradar.usuario.dto.EnderecoDTO;
import br.com.supplyradar.usuario.dto.UsinaRequestBodyDTO;
import org.springframework.stereotype.Component;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;

@Component
public class CadastrarUsinaValidator extends AbstractValidator<UsinaRequestBodyDTO> {
    @Override
    public void rules() {
        ruleFor(body -> body)
                .must(not(stringEmptyOrNull(UsinaRequestBodyDTO::getCnpj)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("cnpj")
                .withAttempedValue(UsinaRequestBodyDTO::getCnpj)
                .critical();

        ruleFor(body -> body)
                .must(not(stringEmptyOrNull(UsinaRequestBodyDTO::getRazaoSocial)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("razaoSocial")
                .withAttempedValue(UsinaRequestBodyDTO::getRazaoSocial)
                .critical();

        ruleFor(UsinaRequestBodyDTO::getEndereco)
                .must(not(stringEmptyOrNull(EnderecoDTO::getBairro)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("endereco.bairro")
                .withAttempedValue(body -> body.getEndereco().getBairro())
                .critical();

        ruleFor(UsinaRequestBodyDTO::getEndereco)
                .must(not(stringEmptyOrNull(EnderecoDTO::getNumero)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("endereco.numero")
                .withAttempedValue(body -> body.getEndereco().getNumero())
                .critical();

        ruleFor(UsinaRequestBodyDTO::getEndereco)
                .must(not(stringEmptyOrNull(EnderecoDTO::getCep)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("endereco.cep")
                .withAttempedValue(body -> body.getEndereco().getCep())
                .critical();

        ruleFor(UsinaRequestBodyDTO::getEndereco)
                .must(not(stringEmptyOrNull(EnderecoDTO::getLogradouro)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("endereco.logradouro")
                .withAttempedValue(body -> body.getEndereco().getLogradouro())
                .critical();

        ruleFor(UsinaRequestBodyDTO::getEndereco)
                .must(not(nullValue(EnderecoDTO::getIdCidade)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("endereco.idCidade")
                .withAttempedValue(body -> body.getEndereco().getIdCidade())
                .critical();
    }
}
