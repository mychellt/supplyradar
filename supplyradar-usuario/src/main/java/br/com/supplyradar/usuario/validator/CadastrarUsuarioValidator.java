package br.com.supplyradar.usuario.validator;

import br.com.fluentvalidator.AbstractValidator;
import br.com.supplyradar.usuario.dto.CreateUsuarioDTO;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;

@Component
public class CadastrarUsuarioValidator extends AbstractValidator<CreateUsuarioDTO> {
    @Override
    public void rules() {
        ruleFor(user -> user)
                .must(not(stringEmptyOrNull(CreateUsuarioDTO::getLogin)))
                .withMessage("Campo obrigatório não informado")
                .withAttempedValue(CreateUsuarioDTO::getLogin)
                .critical();

        ruleFor(user -> user)
                .must(not(stringEmptyOrNull(CreateUsuarioDTO::getSenha)))
                .withMessage("Campo obrigatório não informado")
                .withAttempedValue(CreateUsuarioDTO::getSenha)
                .critical();

        ruleFor(user -> user)
                .must(not(stringEmptyOrNull(CreateUsuarioDTO::getSenhaConfirmacao)))
                .withMessage("Campo obrigatório não informado")
                .withAttempedValue(CreateUsuarioDTO::getSenhaConfirmacao)
                .critical();

        ruleFor(user -> user)
                .must(not(stringEmptyOrNull(CreateUsuarioDTO::getEmail)))
                .withMessage("Campo obrigatório não informado")
                .withAttempedValue(CreateUsuarioDTO::getEmail)
                .critical();

        ruleFor(user -> user)
                .must(not(stringEmptyOrNull(CreateUsuarioDTO::getEmailConfirmacao)))
                .withMessage("Campo obrigatório não informado")
                .withAttempedValue(CreateUsuarioDTO::getEmailConfirmacao)
                .critical();

        ruleFor(user -> user)
                .must(not(stringEmptyOrNull(CreateUsuarioDTO::getNome)))
                .withMessage("Campo obrigatório não informado")
                .withAttempedValue(CreateUsuarioDTO::getNome)
                .critical();

        ruleFor(user -> user)
                .must(not(stringEmptyOrNull(CreateUsuarioDTO::getTelefone)))
                .withMessage("Campo obrigatório não informado")
                .withAttempedValue(CreateUsuarioDTO::getTelefone)
                .critical();


        ruleFor(user -> user)
                .must(Predicate.not(stringEmptyOrNull(CreateUsuarioDTO::getCpf)))
                .when(CreateUsuarioDTO::isNotEstrangeiro)
                .withMessage("Campo obrigatório não informado")
                .withAttempedValue(CreateUsuarioDTO::getCpf)
                .critical();

        ruleFor(user -> user)
                .must(Predicate.not(stringEmptyOrNull(CreateUsuarioDTO::getPassaporte)))
                .when(CreateUsuarioDTO::isEstrangeiro)
                .withMessage("Campo obrigatório não informado")
                .withAttempedValue(CreateUsuarioDTO::getPassaporte)
                .critical();
    }
}