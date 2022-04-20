package br.com.supplyradar.usuario.six2six.fixture.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.TipoUsuario;
import br.com.supplyradar.usuario.dto.CreateUsuarioDTO;

public class CreateUsuarioDTOTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(CreateUsuarioDTO.class).addTemplate("valido", new Rule() {
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
