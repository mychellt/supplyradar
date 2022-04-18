package br.com.supplyradar.persistence.adapter;

import br.com.supplyradar.core.persistence.UsuarioRepository;
import br.com.supplyradar.domain.commons.TokenSolicitacaoAcesso;
import br.com.supplyradar.domain.commons.Usuario;
import br.com.supplyradar.persistence.adapter.jpa.UsuarioJpaRepository;
import br.com.supplyradar.persistence.mapper.UsuarioEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class UsuarioRepositoryAdapter implements UsuarioRepository {
    private final UsuarioJpaRepository jpa;
    private final UsuarioEntityMapper mapper;

    @Override
    public Usuario save(Usuario usuario) {
        return mapper.mapFrom(jpa.save(mapper.mapFrom(usuario)));
    }

    @Override
    public Usuario findByLogin(String login) {
        return null;
    }

    @Override
    public Usuario findByTokenSolicitacaoAcesso(TokenSolicitacaoAcesso tokenSolicitacaoAcesso) {
        return null;
    }

    @Override
    public void autorizar(final Usuario usuario) {
        jpa.autorizarById(usuario.getId());
    }
}
