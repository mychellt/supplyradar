package br.com.supplyradar.usuario.processor;

import br.com.fluentvalidator.context.Error;
import br.com.fluentvalidator.context.ValidationResult;
import br.com.supplyradar.core.command.Command;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.core.persistence.UsuarioRepository;
import br.com.supplyradar.domain.commons.TokenSolicitacaoAcesso;
import br.com.supplyradar.domain.commons.Usuario;
import br.com.supplyradar.domain.exceptions.DomainException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class AutorizarUsuarioCommandProcessor implements Command<Void> {
    private final UsuarioRepository usuarioRepository;

    @Override
    public Void process(CommandContext context) {
        final TokenSolicitacaoAcesso tokenSolicitacaoAcesso = context.getData(TokenSolicitacaoAcesso.class);

        Usuario usuario = usuarioRepository.findByTokenSolicitacaoAcesso(tokenSolicitacaoAcesso);

        if(isNull(usuario)){
            final Error error = Error.create(null, "Não existe solicitação de acesso associada ao token informado", HttpStatus.BAD_REQUEST.toString(), null);
            throw new DomainException(ValidationResult.fail(List.of(error)));
        }

        usuarioRepository.autorizar(usuario);
        return null;
    }


}
