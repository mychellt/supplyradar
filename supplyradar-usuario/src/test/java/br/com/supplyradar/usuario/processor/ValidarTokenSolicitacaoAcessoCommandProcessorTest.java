package br.com.supplyradar.usuario.processor;


import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.core.persistence.TokenSolicitacaoAcessoRepository;
import br.com.supplyradar.domain.commons.TokenSolicitacaoAcesso;
import br.com.supplyradar.usuario.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class})
class ValidarTokenSolicitacaoAcessoCommandProcessorTest extends AbstractTest {

    private ValidTokenSolicitacaoAcessoCommandProcessor validarTokenSolicitacaoAcessoCommandProcessor;

    @Mock
    private TokenSolicitacaoAcessoRepository tokenSolicitacaoAcessoRepository;

    @Mock
    private AutorizarUsuarioCommandProcessor autorizarUsuarioCommandProcessor;

    @BeforeEach
    void setUp() {
        validarTokenSolicitacaoAcessoCommandProcessor = new ValidTokenSolicitacaoAcessoCommandProcessor(tokenSolicitacaoAcessoRepository, autorizarUsuarioCommandProcessor);
    }

    @DisplayName(value = "Deve ser capaz de realizar a validação de tokens")
    @Test
    void validar() {
        final TokenSolicitacaoAcesso tokenSolicitacaoAcesso = Fixture.from(TokenSolicitacaoAcesso.class).gimme("valido-com-id");

        lenient().when(tokenSolicitacaoAcessoRepository.findByKey(anyString())).thenReturn(tokenSolicitacaoAcesso);
        doNothing().when(autorizarUsuarioCommandProcessor).process(any(CommandContext.class));

        final CommandContext commandContext = new CommandContext();
        commandContext.setData(UUID.randomUUID().toString());

        final TokenSolicitacaoAcesso tokenSolicitacaoAcessoValidado = validarTokenSolicitacaoAcessoCommandProcessor.process(commandContext);
        assertThat(tokenSolicitacaoAcessoValidado, notNullValue());
        assertEquals(Boolean.TRUE, tokenSolicitacaoAcessoValidado.isExpirado());

        verify(tokenSolicitacaoAcessoRepository).findByKey(anyString());
        verify(autorizarUsuarioCommandProcessor).process(any(CommandContext.class));
    }
}
