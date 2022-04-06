package br.com.supplyradar.administrativo.processor.permissao;

import br.com.supplyradar.core.command.Command;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.core.persistence.PermissaoRepository;
import br.com.supplyradar.domain.commons.Permissao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListPermissaoCommandProcessor implements Command<List<Permissao>> {
    private final PermissaoRepository permissaoRepository;

    @Override
    public List<Permissao> process(CommandContext context) {
       return permissaoRepository.findAll();
    }
}
