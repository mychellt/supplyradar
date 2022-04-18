package br.com.supplyradar.usuario.processor;

import br.com.fluentvalidator.context.Error;
import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.core.persistence.PessoaRepository;
import br.com.supplyradar.core.persistence.SolicitacaoAcessoRepository;
import br.com.supplyradar.core.persistence.UsuarioRepository;
import br.com.supplyradar.core.queue.mail.MailQueue;
import br.com.supplyradar.domain.commons.*;
import br.com.supplyradar.domain.exceptions.DomainException;
import br.com.supplyradar.domain.exceptions.UsuarioJaExisteException;
import br.com.supplyradar.domain.mail.MailMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class})
class CadastrarUsuarioCommandProcessorTest extends AbstractUsuarioTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private SolicitacaoAcessoRepository solicitacaoAcessoRepository;

    @Mock
    private GerarTokenSolicitacaoAcessoCommandProcessor tokenSolicitacaoAcessoProcessor;

    @Mock
    private MailQueue mailQueue;

    private CadastrarUsuarioCommandProcessor processor;

    @BeforeEach
    void setUp() {
        final Usuario usuario = Fixture.from(Usuario.class).gimme("valido-com-id");
        final SolicitacaoAcesso solicitacaoAcesso = Fixture.from(SolicitacaoAcesso.class).gimme("valido-com-id");
        final TokenSolicitacaoAcesso tokenSolicitacaoAcesso = Fixture.from(TokenSolicitacaoAcesso.class).gimme("valido-com-id");
        processor =  new CadastrarUsuarioCommandProcessor(usuarioRepository, solicitacaoAcessoRepository, tokenSolicitacaoAcessoProcessor, mailQueue);

        lenient().doNothing().when(mailQueue).push(any(MailMessage.class));
        lenient().when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);
        lenient().when(solicitacaoAcessoRepository.save(any(SolicitacaoAcesso.class))).thenReturn(solicitacaoAcesso);
        lenient().when(tokenSolicitacaoAcessoProcessor.process(any(CommandContext.class))).thenReturn(tokenSolicitacaoAcesso);
    }

    @DisplayName(value = "Dado um usuário válido deve ser capaz de realizado o cadastro.")
    @Test
    void process() {
        final CreateUsuario createUsuario = Fixture.from(CreateUsuario.class).gimme("valido");

        final CommandContext commandContext = new CommandContext();
        commandContext.setData(createUsuario);

        final Usuario usuarioCadastrado = processor.process(commandContext);

        assertThat(usuarioCadastrado, notNullValue());
        assertThat(usuarioCadastrado.getId(), notNullValue());
        assertThat(usuarioCadastrado.getPessoa(), notNullValue());
        assertThat(usuarioCadastrado.getDateOfChange(), notNullValue());
        assertThat(usuarioCadastrado.getDateOfCreate(), notNullValue());
        assertThat(usuarioCadastrado.getPessoa().getDateOfChange(), notNullValue());
        assertThat(usuarioCadastrado.getPessoa().getDateOfCreate(), notNullValue());
        assertThat(usuarioCadastrado.getTipo(), notNullValue());
        assertThat(usuarioCadastrado.getSenha(), not(emptyOrNullString()));
        assertThat(usuarioCadastrado.getLogin(), not(emptyOrNullString()));
        assertThat(usuarioCadastrado.getPessoa().getTelefone(), not(emptyOrNullString()));
        assertThat(usuarioCadastrado.getPessoa().getEmail().getAddress(), not(emptyOrNullString()));
        assertThat(((PessoaFisica)usuarioCadastrado.getPessoa()).getNome(), not(emptyOrNullString()));
        assertThat(((PessoaFisica)usuarioCadastrado.getPessoa()).getCpfPassaporte(), not(emptyOrNullString()));

        verify(mailQueue).push(any(MailMessage.class));
        verify(usuarioRepository).save(any(Usuario.class));
        verify(tokenSolicitacaoAcessoProcessor).process(any(CommandContext.class));
        verify(solicitacaoAcessoRepository).save(any(SolicitacaoAcesso.class));
    }

    @DisplayName(value = "Não deve ser capaz de realizar o cadastro do usuário quando já existir um usuário cadastrado com o login informado.")
    @Test
    void usuarioJaCadastrado() {
        final CreateUsuario createUsuario = Fixture.from(CreateUsuario.class).gimme("valido");
        final Usuario usuario = Fixture.from(Usuario.class).gimme("valido");
        usuario.setLogin(createUsuario.getLogin());

        when(usuarioRepository.findByLogin(anyString())).thenReturn(usuario);

        final CommandContext commandContext = new CommandContext();
        commandContext.setData(createUsuario);

        final UsuarioJaExisteException usuarioJaExisteException = Assertions.assertThrows(UsuarioJaExisteException.class, () -> processor.process(commandContext));
        assertThat(usuarioJaExisteException, notNullValue());

        final Collection<Error> errors = usuarioJaExisteException.getValidationResult().getErrors();

        assertEquals(errors.stream().findFirst().map(Error::getMessage).orElse(""), "Usuário já existente");

        verify(mailQueue, never()).push(any(MailMessage.class));
        verify(usuarioRepository, never()).save(any(Usuario.class));
        verify(tokenSolicitacaoAcessoProcessor, never()).process(any(CommandContext.class));
        verify(solicitacaoAcessoRepository, never()).save(any(SolicitacaoAcesso.class));
    }

    @DisplayName(value = "Não deve ser capaz de realizar o cadastro do usuário quando os e-mails dados forem diferentes.")
    @Test
    void emailsNaoSaoIguais() {
        final CreateUsuario createUsuario = Fixture.from(CreateUsuario.class).gimme("valido");
        createUsuario.setEmailConfirmacao("outro@exemplo.com");

        final CommandContext commandContext = new CommandContext();
        commandContext.setData(createUsuario);

        final DomainException domainException = Assertions.assertThrows(DomainException.class, () -> processor.process(commandContext));
        assertThat(domainException, notNullValue());

        final Collection<Error> errors = domainException.getValidationResult().getErrors();

        assertEquals(errors.stream().findFirst().map(Error::getMessage).orElse(""), "Erro no e-mail: os valores informados não são iguais");

        verify(mailQueue, never()).push(any(MailMessage.class));
        verify(usuarioRepository, never()).save(any(Usuario.class));
        verify(tokenSolicitacaoAcessoProcessor, never()).process(any(CommandContext.class));
        verify(solicitacaoAcessoRepository, never()).save(any(SolicitacaoAcesso.class));
    }

    @DisplayName(value = "Não deve ser capaz de realizar o cadastro do usuário quando as senhas dadasforem diferentes.")
    @Test
    void senhasNaoSaoIguais() {
        final CreateUsuario createUsuario = Fixture.from(CreateUsuario.class).gimme("valido");
        createUsuario.setSenhaConfirmacao("outra-senha-fake");

        final CommandContext commandContext = new CommandContext();
        commandContext.setData(createUsuario);

        final DomainException domainException = Assertions.assertThrows(DomainException.class, () -> processor.process(commandContext));
        assertThat(domainException, notNullValue());

        final Collection<Error> errors = domainException.getValidationResult().getErrors();

        assertEquals(errors.stream().findFirst().map(Error::getMessage).orElse(""), "Erro na senha: os valores informados não são iguais");

        verify(mailQueue, never()).push(any(MailMessage.class));
        verify(usuarioRepository, never()).save(any(Usuario.class));
        verify(tokenSolicitacaoAcessoProcessor, never()).process(any(CommandContext.class));
        verify(solicitacaoAcessoRepository, never()).save(any(SolicitacaoAcesso.class));
    }
}
