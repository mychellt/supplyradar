package br.com.supplyradar.persistence.six2six.fixture.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.TokenSolicitacaoAcesso;
import br.com.supplyradar.persistence.model.commons.SolicitacaoAcessoEntity;
import br.com.supplyradar.persistence.model.commons.TokenSolicitacaoAcessoEntity;

public class TokenSolicitacaoAcessoEntityTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(TokenSolicitacaoAcessoEntity.class).addTemplate("valido", new Rule() {
            {

            }
        });
    }
}
