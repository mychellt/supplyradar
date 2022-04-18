package br.com.supplyradar.six2six.fixture.templates.domain.commons;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.SolicitacaoAcesso;
import br.com.supplyradar.domain.commons.TokenSolicitacaoAcesso;
import br.com.supplyradar.domain.commons.Usuario;

import java.time.LocalDateTime;
import java.util.UUID;

public class TokenSolicitacaoAcessoTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(TokenSolicitacaoAcesso.class).addTemplate("valido", new Rule() {
            {
                add("key", UUID.randomUUID().toString());
                add("expirado", Boolean.FALSE.toString());
                add("solicitacao", one(SolicitacaoAcesso.class, "valido"));
                add("dateOfCreate", LocalDateTime.now());
                add("dateOfChange", LocalDateTime.now());
            }
        });
        Fixture.of(TokenSolicitacaoAcesso.class).addTemplate("valido-com-id").inherits("valido", new Rule() {
            {
                add("id", UUID.randomUUID());
                add("solicitacao", one(SolicitacaoAcesso.class, "valido-com-id"));
            }
        });
    }
}
