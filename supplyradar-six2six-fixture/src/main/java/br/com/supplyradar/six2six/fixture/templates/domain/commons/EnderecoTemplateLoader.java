package br.com.supplyradar.six2six.fixture.templates.domain.commons;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.Cidade;
import br.com.supplyradar.domain.commons.Endereco;
import br.com.supplyradar.domain.commons.TipoEndereco;

import java.util.UUID;

public class EnderecoTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(Endereco.class).addTemplate("valido", new Rule() {
            {
                add("id", UUID.randomUUID());
                add("logradouro", "logradouro-endereco-valido");
                add("cep", "cep-endereco-valido");
                add("numero", "numero-endereco-valido");
                add("complemento", "complemento-endereco-valido");
                add("bairro", "bairro-endereco-valido");
                add("cidade", one(Cidade.class, "valido"));
                add("tipo", TipoEndereco.COMERCIAL);
            }
        });
    }
}
