package br.com.supplyradar.usuario.validator;

import br.com.fluentvalidator.AbstractValidator;
import br.com.supplyradar.usuario.dto.EnderecoDTO;
import br.com.supplyradar.usuario.dto.FornecedorRequestBodyDTO;
import br.com.supplyradar.usuario.dto.UsinaRequestBodyDTO;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import static java.util.Optional.ofNullable;

@Component
public class CriarFornecedorValidator extends AbstractValidator<FornecedorRequestBodyDTO> {
    @Override
    public void rules() {
        ruleFor(body -> body)
                .must(not(stringEmptyOrNull(FornecedorRequestBodyDTO::getCnpj)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("cnpj")
                .withAttempedValue(FornecedorRequestBodyDTO::getCnpj)
                .critical();

        ruleFor(body -> body)
                .must(not(stringEmptyOrNull(FornecedorRequestBodyDTO::getRazaoSocial)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("razao_social")
                .withAttempedValue(FornecedorRequestBodyDTO::getRazaoSocial)
                .critical();

        ruleFor(body -> body)
                .must(not(stringEmptyOrNull(FornecedorRequestBodyDTO::getNomeFantasia)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("nome_fantasia")
                .withAttempedValue(FornecedorRequestBodyDTO::getNomeFantasia)
                .critical();

        ruleFor(body -> body)
                .must(not(stringEmptyOrNull(FornecedorRequestBodyDTO::getTelefone)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("telefone")
                .withAttempedValue(FornecedorRequestBodyDTO::getTelefone)
                .critical();

        ruleFor(body -> body)
                .must(not(stringEmptyOrNull(FornecedorRequestBodyDTO::getFornecimentos)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("fornecimentos")
                .withAttempedValue(FornecedorRequestBodyDTO::getFornecimentos)
                .critical();

        ruleFor(body -> body)
                .must(not(stringEmptyOrNull(FornecedorRequestBodyDTO::getExperiencias)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("fornecimentos")
                .withAttempedValue(FornecedorRequestBodyDTO::getExperiencias)
                .critical();

        rulesForEndereco();
    }

    private void rulesForEndereco() {
        ruleFor(FornecedorRequestBodyDTO::getEndereco)
                .must(Objects::nonNull)
                .withMessage("Campo obrigatório não informado")
                .withFieldName("endereco")
                .critical();

        ruleFor(FornecedorRequestBodyDTO::getEndereco)
                .must(not(stringEmptyOrNull(EnderecoDTO::getBairro)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("endereco.bairro")
                .withAttempedValue(e -> ofNullable(e.getEndereco()).map(EnderecoDTO::getBairro).orElse(""))
                .critical();

        ruleFor(FornecedorRequestBodyDTO::getEndereco)
                .must(not(stringEmptyOrNull(EnderecoDTO::getNumero)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("endereco.numero")
                .withAttempedValue(e -> ofNullable(e.getEndereco()).map(EnderecoDTO::getNumero).orElse(""))
                .critical();

        ruleFor(FornecedorRequestBodyDTO::getEndereco)
                .must(not(stringEmptyOrNull(EnderecoDTO::getCep)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("endereco.cep")
                .withAttempedValue(e -> ofNullable(e.getEndereco()).map(EnderecoDTO::getCep).orElse(""))
                .critical();

        ruleFor(FornecedorRequestBodyDTO::getEndereco)
                .must(not(stringEmptyOrNull(EnderecoDTO::getLogradouro)))
                .withMessage("Campo obrigatório não informado")
                .withFieldName("endereco.logradouro")
                .withAttempedValue(e -> ofNullable(e.getEndereco()).map(EnderecoDTO::getLogradouro).orElse(""))
                .critical();

        ruleFor(FornecedorRequestBodyDTO::getEndereco)
                .must(e -> e.getIdCidade() != null)
                .when(Objects::nonNull)
                .withMessage("Campo obrigatório não informado ou inválido")
                .withFieldName("endereco.idCidade")
                .withAttempedValue(e -> ofNullable(e.getEndereco()).map(EnderecoDTO::getIdCidade).orElse(null))
                .critical();
    }
}
