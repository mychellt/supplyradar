package br.com.supplyradar.administrativo.mapper;


import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import br.com.supplyradar.administrativo.dto.PermissaoDTO;
import br.com.supplyradar.domain.commons.Permissao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({MockitoExtension.class})
@SpringBootTest(classes = {PermissaoMapperImpl.class})
class PermissaoMapperUTest {

    @Autowired
    private PermissaoMapper mapper;

    @BeforeAll
    public static void before() {
        FixtureFactoryLoader.loadTemplates("br.com.supplyradar.six2six.fixture.templates.domain.commons");
        FixtureFactoryLoader.loadTemplates("br.com.supplyradar.administrativo.six2six.fixture");
    }

    @DisplayName(value = "Deve ser capaz de realizar o mapeamento do DTO para o Domain")
    @Test
    void testMapFromDtoToDomain() {
        PermissaoDTO permissaoDTO = Fixture.from(PermissaoDTO.class).gimme("valido");
        Permissao permissao = mapper.mapFrom(permissaoDTO);
        assertThat(permissao, notNullValue());
        assertEquals(permissao.getDescricao(), permissaoDTO.getDescricao());
        assertEquals(permissao.getNome(), permissaoDTO.getNome());
        assertEquals(permissao.getOrdem(), permissaoDTO.getOrdem());
        assertEquals(permissao.getSigla(), permissaoDTO.getSigla());
        assertEquals(permissao.getTipo(), permissaoDTO.getTipo());
    }

    @DisplayName(value = "Deve ser capaz de realizar o mapeamento do Domain para o DTO")
    @Test
    void testMapFromDomainToDto() {
        Permissao permissao = Fixture.from(Permissao.class).gimme("valido");
        PermissaoDTO permissaoDTO = mapper.mapFrom(permissao);
        assertThat(permissaoDTO, notNullValue());
        assertEquals(permissaoDTO.getDescricao(), permissao.getDescricao());
        assertEquals(permissaoDTO.getNome(), permissao.getNome());
        assertEquals(permissaoDTO.getOrdem(), permissao.getOrdem());
        assertEquals(permissaoDTO.getSigla(), permissao.getSigla());
        assertEquals(permissaoDTO.getTipo(), permissao.getTipo());
    }
}
