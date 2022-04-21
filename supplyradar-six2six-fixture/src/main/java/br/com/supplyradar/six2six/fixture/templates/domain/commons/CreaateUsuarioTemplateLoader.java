package br.com.supplyradar.six2six.fixture.templates.domain.commons;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.CreateUsuario;
import br.com.supplyradar.domain.commons.TipoUsuario;

public class CreaateUsuarioTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(CreateUsuario.class).addTemplate("valido", new Rule() {
            {
                add("login", "fake-login");
                add("senha", "fake-senha");
                add("senhaConfirmacao", "fake-senha");
                add("email", "fake-email");
                add("emailConfirmacao", "fake-email");
                add("aceitaTermoAdesao", Boolean.TRUE);
                add("concordaPoliticaPrivacidade", Boolean.TRUE);
                add("cpfPassaporte", "fake-cpf-passaporte");
                add("estrangeiro", Boolean.FALSE);
                add("telefone", "fake-telefone");
                add("nome", "fake-nome");
                add("tipo", TipoUsuario.OPERADOR.name());
            }
        });
    }
}
