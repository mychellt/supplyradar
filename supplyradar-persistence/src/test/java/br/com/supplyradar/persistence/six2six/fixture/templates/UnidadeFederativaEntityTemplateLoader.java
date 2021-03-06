package br.com.supplyradar.persistence.six2six.fixture.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.persistence.model.commons.UnidadeFederativaEntity;

import java.util.UUID;

public class UnidadeFederativaEntityTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(UnidadeFederativaEntity.class).addTemplate("valido", new Rule() {
            {
                add("id", UUID.randomUUID());
                add("nome", "nome-unidade-federativa-valido");
                add("sigla", "sigla-unidade-federativa-valido");
            }
        });
    }
}
