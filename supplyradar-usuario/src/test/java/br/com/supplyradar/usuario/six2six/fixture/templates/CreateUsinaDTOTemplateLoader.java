package br.com.supplyradar.usuario.six2six.fixture.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.Endereco;
import br.com.supplyradar.domain.commons.TipoUsuario;
import br.com.supplyradar.usuario.dto.CreateUsinaDTO;
import br.com.supplyradar.usuario.dto.CreateUsuarioDTO;
import br.com.supplyradar.usuario.dto.EnderecoDTO;

public class CreateUsinaDTOTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(CreateUsinaDTO.class).addTemplate("valido", new Rule() {
            {
               add("cnpj", "000.000.00-0000/00");
               add("inscricaoEstadual", "123456789");
               add("razaoSocial", "fake-razao-social");
               add("website", "http://website.com");
               add("endereco", one(EnderecoDTO.class, "valido"));
            }
        });
    }
}
