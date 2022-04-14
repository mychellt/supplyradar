package br.com.supplyradar.persistence.six2six.fixture.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.persistence.model.commons.PessoaEntity;
import br.com.supplyradar.persistence.model.commons.UsuarioEntity;

public class PessoaEntityTemplateLoader implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(PessoaEntity.class).addTemplate("valido", new Rule() {
            {
               
            }
        });
    }
}
