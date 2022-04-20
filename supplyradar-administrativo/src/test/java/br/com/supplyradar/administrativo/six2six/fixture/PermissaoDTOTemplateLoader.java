package br.com.supplyradar.administrativo.six2six.fixture;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.TipoAtribuicao;
import br.com.supplyradar.administrativo.dto.PermissaoDTO;

public class PermissaoDTOTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(PermissaoDTO.class).addTemplate("valido", new Rule() {
            {
                add("sigla", "ROLE_DEFAULT");
                add("nome", "fake-nome");
                add("descricao", "fake-descricao");
                add("ordem", 0);
                add("tipo", TipoAtribuicao.TODOS);
            }
        });
    }
}
