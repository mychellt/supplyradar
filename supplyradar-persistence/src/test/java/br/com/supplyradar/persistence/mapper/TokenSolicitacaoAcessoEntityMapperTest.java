package br.com.supplyradar.persistence.mapper;

import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.domain.commons.TokenSolicitacaoAcesso;
import br.com.supplyradar.persistence.AbstractPersistenceTest;
import br.com.supplyradar.persistence.mapper.factory.PessoaEntityFactory;
import br.com.supplyradar.persistence.mapper.factory.PessoaFactory;
import br.com.supplyradar.persistence.model.commons.TokenSolicitacaoAcessoEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith({MockitoExtension.class})
@SpringBootTest(classes = {
        UsuarioEntityMapperImpl.class,
        PessoaEntityFactory.class,
        PessoaFactory.class,
        EmailEntityMapperImpl.class,
        CNPJEntityMapperImpl.class,
        TokenSolicitacaoAcessoEntityMapperImpl.class,
        SolicitacaoAcessoEntityMapperImpl.class
})
public class TokenSolicitacaoAcessoEntityMapperTest {

    @Autowired
    private TokenSolicitacaoAcessoEntityMapper mapper;

    @DisplayName(value = "Deve ser capaz de mapear os dados de Entity para Domain")
    @Test
    void mapFromEntity() {
        final TokenSolicitacaoAcessoEntity tokenSolicitacaoAcessoEntity = Fixture.from(TokenSolicitacaoAcessoEntity.class).gimme("valido");
        final TokenSolicitacaoAcesso tokenSolicitacaoAcesso = mapper.mapFrom(tokenSolicitacaoAcessoEntity);
        assertThat(tokenSolicitacaoAcesso, notNullValue());
        assertThat(tokenSolicitacaoAcesso.getSolicitacao(), notNullValue());
        assertEquals(tokenSolicitacaoAcesso.getKey(), tokenSolicitacaoAcessoEntity.getKey());
    }

    @DisplayName(value = "Deve ser capaz de mapear os dados de Domain para Entity")
    @Test
    void mapFromDomain() {
        final TokenSolicitacaoAcesso tokenSolicitacaoAcesso = Fixture.from(TokenSolicitacaoAcesso.class).gimme("valido");
        final TokenSolicitacaoAcessoEntity tokenSolicitacaoAcessoEntity = mapper.mapFrom(tokenSolicitacaoAcesso);
        assertThat(tokenSolicitacaoAcessoEntity, notNullValue());
        assertThat(tokenSolicitacaoAcessoEntity.getSolicitacao(), notNullValue());
        assertEquals(tokenSolicitacaoAcessoEntity.getKey(), tokenSolicitacaoAcesso.getKey());
    }
}
