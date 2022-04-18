package br.com.supplyradar.usuario.processor;

import br.com.fluentvalidator.context.Error;
import br.com.fluentvalidator.context.ValidationResult;
import br.com.supplyradar.core.command.Command;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.core.queue.mail.MailQueue;
import br.com.supplyradar.core.persistence.PessoaRepository;
import br.com.supplyradar.core.persistence.SolicitacaoAcessoRepository;
import br.com.supplyradar.core.persistence.UsuarioRepository;
import br.com.supplyradar.domain.commons.*;
import br.com.supplyradar.domain.exceptions.DomainException;
import br.com.supplyradar.domain.exceptions.UsuarioJaExisteException;
import br.com.supplyradar.domain.mail.MailMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static java.lang.String.valueOf;
import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class CadastrarUsuarioCommandProcessor implements Command<Usuario> {
    private final UsuarioRepository usuarioRepository;
    private final SolicitacaoAcessoRepository solicitacaoAcessoRepository;
    private final GerarTokenSolicitacaoAcessoCommandProcessor tokenSolicitacaoAcessoProcessor;
    private final MailQueue mailQueue;

    @Override
    public Usuario process(CommandContext context) {
        final CreateUsuario createUsuario = context.getData(CreateUsuario.class);
        final Usuario usuarioJaCadastrado = usuarioRepository.findByLogin(createUsuario.getLogin());

        if(nonNull(usuarioJaCadastrado)) {
            final Error error = Error.create("login", "Usuário já existente", valueOf(HttpStatus.BAD_REQUEST.value()), createUsuario.getLogin());
            throw new UsuarioJaExisteException(ValidationResult.fail(List.of(error)));
        }

        if(!createUsuario.getEmail().equals(createUsuario.getEmailConfirmacao())) {
            final Error error = Error.create("email", "Erro no e-mail: os valores informados não são iguais", valueOf(HttpStatus.BAD_REQUEST.value()), createUsuario.getEmail());
            throw new DomainException(ValidationResult.fail(List.of(error)));
        }

        if(!createUsuario.getSenha().equals(createUsuario.getSenhaConfirmacao())) {
            final Error error = Error.create("senha", "Erro na senha: os valores informados não são iguais", valueOf(HttpStatus.BAD_REQUEST.value()), null);
            throw new DomainException(ValidationResult.fail(List.of(error)));
        }

        final PessoaFisica pessoa = new PessoaFisica();
        pessoa.setEmail(Email.builder().address(createUsuario.getEmail()).build());
        pessoa.setTelefone(createUsuario.getTelefone());
        pessoa.setTipo(TipoPessoa.PESSOA_FISICA);
        pessoa.setCpfPassaporte(createUsuario.getCpfPassaporte());
        pessoa.setNome(createUsuario.getNome());
        pessoa.setAtivo(Boolean.TRUE);
        pessoa.setDateOfChange(LocalDateTime.now());
        pessoa.setDateOfCreate(LocalDateTime.now());

        Usuario usuario = new Usuario();
        usuario.setPessoa(pessoa);
        usuario.setAtivo(Boolean.TRUE);
        usuario.setSenha(createUsuario.getSenha());
        usuario.setAutorizado(Boolean.FALSE);
        usuario.setLogin(createUsuario.getLogin());
        usuario.setDateOfChange(LocalDateTime.now());
        usuario.setDateOfCreate(LocalDateTime.now());

        usuario = usuarioRepository.save(usuario);

        final SolicitacaoAcesso solicitacaoAcesso = new SolicitacaoAcesso();
        solicitacaoAcesso.setUsuario(usuario);
        solicitacaoAcesso.setAtivo(Boolean.TRUE);
        solicitacaoAcesso.setDateOfChange(LocalDateTime.now());
        solicitacaoAcesso.setDateOfCreate(LocalDateTime.now());

        solicitacaoAcessoRepository.save(solicitacaoAcesso);

        final CommandContext commandContext = new CommandContext();
        commandContext.setData(solicitacaoAcesso);

        tokenSolicitacaoAcessoProcessor.process(commandContext);

        final MailMessage mailMessage = MailMessage.builder()
                .from("supplyradarsmart@gmail.com")
                .subject("Solicitação de acesso ao sistema SupplyRadar")
                .to(createUsuario.getEmail())
                .content("Teste de cadastro de usuário")
                .build();

        mailQueue.push(mailMessage);
        return usuario;
    }


}
