package br.com.supplyradar.administrativo.validator;

import br.com.fluentvalidator.AbstractValidator;
import br.com.supplyradar.administrativo.dto.PermissaoDTO;
import org.springframework.stereotype.Component;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;


@Component
public class PermissaoMandatoryFieldValidator extends AbstractValidator<PermissaoDTO> {
    @Override
    public void rules() {
        ruleFor(permissao -> permissao)
                .must(not(stringEmptyOrNull(PermissaoDTO::getSigla)))
                .withMessage("Campo obrigatório não informado")
                .withAttempedValue(PermissaoDTO::getSigla)
                .critical();
    }
}
