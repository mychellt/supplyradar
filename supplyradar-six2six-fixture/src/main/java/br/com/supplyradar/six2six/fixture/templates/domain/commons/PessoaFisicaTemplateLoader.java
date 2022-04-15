package br.com.supplyradar.six2six.fixture.templates.domain.commons;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.PessoaFisica;
import br.com.supplyradar.domain.commons.TipoPessoa;
import br.com.supplyradar.domain.commons.TipoUsuario;
import br.com.supplyradar.domain.commons.Usuario;

import java.util.UUID;

public class PessoaFisicaTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(PessoaFisica.class).addTemplate("valido", new Rule() {
            {
                add("id", UUID.randomUUID());
                add("tipo", TipoPessoa.PESSOA_FISICA);
            }
        });
    }
}
