package br.com.supplyradar.six2six.fixture.templates.domain.commons;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.PessoaFisica;
import br.com.supplyradar.domain.commons.PessoaJuridica;
import br.com.supplyradar.domain.commons.TipoUsuario;
import br.com.supplyradar.domain.commons.Usuario;

import java.time.LocalDateTime;
import java.util.UUID;

public class UsuarioTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(Usuario.class).addTemplate("valido", new Rule() {
            {
                add("login", "login-usuario-valido");
                add("senha", "senha-usuario-valido");
                add("tipo", TipoUsuario.OPERADOR);
                add("autorizado", Boolean.TRUE.toString());
                add("pessoa", one(PessoaFisica.class, "valido"));
                add("dateOfChange", LocalDateTime.now());
                add("dateOfCreate", LocalDateTime.now());
            }
        });

        Fixture.of(Usuario.class).addTemplate("valido-com-id").inherits("valido", new Rule(){
            {
                add("id", UUID.randomUUID());
                add("pessoa", one(PessoaFisica.class, "valido-com-id"));
            }
        });

        Fixture.of(Usuario.class).addTemplate("valido-pessoa-juridica").inherits("valido", new Rule(){
            {
                add("pessoa", one(PessoaJuridica.class, "valido"));
            }
        });
    }
}
