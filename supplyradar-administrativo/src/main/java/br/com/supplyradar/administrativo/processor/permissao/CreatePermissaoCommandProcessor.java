package br.com.supplyradar.administrativo.processor.permissao;

import br.com.supplyradar.core.command.Command;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.core.persistence.PermissaoRepository;
import br.com.supplyradar.domain.commons.Permissao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePermissaoCommandProcessor implements Command<Permissao> {
    private final PermissaoRepository permissaoRepository;

    @Override
    public Permissao process(CommandContext context) {
        final Permissao permissao = context.getData(Permissao.class);
        return permissaoRepository.save(permissao);
    }
}
