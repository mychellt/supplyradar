package br.com.supplyradar.persistence.six2six.fixture.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.PessoaJuridica;
import br.com.supplyradar.domain.commons.SituacaoCadastro;
import br.com.supplyradar.domain.commons.TipoUsina;
import br.com.supplyradar.domain.commons.Usina;
import br.com.supplyradar.persistence.model.commons.PessoaJuridicaEntity;
import br.com.supplyradar.persistence.model.commons.UsinaEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class UsinaTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(UsinaEntity.class).addTemplate("valido", new Rule() {
            {
                add("dateOfChange", LocalDateTime.now());
                add("dateOfCreate", LocalDateTime.now());
                add("situacao", SituacaoCadastro.AGUARDANDO_ASSINATURA_CONTRATO);
                add("pessoa", one(PessoaJuridicaEntity.class, "valido"));
                add("tipo", TipoUsina.EOLICA_OFFSHORE);
            }
        });

        Fixture.of(UsinaEntity.class).addTemplate("valido-com-id").inherits("valido", new Rule(){
            {
                add("id", UUID.randomUUID());
            }
        });
    }
}
