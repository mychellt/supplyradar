package br.com.supplyrdar.six2six.fixture.templates.domain.commons;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.Permissao;
import br.com.supplyradar.domain.commons.TipoAtribuicao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@SuppressWarnings("java:S1171")
public class PermissaoTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(Permissao.class).addTemplate("valido", new Rule() {
            {
                add("sigla", "ROLE_DEFAULT");
                add("nome", "permissao default");
                add("descricao", "descricao default");
                add("ordem", 0);
                add("tipo", TipoAtribuicao.TODOS);
                add("dateOfChange", LocalDateTime.now());
                add("dateOfCreate", LocalDateTime.now());
            }
        });

        Fixture.of(Permissao.class).addTemplate("invalido-sem-sigla").inherits("valido", new Rule() {
            {
                add("sigla", null);
            }
        });

        Fixture.of(Permissao.class).addTemplate("invalido-sem-nome").inherits("valido", new Rule() {
            {
                add("nome", null);
            }
        });

        Fixture.of(Permissao.class).addTemplate("invalido-sem-descricao").inherits("valido", new Rule() {
            {
                add("descricao", null);
            }
        });
    }
}