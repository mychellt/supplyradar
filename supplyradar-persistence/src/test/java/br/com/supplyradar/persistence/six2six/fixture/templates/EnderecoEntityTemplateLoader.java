package br.com.supplyradar.persistence.six2six.fixture.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.TipoEndereco;
import br.com.supplyradar.persistence.model.commons.CidadeEntity;
import br.com.supplyradar.persistence.model.commons.EnderecoEntity;
import br.com.supplyradar.persistence.model.commons.PessoaEntity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

public class EnderecoEntityTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(EnderecoEntity.class).addTemplate("valido", new Rule() {
            {
               add("logradouro","logradouro-endereco-valido");
               add("cep", "cep-endereco-valido");
               add("numero", "numero-endereco-valido");
               add("complemento", "complemento-endereco-valido");
               add("bairro", "bairro-endereco-valido");
               add("cidade", one(CidadeEntity.class, "valido"));
               add("tipo", TipoEndereco.COMERCIAL);
            }
        });
    }
}
