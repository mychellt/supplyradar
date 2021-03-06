package br.com.supplyradar.six2six.fixture.templates.domain.commons;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.*;

import java.time.LocalDateTime;
import java.util.UUID;

public class UsinaTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(Usina.class).addTemplate("valido", new Rule() {
            {
                add("dateOfChange", LocalDateTime.now());
                add("dateOfCreate", LocalDateTime.now());
                add("situacao", SituacaoCadastro.AGUARDANDO_ASSINATURA_CONTRATO);
                add("pessoa", one(PessoaJuridica.class, "valido"));
                add("tipo", TipoUsina.EOLICA_OFFSHORE);
            }
        });

        Fixture.of(Usina.class).addTemplate("valido-com-id").inherits("valido", new Rule(){
            {
                add("id", UUID.randomUUID());
            }
        });
    }
}
