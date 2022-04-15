package br.com.supplyradar.six2six.fixture.templates.domain.commons;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.Cidade;
import br.com.supplyradar.domain.commons.UnidadeFederativa;

import java.util.UUID;

public class CidadeTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(Cidade.class).addTemplate("valido", new Rule() {
            {
                add("id", UUID.randomUUID());
                add("unidadeFederativa", one(UnidadeFederativa.class, "valido"));
                add("nome", "nome-cidade-valido");
            }
        });
    }
}
