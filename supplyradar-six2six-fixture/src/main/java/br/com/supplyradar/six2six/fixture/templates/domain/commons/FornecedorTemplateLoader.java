package br.com.supplyradar.six2six.fixture.templates.domain.commons;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.*;

import java.time.LocalDateTime;
import java.util.UUID;

public class FornecedorTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(Fornecedor.class).addTemplate("valido", new Rule() {
            {
                add("dateOfChange", LocalDateTime.now());
                add("dateOfCreate", LocalDateTime.now());
                add("ativo", Boolean.TRUE);
                add("administrador", one(Usuario.class, "valido-pessoa-juridica"));
                add("atendimento", Atendimento.builder().atendimento24Horas(true).contingencia(true).build());
                add("atuacao", Atuacao.builder().resumo("fake-resumo").descricao("fake-descricao").build());
            }
        });

        Fixture.of(Fornecedor.class).addTemplate("valido-com-id").inherits("valido", new Rule(){
            {
                add("id", UUID.randomUUID());
            }
        });
    }
}
