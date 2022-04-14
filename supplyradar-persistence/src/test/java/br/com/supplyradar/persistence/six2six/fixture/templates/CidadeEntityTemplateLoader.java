package br.com.supplyradar.persistence.six2six.fixture.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.persistence.model.commons.CidadeEntity;
import br.com.supplyradar.persistence.model.commons.UnidadeFederativaEntity;

public class CidadeEntityTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(CidadeEntity.class).addTemplate("valido", new Rule() {
            {
                add("unidadeFederativa", one(UnidadeFederativaEntity.class, "valido"));
                add("nome", "nome-cidade-valido");
            }
        });
    }
}
