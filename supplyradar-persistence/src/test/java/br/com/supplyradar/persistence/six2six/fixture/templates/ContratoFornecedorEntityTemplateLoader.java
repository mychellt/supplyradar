package br.com.supplyradar.persistence.six2six.fixture.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.assinatura.ContratoFornecedor;
import br.com.supplyradar.domain.commons.Fornecedor;
import br.com.supplyradar.persistence.model.assinatura.ContratoFornecedorEntity;
import br.com.supplyradar.persistence.model.commons.CidadeEntity;
import br.com.supplyradar.persistence.model.commons.FornecedorEntity;
import br.com.supplyradar.persistence.model.commons.UnidadeFederativaEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class ContratoFornecedorEntityTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(ContratoFornecedorEntity.class).addTemplate("valido", new Rule() {
            {
                add("fornecedor", one(FornecedorEntity.class, "valido"));
                add("ativo", Boolean.TRUE);
                add("dateOfCreate", LocalDateTime.now());
                add("dateOfChange", LocalDateTime.now());
            }
        });
    }
}
