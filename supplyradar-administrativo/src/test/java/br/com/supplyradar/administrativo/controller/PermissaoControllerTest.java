package br.com.supplyradar.administrativo.controller;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import br.com.supplyradar.administrativo.mapper.PermissaoMapper;
import br.com.supplyradar.administrativo.processor.permissao.*;
import br.com.supplyradar.administrativo.validator.PermissaoMandatoryFieldValidator;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.domain.commons.Permissao;
import br.com.supplyradar.administrativo.dto.PermissaoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.UUID;

import static java.util.Collections.emptyList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EnableWebMvc
@WebMvcTest(PermissaoController.class)
@ContextConfiguration(classes = PermissaoControllerTest.class)
@ComponentScan(basePackageClasses = {PermissaoController.class, PermissaoMandatoryFieldValidator.class, PermissaoMapper.class})
public class PermissaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreatePermissaoCommandProcessor createPermissaoCommandProcessor;

    @MockBean
    private UpdatePermissaoCommandProcessor updatePermissaoCommandProcessor;

    @MockBean
    private FetchPermissaoCommandProcessor fetchPermissaoCommandProcessor;

    @MockBean
    private ListPermissaoCommandProcessor listPermissaoCommandProcessor;

    @MockBean
    private DeletePermissaoCommandProcessor deletePermissaoCommandProcessor;

    @Spy
    private PermissaoMandatoryFieldValidator permissaoMandatoryFieldValidator;

    private ObjectMapper objectMapper;

    @BeforeAll
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.supplyradar.six2six.fixture.templates.domain.commons");
        FixtureFactoryLoader.loadTemplates("br.com.supplyradar.administrativo.six2six.fixture");
    }

    @BeforeEach
    public void before() {
        objectMapper = new ObjectMapper();
    }

    @DisplayName(value = "Dado uma requisição válida, deve ser capaz de invocar o processor para criação do registro.")
    @Test
    public void testCreate() throws Exception {
        final PermissaoDTO permissaoDTO = Fixture.from(PermissaoDTO.class).gimme("valido");
        final Permissao permissao = Fixture.from(Permissao.class).gimme("valido");

        when(createPermissaoCommandProcessor.process(any(CommandContext.class))).thenReturn(permissao);
        when(updatePermissaoCommandProcessor.process(any(CommandContext.class))).thenReturn(permissao);
        when(fetchPermissaoCommandProcessor.process(any(CommandContext.class))).thenReturn(null);
        when(listPermissaoCommandProcessor.process(any(CommandContext.class))).thenReturn(emptyList());
        when(deletePermissaoCommandProcessor.process(any(CommandContext.class))).thenReturn(permissao);

        mockMvc.perform(post("/administrativo/permissao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(permissaoDTO)))
                .andExpect(status().is(200));

        final ArgumentCaptor<CommandContext> commandContextArgumentCaptor = ArgumentCaptor.forClass(CommandContext.class);
        verify(createPermissaoCommandProcessor, only()).process(commandContextArgumentCaptor.capture());
        verify(updatePermissaoCommandProcessor, never()).process(commandContextArgumentCaptor.capture());
        verify(fetchPermissaoCommandProcessor, never()).process(commandContextArgumentCaptor.capture());
        verify(listPermissaoCommandProcessor, never()).process(commandContextArgumentCaptor.capture());
        verify(deletePermissaoCommandProcessor, never()).process(commandContextArgumentCaptor.capture());
        final CommandContext commandContext = commandContextArgumentCaptor.getValue();
        assertThat(commandContext.getData(Permissao.class).getDescricao(), equalTo(permissao.getDescricao()));
    }

    @DisplayName(value = "Data uma requisição válida, deve ser capaz de invocar o processor para atualização do registro.")
    @Test
    public void testUpdate() throws Exception {
        final PermissaoDTO permissaoDTO = Fixture.from(PermissaoDTO.class).gimme("valido");
        final Permissao permissao = Fixture.from(Permissao.class).gimme("valido");

        when(createPermissaoCommandProcessor.process(any(CommandContext.class))).thenReturn(permissao);
        when(updatePermissaoCommandProcessor.process(any(CommandContext.class))).thenReturn(permissao);
        when(fetchPermissaoCommandProcessor.process(any(CommandContext.class))).thenReturn(null);
        when(listPermissaoCommandProcessor.process(any(CommandContext.class))).thenReturn(emptyList());
        when(deletePermissaoCommandProcessor.process(any(CommandContext.class))).thenReturn(permissao);

        mockMvc.perform(put("/administrativo/permissao/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(permissaoDTO)))
                .andExpect(status().is(202));

        final ArgumentCaptor<CommandContext> commandContextArgumentCaptor = ArgumentCaptor.forClass(CommandContext.class);
        verify(createPermissaoCommandProcessor, never()).process(commandContextArgumentCaptor.capture());
        verify(updatePermissaoCommandProcessor, only()).process(commandContextArgumentCaptor.capture());
        verify(fetchPermissaoCommandProcessor, never()).process(commandContextArgumentCaptor.capture());
        verify(listPermissaoCommandProcessor, never()).process(commandContextArgumentCaptor.capture());
        verify(deletePermissaoCommandProcessor, never()).process(commandContextArgumentCaptor.capture());
        final CommandContext commandContext = commandContextArgumentCaptor.getValue();
        assertThat(commandContext.getData(Permissao.class).getDescricao(), equalTo(permissao.getDescricao()));
    }

    @DisplayName(value = "Data um id válido para um registro existente, deve ser capaz de retornar o registro.")
    @Test
    public void testGetOne() throws Exception {

        final Permissao permissao = Fixture.from(Permissao.class).gimme("valido");

        when(createPermissaoCommandProcessor.process(any(CommandContext.class))).thenReturn(null);
        when(updatePermissaoCommandProcessor.process(any(CommandContext.class))).thenReturn(null);
        when(fetchPermissaoCommandProcessor.process(any(CommandContext.class))).thenReturn(permissao);
        when(listPermissaoCommandProcessor.process(any(CommandContext.class))).thenReturn(emptyList());
        when(deletePermissaoCommandProcessor.process(any(CommandContext.class))).thenReturn(permissao);

        mockMvc.perform(get("/administrativo/permissao/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));

        final ArgumentCaptor<CommandContext> commandContextArgumentCaptor = ArgumentCaptor.forClass(CommandContext.class);
        verify(fetchPermissaoCommandProcessor, only()).process(commandContextArgumentCaptor.capture());
        verify(updatePermissaoCommandProcessor, never()).process(commandContextArgumentCaptor.capture());
        verify(createPermissaoCommandProcessor, never()).process(commandContextArgumentCaptor.capture());
        verify(listPermissaoCommandProcessor, never()).process(commandContextArgumentCaptor.capture());
        verify(deletePermissaoCommandProcessor, never()).process(commandContextArgumentCaptor.capture());
    }

    @DisplayName(value = "Deve ser capaz de retornar todas as permissões")
    @Test
    public void testGetAll() throws Exception {
        final Permissao permissao = Fixture.from(Permissao.class).gimme("valido");

        when(createPermissaoCommandProcessor.process(any(CommandContext.class))).thenReturn(null);
        when(updatePermissaoCommandProcessor.process(any(CommandContext.class))).thenReturn(null);
        when(fetchPermissaoCommandProcessor.process(any(CommandContext.class))).thenReturn(null);
        when(listPermissaoCommandProcessor.process(any(CommandContext.class))).thenReturn(List.of(permissao));
        when(deletePermissaoCommandProcessor.process(any(CommandContext.class))).thenReturn(permissao);

        mockMvc.perform(get("/administrativo/permissao/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));

        final ArgumentCaptor<CommandContext> commandContextArgumentCaptor = ArgumentCaptor.forClass(CommandContext.class);
        verify(fetchPermissaoCommandProcessor, never()).process(commandContextArgumentCaptor.capture());
        verify(updatePermissaoCommandProcessor, never()).process(commandContextArgumentCaptor.capture());
        verify(createPermissaoCommandProcessor, never()).process(commandContextArgumentCaptor.capture());
        verify(listPermissaoCommandProcessor, only()).process(commandContextArgumentCaptor.capture());
        verify(deletePermissaoCommandProcessor, never()).process(commandContextArgumentCaptor.capture());
    }
}
