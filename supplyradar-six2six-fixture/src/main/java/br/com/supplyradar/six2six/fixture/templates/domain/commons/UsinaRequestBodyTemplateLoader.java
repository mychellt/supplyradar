package br.com.supplyradar.six2six.fixture.templates.domain.commons;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.CreateUsuario;
import br.com.supplyradar.domain.commons.Endereco;
import br.com.supplyradar.domain.commons.UsinaRequestBody;

public class UsinaRequestBodyTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(UsinaRequestBody.class).addTemplate("valido", new Rule() {
            {
                add("cnpj", "000.000.00-0000/00");
                add("inscricaoEstadual", "123456789");
                add("razaoSocial", "fake-razao-social");
                add("website", "http://website.com");
                add("endereco", one(Endereco.class, "valido"));
            }
        });

        Fixture.of(UsinaRequestBody.class).addTemplate("invalido-sem-cnpj").inherits("valido", new Rule() {
            {
                add("cnpj", null);
            }
        });

        Fixture.of(UsinaRequestBody.class).addTemplate("invalido-sem-razao-social").inherits("valido", new Rule() {
            {
                add("razaoSocial", null);
            }
        });

        Fixture.of(UsinaRequestBody.class).addTemplate("invalido-sem-cep").inherits("valido", new Rule() {
            {
                add("endereco", one(Endereco.class, "invalido-sem-cep"));
            }
        });

        Fixture.of(UsinaRequestBody.class).addTemplate("invalido-sem-numero").inherits("valido", new Rule() {
            {
                add("endereco", one(Endereco.class, "invalido-sem-numero"));
            }
        });

        Fixture.of(UsinaRequestBody.class).addTemplate("invalido-sem-logradouro").inherits("valido", new Rule() {
            {
                add("endereco", one(Endereco.class, "invalido-sem-logradouro"));
            }
        });

        Fixture.of(UsinaRequestBody.class).addTemplate("invalido-sem-bairro").inherits("valido", new Rule() {
            {
                add("endereco", one(Endereco.class, "invalido-sem-bairro"));
            }
        });

        Fixture.of(UsinaRequestBody.class).addTemplate("invalido-sem-id-cidade").inherits("valido", new Rule() {
            {
                add("endereco", one(Endereco.class, "invalido-sem-id-cidade"));
            }
        });
    }
}
