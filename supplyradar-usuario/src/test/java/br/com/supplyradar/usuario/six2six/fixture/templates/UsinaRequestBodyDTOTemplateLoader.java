package br.com.supplyradar.usuario.six2six.fixture.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.CreateUsuario;
import br.com.supplyradar.domain.commons.Endereco;
import br.com.supplyradar.usuario.dto.UsinaRequestBodyDTO;
import br.com.supplyradar.usuario.dto.EnderecoDTO;

public class UsinaRequestBodyDTOTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(UsinaRequestBodyDTO.class).addTemplate("valido", new Rule() {
            {
               add("cnpj", "000.000.00-0000/00");
               add("inscricaoEstadual", "123456789");
               add("razaoSocial", "fake-razao-social");
               add("website", "http://website.com");
               add("endereco", one(EnderecoDTO.class, "valido"));
            }
        });

        Fixture.of(UsinaRequestBodyDTO.class).addTemplate("invalido-sem-cnpj").inherits("valido", new Rule() {
            {
                add("cnpj", null);
            }
        });

        Fixture.of(UsinaRequestBodyDTO.class).addTemplate("invalido-sem-razao-social").inherits("valido", new Rule() {
            {
                add("razaoSocial", null);
            }
        });

        Fixture.of(UsinaRequestBodyDTO.class).addTemplate("invalido-sem-cep").inherits("valido", new Rule() {
            {
                add("endereco", one(EnderecoDTO.class, "invalido-sem-cep"));
            }
        });

        Fixture.of(UsinaRequestBodyDTO.class).addTemplate("invalido-sem-numero").inherits("valido", new Rule() {
            {
                add("endereco", one(EnderecoDTO.class, "invalido-sem-numero"));
            }
        });

        Fixture.of(UsinaRequestBodyDTO.class).addTemplate("invalido-sem-logradouro").inherits("valido", new Rule() {
            {
                add("endereco", one(EnderecoDTO.class, "invalido-sem-logradouro"));
            }
        });

        Fixture.of(UsinaRequestBodyDTO.class).addTemplate("invalido-sem-bairro").inherits("valido", new Rule() {
            {
                add("endereco", one(EnderecoDTO.class, "invalido-sem-bairro"));
            }
        });

        Fixture.of(UsinaRequestBodyDTO.class).addTemplate("invalido-sem-id-cidade").inherits("valido", new Rule() {
            {
                add("endereco", one(EnderecoDTO.class, "invalido-sem-id-cidade"));
            }
        });
    }
}
