package br.com.supplyradar.persistence.six2six.fixture.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.assinatura.ContratoFornecedor;
import br.com.supplyradar.domain.commons.Atendimento;
import br.com.supplyradar.domain.commons.Atuacao;
import br.com.supplyradar.domain.commons.Fornecedor;
import br.com.supplyradar.persistence.model.assinatura.ContratoFornecedorEntity;
import br.com.supplyradar.persistence.model.commons.AtendimentoEntity;
import br.com.supplyradar.persistence.model.commons.AtuacaoEntity;
import br.com.supplyradar.persistence.model.commons.FornecedorEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class FornecedorEntityTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(FornecedorEntity.class).addTemplate("valido", new Rule() {
            {
                add("dateOfChange", LocalDateTime.now());
                add("dateOfCreate", LocalDateTime.now());
                add("atuacao", AtuacaoEntity.builder().descricao("fake-descricao").resumo("fake-resumo").build());
                add("atendimento", AtendimentoEntity.builder().contingencia(Boolean.TRUE).atendimento24Horas(Boolean.TRUE).build());
//                add("contrato", one(ContratoFornecedorEntity.class, "valido"));
                add("ativo", Boolean.TRUE);
            }
        });

        Fixture.of(FornecedorEntity.class).addTemplate("valido-com-id").inherits("valido", new Rule(){
            {
                add("id", UUID.randomUUID());
            }
        });
    }
}
