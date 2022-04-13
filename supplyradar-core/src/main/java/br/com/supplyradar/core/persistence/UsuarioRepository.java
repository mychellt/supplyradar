package br.com.supplyradar.core.persistence;

import br.com.supplyradar.domain.commons.Usuario;

public interface UsuarioRepository {
    Usuario save(final Usuario usuario);
    Usuario findByLogin(final String login);
}
