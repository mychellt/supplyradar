package br.com.supplyradar.persistence.mapper;

import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.domain.commons.SolicitacaoAcesso;
import br.com.supplyradar.persistence.AbstractPersistenceTest;
import br.com.supplyradar.persistence.mapper.factory.PessoaEntityFactory;
import br.com.supplyradar.persistence.mapper.factory.PessoaFactory;
import br.com.supplyradar.persistence.model.commons.SolicitacaoAcessoEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;



@SpringBootTest(classes = {SolicitacaoAcessoEntityMapperImpl.class, UsuarioEntityMapperImpl.class, PessoaEntityFactory.class, PessoaFactory.class})
public class SolicitacaoAcessoEntityMapperTest extends AbstractMapperTest {

    @Autowired
    private SolicitacaoAcessoEntityMapper solicitacaoAcessoEntityMapper;

    @DisplayName(value = "Deve ser capaz de mapear os dados de Entity para Domain")
    @Test
    void mapFromEntity() {
        final SolicitacaoAcessoEntity solicitacaoAcessoEntity = Fixture.from(SolicitacaoAcessoEntity.class).gimme("valido");
        final SolicitacaoAcesso solicitacaoAcesso = solicitacaoAcessoEntityMapper.mapFrom(solicitacaoAcessoEntity);
        assertThat(solicitacaoAcesso, notNullValue());
        assertThat(solicitacaoAcesso.getId(), notNullValue());
        assertThat(solicitacaoAcesso.getUsuario(), notNullValue());
        assertEquals(solicitacaoAcessoEntity.getId(), solicitacaoAcesso.getId());
        assertEquals(solicitacaoAcessoEntity.isAtivo(), solicitacaoAcesso.isAtivo());
        assertEquals(solicitacaoAcessoEntity.getUsuario().getTipo(), solicitacaoAcesso.getUsuario().getTipo());
        assertEquals(solicitacaoAcessoEntity.getUsuario().getSenha(), solicitacaoAcesso.getUsuario().getSenha());
        assertEquals(solicitacaoAcessoEntity.getUsuario().getLogin(), solicitacaoAcesso.getUsuario().getLogin());
        assertEquals(solicitacaoAcessoEntity.getUsuario().getTipo(), solicitacaoAcesso.getUsuario().getTipo());
        assertEquals(solicitacaoAcessoEntity.getUsuario().isAtivo(), solicitacaoAcesso.getUsuario().isAtivo());
        assertEquals(solicitacaoAcessoEntity.getUsuario().isAutorizado(), solicitacaoAcesso.getUsuario().isAutorizado());
    }

    @DisplayName(value = "Deve ser capaz de mapear os dados de Domain para Entity")
    @Test
    void mapFromDomain() {
        final SolicitacaoAcesso solicitacaoAcesso = Fixture.from(SolicitacaoAcesso.class).gimme("valido");
        final SolicitacaoAcessoEntity solicitacaoAcessoEntity = solicitacaoAcessoEntityMapper.mapFrom(solicitacaoAcesso);
        assertThat(solicitacaoAcesso, notNullValue());
        assertThat(solicitacaoAcesso.getUsuario(), notNullValue());
        assertEquals(solicitacaoAcessoEntity.getId(), solicitacaoAcesso.getId());
        assertEquals(solicitacaoAcessoEntity.isAtivo(), solicitacaoAcesso.isAtivo());
        assertEquals(solicitacaoAcessoEntity.getUsuario().getTipo(), solicitacaoAcesso.getUsuario().getTipo());
        assertEquals(solicitacaoAcessoEntity.getUsuario().getSenha(), solicitacaoAcesso.getUsuario().getSenha());
        assertEquals(solicitacaoAcessoEntity.getUsuario().getLogin(), solicitacaoAcesso.getUsuario().getLogin());
        assertEquals(solicitacaoAcessoEntity.getUsuario().getTipo(), solicitacaoAcesso.getUsuario().getTipo());
        assertEquals(solicitacaoAcessoEntity.getUsuario().isAtivo(), solicitacaoAcesso.getUsuario().isAtivo());
        assertEquals(solicitacaoAcessoEntity.getUsuario().isAutorizado(), solicitacaoAcesso.getUsuario().isAutorizado());
    }
}
