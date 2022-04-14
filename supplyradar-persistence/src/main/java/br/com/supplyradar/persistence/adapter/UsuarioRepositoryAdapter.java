package br.com.supplyradar.persistence.adapter;

import br.com.supplyradar.core.persistence.UsuarioRepository;
import br.com.supplyradar.domain.commons.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepositoryAdapter implements UsuarioRepository {

    @Override
    public Usuario save(Usuario usuario) {
        return null;
    }

    @Override
    public Usuario findByLogin(String login) {
        return null;
    }
}
