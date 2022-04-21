package br.com.supplyradar.usuario.processor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
class CadastrarUsinaCommandProcessorTest extends AbstractUsuarioTest {

    private CadastrarUsinaCommandProcessor cadastrarUsinaCommandProcessor;

    @BeforeEach
    void setUp() {

    }

    @DisplayName(value = "Deve ser capaz de criar um registro de usina")
    @Test
    void process() {

    }
}
