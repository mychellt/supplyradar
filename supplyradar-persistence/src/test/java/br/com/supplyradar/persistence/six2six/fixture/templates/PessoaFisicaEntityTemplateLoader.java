package br.com.supplyradar.persistence.six2six.fixture.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.persistence.model.commons.PessoaEntity;
import br.com.supplyradar.persistence.model.commons.PessoaFisicaEntity;

public class PessoaFisicaEntityTemplateLoader implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(PessoaFisicaEntity.class).addTemplate("valido", new Rule() {
            {
               
            }
        });
    }
}
