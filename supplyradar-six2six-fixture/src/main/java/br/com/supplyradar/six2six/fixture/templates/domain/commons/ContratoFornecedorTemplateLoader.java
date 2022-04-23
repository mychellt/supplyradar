package br.com.supplyradar.six2six.fixture.templates.domain.commons;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.assinatura.ContratoFornecedor;
import br.com.supplyradar.domain.commons.Fornecedor;

import java.time.LocalDateTime;

public class ContratoFornecedorTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(ContratoFornecedor.class).addTemplate("valido", new Rule() {
            {
                add("fornecedor", one(Fornecedor.class, "valido"));
                add("ativo", Boolean.TRUE);
                add("dateOfCreate", LocalDateTime.now());
                add("dateOfChange", LocalDateTime.now());
            }
        });
    }
}
