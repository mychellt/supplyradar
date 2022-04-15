package br.com.supplyradar.six2six.fixture.templates.domain.commons;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.Cnpj;
import br.com.supplyradar.domain.commons.Email;
import br.com.supplyradar.domain.commons.PessoaJuridica;
import br.com.supplyradar.domain.commons.TipoPessoa;

import java.util.UUID;

public class PessoaJuridicaTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(PessoaJuridica.class).addTemplate("valido", new Rule() {
            {
                add("id", UUID.randomUUID());
                add("telefone", "fake-telefone");
                add("email", Email.builder().address("fake-email@exemplo.com").build());
                add("tipo", TipoPessoa.PESSOA_JURIDICA);
                add("cnpj", Cnpj.builder().number("fake-cnpj").build());
                add("inscricaoEstadual", "fake-inscricao-estadual");
                add("nomeFantasia", "fake-nome-fantasia");
                add("website", "fake-website.com.br");
                add("razaoSocial","fake-razao-social");
            }
        });
    }
}
