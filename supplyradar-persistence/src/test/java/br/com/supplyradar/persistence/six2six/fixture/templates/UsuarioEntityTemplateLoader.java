package br.com.supplyradar.persistence.six2six.fixture.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.TipoAtribuicao;
import br.com.supplyradar.domain.commons.TipoUsuario;
import br.com.supplyradar.persistence.model.commons.PermissaoEntity;
import br.com.supplyradar.persistence.model.commons.PessoaEntity;
import br.com.supplyradar.persistence.model.commons.UsuarioEntity;

import javax.persistence.*;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

public class UsuarioEntityTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(UsuarioEntity.class).addTemplate("valido", new Rule() {
            {
                add("login", "login-usuario-valido");
                add("senha", "senha-usuario-valido");
                add("tipo", TipoUsuario.OPERADOR);
                add("autorizado", Boolean.TRUE.toString());
            }
        });
    }
}
