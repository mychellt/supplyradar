package br.supplyradar.administrativo.processor;

import br.com.supplyradar.core.command.Command;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.domain.commons.Permissao;
import br.supplyradar.administrativo.mapper.PermissaoMapper;
import org.springframework.stereotype.Service;

@Service
public class CreatePermissaoCommandProcessor implements Command<Permissao> {

    @Override
    public Permissao process(CommandContext context) {
        return null;
    }
}
