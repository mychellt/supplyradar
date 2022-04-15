package br.com.supplyradar.six2six.fixture.templates.domain.commons;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.*;

import java.util.UUID;

public class PessoaFisicaTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(PessoaFisica.class).addTemplate("valido", new Rule() {
            {
                add("nome", "fake-nome");
                add("telefone", "fake-telefone");
                add("email", Email.builder().address("fake-email@exemplo.com").build());
                add("tipo", TipoPessoa.PESSOA_FISICA);
                add("cpfPassaporte", "fake-cpf-passaporte");
                add("passaporte", Boolean.FALSE.toString());
            }
        });
    }
}
