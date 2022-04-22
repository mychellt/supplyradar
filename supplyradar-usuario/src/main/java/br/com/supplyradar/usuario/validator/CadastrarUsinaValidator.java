package br.com.supplyradar.usuario.validator;

import br.com.fluentvalidator.AbstractValidator;
import br.com.supplyradar.usuario.dto.EnderecoDTO;
import br.com.supplyradar.usuario.dto.UsinaRequestBodyDTO;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.instanceOf;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import static java.util.Optional.ofNullable;

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
                .must(not(stringEmptyOrNull(UsinaRequestBodyDTO::getNome)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("nome")
                .withAttempedValue(UsinaRequestBodyDTO::getNome)
                .critical();

        ruleFor(body -> body)
                .must(not(stringEmptyOrNull(UsinaRequestBodyDTO::getTipo)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("tipo")
                .withAttempedValue(UsinaRequestBodyDTO::getTipo)
                .critical();

        ruleFor(body -> body)
                .must(not(stringEmptyOrNull(UsinaRequestBodyDTO::getRazaoSocial)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("razaoSocial")
                .withAttempedValue(UsinaRequestBodyDTO::getRazaoSocial)
                .critical();

        rulesForEndereco();
        rulesForEnderecoCorrespondencia();
    }

    private void rulesForEndereco() {
        ruleFor(UsinaRequestBodyDTO::getEndereco)
                .must(Objects::nonNull)
                .withMessage("Campo obrigatório não informado")
                .withFieldName("endereco")
                .critical();

        ruleFor(UsinaRequestBodyDTO::getEndereco)
                .must(not(stringEmptyOrNull(EnderecoDTO::getBairro)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("endereco.bairro")
                .withAttempedValue(e -> ofNullable(e.getEndereco()).map(EnderecoDTO::getBairro).orElse(""))
                .critical();

        ruleFor(UsinaRequestBodyDTO::getEndereco)
                .must(not(stringEmptyOrNull(EnderecoDTO::getNumero)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("endereco.numero")
                .withAttempedValue(e -> ofNullable(e.getEndereco()).map(EnderecoDTO::getNumero).orElse(""))
                .critical();

        ruleFor(UsinaRequestBodyDTO::getEndereco)
                .must(not(stringEmptyOrNull(EnderecoDTO::getCep)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("endereco.cep")
                .withAttempedValue(e -> ofNullable(e.getEndereco()).map(EnderecoDTO::getCep).orElse(""))
                .critical();

        ruleFor(UsinaRequestBodyDTO::getEndereco)
                .must(not(stringEmptyOrNull(EnderecoDTO::getLogradouro)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("endereco.logradouro")
                .withAttempedValue(e -> ofNullable(e.getEndereco()).map(EnderecoDTO::getLogradouro).orElse(""))
                .critical();

        ruleFor(body -> ofNullable(body.getEndereco()).map(EnderecoDTO::getIdCidade).orElse(null))
                .must(instanceOf(UUID.class))
                .when(Objects::nonNull)
                .withMessage("Campo obrigatório não informado ou inválido")
                .withFieldName("endereco_correspondencia.idCidade")
                .withAttempedValue(e -> ofNullable(e.getEndereco()).map(EnderecoDTO::getIdCidade).orElse(null))
                .critical();
    }
    private void rulesForEnderecoCorrespondencia() {
        ruleFor(UsinaRequestBodyDTO::getEnderecoCorrespondencia)
                .must(Objects::nonNull)
                .withMessage("Campo obrigatório não informado")
                .withFieldName("endereco_correspondencia")
                .critical();

        ruleFor(UsinaRequestBodyDTO::getEnderecoCorrespondencia)
                .must(not(stringEmptyOrNull(EnderecoDTO::getBairro)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("endereco_correspondencia.bairro")
                .withAttempedValue(e -> ofNullable(e.getEnderecoCorrespondencia()).map(EnderecoDTO::getBairro).orElse(""))
                .critical();

        ruleFor(UsinaRequestBodyDTO::getEnderecoCorrespondencia)
                .must(not(stringEmptyOrNull(EnderecoDTO::getNumero)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("endereco_correspondencia.numero")
                .withAttempedValue(e -> ofNullable(e.getEnderecoCorrespondencia()).map(EnderecoDTO::getNumero).orElse(""))
                .critical();

        ruleFor(UsinaRequestBodyDTO::getEnderecoCorrespondencia)
                .must(not(stringEmptyOrNull(EnderecoDTO::getCep)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("endereco_correspondencia.cep")
                .withAttempedValue(e -> ofNullable(e.getEnderecoCorrespondencia()).map(EnderecoDTO::getCep).orElse(""))
                .critical();

        ruleFor(UsinaRequestBodyDTO::getEnderecoCorrespondencia)
                .must(not(stringEmptyOrNull(EnderecoDTO::getLogradouro)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("endereco_correspondencia.logradouro")
                .withAttempedValue(e -> ofNullable(e.getEnderecoCorrespondencia()).map(EnderecoDTO::getLogradouro).orElse(""))
                .critical();

        ruleFor(body -> ofNullable(body.getEnderecoCorrespondencia()).map(EnderecoDTO::getIdCidade).orElse(null))
                .must(instanceOf(UUID.class))
                .when(Objects::nonNull)
                .withMessage("Campo obrigatório não informado ou inválido")
                .withFieldName("endereco_correspondencia.idCidade")
                .withAttempedValue(e -> ofNullable(e.getEnderecoCorrespondencia()).map(EnderecoDTO::getIdCidade).orElse(null))
                .critical();
    }
}
