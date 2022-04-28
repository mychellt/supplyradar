package br.com.supplyradar.six2six.fixture.templates.domain.commons;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.assinatura.Oferta;
import br.com.supplyradar.domain.assinatura.TipoAssinatura;
import br.com.supplyradar.domain.commons.PessoaJuridica;
import br.com.supplyradar.domain.processo.TipoCategoria;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class OfertaTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(Oferta.class).addTemplate("valido", new Rule() {
            {
                add("valor", BigDecimal.TEN);
                add("quantidadeServicosPermitida", 1);
                add("tipoAssinatura", TipoAssinatura.INDETERMINATE);
                add("tipoCategoria", TipoCategoria.PRODUTO);
                add("ilimitado", Boolean.TRUE);
                add("taxa", BigDecimal.TEN);
                add("pessoa", one(PessoaJuridica.class, "valido"));
                add("validade", LocalDate.now());
            }
        });

        Fixture.of(Oferta.class).addTemplate("valido-com-id").inherits("valido", new Rule() {
            {
                add("id", UUID.randomUUID());
            }
        });
    }
}
