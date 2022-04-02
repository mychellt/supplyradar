package br.com.supplyradar.persistence.six2six.fixture.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.TipoAtribuicao;
import br.com.supplyradar.persistence.model.commons.PermissaoEntity;

public class PermissaoEntityTemplateLoader implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(PermissaoEntity.class).addTemplate("valido", new Rule() {
            {
                add("sigla", "ROLE_DEFAULT");
                add("nome", "permissao default");
                add("descricao", "descricao default");
                add("ordem", 0);
                add("tipo", TipoAtribuicao.TODOS);
            }
        });
    }
}
