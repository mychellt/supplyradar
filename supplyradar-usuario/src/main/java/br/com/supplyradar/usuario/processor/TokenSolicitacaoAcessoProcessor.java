package br.com.supplyradar.usuario.processor;

import br.com.supplyradar.core.command.Command;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.domain.commons.TokenSolicitacaoAcesso;
import org.springframework.stereotype.Component;

@Component
public class TokenSolicitacaoAcessoProcessor implements Command<TokenSolicitacaoAcesso> {

    @Override
    public TokenSolicitacaoAcesso process(CommandContext context) {
        return null;
    }
}
