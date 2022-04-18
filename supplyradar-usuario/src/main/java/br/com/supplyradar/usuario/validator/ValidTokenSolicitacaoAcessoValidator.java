package br.com.supplyradar.usuario.validator;

import br.com.fluentvalidator.AbstractValidator;
import br.com.fluentvalidator.predicate.ObjectPredicate;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;

@Component
public class ValidTokenSolicitacaoAcessoValidator extends AbstractValidator<UUID> {

    @Override
    public void rules() {
        ruleFor(UUID::toString)
                .must(not(String::isBlank))
                .withMessage("Chave de verificação inválida")
                .withAttempedValue(String::valueOf)
                .withFieldName("key")
                .critical();

        ruleFor(key -> key)
                .must(ObjectPredicate.instanceOf(UUID.class))
                .withMessage("Chave de verificação inválida")
                .withFieldName("key")
                .withAttempedValue(String::valueOf)
                .critical();
    }
}
