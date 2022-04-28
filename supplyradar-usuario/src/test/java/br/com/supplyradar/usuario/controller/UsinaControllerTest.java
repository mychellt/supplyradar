package br.com.supplyradar.usuario.controller;

import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.domain.commons.Usina;
import br.com.supplyradar.core.configuration.RestControllerExceptionHandler;
import br.com.supplyradar.usuario.AbstractTest;
import br.com.supplyradar.usuario.dto.UsinaRequestBodyDTO;
import br.com.supplyradar.usuario.mapper.UsinaRequestBodyDTOMapperImpl;
import br.com.supplyradar.usuario.mapper.EnderecoDTOMapperImpl;
import br.com.supplyradar.usuario.processor.CadastrarUsinaCommandProcessor;
import br.com.supplyradar.usuario.validator.CadastrarUsinaValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {
        UsinaController.class,
        UsinaRequestBodyDTOMapperImpl.class,
        EnderecoDTOMapperImpl.class,
        CadastrarUsinaValidator.class,
        RestControllerExceptionHandler.class
})
@WebMvcTest
public class UsinaControllerTest extends AbstractTest {
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @MockBean
    private CadastrarUsinaCommandProcessor cadastrarUsinaCommandProcessor;

    @Spy
    private CadastrarUsinaValidator cadastrarUsinaValidator;

    @BeforeEach
    public void setUp() {
        Usina usina = Fixture.from(Usina.class).gimme("valido");
        lenient().when(cadastrarUsinaCommandProcessor.process(any(CommandContext.class))).thenReturn(usina);
        objectMapper = new ObjectMapper();
    }

    @DisplayName(value = "Dado uma requisição válida, deve ser capaz de chamar o processor e retornar sucesso.")
    @Test
    void create() throws Exception {
        UsinaRequestBodyDTO usinaRequestBodyDTO = Fixture.from(UsinaRequestBodyDTO.class).gimme("valido");

        mockMvc.perform(post("/usinas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usinaRequestBodyDTO)))
                .andExpect(status()
                .is(HttpStatus.OK.value()));

        verify(cadastrarUsinaCommandProcessor).process(any(CommandContext.class));
    }

    @DisplayName(value = "Não deve ser capaz de cadastrar a usina quando os dados obrigatórios não foram informados.")
    @ParameterizedTest
    @MethodSource(value = "getBodyToFail")
    void createFail(final UsinaRequestBodyDTO usinaRequestBodyDTO) throws Exception {

        mockMvc.perform(post("/usinas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usinaRequestBodyDTO)))
                .andExpect(status()
                        .is(HttpStatus.BAD_REQUEST.value()));

        verify(cadastrarUsinaCommandProcessor, never()).process(any(CommandContext.class));

    }

    private static Stream<UsinaRequestBodyDTO> getBodyToFail() {
        return Stream.of(
                Fixture.from(UsinaRequestBodyDTO.class).gimme("invalido-sem-cnpj"),
                Fixture.from(UsinaRequestBodyDTO.class).gimme("invalido-sem-razao-social"),
                Fixture.from(UsinaRequestBodyDTO.class).gimme("invalido-sem-cep"),
                Fixture.from(UsinaRequestBodyDTO.class).gimme("invalido-sem-numero"),
                Fixture.from(UsinaRequestBodyDTO.class).gimme("invalido-sem-bairro"),
                Fixture.from(UsinaRequestBodyDTO.class).gimme("invalido-sem-logradouro"),
                Fixture.from(UsinaRequestBodyDTO.class).gimme("invalido-sem-id-cidade")
        );
    }
}
