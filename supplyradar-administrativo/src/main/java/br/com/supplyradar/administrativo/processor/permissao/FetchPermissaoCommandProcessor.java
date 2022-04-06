package br.com.supplyradar.administrativo.processor.permissao;

import br.com.fluentvalidator.context.Error;
import br.com.fluentvalidator.context.ValidationResult;
import br.com.supplyradar.core.command.Command;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.core.persistence.PermissaoRepository;
import br.com.supplyradar.domain.commons.Permissao;
import br.com.supplyradar.domain.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FetchPermissaoCommandProcessor implements Command<Permissao> {
    private final PermissaoRepository permissaoRepository;

    @Override
    public Permissao process(CommandContext context) {
        UUID id = context.getProperty("id", UUID.class);
        final Optional<Permissao> optionalPermissao = permissaoRepository.findOne(id);
        if(optionalPermissao.isEmpty()){
            final Error error = Error.create("id", "Registro não encontrado", "404", null);
            throw new ObjectNotFoundException(ValidationResult.fail(List.of(error)));
        }
        return optionalPermissao.get();
    }
}
