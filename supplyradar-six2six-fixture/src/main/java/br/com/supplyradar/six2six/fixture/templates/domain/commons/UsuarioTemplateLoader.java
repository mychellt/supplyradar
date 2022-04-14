package br.com.supplyradar.six2six.fixture.templates.domain.commons;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.TipoUsuario;
import br.com.supplyradar.domain.commons.Usuario;

public class UsuarioTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(Usuario.class).addTemplate("valido", new Rule() {
            {
                add("login", "login-usuario-valido");
                add("senha", "senha-usuario-valido");
                add("tipo", TipoUsuario.OPERADOR);
                add("autorizado", Boolean.TRUE.toString());
            }
        });
    }
}
