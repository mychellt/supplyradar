package br.com.supplyradar.usuario.processor;

import br.com.supplyradar.core.command.Command;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.domain.commons.Usina;
import org.springframework.stereotype.Service;


@Service
public class CadastrarUsinaCommandProcessor implements Command<Usina> {
    @Override
    public Usina process(CommandContext context) {
        return null;
    }
}
