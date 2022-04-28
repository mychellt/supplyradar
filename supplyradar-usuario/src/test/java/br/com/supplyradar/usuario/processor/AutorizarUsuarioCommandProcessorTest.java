package br.com.supplyradar.usuario.processor;

import br.com.fluentvalidator.context.Error;
import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.core.persistence.UsuarioRepository;
import br.com.supplyradar.domain.commons.TokenSolicitacaoAcesso;
import br.com.supplyradar.domain.commons.Usuario;
import br.com.supplyradar.domain.exceptions.DomainException;
import br.com.supplyradar.usuario.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class})
public class AutorizarUsuarioCommandProcessorTest extends AbstractTest {
    private AutorizarUsuarioCommandProcessor autorizarUsuarioCommandProcessor;

    @Mock
    private UsuarioRepository usuarioRepository;


    @BeforeEach
    void setUp() {
        final Usuario usuario = Fixture.from(Usuario.class).gimme("valido-com-id");
        autorizarUsuarioCommandProcessor =  new AutorizarUsuarioCommandProcessor(usuarioRepository);
        lenient().doNothing().when(usuarioRepository).autorizar(any(Usuario.class));
        lenient().when(usuarioRepository.findByTokenSolicitacaoAcesso(any(TokenSolicitacaoAcesso.class))).thenReturn(usuario);
    }

    @DisplayName(value = "Deve ser capaz de realizar a autorização de um usuário.")
    @Test
    void autorizar() {
        final TokenSolicitacaoAcesso tokenSolicitacaoAcesso = Fixture.from(TokenSolicitacaoAcesso.class).gimme("valido-com-id");

        CommandContext commandContext = new CommandContext();
        commandContext.setData(tokenSolicitacaoAcesso);

        autorizarUsuarioCommandProcessor.process(commandContext);

        verify(usuarioRepository).autorizar(any(Usuario.class));

    }

    @DisplayName(value = "Não deve ser capaz de realizar a autorização quando não for encontrado um usuário.")
    @Test
    void autorizarFail_usuarioNaoEncontrado() {
        final TokenSolicitacaoAcesso tokenSolicitacaoAcesso = Fixture.from(TokenSolicitacaoAcesso.class).gimme("valido-com-id");

        CommandContext commandContext = new CommandContext();
        commandContext.setData(tokenSolicitacaoAcesso);

        lenient().when(usuarioRepository.findByTokenSolicitacaoAcesso(any(TokenSolicitacaoAcesso.class))).thenReturn(null);

        DomainException domainException = Assertions.assertThrows(DomainException.class, () -> autorizarUsuarioCommandProcessor.process(commandContext));
        assertThat(domainException, notNullValue());
        assertThat(domainException.getValidationResult(), notNullValue());
        assertThat(domainException.getValidationResult().getErrors(), notNullValue());

        assertEquals("Não existe solicitação de acesso associada ao token informado", domainException.getValidationResult().getErrors().stream().findAny().map(Error::getMessage).orElse(""));

        verify(usuarioRepository, never()).autorizar(any(Usuario.class));
    }
}
