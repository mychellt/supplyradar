package br.com.supplyradar.usuario.six2six.fixture.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.TipoEndereco;
import br.com.supplyradar.usuario.dto.CreateUsinaDTO;
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
    }
}
