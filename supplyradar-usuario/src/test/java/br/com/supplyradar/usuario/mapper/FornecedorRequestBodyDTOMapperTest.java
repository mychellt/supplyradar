package br.com.supplyradar.usuario.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {FornecedorRequestBodyDTOMapperImpl.class})
public class FornecedorRequestBodyDTOMapperTest extends AbstractMapperTest {
    @Autowired
    private FornecedorRequestBodyDTOMapper fornecedorRequestBodyDTOMapper;

    @DisplayName(value = "Deve ser capaz de mapear DTO para Domain.")
    @Test
    void fromDTO() {

    }

    @DisplayName(value = "Deve ser capaz de mapear Domain para DTO.")
    @Test
    void fromDomain() {

    }
}
