package br.com.supplyradar.usuario.controller;


import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.domain.commons.Fornecedor;
import br.com.supplyradar.usuario.dto.FornecedorRequestBodyDTO;
import br.com.supplyradar.usuario.mapper.FornecedorRequestBodyDTOMapperImpl;
import br.com.supplyradar.usuario.processor.AbstractUsuarioTest;
import br.com.supplyradar.usuario.processor.CriarFornecedorCommandProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {
        FornecedorController.class,
        CriarFornecedorCommandProcessor.class,
        FornecedorRequestBodyDTOMapperImpl.class
})
@WebMvcTest
class FornecedorControllerTest extends AbstractUsuarioTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CriarFornecedorCommandProcessor criarFornecedorProcessor;

    private ObjectMapper objectMapper;

    private Fornecedor fornecedor;

    @BeforeEach
    void setUp() {
        fornecedor = Fixture.from(Fornecedor.class).gimme("valido-com-id");
        when(criarFornecedorProcessor.process(any(CommandContext.class))).thenReturn(fornecedor);
        objectMapper = new ObjectMapper();
    }

    @DisplayName(value = "Deve ser capaz de realizar o cadastro de fornecedores.")
    @Test
    void create() throws Exception {

        FornecedorRequestBodyDTO fornecedorRequestBodyDTO = Fixture.from(FornecedorRequestBodyDTO.class).gimme("valido");

        mockMvc.perform(post("/fornecedores")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(fornecedorRequestBodyDTO)))
                .andExpect(status()
                        .is(HttpStatus.OK.value()));

        verify(criarFornecedorProcessor).process(any(CommandContext.class));
    }
}
