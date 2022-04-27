package br.com.supplyradar.usuario.mapper;

import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.domain.commons.UsinaRequestBody;
import br.com.supplyradar.usuario.dto.UsinaRequestBodyDTO;
import br.com.supplyradar.usuario.processor.AbstractUsuarioTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;



@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {UsinaRequestBodyDTOMapperImpl.class, EnderecoDTOMapperImpl.class})
class UsinaRequestBodyDTOMapperTest extends AbstractMapperTest {
    @Autowired
    private UsinaRequestBodyDTOMapper usinaRequestBodyDTOMapper;

    @DisplayName(value = "Deve ser capaz de mapear DTO para Domain.")
    @Test
    void fromDTO() {
        final UsinaRequestBodyDTO usinaRequestBodyDTO = Fixture.from(UsinaRequestBodyDTO.class).gimme("valido");
        UsinaRequestBody usinaRequestBody = usinaRequestBodyDTOMapper.mapFrom(usinaRequestBodyDTO);
        assertThat(usinaRequestBody, notNullValue());
        assertThat(usinaRequestBody.getEndereco(), notNullValue());
        assertThat(usinaRequestBody.getEndereco().getCidade(), notNullValue());
        assertEquals(usinaRequestBody.getCnpj(), usinaRequestBodyDTO.getCnpj());
        assertEquals(usinaRequestBody.getWebsite(), usinaRequestBodyDTO.getWebsite());
        assertEquals(usinaRequestBody.getRazaoSocial(), usinaRequestBodyDTO.getRazaoSocial());
        assertEquals(usinaRequestBody.getInscricaoEstadual(), usinaRequestBodyDTO.getInscricaoEstadual());
        assertEquals(usinaRequestBody.getEndereco().getBairro(), usinaRequestBodyDTO.getEndereco().getBairro());
        assertEquals(usinaRequestBody.getEndereco().getNumero(), usinaRequestBodyDTO.getEndereco().getNumero());
        assertEquals(usinaRequestBody.getEndereco().getCep(), usinaRequestBodyDTO.getEndereco().getCep());
        assertEquals(usinaRequestBody.getEndereco().getTipo().name(), usinaRequestBodyDTO.getEndereco().getTipo());
        assertEquals(usinaRequestBody.getEndereco().getCidade().getId(), usinaRequestBodyDTO.getEndereco().getIdCidade());
    }

    @DisplayName(value = "Deve ser capaz de mapear Domain para DTO")
    @Test
    void fromDomain() {
        final UsinaRequestBody usinaRequestBody = Fixture.from(UsinaRequestBody.class).gimme("valido");
        UsinaRequestBodyDTO usinaRequestBodyDTO = usinaRequestBodyDTOMapper.mapFrom(usinaRequestBody);
        assertThat(usinaRequestBodyDTO, notNullValue());
        assertThat(usinaRequestBodyDTO.getEndereco(), notNullValue());
        assertThat(usinaRequestBodyDTO.getEndereco().getIdCidade(), notNullValue());
        assertEquals(usinaRequestBodyDTO.getCnpj(), usinaRequestBody.getCnpj());
        assertEquals(usinaRequestBodyDTO.getWebsite(), usinaRequestBody.getWebsite());
        assertEquals(usinaRequestBodyDTO.getRazaoSocial(), usinaRequestBody.getRazaoSocial());
        assertEquals(usinaRequestBodyDTO.getInscricaoEstadual(), usinaRequestBody.getInscricaoEstadual());
        assertEquals(usinaRequestBodyDTO.getEndereco().getBairro(), usinaRequestBody.getEndereco().getBairro());
        assertEquals(usinaRequestBodyDTO.getEndereco().getNumero(), usinaRequestBody.getEndereco().getNumero());
        assertEquals(usinaRequestBodyDTO.getEndereco().getCep(), usinaRequestBody.getEndereco().getCep());
        assertEquals(usinaRequestBodyDTO.getEndereco().getTipo(), usinaRequestBody.getEndereco().getTipo().name());
        assertEquals(usinaRequestBodyDTO.getEndereco().getIdCidade(), usinaRequestBody.getEndereco().getCidade().getId());
    }
}
