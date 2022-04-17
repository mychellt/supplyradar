package br.com.supplyradar.six2six.fixture.templates.domain.commons;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.SolicitacaoAcesso;
import br.com.supplyradar.domain.commons.Usuario;

import java.time.LocalDateTime;
import java.util.UUID;

public class SolicitacaoAcessoTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(SolicitacaoAcesso.class).addTemplate("valido", new Rule() {
            {
                add("usuario", one(Usuario.class, "valido"));
                add("dateOfChange", LocalDateTime.now());
                add("dateOfCreate", LocalDateTime.now());
                add("ativo", Boolean.TRUE.toString());
            }
        });
        Fixture.of(SolicitacaoAcesso.class).addTemplate("valido-com-id").inherits("valido", new Rule() {
            {
                add("id", UUID.randomUUID());
                add("usuario", one(Usuario.class, "valido-com-id"));
            }
        });
    }
}
