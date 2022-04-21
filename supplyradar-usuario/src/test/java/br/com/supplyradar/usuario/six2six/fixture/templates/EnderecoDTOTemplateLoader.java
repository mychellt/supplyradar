package br.com.supplyradar.usuario.six2six.fixture.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.Endereco;
import br.com.supplyradar.domain.commons.TipoEndereco;
import br.com.supplyradar.usuario.dto.EnderecoDTO;

import java.util.UUID;

public class EnderecoDTOTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(EnderecoDTO.class).addTemplate("valido", new Rule() {
            {
                add("logradouro", "fake-logradouro");
                add("numero", "123456789");
                add("bairro", "fake-bairro");
                add("complemento", "fake-complemento");
                add("tipo", TipoEndereco.COMERCIAL.name());
                add("cep", "99.999-99");
                add("idCidade", UUID.randomUUID());
                add("idPessoa", UUID.randomUUID());
            }
        });

        Fixture.of(EnderecoDTO.class).addTemplate("invalido-sem-logradouro").inherits("valido", new Rule() {
            {
                add("logradouro", null);
            }
        });

        Fixture.of(EnderecoDTO.class).addTemplate("invalido-sem-cep").inherits("valido", new Rule() {
            {
                add("cep", null);
            }
        });

        Fixture.of(EnderecoDTO.class).addTemplate("invalido-sem-numero").inherits("valido", new Rule() {
            {
                add("numero", null);
            }
        });

        Fixture.of(EnderecoDTO.class).addTemplate("invalido-sem-bairro").inherits("valido", new Rule() {
            {
                add("bairro", null);
            }
        });

        Fixture.of(EnderecoDTO.class).addTemplate("invalido-sem-id-cidade").inherits("valido", new Rule() {
            {
                add("idCidade", null);
            }
        });
    }
}
