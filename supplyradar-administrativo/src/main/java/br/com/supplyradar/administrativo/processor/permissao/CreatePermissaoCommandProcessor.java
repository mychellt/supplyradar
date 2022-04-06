package br.com.supplyradar.administrativo.processor.permissao;

import br.com.supplyradar.core.command.Command;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.core.persistence.PermissaoRepository;
import br.com.supplyradar.domain.commons.Permissao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreatePermissaoCommandProcessor implements Command<Permissao> {
    private final PermissaoRepository permissaoRepository;

    @Override
    public Permissao process(CommandContext context) {
        final Permissao permissao = context.getData(Permissao.class);
        permissao.setDateOfCreate(LocalDateTime.now());
        permissao.setDateOfChange(LocalDateTime.now());
        return permissaoRepository.save(permissao);
    }
}
