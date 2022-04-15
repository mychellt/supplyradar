package br.com.supplyradar.six2six.fixture.templates.domain.commons;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.UnidadeFederativa;

import java.util.UUID;

public class UnidadeFederativaTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(UnidadeFederativa.class).addTemplate("valido", new Rule() {
            {
                add("nome", "nome-unidade-federativa-valido");
                add("sigla", "sigla-unidade-federativa-valido");
            }
        });
    }
}
