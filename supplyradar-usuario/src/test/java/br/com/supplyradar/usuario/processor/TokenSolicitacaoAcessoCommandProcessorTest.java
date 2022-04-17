package br.com.supplyradar.usuario.processor;

import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.core.persistence.TokenSolicitacaoAcessoRepository;
import br.com.supplyradar.domain.commons.SolicitacaoAcesso;
import br.com.supplyradar.domain.commons.TokenSolicitacaoAcesso;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;

@ExtendWith({MockitoExtension.class})
class TokenSolicitacaoAcessoCommandProcessorTest extends AbstractUsuarioTest {
    private TokenSolicitacaoAcessoCommandProcessor processor;

    @Mock
    private TokenSolicitacaoAcessoRepository tokenSolicitacaoAcessoRepository;

    @BeforeEach
    public void setUp() {
        final TokenSolicitacaoAcesso tokenSolicitacaoAcesso = Fixture.from(TokenSolicitacaoAcesso.class).gimme("valido-com-id");
        lenient().when(tokenSolicitacaoAcessoRepository.save(any(TokenSolicitacaoAcesso.class))).thenReturn(tokenSolicitacaoAcesso);
        processor = new TokenSolicitacaoAcessoCommandProcessor(tokenSolicitacaoAcessoRepository);
    }

    @DisplayName(value = "Deve ser capz de gerar um token de acesso para o usuário.")
    @Test
    public void process() {
        final SolicitacaoAcesso solicitacaoAcesso = Fixture.from(SolicitacaoAcesso.class).gimme("valido-com-id");
        final CommandContext commandContext = new CommandContext();
        commandContext.setData(solicitacaoAcesso);
        TokenSolicitacaoAcesso tokenSolicitacaoAcessoCadastrado = processor.process(commandContext);
        assertThat(tokenSolicitacaoAcessoCadastrado, notNullValue());
        assertThat(tokenSolicitacaoAcessoCadastrado.getId(), notNullValue());
        assertThat(tokenSolicitacaoAcessoCadastrado.getDateOfChange(), notNullValue());
        assertThat(tokenSolicitacaoAcessoCadastrado.getDateOfCreate(), notNullValue());

        verify(tokenSolicitacaoAcessoRepository).save(any(TokenSolicitacaoAcesso.class));

    }
}
