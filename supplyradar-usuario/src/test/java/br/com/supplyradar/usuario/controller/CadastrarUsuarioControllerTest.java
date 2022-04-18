package br.com.supplyradar.usuario.controller;

import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.core.persistence.SolicitacaoAcessoRepository;
import br.com.supplyradar.core.persistence.TokenSolicitacaoAcessoRepository;
import br.com.supplyradar.core.persistence.UsuarioRepository;
import br.com.supplyradar.core.queue.mail.MailQueue;
import br.com.supplyradar.domain.commons.CreateUsuario;
import br.com.supplyradar.domain.commons.Usuario;
import br.com.supplyradar.usuario.dto.CreateUsuarioDTO;
import br.com.supplyradar.usuario.mapper.CreateUsuarioDTOMapper;
import br.com.supplyradar.usuario.processor.AbstractUsuarioTest;
import br.com.supplyradar.usuario.processor.CadastrarUsuarioCommandProcessor;
import br.com.supplyradar.usuario.processor.GerarTokenSolicitacaoAcessoCommandProcessor;
import br.com.supplyradar.usuario.validator.CadastrarUsuarioValidator;
import br.com.supplyradar.usuario.validator.ValidTokenSolicitacaoAcessoValidator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@EnableWebMvc
@WebMvcTest(CadastrarUsuarioController.class)
@ContextConfiguration(classes = CadastrarUsuarioControllerTest.class)
@ComponentScan(basePackageClasses = {
        CadastrarUsuarioController.class,
        CreateUsuarioDTOMapper.class,
        CadastrarUsuarioValidator.class,
        CadastrarUsuarioCommandProcessor.class
})
class CadastrarUsuarioControllerTest extends AbstractUsuarioTest {
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @MockBean
    private CadastrarUsuarioCommandProcessor cadastrarUsuarioCommandProcessor;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @MockBean
    private SolicitacaoAcessoRepository solicitacaoAcessoRepository;

    @MockBean
    private GerarTokenSolicitacaoAcessoCommandProcessor tokenSolicitacaoAcessoProcessor;

    @MockBean
    private MailQueue mailQueue;

    @MockBean
    private TokenSolicitacaoAcessoRepository tokenSolicitacaoAcessoRepository;

    @BeforeEach
    public void setUp() {
        Usuario usuario = Fixture.from(Usuario.class).gimme("valido");
        objectMapper = new ObjectMapper();
        lenient().when(cadastrarUsuarioCommandProcessor.process(any(CommandContext.class))).thenReturn(usuario);
    }

    @DisplayName(value = "Dado um requisição válida, deve ser capaz de criar o usuário e retornar sucesso.")
    @Test
    void create() throws Exception {
        CreateUsuarioDTO createUsuarioDTO = Fixture.from(CreateUsuarioDTO.class).gimme("valido");

        mockMvc.perform(post("/public/usuario/cadastrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createUsuarioDTO)))
                .andExpect(status().is(200));

        verify(cadastrarUsuarioCommandProcessor).process(any(CommandContext.class));
    }
}
