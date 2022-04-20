package br.com.supplyradar.usuario.mapper;

import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.domain.commons.CreateUsina;
import br.com.supplyradar.usuario.dto.CreateUsinaDTO;
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
@SpringBootTest(classes = {CreateUsinaDTOMapperImpl.class, EnderecoDTOMapperImpl.class})
class CreateUsinaDTOMapperTest extends AbstractUsuarioTest {
    @Autowired
    private CreateUsinaDTOMapper createUsinaDTOMapper;

    @DisplayName(value = "Deve ser capaz de mapear DTO para Domain.")
    @Test
    void fromDTO() {
        final CreateUsinaDTO createUsinaDTO = Fixture.from(CreateUsinaDTO.class).gimme("valido");
        CreateUsina createUsina = createUsinaDTOMapper.mapFrom(createUsinaDTO);
        assertThat(createUsina, notNullValue());
        assertThat(createUsina.getEndereco(), notNullValue());
        assertEquals(createUsina.getCnpj(), createUsinaDTO.getCnpj());
        assertEquals(createUsina.getWebsite(), createUsinaDTO.getWebsite());
        assertEquals(createUsina.getRazaoSocial(), createUsinaDTO.getRazaoSocial());
        assertEquals(createUsina.getInscricaoEstadual(), createUsinaDTO.getInscricaoEstadual());
    }

    @DisplayName(value = "Deve ser capaz de mapear Domain para DTO")
    @Test
    void fromDomain() {

    }
}
