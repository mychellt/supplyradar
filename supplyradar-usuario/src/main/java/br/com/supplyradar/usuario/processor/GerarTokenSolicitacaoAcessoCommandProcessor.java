package br.com.supplyradar.usuario.processor;

import br.com.fluentvalidator.context.Error;
import br.com.fluentvalidator.context.ValidationResult;
import br.com.supplyradar.core.command.Command;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.core.persistence.TokenSolicitacaoAcessoRepository;
import br.com.supplyradar.domain.commons.SolicitacaoAcesso;
import br.com.supplyradar.domain.commons.TokenSolicitacaoAcesso;
import br.com.supplyradar.domain.exceptions.DomainException;
import br.com.supplyradar.usuario.utils.DateUtils;
import br.com.supplyradar.usuario.utils.MD5Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Component
public class GerarTokenSolicitacaoAcessoCommandProcessor implements Command<TokenSolicitacaoAcesso> {
    private final TokenSolicitacaoAcessoRepository tokenSolicitacaoAcessoRepository;

    @Override
    public TokenSolicitacaoAcesso process(final CommandContext context) {
        final SolicitacaoAcesso solicitacao = context.getData(SolicitacaoAcesso.class);
        final String currentDateFormatted = DateUtils.formatCurrentDate("yyyyMMddHHmmss");

        try {
            TokenSolicitacaoAcesso token = new TokenSolicitacaoAcesso();
            token.setExpirado(false);
            token.setKey(createKeyWithMD5(currentDateFormatted));
            token.setSolicitacao(solicitacao);
            token.setAtivo(Boolean.TRUE);
            token.setDateOfChange(LocalDateTime.now());
            token.setDateOfCreate(LocalDateTime.now());

            token = tokenSolicitacaoAcessoRepository.save(token);
            return token;

        } catch (final NoSuchAlgorithmException e) {
            final Error error = Error.create(null, "Erro inesperado durante a geração do token de acesso", "500", null);
            throw new DomainException(ValidationResult.fail(List.of(error)));
        }
    }

    private String createKeyWithMD5(final String info) throws NoSuchAlgorithmException {
        return MD5Utils.md5("tokenSolicitacaoAcesso$$" + info);
    }
}
