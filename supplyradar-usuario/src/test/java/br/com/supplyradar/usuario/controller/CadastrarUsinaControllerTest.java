package br.com.supplyradar.usuario.controller;

import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.domain.commons.Usina;
import br.com.supplyradar.usuario.dto.CreateUsinaDTO;
import br.com.supplyradar.usuario.processor.AbstractUsuarioTest;
import br.com.supplyradar.usuario.processor.CadastrarUsinaCommandProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {
        CadastrarUsinaController.class
})
@WebMvcTest
public class CadastrarUsinaControllerTest extends AbstractUsuarioTest {
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @MockBean
    private CadastrarUsinaCommandProcessor cadastrarUsinaCommandProcessor;

    @BeforeEach
    public void setUp() {
        Usina usina = Fixture.from(Usina.class).gimme("valido");
        lenient().when(cadastrarUsinaCommandProcessor.process(any(CommandContext.class))).thenReturn(usina);
        objectMapper = new ObjectMapper();
    }

    @DisplayName(value = "Dado uma requisição válida, deve ser capaz de chamar o processor e retornar sucesso.")
    @Test
    void create() throws Exception {
        CreateUsinaDTO createUsinaDTO = Fixture.from(CreateUsinaDTO.class).gimme("valido");

        mockMvc.perform(post("/usina")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createUsinaDTO)))
                .andExpect(status()
                .is(HttpStatus.OK.value()));
    }
}
