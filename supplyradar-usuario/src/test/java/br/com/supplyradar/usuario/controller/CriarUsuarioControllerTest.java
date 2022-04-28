package br.com.supplyradar.usuario.controller;

import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.domain.commons.Usuario;
import br.com.supplyradar.usuario.AbstractTest;
import br.com.supplyradar.usuario.dto.CreateUsuarioDTO;
import br.com.supplyradar.usuario.mapper.CreateUsuarioDTOMapper;
import br.com.supplyradar.usuario.processor.CadastrarUsuarioCommandProcessor;
import br.com.supplyradar.usuario.validator.CadastrarUsuarioValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@ContextConfiguration(classes = {
        CriarUsuarioController.class,
        CadastrarUsuarioCommandProcessor.class,
        CadastrarUsuarioValidator.class, CreateUsuarioDTOMapper.class
})
@WebMvcTest
class CriarUsuarioControllerTest extends AbstractTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @MockBean
    private CadastrarUsuarioCommandProcessor cadastrarUsuarioCommandProcessor;

    @Spy
    private CadastrarUsuarioValidator cadastrarUsuarioValidator;

    @MockBean
    private CreateUsuarioDTOMapper usuarioDTOMapper;

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

        mockMvc.perform(post("/public/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createUsuarioDTO)))
                .andExpect(status().is(200));

        verify(cadastrarUsuarioCommandProcessor).process(any(CommandContext.class));
    }
}
