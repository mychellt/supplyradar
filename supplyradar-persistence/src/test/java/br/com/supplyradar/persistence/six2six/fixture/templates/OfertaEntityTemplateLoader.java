package br.com.supplyradar.persistence.six2six.fixture.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.assinatura.TipoAssinatura;
import br.com.supplyradar.domain.processo.TipoCategoria;
import br.com.supplyradar.persistence.model.assinatura.OfertaEntity;
import br.com.supplyradar.persistence.model.commons.PessoaEntity;
import br.com.supplyradar.persistence.model.commons.PessoaJuridicaEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class OfertaEntityTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(OfertaEntity.class).addTemplate("valido", new Rule() {
            {
                add("valor", BigDecimal.TEN);
                add("quantidadeServicosPermitida", 1);
                add("tipoAssinatura", TipoAssinatura.INDETERMINATE);
                add("tipoCategoria", TipoCategoria.PRODUTO);
                add("ilimitado", Boolean.TRUE);
                add("taxa", BigDecimal.TEN);
                add("pessoa", one(PessoaJuridicaEntity.class, "valido"));
                add("validade", LocalDate.now());
            }
        });

        Fixture.of(OfertaEntity.class).addTemplate("valido-com-id").inherits("valido", new Rule() {
            {
                add("id", UUID.randomUUID());
            }
        });
    }
}
