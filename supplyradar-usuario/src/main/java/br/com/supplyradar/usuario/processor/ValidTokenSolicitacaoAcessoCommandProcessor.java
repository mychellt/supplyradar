package br.com.supplyradar.usuario.processor;

import br.com.fluentvalidator.context.Error;
import br.com.fluentvalidator.context.ValidationResult;
import br.com.supplyradar.core.command.Command;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.core.persistence.TokenSolicitacaoAcessoRepository;
import br.com.supplyradar.core.utils.CoreUtils;
import br.com.supplyradar.domain.commons.TokenSolicitacaoAcesso;
import br.com.supplyradar.domain.exceptions.DomainException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ValidTokenSolicitacaoAcessoCommandProcessor implements Command<TokenSolicitacaoAcesso> {
    private final TokenSolicitacaoAcessoRepository tokenSolicitacaoAcessoRepository;
    private final AutorizarUsuarioCommandProcessor autorizarUsuarioCommandProcessor;

    @Override
    public TokenSolicitacaoAcesso process(CommandContext context) {
        final String key = context.getData(String.class);

        TokenSolicitacaoAcesso tokenSolicitacaoAcesso = tokenSolicitacaoAcessoRepository.findByKey(key);

        if(CoreUtils.isNotValid(tokenSolicitacaoAcesso)) {
            final Error error = Error.create(null, "Código de autenticação inváido", HttpStatus.BAD_REQUEST.toString(), null);
            throw new DomainException(ValidationResult.fail(List.of(error)));
        }

        if(tokenSolicitacaoAcesso.isExpirado()) {
            final Error error = Error.create(null, "O cadastro já foi confirmado anteriormente", HttpStatus.BAD_REQUEST.toString(), null);
            throw new DomainException(ValidationResult.fail(List.of(error)));
        }

        tokenSolicitacaoAcesso.setExpirado(Boolean.TRUE);
        tokenSolicitacaoAcessoRepository.save(tokenSolicitacaoAcesso);

        final CommandContext commandContext = new CommandContext();
        commandContext.setData(tokenSolicitacaoAcesso);

        autorizarUsuarioCommandProcessor.process(commandContext);
        return tokenSolicitacaoAcesso;
    }
}
