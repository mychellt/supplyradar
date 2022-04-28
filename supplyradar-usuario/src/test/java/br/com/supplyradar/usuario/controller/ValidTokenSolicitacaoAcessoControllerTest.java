package br.com.supplyradar.usuario.controller;

import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.domain.commons.TokenSolicitacaoAcesso;
import br.com.supplyradar.usuario.AbstractTest;
import br.com.supplyradar.usuario.processor.ValidTokenSolicitacaoAcessoCommandProcessor;
import br.com.supplyradar.usuario.validator.ValidTokenSolicitacaoAcessoValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@ContextConfiguration(classes = {
        ValidTokenSolicitacaoAcessoController.class,
        ValidTokenSolicitacaoAcessoValidator.class,
        ValidTokenSolicitacaoAcessoCommandProcessor.class
})
@WebMvcTest
class ValidTokenSolicitacaoAcessoControllerTest extends AbstractTest {
    @Autowired
    private MockMvc mockMvc;

    @Spy
    private ValidTokenSolicitacaoAcessoValidator validTokenSolicitacaoAcessoValidator;

    @MockBean
    private ValidTokenSolicitacaoAcessoCommandProcessor validTokenSolicitacaoAcessoCommandProcessor;

    @Spy
    private ObjectMapper objectMapper;


    @BeforeEach
    public void setUp() {
        TokenSolicitacaoAcesso tokenSolicitacaoAcesso = Fixture.from(TokenSolicitacaoAcesso.class).gimme("valido");
        when(validTokenSolicitacaoAcessoCommandProcessor.process(any(CommandContext.class))).thenReturn(tokenSolicitacaoAcesso);
    }

    @DisplayName(value = "Deve ser capaz de realizar a validação de um token.")
    @Test
    void valid() throws Exception {
        final String key = UUID.randomUUID().toString();

        mockMvc.perform(get("/public/token/" + key)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.OK.value()));

        verify(validTokenSolicitacaoAcessoCommandProcessor).process(any(CommandContext.class));

    }

    @DisplayName(value = "Não deve ser capaz de realizar a validação de token inválido")
    @Test
    void notValidUUID() throws Exception {
        mockMvc.perform(get("/public/token/" + "123456")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));

        verify(validTokenSolicitacaoAcessoCommandProcessor, never()).process(any(CommandContext.class));
    }
}
