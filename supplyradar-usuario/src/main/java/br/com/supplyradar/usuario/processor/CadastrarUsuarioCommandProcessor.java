package br.com.supplyradar.usuario.processor;

import br.com.supplyradar.core.command.Command;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.domain.commons.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarUsuarioCommandProcessor implements Command<Usuario> {

    @Override
    public Usuario process(CommandContext context) {
        return null;
    }

}
