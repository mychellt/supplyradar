package br.com.supplyradar.persistence.six2six.fixture.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.Cnpj;
import br.com.supplyradar.domain.commons.Email;
import br.com.supplyradar.domain.commons.PessoaJuridica;
import br.com.supplyradar.domain.commons.TipoPessoa;
import br.com.supplyradar.persistence.model.commons.PessoaJuridicaEntity;

import java.util.UUID;

public class PessoaJuridicaEntityTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(PessoaJuridicaEntity.class).addTemplate("valido", new Rule() {
            {
                add("id", UUID.randomUUID());
                add("telefone", "fake-telefone");
                add("email", "fake-email@exemplo.com");
                add("tipo", TipoPessoa.PESSOA_JURIDICA);
                add("cnpj", "fake-cnpj");
                add("inscricaoEstadual", "fake-inscricao-estadual");
                add("nomeFantasia", "fake-nome-fantasia");
                add("website", "fake-website.com.br");
                add("razaoSocial","fake-razao-social");
            }
        });
    }
}
