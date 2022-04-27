package br.com.supplyradar.usuario.processor;

import br.com.supplyradar.core.command.Command;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.domain.commons.Fornecedor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CriarFornecedorCommandProcessor implements Command<Fornecedor> {
    @Override
    public Fornecedor process(CommandContext context) {
        return null;
    }
}
