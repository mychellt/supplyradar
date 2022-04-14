package br.com.supplyradar.persistence.six2six.fixture.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.persistence.model.commons.SolicitacaoAcessoEntity;
import br.com.supplyradar.persistence.model.commons.UsuarioEntity;

import java.util.UUID;

public class SolicitacaoAcessoEntityTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(SolicitacaoAcessoEntity.class).addTemplate("valido", new Rule() {
            {
                add("id", UUID.randomUUID());
                add("usuario", one(UsuarioEntity.class, "valido"));
            }
        });
    }
}
